package swing_jdbc;

import java.sql.*;

/**
 * @author Carlos Salazar
 * @email dreamappsmx@gmail.com
 * @version 0.1
 */

public class AccesoDatos {
    
    private String driver, usuario, contraseña;
    private Connection conexion;
    private static int id_cliente, id_tarjeta;
    
    public AccesoDatos() throws SQLException, ClassNotFoundException{
        driver = "oracle.jdbc.driver.OracleDriver";
        usuario = "final";
        contraseña = "final";
    }
    
    public void conectar() throws SQLException, ClassNotFoundException{                
        Class.forName(driver);        
        conexion = null;
        conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:CURSOBD", usuario, contraseña);               
    }
    
    public void consultaIdCliente() throws SQLException{            
        PreparedStatement sentencia = null;
 
        String query = "SELECT CLIENTE_SEQ.NEXTVAL FROM DUAL";
 		
	sentencia = conexion.prepareStatement(query);
        
        ResultSet resultado = sentencia.executeQuery();
 
        while (resultado.next())
          id_cliente = resultado.getInt("NEXTVAL");
    }                    
    
    public void insertaUsuario(Cliente cliente) throws SQLException {        
        String valores = "INSERT INTO CLIENTE(CLIENTE_ID, NOMBRE, APELLIDO_PATERNO, APELLIDO_MATERNO, RFC, EMAIL, DIRECCION) VALUES(" + id_cliente + ", '" + cliente.getNombre() + "', '" + cliente.getApellidoPaterno() + "', '" + cliente.getApellidoMaterno() + "', '" + cliente.getRfc() + "', '" + cliente.getEmail() + "', '" + cliente.getDireccion() + "')";
        
        Statement sentencia = conexion.createStatement();
        sentencia.executeUpdate(valores);
    }
    
    public void consultaIdTarjeta() throws SQLException{
        PreparedStatement sentencia = null;
 
        String query = "SELECT TARJETA_SEQ.NEXTVAL FROM DUAL";
 		
	sentencia = conexion.prepareStatement(query);
        
        ResultSet resultado = sentencia.executeQuery();
 
        while (resultado.next())
          id_tarjeta = resultado.getInt("NEXTVAL");
    }
    
    public void insertarTarjeta(Tarjeta tarjeta) throws SQLException{
        String valores = "INSERT INTO TARJETA_CLIENTE(TARJETA_CLIENTE_ID, NUMERO_TARJETA, MES_EXPIRACION, ANIO_EXPIRACION, NUMERO_SEGURIDAD) VALUES(" + id_tarjeta + ", '" +  tarjeta.getNumero() + "', '" + tarjeta.getMes() + "', '" + tarjeta.getAño() + "', '" +  tarjeta.getSeguridad() + "')";
        
        Statement sentencia = conexion.createStatement();
        sentencia.executeUpdate(valores);
    }
    
    public void actualizarCliente() throws SQLException{                
        String valores = "UPDATE CLIENTE SET TARJETA_CLIENTE_ID = " + id_tarjeta + " WHERE CLIENTE_ID = " + id_cliente;
        
        Statement sentencia = conexion.createStatement();
        sentencia.executeUpdate(valores);
    }
}
