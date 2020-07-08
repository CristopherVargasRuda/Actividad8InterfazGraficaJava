package app.Client.components.configuraciones;
//importa las Librerias
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
//clase que implementa las clases ouseListener,MouseMotionListener y MouseWheelListener
public class ConfiguracionesComponent implements MouseListener,
        MouseMotionListener, MouseWheelListener {
    
    //Declara un objeto ConfiguracionesTemplate 
    private ConfiguracionesTemplate configuracionesTemplate;
    
    //Metodo Constructor
    public ConfiguracionesComponent() {
        //instancia el objeto configuracionesTemplate
        this.configuracionesTemplate = new ConfiguracionesTemplate(this);
    }
    //metodo get que retorna el objeto ConfiguracionesTemplate
    public ConfiguracionesTemplate getConfiguracionesTemplate() {
        return this.configuracionesTemplate;
    }
    //Metodo que nos permite al momento de dar click enviarle y modificarle la informacion de los label
    //lPOnClickXValor y lPOnClickYValor
    @Override
    public void mouseClicked(MouseEvent e) {
        this.configuracionesTemplate.getLPOnClickXValor().setText(e.getX() + "");
        this.configuracionesTemplate.getLPOnClickYValor().setText(e.getY() + "");
    }
    //Metodo que nos permite que al presionar el botón del Mouse cambie la información de los Labels 
    //lPInicialXValor y lInicialYValor
    @Override
    public void mousePressed(MouseEvent e) {
        this.configuracionesTemplate.getLPInicialXValor().setText(e.getX() + "");
        this.configuracionesTemplate.getLPInicialYValor().setText(e.getY() + "");
    }
    //Metodo que nos permite que al soltar el botón del Mouse cambie la información de los Labels 
    //lPFinalXValor y lPFinalYValor:
    @Override
    public void mouseReleased(MouseEvent e) {
        this.configuracionesTemplate.getLPFinalXValor().setText(e.getX() + "");
        this.configuracionesTemplate.getLPFinalYValor().setText(e.getY() + "");
    }
    //Metodo que nos permite que al entrar al panel pDibujo cambie el valor de lEstadoValor 
    //para indicar que el estado ahora es ADENTRO:
    @Override
    public void mouseEntered(MouseEvent e) {
        this.configuracionesTemplate.getLEstadoValor().setText("ADENTRO");
    }
    //Metodo que nos permite que al salir del panel pDibujo cambie el valor de lEstadoValor
    //para indicar que el estado ahora es AFUERA:
    @Override
    public void mouseExited(MouseEvent e) {
        this.configuracionesTemplate.getLEstadoValor().setText("AFUERA");
    }
    //Metodo que nos permite actualizar la posición en tiempo real del Mouse mientras este mantenga oprimido el click
    //y para eso se cambia la información de los label lLadoXValor y lLadoYValor
    @Override
    public void mouseDragged(MouseEvent e) {
        this.configuracionesTemplate.getLLadoXValor().setText(e.getX() + "");
        this.configuracionesTemplate.getLLadoYValor().setText(e.getY() + "");
    }
    //Metodo que nos permite actualizar la posición en tiempo real del Mouse mientras este se mantenga dentro del panel
    //y para eso se cambia la información de los label lPActualXValor y lPActualYValor
    @Override
    public void mouseMoved(MouseEvent e) {
        this.configuracionesTemplate.getLPActualXValor().setText(e.getX() + "");
        this.configuracionesTemplate.getLPActualYValor().setText(e.getY() + "");
    }
    //Metodo que nos permite identificar el movimiento del scroll del mouse dentro del panel
    // y modificar la informacion de esta accion en el label lZoomValor
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int valorZoomActual = Integer.parseInt(this.configuracionesTemplate.getLZoomValor().getText());
        if (e.getWheelRotation() == -1) {
            this.configuracionesTemplate.getLZoomValor().setText(valorZoomActual + 1 + "");
        }
        if (e.getWheelRotation() == 1 && valorZoomActual > 0) {
            this.configuracionesTemplate.getLZoomValor().setText(valorZoomActual - 1 + "");
        }
    }
}