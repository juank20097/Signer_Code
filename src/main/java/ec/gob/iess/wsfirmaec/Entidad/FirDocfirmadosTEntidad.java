/**
 * Copyrigth 2024 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */

package ec.gob.iess.wsfirmaec.Entidad;

/**
 * Clase que define las entidad a generar en la BDD
 * 
 * 
  * @author  jestevez
 * @version $Revision: 1.0.0 $ 
 *          <p>
 *          [$Author: jestevez $, Date: 23 feb 2024 $]
 *          </p>
 */


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;


/**
 * La clase de persistencia para la tabla fir_docfirmados_t.
 * 
 */
@Entity
@Table(name="FIR_DOCFIRMADOS_T", schema = "public")
@SequenceGenerator(name = "fir_docfirmados_s", sequenceName = "public.fir_docfirmados_s", allocationSize = 1)
@NamedQuery(name="FirDocfirmadosTEntidad.findAll", query="SELECT f FROM FirDocfirmadosTEntidad f")
public class FirDocfirmadosTEntidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fir_docfirmados_s")
	@Column(name="id_doc", length = 38,nullable = false )
	@PrimaryKeyJoinColumn(name = "FIR_DOCFIRMADOS_pk")
	private Integer idDoc;

	@Column(name="archivo" )
	private byte[] archivo;

	@Column(name="cedula", length = 10,nullable = false )
	private String cedula;
	
	@Column(name="error", length = 500 )
	private String error; 

	@Column(name="firma_valida")
	private boolean firmasValidas;
	
	@Column(name="integridad")
	private boolean integridadDocumento;

	@Column(name="nombre_doc", length = 256, nullable = false)
	private String nombreDocumento;  
	
	@Column(name="usuario_creacion", nullable = false)
	private String usuarioCreacion; 
	
	@Column(name="fecha_creacion", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-5")
	private Timestamp fechaCreacion;
	
	@Column(name="ip_equipo", nullable = false)
	private String ipEquipo; 
	
	//bi-directional many-to-one association to FirDocfirmadosdetT
	@OneToMany(mappedBy="idDocDet")
	private List<FirDocfirmadosdetTEntidad> certificado; 

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
	 * @return el archivo
	 */
	public byte[] getArchivo() {
		return archivo;
	}

	/**
	 * @param archivo el archivo para editar
	 */
	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}

	/**
	 * @return el cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula el cedula para editar
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return el error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error el error para editar
	 */
	public void setError(String error) {
		this.error = error;
	}

	/**
	 * @return el firmasValidas
	 */
	public boolean isFirmasValidas() {
		return firmasValidas;
	}

	/**
	 * @param firmasValidas el firmasValidas para editar
	 */
	public void setFirmasValidas(boolean firmasValidas) {
		this.firmasValidas = firmasValidas;
	}

	/**
	 * @return el integridadDocumento
	 */
	public boolean isIntegridadDocumento() {
		return integridadDocumento;
	}

	/**
	 * @param integridadDocumento el integridadDocumento para editar
	 */
	public void setIntegridadDocumento(boolean integridadDocumento) {
		this.integridadDocumento = integridadDocumento;
	}

	/**
	 * @return el nombreDocumento
	 */
	public String getNombreDocumento() {
		return nombreDocumento;
	}

	/**
	 * @param nombreDocumento el nombreDocumento para editar
	 */
	public void setNombreDocumento(String nombreDocumento) {
		this.nombreDocumento = nombreDocumento;
	}

	/**
	 * @return el fechaCreacion
	 */
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion el fechaCreacion para editar
	 */
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return el certificado
	 */
	public List<FirDocfirmadosdetTEntidad> getCertificado() {
		return certificado;
	}

	/**
	 * @param certificado el certificado para editar
	 */
	public void setCertificado(List<FirDocfirmadosdetTEntidad> certificado) {
		this.certificado = certificado;
	}

	/**
	 * @return el usuarioCreacion
	 */
	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	/**
	 * @param usuarioCreacion el usuarioCreacion para editar
	 */
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	/**
	 * @return el ipEquipo
	 */
	public String getIpEquipo() {
		return ipEquipo;
	}

	/**
	 * @param ipEquipo el ipEquipo para editar
	 */
	public void setIpEquipo(String ipEquipo) {
		this.ipEquipo = ipEquipo;
	}
	
}
