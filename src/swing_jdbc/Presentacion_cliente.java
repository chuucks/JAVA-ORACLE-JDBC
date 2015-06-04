package swing_jdbc;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author Carlos Salazar
 * @email dreamappsmx@gmail.com
 * @version 0.1
 */

public class Presentacion_cliente extends JFrame implements ActionListener{        
    
    private Container contenedor;
    
        private JPanel panel_titulo;
            private Label titulo;

        private JPanel panel_formulario; 

            private Label etiqueta_nombre;    
            private JTextArea texto_nombre;

            private Label etiqueta_apellido_paterno;  
            private JTextArea texto_apellido_paterno;

            private Label etiqueta_apellido_materno;    
            private JTextArea texto_apellido_materno;

            private Label etiqueta_rfc;
            private JTextArea texto_rfc;

            private Label etiqueta_email;
            private JTextArea texto_email;

            private Label etiqueta_direccion;
            private JTextArea texto_direccion;
    
    private JPanel panel_botones;
                
        private JButton boton_comfirmar;   
        
    public Presentacion_cliente(){
        super("Seguros para autos");
        setResizable(false);
        setSize(480, 320);
        setLocationRelativeTo(null);
        setFocusable(true);
        requestFocus(); 
        
        this.setLayout(new BorderLayout());
        añadirComponentes();               
        
        setVisible(true);
        setDefaultCloseOperation(3);
    } 
    
    private void añadirComponentes(){
        //Titulo
        panel_titulo = new JPanel();
        
        titulo = new Label("Datos del cliente");
        titulo.setFont(new Font("Arial", 1, 16));
        panel_titulo.add(titulo);
        
        //Formulario
        panel_formulario = new JPanel(new GridLayout(6, 1, 5, 5));
        
        etiqueta_nombre = new Label("Nombre: ");        
        texto_nombre = new JTextArea("", 2, 8);        
        panel_formulario.add(etiqueta_nombre);
        panel_formulario.add(texto_nombre);
        
        etiqueta_apellido_paterno = new Label("Apellido paterno: ");        
        texto_apellido_paterno = new JTextArea("", 2, 8);
        panel_formulario.add(etiqueta_apellido_paterno);
        panel_formulario.add(texto_apellido_paterno);
        
        etiqueta_apellido_materno = new Label("Apellido materno: ");      
        texto_apellido_materno = new JTextArea("", 2, 8);
        panel_formulario.add(etiqueta_apellido_materno);
        panel_formulario.add(texto_apellido_materno);
        
        etiqueta_rfc = new Label("RFC(13): ");      
        texto_rfc = new JTextArea("", 2, 8);
        panel_formulario.add(etiqueta_rfc);
        panel_formulario.add(texto_rfc);
        
        etiqueta_email = new Label("eMail: ");      
        texto_email = new JTextArea("", 2, 8);
        panel_formulario.add(etiqueta_email);
        panel_formulario.add(texto_email);
        
        etiqueta_direccion = new Label("Dirección: ");
        texto_direccion = new JTextArea("", 2, 8);
        panel_formulario.add(etiqueta_direccion);
        panel_formulario.add(texto_direccion);
        
        //Contenedor del panel titulo y formulario
        contenedor = new Container();
        contenedor.setLayout(new BorderLayout());
        contenedor.add(panel_titulo, "North");
        contenedor.add(panel_formulario, "South");
        
        //Boton                
        panel_botones = new JPanel();       
        
        boton_comfirmar = new JButton("Siguiente");
        boton_comfirmar.addActionListener(this);
        panel_botones.add(boton_comfirmar);               
        
        this.add(contenedor, "North");
        this.add(panel_botones, "South");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nombre = texto_nombre.getText();
        String ap_paterno = texto_apellido_paterno.getText();
        String ap_materno = texto_apellido_materno.getText();
        String rfc = texto_rfc.getText();
        String email = texto_email.getText();
        String direccion = texto_direccion.getText();
        
        if(!nombre.isEmpty() && !ap_paterno.isEmpty() && !ap_materno.isEmpty() && !rfc.isEmpty() && !email.isEmpty() && !direccion.isEmpty() && email.contains("@")){
            Servicio servicio = new Servicio();            
            servicio.registraCliente(new Cliente(nombre, ap_paterno, ap_materno, rfc, email, direccion));
            
            dispose();
            Presentacion_tarjeta tarjeta = new Presentacion_tarjeta();
        }else{
            JOptionPane.showMessageDialog(this, "Ingrese todos los campos y/o valide su email");
        }            
    }        
}