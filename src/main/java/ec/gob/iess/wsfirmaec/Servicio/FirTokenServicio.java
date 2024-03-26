/**
 * Copyrigth 2024 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iess.wsfirmaec.Servicio;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ec.gob.iess.wsfirmaec.Entidad.FirSistemasTPEntidad;
import ec.gob.iess.wsfirmaec.Repositorio.FirSistemasTPRepositorio;
import ec.gob.iess.wsfirmaec.Utilitario.ParametrosUtilitario;
import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Clase de consumo de servicios rest para el consumo de Token.
 * 
 * 
  * @author  jestevez
 * @version $Revision: 1.0.0 $ 
 *          <p>
 *          [$Author: jestevez $, Date: 23 feb 2024 $]
 *          </p>
 */
@Service
public class FirTokenServicio {

	private final RestTemplate restTemplate;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private FirSistemasTPRepositorio sistemaRepo;

	@Value("${url.externa}")
	private String UrlExterno;
	@Value("${app.apikey}")
	private String ApiKey;
	@Value("${app.apikeyrest}")
	private String ApiKeyRest;
	@Value("${app.urlapi}")
	private String UrlApi;

	@Autowired
	public FirTokenServicio(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	/**
	 * Método ejecutado después de la construcción del bean para guardar un sistema en la base de datos.
	 * Utiliza las propiedades de la clase para inicializar un objeto FirSistemasTPEntidad y lo guarda en la base de datos.
	 */
	@PostConstruct
	 public void insertarDatos() {
	        String sql = "INSERT INTO sistema (id, url, apikey, apikeyrest, descripcion, nombre) VALUES (?, ?, ?, ?, ?, ?);";
	        jdbcTemplate.update(sql,(long)1,this.UrlApi,this.ApiKey,this.ApiKeyRest,"IESS","iess");
	    }
	
	/**
	 * Método ejecutado después de la construcción del bean para guardar un sistema en la base de datos.
	 * Utiliza las propiedades de la clase para inicializar un objeto FirSistemasTPEntidad y lo guarda en la base de datos.
	 */
	@PostConstruct
	public void guardarSistema() {
		FirSistemasTPEntidad sistema = new FirSistemasTPEntidad();
		sistema.setId((long) 1);
		sistema.setApiKey(this.ApiKey);
		sistema.setApiKeyRest(this.ApiKeyRest);
		sistema.setDescripcion("IESS");
		sistema.setNombre("iess");
		sistema.setUrl(this.UrlApi);
		sistemaRepo.save(sistema);
	}

	/**
	 * Obtiene el Token de los servicios del MINTEL.
	 * 
	 * [Author: jestevez, Date: 23/02/2024]
	 *
	 * @param body el json que envia la información de los documentos.
	 * @return el Token de uso de FirmaEC.
	 */
	public String consumirServicioPostTokenMintel(String body) {
		String servicioExternoUrl = UrlExterno + "servicio/documentos";
		String requestBody = body;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("x-api-key", this.obtenerKey());

		HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
		String respuesta = restTemplate.postForObject(servicioExternoUrl, requestEntity, String.class);
		return respuesta;
	}

	/**
	 * Obtiene los documentos firmados de código de MINTEL.
	 *
	 * @param body el json que envia la información de los documentos.
	 * @return el Token de uso de FirmaEC.
	 */
	public String consumirServicioPostFirmaDocumentos(String archivo, String clave, ParametrosUtilitario parametros,
			String base64) {
		String respuesta = "";
		String json = concatenarParametros(parametros);
		try {
			String servicioExternoUrl = UrlExterno + "api/appfirmardocumentotransversal";
			String requestBody = "pkcs12=" + URLEncoder.encode(archivo, "UTF-8") + "&password="
					+ URLEncoder.encode(clave, "UTF-8") + "&json=" + URLEncoder.encode(json, "UTF-8") + "&base64="
					+ URLEncoder.encode(base64, "UTF-8");
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
			respuesta = restTemplate.postForObject(servicioExternoUrl, requestEntity, String.class);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return respuesta;
	}

	/**
	 * Metodo que me genera la información JSON
	 * 
	 * @param par
	 * @return un String con toda la información ordenada
	 */
	private String concatenarParametros(ParametrosUtilitario par) {
		return "{\"sistema\":\"" + par.getSistema() + "\"," + "\"operacion\":\"" + par.getOperacion() + "\","
				+ "\"url\":\"" + par.getUrl() + "\"," + "\"versionFirmaEC\":\"" + par.getVersionFirmaEC() + "\","
				+ "\"formatoDocumento\":\"" + par.getFormatoDocumento() + "\"," + "\"tokenJwt\":\"" + par.getTokenJwt()
				+ "\"," + "\"llx\":" + par.getLlx() + "," + "\"lly\":" + par.getLly() + "," + "\"pagina\":"
				+ par.getPagina() + "," + "\"tipoEstampado\":\"" + par.getTipoEstampado() + "\"," + "\"razon\":\""
				+ par.getRazon() + "\"," + "\"pre\":" + false + "," + "\"des\":" + false + "}";
	}
	
	/**
	 * Método para obtener la clave API REST de un sistema.
	 * 
	 * @return La clave API REST del primer sistema encontrado en la base de datos.
	 */
	private String obtenerKey() {
		List<FirSistemasTPEntidad> list= sistemaRepo.findAll();
		return list.get(0).getApiKeyRest();
	}
}
