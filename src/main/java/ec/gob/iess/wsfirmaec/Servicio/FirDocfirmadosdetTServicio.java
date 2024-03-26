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


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.iess.wsfirmaec.Entidad.FirDocfirmadosdetTEntidad;
import ec.gob.iess.wsfirmaec.Repositorio.FirDocfirmadosdetTRepositorio;


/**
 * Servicio para la entidad de detalles de documentos firmados.
 */
@Service
public class FirDocfirmadosdetTServicio {

	@Autowired
	private FirDocfirmadosdetTRepositorio firmadosDetRepo;
	
	 /**
     * Inserta o actualiza un detalle de documento firmado.
     *
     * @param fir Detalle de documento firmado a insertar o actualizar.
     * @return Detalle de documento firmado insertado o actualizado.
     */
	public FirDocfirmadosdetTEntidad insertarActualizar(FirDocfirmadosdetTEntidad fir) {
		return firmadosDetRepo.save(fir);
	}
	
}
