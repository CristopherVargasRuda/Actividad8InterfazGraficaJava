package app.Client.components.perfil;


public class PerfilComponent {
    private PerfilTemplate perfilTemplate;

    public PerfilComponent() {
        this.perfilTemplate = new PerfilTemplate(this);
    }
    
    
    public PerfilTemplate getPerfilTemplate() {
        return this.perfilTemplate;
    }
}
