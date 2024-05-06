/**
 * Copyrigth 2024 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */

package ec.gob.iess.wsfirmaec.Repositorio;

/**
 * Clase que define el repositorio de accesores a BDD
 * 
 * 
  * @author  jestevez
 * @version $Revision: 1.0.0 $ 
 *          <p>
 *          [$Author: jestevez $, Date: 23 feb 2024 $]
 *          </p>
 */


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.gob.iess.wsfirmaec.Entidad.FirDocfirmadosdetTEntidad;

/**
 * Repositorio para la entidad de detalles de documentos firmados.
 */
@Repository
public interface FirDocfirmadosdetTRepositorio extends JpaRepository<FirDocfirmadosdetTEntidad, Integer> {
	
}
