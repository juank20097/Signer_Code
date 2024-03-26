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
public class ParametrosUtilitario{

	private String sistema;
	
	private String operacion;
	
	private String url;
	
	private String versionFirmaEC;
	
	private String formatoDocumento;
	
	private String tokenJwt;
	
	private Integer llx;
	
	private Integer lly;
	
	private Integer pagina;
	
	private String tipoEstampado;
	
	private String razon;
	
	private boolean pre;
	
	private boolean des;

	/**
	 * @return el sistema
	 */
	public String getSistema() {
		return sistema;
	}

	/**
	 * @param sistemas el sistema para editar
	 */
	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	/**
	 * @return el operacion
	 */
	public String getOperacion() {
		return operacion;
	}

	/**
	 * @param operacion el operacion para editar
	 */
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	/**
	 * @return el url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url el url para editar
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return el versionFirmaEC
	 */
	public String getVersionFirmaEC() {
		return versionFirmaEC;
	}

	/**
	 * @param versionFirmaEC el versionFirmaEC para editar
	 */
	public void setVersionFirmaEC(String versionFirmaEC) {
		this.versionFirmaEC = versionFirmaEC;
	}

	/**
	 * @return el formatoDocumento
	 */
	public String getFormatoDocumento() {
		return formatoDocumento;
	}

	/**
	 * @param formatoDocumento el formatoDocumento para editar
	 */
	public void setFormatoDocumento(String formatoDocumento) {
		this.formatoDocumento = formatoDocumento;
	}

	/**
	 * @return el tokenJwt
	 */
	public String getTokenJwt() {
		return tokenJwt;
	}

	/**
	 * @param tokenJwt el tokenJwt para editar
	 */
	public void setTokenJwt(String tokenJwt) {
		this.tokenJwt = tokenJwt;
	}

	/**
	 * @return el llx
	 */
	public Integer getLlx() {
		return llx;
	}

	/**
	 * @param llx el llx para editar
	 */
	public void setLlx(Integer llx) {
		this.llx = llx;
	}

	/**
	 * @return el lly
	 */
	public Integer getLly() {
		return lly;
	}

	/**
	 * @param lly el lly para editar
	 */
	public void setLly(Integer lly) {
		this.lly = lly;
	}

	/**
	 * @return el pagina
	 */
	public Integer getPagina() {
		return pagina;
	}

	/**
	 * @param pagina el pagina para editar
	 */
	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}

	/**
	 * @return el tipoEstampado
	 */
	public String getTipoEstampado() {
		return tipoEstampado;
	}

	/**
	 * @param tipoEstampado el tipoEstampado para editar
	 */
	public void setTipoEstampado(String tipoEstampado) {
		this.tipoEstampado = tipoEstampado;
	}

	/**
	 * @return el razon
	 */
	public String getRazon() {
		return razon;
	}

	/**
	 * @param razon el razon para editar
	 */
	public void setRazon(String razon) {
		this.razon = razon;
	}

	/**
	 * @return el pre
	 */
	public boolean isPre() {
		return pre;
	}

	/**
	 * @param pre el pre para editar
	 */
	public void setPre(boolean pre) {
		this.pre = pre;
	}

	/**
	 * @return el des
	 */
	public boolean isDes() {
		return des;
	}

	/**
	 * @param des el des para editar
	 */
	public void setDes(boolean des) {
		this.des = des;
	}
	

	

	
	
	
}