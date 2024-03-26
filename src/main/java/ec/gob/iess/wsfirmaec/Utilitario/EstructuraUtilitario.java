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

/**
 * Clase de utilidad para almacenar información de auditoría.
 */
public class EstructuraUtilitario{

	private String certificado;

	private String password;

	private ParametrosUtilitario parametros;
	
	private String base64;

	/**
	 * @return el cerificado
	 */
	public String getCertificado() {
		return certificado;
	}

	/**
	 * @param cerificado el cerificado to editar
	 */
	public void setCertificado(String cerificado) {
		this.certificado = cerificado;
	}

	/**
	 * @return el password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password del password to editar
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the parametros
	 */
	public ParametrosUtilitario getParametros() {
		return parametros;
	}

	/**
	 * @param parametros the parametros to set
	 */
	public void setParametros(ParametrosUtilitario parametros) {
		this.parametros = parametros;
	}

	/**
	 * @return el base64
	 */
	public String getBase64() {
		return base64;
	}

	/**
	 * @param base64 el base64 to editar
	 */
	public void setBase64(String base64) {
		this.base64 = base64;
	}

	
	
	
}