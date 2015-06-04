package swing_jdbc;

/**
 * @author Carlos Salazar
 * @email dreamappsmx@gmail.com
 * @version 0.1
 */

//Interfaz que define los métodos necesarios para implementar la capa de sericio de la aplicación
public interface Servicios {
            
    /**
     *
     * @param cliente
     */
    public void registraCliente(Cliente cliente);
    
    /**
     *
     * @param tarjeta
     */
    public void registraTarjeta(Tarjeta tarjeta);
    
}
