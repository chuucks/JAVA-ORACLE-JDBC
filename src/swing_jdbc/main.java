/*
 * UNAM Facultad de Ingenería
 * Bases de Datos 2015-2
 * Proyecto final
 * Jiménez Saavedra Raúl Rodolfo
 * Salazar Cárdenas Carlos Eduardo 
 */

package swing_jdbc;

import java.sql.SQLException;

/**
 * @author Carlos Salazar
 * @email dreamappsmx@gmail.com
 * @version 0.1
 */

//Esta es una aplicación que interactua con una base de datos mediante JDBC
//También interactua con el usuario mediante una interfaz echa en SWING
public class main {    
        
    public static void main(String[] args){
        //Llamada a la capa de presentación
        Presentacion_cliente cliente = new Presentacion_cliente();        
    }    
}