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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Clase que instancia la utilización y manejo de servicios REST en las clases.
 */
@Configuration
public class PlantillaRestUtilitario {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
