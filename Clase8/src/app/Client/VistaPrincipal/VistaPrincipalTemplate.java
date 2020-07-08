
package app.Client.VistaPrincipal;

import app.Services.RecursosService;
import app.Services.ObjGraficosService;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VistaPrincipalTemplate extends JFrame{
    
    private VistaPrincipalComponent vistaPrincipalComponent;
    private ObjGraficosService sObjGraficos;
    private JPanel pNavegacion, pBarra, pPrincipal;
    
    public VistaPrincipalTemplate(VistaPrincipalComponent vistaPrincipalComponent){
        super("Vista Principal");
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        
        sObjGraficos = ObjGraficosService.getService();
        
        
        this.crearJPanels();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(1100, 650);
        setLocationRelativeTo(this);
        setLayout(null);
        
        setVisible(true);
        
    }
    
    public void crearJPanels(){
        pNavegacion = sObjGraficos.construirJPanel(0, 0, 250, 700, null, null);
        this.add(pNavegacion);

        pBarra = sObjGraficos.construirJPanel(250, 0, 850, 50, null, null);
        this.add(pBarra);

        pPrincipal = sObjGraficos.construirJPanel(250, 50, 850, 600, null, null);
        this.add(pPrincipal);
    }

    public JPanel getpNavegacion() {
        return pNavegacion;
    }

    public JPanel getpBarra() {
        return pBarra;
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }
    
    
    
    
}
