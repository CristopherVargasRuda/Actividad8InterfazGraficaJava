package app.Client.components.navegacionUsuario;

import app.Client.VistaPrincipal.VistaPrincipalComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NavegacionUsuarioComponent implements ActionListener {

    private NavegacionUsuarioTemplate navegacionUsuarioTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    
    public NavegacionUsuarioComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        this.navegacionUsuarioTemplate =  new NavegacionUsuarioTemplate(this);
    }
    
    public NavegacionUsuarioTemplate getNavegacionUsuarioTemplate() {
        return this.navegacionUsuarioTemplate;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.vistaPrincipalComponent.mostrarComponente(e.getActionCommand().trim()); //trim quita los espacios anteriores al texto 
    }

    
}