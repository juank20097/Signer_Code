package ec.gob.iess.wsfirmaec.Entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="FIR_SISTEMAS_TP")
@SequenceGenerator(name = "fir_sistemas_s", sequenceName = "fir_sistemas_s", allocationSize = 1)
@NamedQuery(name="FirSistemasTPEntidad.findAll", query="SELECT f FROM FirSistemasTPEntidad f")
public class FirSistemasTPEntidad {

	 	@Id
	 	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fir_sistemas_s")
	 	@Column(name="id", length = 38,nullable = false)
	    private Long id;

	    @Column(length = 255)
	    private String url;

	    @Column(name = "apikey", length = 255)
	    private String apiKey;

	    @Column(name = "apikeyrest", length = 255)
	    private String apiKeyRest;

	    @Column(length = 255)
	    private String descripcion;

	    @Column(length = 255)
	    private String nombre;

		/**
		 * @return el id
		 */
		public Long getId() {
			return id;
		}

		/**
		 * @param id el id a establecer
		 */
		public void setId(Long id) {
			this.id = id;
		}

		/**
		 * @return la url
		 */
		public String getUrl() {
			return url;
		}

		/**
		 * @param url la url a establecer
		 */
		public void setUrl(String url) {
			this.url = url;
		}

		/**
		 * @return la apiKey
		 */
		public String getApiKey() {
			return apiKey;
		}

		/**
		 * @param apiKey la apiKey a establecer
		 */
		public void setApiKey(String apiKey) {
			this.apiKey = apiKey;
		}

		/**
		 * @return la apiKeyRest
		 */
		public String getApiKeyRest() {
			return apiKeyRest;
		}

		/**
		 * @param apiKeyRest la apiKeyRest a establecer
		 */
		public void setApiKeyRest(String apiKeyRest) {
			this.apiKeyRest = apiKeyRest;
		}

		/**
		 * @return la descripción
		 */
		public String getDescripcion() {
			return descripcion;
		}

		/**
		 * @param descripcion la descripción a establecer
		 */
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		/**
		 * @return el nombre
		 */
		public String getNombre() {
			return nombre;
		}

		/**
		 * @param nombre el nombre a establecer
		 */
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

	    
	    
}
