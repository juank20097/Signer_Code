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

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;


/**
 * Entidad que representa los detalles de los documentos firmados.
 */
@Entity
@Table(name="FIR_DOCFIRMADOSDET_T", schema = "public", uniqueConstraints = {
	    @UniqueConstraint(name = "fir_docfirmadosdet_pk", columnNames = "id_docdet")
	})
@SequenceGenerator(name = "fir_docfirmadosdet_s", sequenceName = "public.fir_docfirmadosdet_s", allocationSize = 1)
@NamedQuery(name="FirDocfirmadosdetTEntidad.findAll", query="SELECT f FROM FirDocfirmadosdetTEntidad f")
public class FirDocfirmadosdetTEntidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fir_docfirmadosdet_s")
	@Column(name="id_docdet", length = 38, nullable = false)
	private Integer idDocDet; 

	@Column(name="apellido", length = 100, nullable = false)
	private String apellido; 

	@Column(name="cargo", length = 256)
	private String cargo; 

	@Column(name="cedula", length = 10, nullable = false)
	private String cedula; 

	@Column(name="cer_digvalido", nullable = false)
	private boolean certificadoDigitalValido; 

	@Column(name="cert_vigente", nullable = false)
	private boolean certificadoVigente; 

	@Column(name="claves_uso", length = 100, nullable = false)
	private String clavesUso; 

	@Column(name="emitido_para", length = 256,nullable = false)
	private String emitidoPara; 

	@Column(name="emitido_por", length = 256,nullable = false)
	private String emitidoPor; 

	@Column(name="ent_certificadora", length = 256,nullable = false)
	private String entidadCertificadora; 

	@Column(name="fec_firma", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-5")
	private Timestamp fechaFirma; 

	@Column(name="fec_revocado")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-5")
	private Timestamp fechaRevocado; 

	@Column(name="fec_sellotiempo")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-5")
	private Timestamp fechaSellotiempo; 

	@Column(name="institucion",length = 256, nullable = false)
	private String institucion; 

	@Column(name="integridad")
	private boolean integridadFirma; 

	@Column(name="localizacion",length = 256)
	private String localizacion; 

	@Column(name="nombre",length = 100, nullable = false)
	private String nombre; 

	@Column(name="razon_firma", length = 256, nullable = false)
	private String razonFirma; 

	@Column(name="sellado_tiempo", nullable = false)
	private boolean selladoTiempo; 

	@Column(name="serial", nullable = false)
	private String serial; 

	@Column(name="valido_desde", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-5")
	private Timestamp validoDesde; 

	@Column(name="valido_hasta", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-5")
	private Timestamp validoHasta; 
	
	@Column(name="usuario_creacion", nullable = false)
	private String usuarioCreacion; 
	
	@Column(name="fecha_creacion", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-5")
	private Timestamp fechaCreacion;
	
	@Column(name="ip_equipo", nullable = false)
	private String ipEquipo; 
	
	@ManyToOne
	@JoinColumn(name = "id_doc", referencedColumnName = "id_doc",  foreignKey = @ForeignKey(name ="fir_docfir_fir_docfirdet_fk"))
	private FirDocfirmadosTEntidad firmados;

	public FirDocfirmadosdetTEntidad() {
	}

	/**
	 * @return el idDocDet
	 */
	public Integer getIdDocDet() {
		return idDocDet;
	}

	/**
	 * @param idDocDet el idDocDet para editar
	 */
	public void setIdDocDet(Integer idDocDet) {
		this.idDocDet = idDocDet;
	}

	/**
	 * @return el apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido el apellido para editar
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return el cargo
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * @param cargo el cargo para editar
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
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
	 * @return el certificadoDigitalValido
	 */
	public boolean isCertificadoDigitalValido() {
		return certificadoDigitalValido;
	}

	/**
	 * @param certificadoDigitalValido el certificadoDigitalValido para editar
	 */
	public void setCertificadoDigitalValido(boolean certificadoDigitalValido) {
		this.certificadoDigitalValido = certificadoDigitalValido;
	}

	/**
	 * @return el certificadoVigente
	 */
	public boolean isCertificadoVigente() {
		return certificadoVigente;
	}

	/**
	 * @param certificadoVigente el certificadoVigente para editar
	 */
	public void setCertificadoVigente(boolean certificadoVigente) {
		this.certificadoVigente = certificadoVigente;
	}

	/**
	 * @return el clavesUso
	 */
	public String getClavesUso() {
		return clavesUso;
	}

	/**
	 * @param clavesUso el clavesUso para editar
	 */
	public void setClavesUso(String clavesUso) {
		this.clavesUso = clavesUso;
	}

	/**
	 * @return el emitidoPara
	 */
	public String getEmitidoPara() {
		return emitidoPara;
	}

	/**
	 * @param emitidoPara el emitidoPara para editar
	 */
	public void setEmitidoPara(String emitidoPara) {
		this.emitidoPara = emitidoPara;
	}

	/**
	 * @return el emitidoPor
	 */
	public String getEmitidoPor() {
		return emitidoPor;
	}

	/**
	 * @param emitidoPor el emitidoPor para editar
	 */
	public void setEmitidoPor(String emitidoPor) {
		this.emitidoPor = emitidoPor;
	}

	/**
	 * @return el entidadCertificadora
	 */
	public String getEntidadCertificadora() {
		return entidadCertificadora;
	}

	/**
	 * @param entidadCertificadora el entidadCertificadora para editar
	 */
	public void setEntidadCertificadora(String entidadCertificadora) {
		this.entidadCertificadora = entidadCertificadora;
	}

	/**
	 * @return el fechaFirma
	 */
	public Timestamp getFechaFirma() {
		return fechaFirma;
	}

	/**
	 * @param fechaFirma el fechaFirma para editar
	 */
	public void setFechaFirma(Timestamp fechaFirma) {
		this.fechaFirma = fechaFirma;
	}

	/**
	 * @return el fechaRevocado
	 */
	public Timestamp getFechaRevocado() {
		return fechaRevocado;
	}

	/**
	 * @param fechaRevocado el fechaRevocado para editar
	 */
	public void setFechaRevocado(Timestamp fechaRevocado) {
		this.fechaRevocado = fechaRevocado;
	}

	/**
	 * @return el fechaSellotiempo
	 */
	public Timestamp getFechaSellotiempo() {
		return fechaSellotiempo;
	}

	/**
	 * @param fechaSellotiempo el fechaSellotiempo para editar
	 */
	public void setFechaSellotiempo(Timestamp fechaSellotiempo) {
		this.fechaSellotiempo = fechaSellotiempo;
	}

	/**
	 * @return el institucion
	 */
	public String getInstitucion() {
		return institucion;
	}

	/**
	 * @param institucion el institucion para editar
	 */
	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	/**
	 * @return el integridadFirma
	 */
	public boolean isIntegridadFirma() {
		return integridadFirma;
	}

	/**
	 * @param integridadFirma el integridadFirma para editar
	 */
	public void setIntegridadFirma(boolean integridadFirma) {
		this.integridadFirma = integridadFirma;
	}

	/**
	 * @return el localizacion
	 */
	public String getLocalizacion() {
		return localizacion;
	}

	/**
	 * @param localizacion el localizacion para editar
	 */
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	/**
	 * @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre el nombre para editar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return el razonFirma
	 */
	public String getRazonFirma() {
		return razonFirma;
	}

	/**
	 * @param razonFirma el razonFirma para editar
	 */
	public void setRazonFirma(String razonFirma) {
		this.razonFirma = razonFirma;
	}

	/**
	 * @return el selladoTiempo
	 */
	public boolean isSelladoTiempo() {
		return selladoTiempo;
	}

	/**
	 * @param selladoTiempo el selladoTiempo para editar
	 */
	public void setSelladoTiempo(boolean selladoTiempo) {
		this.selladoTiempo = selladoTiempo;
	}

	/**
	 * @return el serial
	 */
	public String getSerial() {
		return serial;
	}

	/**
	 * @param serial el serial para editar
	 */
	public void setSerial(String serial) {
		this.serial = serial;
	}

	/**
	 * @return el validoDesde
	 */
	public Timestamp getValidoDesde() {
		return validoDesde;
	}

	/**
	 * @param validoDesde el validoDesde para editar
	 */
	public void setValidoDesde(Timestamp validoDesde) {
		this.validoDesde = validoDesde;
	}

	/**
	 * @return el validoHasta
	 */
	public Timestamp getValidoHasta() {
		return validoHasta;
	}

	/**
	 * @param validoHasta el validoHasta para editar
	 */
	public void setValidoHasta(Timestamp validoHasta) {
		this.validoHasta = validoHasta;
	}

	/**
	 * @return el firmados
	 */
	public FirDocfirmadosTEntidad getFirmados() {
		return firmados;
	}

	/**
	 * @param firmados el firmados para editar
	 */
	public void setFirmados(FirDocfirmadosTEntidad firmados) {
		this.firmados = firmados;
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
	 * @return la fechaCreacion
	 */
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion la fechaCreacion para editar
	 */
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
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
