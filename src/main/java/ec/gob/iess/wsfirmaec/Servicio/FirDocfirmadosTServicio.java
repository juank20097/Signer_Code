/**
 * Copyrigth 2024 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */

package ec.gob.iess.wsfirmaec.Servicio;

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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.iess.wsfirmaec.Entidad.FirDocfirmadosTEntidad;
import ec.gob.iess.wsfirmaec.Repositorio.FirDocfirmadosTRepositorio;

/**
 * Servicio para la entidad de documentos firmados.
 */
@Service
public class FirDocfirmadosTServicio {

	@Autowired
	private FirDocfirmadosTRepositorio firmadosRepo;
	
	 /**
     * Inserta o actualiza un documento firmado.
     *
     * @param fir Documento firmado a insertar o actualizar.
     * @return Documento firmado insertado o actualizado.
     */
	public FirDocfirmadosTEntidad insertarActualizar(FirDocfirmadosTEntidad fir) {
		return firmadosRepo.save(fir);
	}
	
	 /**
     * Obtiene los detalles de documentos firmados por cédula y nombres.
     *
     * @param cedula  Cédula del firmante.
     * @param nombres Nombres de los documentos.
     * @return Lista de detalles de documentos firmados.
     */
	public List<FirDocfirmadosTEntidad> obtenerIds(String cedula, List<String> nombres) {
		return firmadosRepo.buscarPorCedulaYNombres(cedula,nombres);
	}
	
	 /**
     * Obtiene los documentos firmados por IDs y cédula.
     *
     * @param ids     Lista de IDs de documentos firmados.
     * @param cedula  Cédula del firmante.
     * @return Lista de documentos firmados.
     */
	public List<FirDocfirmadosTEntidad> obtenerDocumentos (List<Integer> ids, String cedula) {
		return firmadosRepo.buscarPorIds(ids, cedula);
	}
}
