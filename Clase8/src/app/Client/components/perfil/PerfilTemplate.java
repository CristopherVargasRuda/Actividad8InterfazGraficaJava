package app.Client.components.perfil;

import java.awt.Color;
import javax.swing.JPanel;


public class PerfilTemplate extends JPanel{
    private PerfilComponent perfilComponent;
    
    public PerfilTemplate(PerfilComponent perfilComponent){
        this.perfilComponent = perfilComponent;
        
        this.setSize(850, 600);
        this.setBackground(Color.BLUE);
        this.setLayout(null);
        this.setVisible(true);
    }
    
}
