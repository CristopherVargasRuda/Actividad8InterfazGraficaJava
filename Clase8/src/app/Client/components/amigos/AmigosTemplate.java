package app.Client.components.amigos;

import java.awt.Color;
import javax.swing.JPanel;


public class AmigosTemplate extends JPanel{
    private AmigosComponent amigosComponent;
    
    public AmigosTemplate(AmigosComponent amigosComponent){
        this.amigosComponent = amigosComponent;
        
        this.setSize(850, 600);
        this.setBackground(Color.black);
        this.setLayout(null);
        this.setVisible(true);
    }
    
}
