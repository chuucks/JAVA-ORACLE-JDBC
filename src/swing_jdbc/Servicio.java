package swing_jdbc;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Carlos Salazar
 * @email dreamappsmx@gmail.com
 * @version 0.1
 */

//Clase que implementa la capa de negocio
public class Servicio implements Servicios{                
    
    //Variables de tipo cliente y tarjeta para cumplir con los procesos de negocio
    private Cliente cliente;
    private Tarjeta tarjeta;
    
    //Variable que permite las conexiones a ORACLE
    private AccesoDatos datos;            
    
    //Método que registra el cliente llamando a la capa de acceso a datos
    @Override
    public void registraCliente(Cliente cliente) {
        this.cliente = cliente;
        
        try {
            datos = new AccesoDatos();
            datos.conectar();
            datos.consultaIdCliente();
            datos.insertaUsuario(this.cliente);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    //Método que registra la tarjeta llamando a la capa de acceso a datos
    @Override
    public void registraTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
        
        try {
            datos = new AccesoDatos();
            datos.conectar();
            datos.consultaIdTarjeta();
            datos.insertarTarjeta(this.tarjeta);
            datos.actualizarCliente();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }   
}
