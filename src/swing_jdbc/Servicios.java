package swing_jdbc;

/**
 * @author Carlos Salazar
 * @email dreamappsmx@gmail.com
 * @version 0.1
 */

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
