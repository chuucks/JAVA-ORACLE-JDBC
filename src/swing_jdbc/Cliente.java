package swing_jdbc;

/**
 * @author Carlos Salazar
 * @email dreamappsmx@gmail.com
 * @version 0.1
 * 
 */

public class Cliente{
    
    private String nombre, ap_paterno, ap_materno, rfc, email, direccion;
    
    public Cliente(String nombre, String ap_paterno, String ap_materno, String rfc, String email, String direccion){
        this.nombre = nombre;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.rfc = rfc;
        this.email = email;
        this.direccion = direccion;        
    }    
    
    public String getNombre(){
        return nombre;
    }
    
    public String getApellidoPaterno(){
        return ap_paterno;
    }
    
    public String getApellidoMaterno(){
        return ap_materno;
    }
    
    public String getRfc(){
        return rfc;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getDireccion(){
        return direccion;
    }
    
    @Override
    public String toString(){
        return nombre + " " + ap_paterno + " " + ap_materno + " "+ rfc + " " + email + " " + direccion;
    }
    
}