package swing_jdbc;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Carlos Salazar
 * @email dreamappsmx@gmail.com
 * @version 0.1
 */

public class Servicio implements Servicios{                
    
    private static Cliente cliente;
    private static Tarjeta tarjeta;
    private AccesoDatos datos;        
    
    @Override
    public void registraCliente(Cliente cliente) {
        Servicio.cliente = cliente;
        
        try {
            datos = new AccesoDatos();
            datos.conectar();
            datos.consultaIdCliente();
            datos.insertaUsuario(cliente);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    @Override
    public void registraTarjeta(Tarjeta tarjeta) {
        Servicio.tarjeta = tarjeta;
        
        try {
            datos = new AccesoDatos();
            datos.conectar();
            datos.consultaIdTarjeta();
            datos.insertarTarjeta(Servicio.tarjeta);
            datos.actualizarCliente();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }   
}
