package app.Client.components.productos;

import java.awt.Color;
import javax.swing.JPanel;


public class ProductosTemplate extends JPanel{
    private ProductosComponent productosComponent;
    
    public ProductosTemplate(ProductosComponent productosComponent){
        this.productosComponent = productosComponent;
        
        this.setSize(850, 600);
        this.setBackground(Color.YELLOW);
        this.setLayout(null);
        this.setVisible(true);
    }
    
}
