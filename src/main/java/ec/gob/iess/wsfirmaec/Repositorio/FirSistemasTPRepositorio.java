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
import ec.gob.iess.wsfirmaec.Entidad.FirSistemasTPEntidad;

/**
 * Repositorio para la obtención de la información de sistema.
 */

@Repository
public interface FirSistemasTPRepositorio extends JpaRepository<FirSistemasTPEntidad, Integer>{

}

