package app.Client.components.accion;

import app.Services.ObjGraficosService;
import app.Services.RecursosService;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class AccionTemplate extends JPanel {

    private AccionComponent accionComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private JLabel lImagen, lTitulo, lParrafo;
    private ImageIcon iDimAux;
    
    public AccionTemplate(
            AccionComponent accionComponent, ImageIcon imagen, String titulo, 
            String parrafo
        ) {

        this.accionComponent = accionComponent;
        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();
        
        iDimAux = new ImageIcon(
                imagen.getImage().getScaledInstance(45, 45, Image.SCALE_AREA_AVERAGING)
        );
        this.lImagen = sObjGraficos.construirJLabel(
                null, (250 - 60) / 2, 5, 45, 45, iDimAux, null, null, null, "c"
        );
        this.add(lImagen);
        
        this.lTitulo = sObjGraficos.construirJLabel(
                titulo, (250 - 220) / 2, 50, 220, 30, null, 
                sRecursos.getColorGrisOscuro(), null, 
                sRecursos.getFontTitulo(), "c"
        );
        this.add(lTitulo);
        
        this.lParrafo = sObjGraficos.construirJLabel(
                parrafo, (250 - 230) / 2, 75, 230, 50, null, 
                sRecursos.getColorGrisOscuro(), null, 
                sRecursos.getFontPequeña(), "c"
        );
        this.add(lParrafo);
        
        this.setSize(250, 125);
        this.setBackground(Color.WHITE);
        this.setBorder(sRecursos.getBorderGris());
        this.setLayout(null);
        this.setVisible(true);
    }

    AccionTemplate(AccionComponent aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

