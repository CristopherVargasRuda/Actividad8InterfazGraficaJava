package app.Client.components.tarjeta;

import app.Services.ObjGraficosService;
import app.Services.RecursosService;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TarjetaTemplate extends JPanel {

    private TarjetaComponent tarjetaComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private JLabel lTitulo, lImagen, lParrafo;
    private ImageIcon iDimAux;

    public TarjetaTemplate(
            TarjetaComponent tarjetaComponent, String titulo, ImageIcon iImagen,
            String parrafo
    ) {

        this.tarjetaComponent = tarjetaComponent;
        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();

        iDimAux = new ImageIcon(
                iImagen.getImage().getScaledInstance(246, 110, Image.SCALE_AREA_AVERAGING)
        );
        lImagen = sObjGraficos.construirJLabel(
                null, 5, 5, 246, 110, iDimAux, null, null, null, "c"
        );
        this.add(lImagen);
        
        this.lTitulo = sObjGraficos.construirJLabel(
                titulo, -15, 120, 180, 30, null, sRecursos.getColorAzul(), 
                null, sRecursos.getFontTitulo(), "c"
        );
        this.add(lTitulo);
        
        lParrafo = sObjGraficos.construirJLabel(
                parrafo, 20, 120, 206, 120, null, 
                sRecursos.getColorGrisOscuro(), null, 
                sRecursos.getFontPequeña(), "c"
        );
        this.add(lParrafo);
        
        

        this.setSize(256, 230);
        this.setBackground(Color.white);
        this.setLayout(null);
        this.setVisible(true);
    }

}
