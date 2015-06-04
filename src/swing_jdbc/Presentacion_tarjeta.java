package swing_jdbc;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
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

//Esta clase implementa la capa de presentación para la interfaz del registro de la tarjeta
public class Presentacion_tarjeta extends JFrame implements ActionListener{        
    
    //Se declaran los elementos de Java SWING para la interfaz de usuario
    private Container contenedor;
    
        private JPanel panel_titulo;
            private Label titulo;

        private JPanel panel_formulario; 
            private Label etiqueta_numero_tarjeta;
            private JTextArea texto_numero_tarjeta;
            private Label etiqueta_mes;
            private JTextArea texto_mes;
            private Label etiqueta_año;
            private JTextArea texto_año;
            private Label etiqueta_numero_seguridad;
            private JTextArea texto_numero_seguridad;

            private Label etiqueta_nombre;    
            private JTextArea texto_nombre;           
    
    private JPanel panel_botones;
                
        private JButton boton_comfirmar;   
    
    //En el método constructor se definen los parametros de la ventana como el titulo, el tamaño, etc
    public Presentacion_tarjeta(){
        super("Seguros para autos");
        setResizable(false);
        setSize(480, 220);
        setLocationRelativeTo(null);
        setFocusable(true);
        requestFocus(); 
        
        this.setLayout(new BorderLayout());
        añadirComponentes();
        
        setVisible(true);
        setDefaultCloseOperation(3);
    } 
    
    //En este método se agregan los elementos de la interfaz gráfica a la ventana, 
    //definiendo el layout con el que se van a presentar
    private void añadirComponentes(){                

        //Titulo
        panel_titulo = new JPanel();
        
        titulo = new Label("Datos de la tarjeta");
        titulo.setFont(new Font("Arial", 1, 16));
        panel_titulo.add(titulo);
        
        //Formulario
        panel_formulario = new JPanel(new GridLayout(4, 1, 5, 5));
        
        etiqueta_numero_tarjeta = new Label("Numero tarjeta: ");
        texto_numero_tarjeta = new JTextArea();
        panel_formulario.add(etiqueta_numero_tarjeta);
        panel_formulario.add(texto_numero_tarjeta);
        
        etiqueta_mes = new Label("Mes expiracion(2): ");
        texto_mes = new JTextArea();
        panel_formulario.add(etiqueta_mes);
        panel_formulario.add(texto_mes);
        
        etiqueta_año = new Label("Año expiracion(4): ");
        texto_año = new JTextArea();
        panel_formulario.add(etiqueta_año);
        panel_formulario.add(texto_año);
        
        etiqueta_numero_seguridad = new Label("Numero seguridad(3): ");
        texto_numero_seguridad = new JTextArea();
        panel_formulario.add(etiqueta_numero_seguridad);
        panel_formulario.add(texto_numero_seguridad);
        
        //Contenedor
        contenedor = new Container();
        contenedor.setLayout(new BorderLayout());
        contenedor.add(panel_titulo, "North");
        contenedor.add(panel_formulario, "South");
        
        //Boton                
        panel_botones = new JPanel();       
        
        boton_comfirmar = new JButton("Ok");
        boton_comfirmar.addActionListener(this);
        panel_botones.add(boton_comfirmar);
        
        this.add(contenedor, "North");
        this.add(panel_botones, "South");
    }
    
    //En este método se definen las acciones a realizar cuando se oprime el botón
    @Override
    public void actionPerformed(ActionEvent e){
        String tarjeta = texto_numero_tarjeta.getText();
        String mes = texto_mes.getText();
        String año = texto_año.getText();
        String seguridad = texto_numero_seguridad.getText();
        
        if(!tarjeta.isEmpty()&& !mes.isEmpty() && !año.isEmpty() && !seguridad.isEmpty()){
            Servicio servicio = new Servicio();
            servicio.registraTarjeta(new Tarjeta(tarjeta, mes, año, seguridad));
            JOptionPane.showMessageDialog(this, "Cliente y terjeta correctamente registrados");
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }else
            JOptionPane.showMessageDialog(this, "Ingrese todos los campos");
    }
}