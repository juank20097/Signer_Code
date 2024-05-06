/**
 * Copyrigth 2024 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iess.wsfirmaec.Utilitario;

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
import java.sql.Timestamp;


/**
 * Clase de utilidad para almacenar información de auditoría.
 */
public class AuditoriaUtilitario{

	private Integer idDoc;

	private String cedula;

	private Timestamp fechaCreacion;
	
	private String nombreDocumento;

	/**
	 * @return el idDoc
	 */
	public Integer getIdDoc() {
		return idDoc;
	}

	/**
	 * @param idDoc el idDoc para editar
	 */
	public void setIdDoc(Integer idDoc) {
		this.idDoc = idDoc;
	}

	/**
     * Obtiene la cédula del usuario.
     *
     * @return Cédula del usuario.
     */
	public String getCedula() {
		return cedula;
	}

	/**
     * Establece la cédula del usuario.
     *
     * @param cedula Cédula del usuario a establecer.
     */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
     * Obtiene la fecha de creación del documento.
     *
     * @return Fecha de creación del documento.
     */
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	 /**
     * Establece la fecha de creación del documento.
     *
     * @param fechaCreacion Fecha de creación del documento a establecer.
     */
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
     * Obtiene el nombre del documento.
     *
     * @return Nombre del documento.
     */
	public String getNombreDocumento() {
		return nombreDocumento;
	}

	 /**
     * Establece el nombre del documento.
     *
     * @param nombreDocumento Nombre del documento a establecer.
     */
	public void setNombreDocumento(String nombreDocumento) {
		this.nombreDocumento = nombreDocumento;
	}
	
	
}