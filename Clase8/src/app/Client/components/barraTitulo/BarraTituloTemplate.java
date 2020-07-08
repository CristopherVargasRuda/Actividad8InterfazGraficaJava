package app.Client.components.barraTitulo;

import app.Services.ObjGraficosService;
import app.Services.RecursosService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class BarraTituloTemplate extends JPanel{

    private BarraTituloComponent barraTituloComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    
    //Declaración objetos gráficos
    private JLabel lLogoApp, lTituloApp;
    private JButton bCerrar;

    //Declaración Objetos Decoradores
    private ImageIcon iLogoApp, iDimAux;
    private Font fontTituloBarra;
    
    public BarraTituloTemplate(BarraTituloComponent barraTituloComponent){

        this.barraTituloComponent = barraTituloComponent;
        this.sObjGraficos= ObjGraficosService.getService();
        this.sRecursos = RecursosService.getService();
    
        this.crearObjetosDecoradores();
        this.crearJLabels();
        this.crearJButtons();
        
        this.setSize(850, 50);
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        this.setVisible(true);
    
    }
    
    public void crearObjetosDecoradores(){
        iLogoApp = new ImageIcon("resources/img/logo_app.png");
        fontTituloBarra= new Font("Britannic Bold", Font.PLAIN, 24);
    }

    public void crearJButtons(){

        iDimAux = new ImageIcon(
            sRecursos.getICerrar().getImage().getScaledInstance(23, 23, Image.SCALE_AREA_AVERAGING)
        );
        bCerrar = sObjGraficos.construirJButton(
            null, 800, 10, 45, 30, sRecursos.getCMano(), iDimAux, null, 
            null, null, null, "c", false
        );
        bCerrar.addActionListener(barraTituloComponent);
        this.add(bCerrar);
    }
    
    public void crearJLabels(){

        // LABEL LOGO APP--------------------------------------------------------------------
        iDimAux = new ImageIcon(
            iLogoApp.getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING)
        );
        lLogoApp = sObjGraficos.construirJLabel(
            null, 20, 0, 50, 50, iDimAux, null, null, null, "c"
        );
        this.add(lLogoApp);

        // LABEL TITULO APP--------------------------------------------------------------------
        lTituloApp = sObjGraficos.construirJLabel(
            "ProductList", 40, 5, 200, 40, null, sRecursos.getColorAzul(), null, 
                fontTituloBarra, "c"
        );
        this.add(lTituloApp);
    }
}
