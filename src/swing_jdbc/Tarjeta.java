package swing_jdbc;

/**
 * @author Carlos Salazar
 * @email dreamappsmx@gmail.com
 * @version 0.1
 */

public class Tarjeta{
        
    String numero_tarjeta, mes_expiracion, año_expiracion, numero_seguridad;
    
    public Tarjeta(String numero_tarjeta, String mes_expiracion, String año_expiracion, String numero_seguridad){        
        this.numero_tarjeta = numero_tarjeta;
        this.mes_expiracion = mes_expiracion;
        this.año_expiracion = año_expiracion;
        this.numero_seguridad = numero_seguridad;
    }
    
    public String getNumero(){
        return numero_tarjeta;
    }
    
    public String getMes(){
        return mes_expiracion;
    }
    
    public String getAño(){
        return año_expiracion;
    }
    
    public String getSeguridad(){
        return numero_seguridad;
    }
    
    @Override
    public String toString(){
      return numero_tarjeta + " " + mes_expiracion + " " + año_expiracion + " " + numero_seguridad;   
    }
}
