package app.Client.VistaPrincipal;

import app.Client.Login.LoginComponent;
import app.Client.components.barraTitulo.BarraTituloComponent;
import app.Client.components.navegacionUsuario.NavegacionUsuarioComponent;
import app.Client.components.inicio.InicioComponent;
import app.Client.components.perfil.PerfilComponent;
import app.Client.components.amigos.AmigosComponent;
import app.Client.components.configuraciones.ConfiguracionesComponent;
import app.Client.components.productos.ProductosComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaPrincipalComponent implements ActionListener{

    private VistaPrincipalTemplate vistaPrincipalTemplate;
    private BarraTituloComponent barraTituloComponent;
    private NavegacionUsuarioComponent navegacionUsuarioComponent;
    private LoginComponent loginComponent;
    private InicioComponent inicioComponent;
    private PerfilComponent perfilComponent;
    private ConfiguracionesComponent configuracionesComponent;
    private ProductosComponent productosComponent;
    private AmigosComponent amigosComponent;


    public VistaPrincipalComponent(LoginComponent loginComponent){
        this.loginComponent = loginComponent;
        this.vistaPrincipalTemplate = new VistaPrincipalTemplate(this);
        this.barraTituloComponent = new BarraTituloComponent();
        this.navegacionUsuarioComponent = new NavegacionUsuarioComponent(this);
        
        vistaPrincipalTemplate.getpBarra().add(
                barraTituloComponent.getBarraTituloTemplate()
        );
        
        vistaPrincipalTemplate.getpNavegacion().add(
            navegacionUsuarioComponent.getNavegacionUsuarioTemplate()
        );
        
        vistaPrincipalTemplate.repaint();
    }
    
    public void mostrarComponente(String comando){
        vistaPrincipalTemplate.getpPrincipal().removeAll();
        switch(comando){
            case "Inicio":
                if (this.inicioComponent == null)
                    this.inicioComponent = new InicioComponent();
                vistaPrincipalTemplate.getpPrincipal().add(
                    inicioComponent.getInicioTemplate()
                );
                break;
            case "Perfil":
                if (this.perfilComponent == null)
                    this.perfilComponent = new PerfilComponent();
                vistaPrincipalTemplate.getpPrincipal().add(
                    perfilComponent.getPerfilTemplate()
                );
                break;
            case "Amigos":
                if (this.amigosComponent == null)
                    this.amigosComponent = new AmigosComponent();
                vistaPrincipalTemplate.getpPrincipal().add(
                    amigosComponent.getAmigosTemplate()
                );
                break;
            case "Productos":
                if (this.productosComponent == null)
                    this.productosComponent = new ProductosComponent();
                vistaPrincipalTemplate.getpPrincipal().add(
                    productosComponent.getProductosTemplate()
                );
                break;
            case "Configuraciones":
                if (this.configuracionesComponent == null)
                    this.configuracionesComponent = new ConfiguracionesComponent();
                vistaPrincipalTemplate.getpPrincipal().add(
                    configuracionesComponent.getConfiguracionesTemplate()
                );
                break;
            case "Cerrar Sesión":
                this.loginComponent.getLoginTemplate().setVisible(true);
                this.vistaPrincipalTemplate.setVisible(false);  
                break;
        }
        vistaPrincipalTemplate.repaint();
    }

    public VistaPrincipalTemplate getVistaPrincipalTemplate() {
        return vistaPrincipalTemplate;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    
}
