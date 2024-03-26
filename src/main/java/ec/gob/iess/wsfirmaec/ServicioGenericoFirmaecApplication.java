/*
 * Copyrigth 2024 INSTITUTO ECUATORIANO DE SEGURIDAD SOCIAL - ECUADOR
 * Todos los derechos reservados
 */
package ec.gob.iess.wsfirmaec;

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

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * La clase principal que inicia el Servicio Genérico Firmaec.
 * Esta clase utiliza la anotación @SpringBootApplication para habilitar la configuración automática
 * y el inicio de Spring Boot.
 */
@SpringBootApplication
public class ServicioGenericoFirmaecApplication {

	 /**
     * El método principal que inicia la aplicación Spring Boot.
     *
     * @param args Los argumentos de la línea de comandos (si los hay).
     */
	public static void main(String[] args) {
		SpringApplication.run(ServicioGenericoFirmaecApplication.class, args);
		
	}

}