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


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ec.gob.iess.wsfirmaec.Entidad.FirDocfirmadosTEntidad;

/**
 * Repositorio para la entidad de documentos firmados.
 */
@Repository
public interface FirDocfirmadosTRepositorio extends JpaRepository<FirDocfirmadosTEntidad, Integer> {
	
	 /**
     * Busca documentos firmados por cédula y nombres de documentos.
     *
     * @param cedula   La cédula del firmante.
     * @param nombres  Lista de nombres de documentos.
     * @return Lista de documentos firmados encontrados.
     */
	@Query("select a from FirDocfirmadosTEntidad a where a.cedula = ?1 and a.nombreDocumento in ?2")
	 List<FirDocfirmadosTEntidad> buscarPorCedulaYNombres(String cedula, List<String> nombres);
	
	 /**
     * Busca documentos firmados por IDs y cédula.
     *
     * @param ids      Lista de IDs de documentos firmados.
     * @param cedula   La cédula del firmante.
     * @return Lista de documentos firmados encontrados.
     */
	@Query("select a from FirDocfirmadosTEntidad a where a.idDoc in ?1 and a.cedula = ?2 ")
	 List<FirDocfirmadosTEntidad> buscarPorIds(List<Integer> ids, String cedula);
	
	
	
}
