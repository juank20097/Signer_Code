/**
 * Copyrigth 2024 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iess.wsfirmaec.Controlador;
/**
 * Clase que define los servicios de uso en los web services
 * 
 * 
  * @author  jestevez
 * @version $Revision: 1.0.0 $ 
 *          <p>
 *          [$Author: jestevez $, Date: 23 feb 2024 $]
 *          </p>
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Path;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.iess.wsfirmaec.Entidad.FirDocfirmadosTEntidad;
import ec.gob.iess.wsfirmaec.Entidad.FirDocfirmadosdetTEntidad;
import ec.gob.iess.wsfirmaec.Servicio.FirDocfirmadosTServicio;
import ec.gob.iess.wsfirmaec.Servicio.FirDocfirmadosdetTServicio;
import ec.gob.iess.wsfirmaec.Servicio.FirTokenServicio;
import ec.gob.iess.wsfirmaec.Utilitario.AuditoriaUtilitario;
import ec.gob.iess.wsfirmaec.Utilitario.EstructuraUtilitario;

/**
 * Controlador para gestionar las operaciones relacionadas con los documentos firmados.
 */
@RestController
@RequestMapping("/iess/firmaec")
public class FirDocfirmadosTControlador {
	
	@Autowired
	private FirDocfirmadosTServicio firmadosService;
	
	@Autowired
	private FirDocfirmadosdetTServicio firmadosdetServicios;
	
	@Autowired
	private  FirTokenServicio tokenServicios;
	
	
	/**
	 * Devuelve información sobre el servicio WS de FirmaEC.
	 *
	 * @return Información sobre el servicio WS de FirmaEC.
	 */
	@CrossOrigin(origins = "*")
	@GetMapping
	public String obtenerInformacion() {
		  return "WS de FirmaEC, este WS permite almacenar la información devuelta de la firma de documentos transversales.";
	}
	
	/**
	 * Inserta un documento firmado en la base de datos.
	 *
	 * @param enter El documento firmado a insertar.
	 * @return Un mensaje indicando el resultado de la operación.
	 * @throws UnknownHostException 
	 */
	@CrossOrigin(origins = "*")
	@PostMapping
	@ResponseBody
	public String insertar(@RequestBody FirDocfirmadosTEntidad enter) throws UnknownHostException {
		 InetAddress localhost = InetAddress.getLocalHost();
			 Timestamp time=new Timestamp(new Date().getTime());
			  enter.setFechaCreacion(time);
			  enter.setIpEquipo(""+localhost);
			  enter.setUsuarioCreacion("ws_firmaec");
			  firmadosService.insertarActualizar(enter);
			  for (FirDocfirmadosdetTEntidad cer : enter.getCertificado()) {
				cer.setFirmados(enter);
				cer.setFechaCreacion(time);
				cer.setIpEquipo(""+localhost);
				cer.setUsuarioCreacion("ws_firmaec");
				firmadosdetServicios.insertarActualizar(cer);
			  }
			 return "OK";
	}
	
	/**
	 * Obtiene los IDs de los documentos firmados por cédula y nombres.
	 *
	 * @param cedula   La cédula del solicitante.
	 * @param nombres  Lista de nombres de documentos.
	 * @return Lista de objetos Auditoria con información de los documentos firmados.
	 */
	@CrossOrigin(origins = "*")
	@PostMapping (path = {"/{cedula}"})
	public List<AuditoriaUtilitario> obtenerIds(@PathVariable("cedula") String cedula,@RequestBody List<String> nombres) {
		 List<FirDocfirmadosTEntidad> firmados = firmadosService.obtenerIds(cedula, nombres);
		 List<AuditoriaUtilitario> audit= new ArrayList<AuditoriaUtilitario>();
		 for (FirDocfirmadosTEntidad fir : firmados) {
			AuditoriaUtilitario aud= new AuditoriaUtilitario();
			aud.setIdDoc(fir.getIdDoc());
			aud.setCedula(fir.getCedula());
			aud.setFechaCreacion(fir.getFechaCreacion());
			aud.setNombreDocumento(fir.getNombreDocumento());
			audit.add(aud);
		}
		 return audit;
	}
	
	/**
	 * Obtiene los documentos firmados por cédula e IDs.
	 *
	 * @param cedula La cédula del solicitante.
	 * @param ids    Lista de IDs de documentos.
	 * @return ResponseEntity con los documentos firmados.
	 * @throws IOException Si ocurre un error durante la creación del archivo ZIP.
	 */
	@CrossOrigin(origins = "*")
	@PostMapping (path = {"/documentos/{cedula}"})
	public ResponseEntity<Resource> obtenerDocumentos(@PathVariable String cedula,@RequestBody List<Integer> ids) throws IOException {
		 List<FirDocfirmadosTEntidad> firmados = firmadosService.obtenerDocumentos(ids, cedula);	
		if (firmados.size()>1) {
			     File tempFile = File.createTempFile("documentos", ".zip");
			     
			     try (FileOutputStream fos = new FileOutputStream(tempFile);
			             ZipOutputStream zipOut = new ZipOutputStream(fos)) {
			            
			    	 for (FirDocfirmadosTEntidad fir : firmados) {
			             byte[] documentContent = fir.getArchivo();
			             ZipEntry zipEntry = new ZipEntry(fir.getNombreDocumento()+"_firmadoIESS.pdf");
			             zipOut.putNextEntry(zipEntry);
			             zipOut.write(documentContent);
			             zipOut.closeEntry();
			         }
			        }
			        Path tempFilePath = tempFile.toPath();
			        Resource resource = new FileSystemResource(tempFilePath);
			        return ResponseEntity.ok()
			                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=documentos_firmados_IESS_"+cedula+".zip")
			                .contentType(MediaType.APPLICATION_OCTET_STREAM)
			                .body(resource);
			} else {
				 ByteArrayResource resource = new ByteArrayResource(firmados.get(0).getArchivo());
				 return ResponseEntity.ok()
				            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+firmados.get(0).getNombreDocumento()+"_firmadoIESS.pdf")
				            .contentType(MediaType.APPLICATION_OCTET_STREAM)
				            .body(resource);
			}

			}
	
	
	/**
	 * Obtiene el token de consumo y ejecución
	 *
	 * @param body cuerpo de la solicitud json.
	 * @return String con el token respectivo de la consulta
	 */
	@CrossOrigin(origins = "*")
	@PostMapping (path = {"/token"})
	public String obtenerToken(@RequestBody String body) throws IOException {
		String token=tokenServicios.consumirServicioPostTokenMintel(body);
		return token;
			}
	
	/**
	 * Obtiene el documento firmado
	 *
	 * @param body cuerpo de la solicitud json.
	 * @return String con la respuesta de la firma
	 */
	@CrossOrigin(origins = "*")
	@PostMapping (path = {"/firmarDocumentos"})
	public String firmarDocumentos(@RequestBody EstructuraUtilitario body) throws IOException {
		String respuesta=tokenServicios.consumirServicioPostFirmaDocumentos(body.getCertificado(), body.getPassword(), body.getParametros(), body.getBase64());
		return respuesta;
			}
}
	
	

	
