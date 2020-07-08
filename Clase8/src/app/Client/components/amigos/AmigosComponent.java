package app.Client.components.amigos;


public class AmigosComponent {
    
    private AmigosTemplate amigosTemplate;

    public AmigosComponent() {
        this.amigosTemplate = new AmigosTemplate(this);
    }
    
    
    public AmigosTemplate getAmigosTemplate() {
        return this.amigosTemplate;
    }
    
}
