package app.Client.Login;

import app.Services.ObjGraficosService;
import app.Services.RecursosService;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Image;

public class LoginTemplate extends JFrame{

    private ObjGraficosService sObjGraficos;//Objeto de la clase Service
    private RecursosService sRecursos;
    private JPanel pDerecha;
    private JPanel pIzquierda;
    private JLabel lTituloApp, lEslogan, lTituloLogin, lNotificaciones;
    private JTextField tNombreUsuario; 
    private JPasswordField tClaveUsuario;
    private JComboBox cbTipoUsuario;
    private JButton bEntrar, bCerrar, bRegistrarse, bOpcion1, bOpcion2, bOpcion3;
    private JCheckBox checkSi, checkNo;
    private ButtonGroup grupo;
    private ImageIcon iFondo, iSvg, iLogo, iUsuario, iClave, iPunto, iFacebook, iTwitter, iYoutube, iDimAux;
    private JLabel lFondo, lSvg, lLogo, lUsuario, lClave, lFacebook, lTwitter, lYoutube;//usados para incorporar imagenes
    
    private LoginComponent loginComponent;
    
    public LoginTemplate(LoginComponent loginComponent) {

        this.loginComponent = loginComponent;
        
        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();
        
        this.crearObjetosDecoradores();
        this.crearJPanels();
        this.crearJTextFields();
        this.crearJPasswordFields();
        this.crearJComboBoxes();
        this.crearJButtons();
        this.crearJCheckBoxes();
        this.crearJLabels();
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 500);
        setUndecorated(true);//Quitar barra por defecto superior
        setLayout(null);
        setLocationRelativeTo(this);//centrar pantalla
        setVisible(true);
    }
    
    //Metodos Crear
    private void crearObjetosDecoradores(){
        
        
        iFondo= new ImageIcon("resources/img/fondo.png");
        iSvg= new ImageIcon("resources/img/imagen.png");
        iLogo= new ImageIcon("resources/img/logo.png");
        iUsuario= new ImageIcon("resources/img/usuario.png");
        iClave= new ImageIcon("resources/img/clave.png");
        iPunto=new ImageIcon("resources/img/punto.png");
        iFacebook=new ImageIcon("resources/img/facebook.png");
        iTwitter = new ImageIcon("resources/img/twitter.png");
        iYoutube= new ImageIcon("resources/img/youtube.png");
            
    }
    
    private void crearJPanels(){  
        pIzquierda = sObjGraficos.construirJPanel(
                0, 0, 600, 500, Color.WHITE, null
        );
        this.add(pIzquierda);
        
        pDerecha= sObjGraficos.construirJPanel(
                600, 0, 400, 500, Color.WHITE, null
        );
        this.add(pDerecha);
    }
    
    private void crearJTextFields(){
        tNombreUsuario = sObjGraficos.construirJTextField(
                "Nombre Usuario", (pDerecha.getWidth()-260)/2, 130, 260, 40, 
                Color.WHITE, sRecursos.getColorAzul(), 
                sRecursos.getColorGrisOscuro(), null, 
                sRecursos.getBorderInferiorAzul(), "c"
        );
        pDerecha.add(tNombreUsuario);   
    }
    
    private void crearJPasswordFields(){
        tClaveUsuario = sObjGraficos.construirJPasswordField(
                "clave Usuario", (pDerecha.getWidth()-260)/2, 260, 260, 40, 
                null, sRecursos.getColorAzul(), sRecursos.getColorGrisOscuro(), 
                null, sRecursos.getBorderInferiorAzul(), "c"
        );
        pDerecha.add(tClaveUsuario);
    }
    
    private void crearJComboBoxes(){
        cbTipoUsuario = sObjGraficos.construirJComboBox(
                "Cliente_Cajero_Administrar", (pDerecha.getWidth()-220)/2, 210, 
                220, 30, Color.WHITE, sRecursos.getColorAzul(), "c"
        );
        pDerecha.add(cbTipoUsuario);
    }
    
    private void crearJButtons(){   
        bEntrar = sObjGraficos.construirJButton(
                "Entrar",(pDerecha.getWidth()-250)/2, 330, 250, 45, 
                sRecursos.getCMano(), null, null, sRecursos.getColorAzul(), 
                Color.WHITE, null, "c", true
        );
        bEntrar.addActionListener(loginComponent);
        pDerecha.add(bEntrar); 
        
        iDimAux = new ImageIcon(sRecursos.getICerrar().getImage().getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING));
        bCerrar = sObjGraficos.construirJButton(
                null, 350, 10, 45, 30, sRecursos.getCMano(), iDimAux, null, 
                null, null, null, "c", false
        );
        bCerrar.addActionListener(loginComponent);
        pDerecha.add(bCerrar);
        
        bRegistrarse = sObjGraficos.construirJButton(
                "Registrarse", 240, 460, 145, 35, sRecursos.getCMano(), null, 
                null, sRecursos.getColorAzul(), Color.WHITE, null, "c", true
        );
        bRegistrarse.addActionListener(loginComponent);
        pDerecha.add(bRegistrarse);
        
        iDimAux = new ImageIcon(iPunto.getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING));
        
        bOpcion1 = sObjGraficos.construirJButton(
                null, 10, 220, 30, 20, sRecursos.getCMano(), iDimAux, null,
                null, null, null, "C", false
        );
        bOpcion1.addActionListener(loginComponent);
        pIzquierda.add(bOpcion1);
        
        bOpcion2 = sObjGraficos.construirJButton(
                null, 10, 250, 30, 20, sRecursos.getCMano(), iDimAux, null, 
                null, null, null, "C", false
        );
        pIzquierda.add(bOpcion2);

        bOpcion3 = sObjGraficos.construirJButton(
                null, 10, 280, 30, 20, sRecursos.getCMano(), iDimAux, null, 
                null, null, null, "C", false
        );
        pIzquierda.add(bOpcion3);

    }
    
    private void crearJCheckBoxes(){
        
        checkSi = sObjGraficos.construirJCheckBox(
                "Si", (pDerecha.getWidth()-45)/2-15, 375, 45, 25, 
                sRecursos.getCMano(), null, null
        );
        pDerecha.add(checkSi);
        
        checkNo = sObjGraficos.construirJCheckBox(
                "No", (pDerecha.getWidth()+45)/2-15, 375, 45, 25, 
                sRecursos.getCMano(), null, null
        );
        pDerecha.add(checkNo);
        
        grupo = new ButtonGroup();
        grupo.add(checkSi);
        grupo.add(checkNo);
    }
    
    private void crearJLabels(){
        lTituloApp = sObjGraficos.construirJLabel(
                "Login Usuario", 100, 20, 220, 30, null, Color.WHITE, null, 
                sRecursos.getFontTPrincipal(), "c"
        );
        pIzquierda.add(lTituloApp);//Añadir sobre el panel
        
        lEslogan = sObjGraficos.construirJLabel(
                "Te ayudamos en todo", (pDerecha.getWidth()-130)/2, 60, 130, 
                20, null, sRecursos.getColorGrisOscuro(), null, 
                sRecursos.getFontSubtitulo(), "c"
        );
        pDerecha.add(lEslogan);
        
        lTituloLogin = sObjGraficos.construirJLabel(
                "Registra tus Datos", (pDerecha.getWidth()-150)/2, 80, 150, 30, 
                null, sRecursos.getColorGrisOscuro(), null, 
                sRecursos.getFontTitulo(), "c"
        );
        pDerecha.add(lTituloLogin);
        
        lNotificaciones = sObjGraficos.construirJLabel(
                "¿Recibir Notificaciones?", (pDerecha.getWidth()-140)/2, 400, 
                140, 20, null, sRecursos.getColorGrisOscuro(), null, 
                sRecursos.getFontSubtitulo(), "c"
        );
        pDerecha.add(lNotificaciones);
        
        iDimAux = new ImageIcon(iLogo.getImage().getScaledInstance(40, 40, Image.SCALE_AREA_AVERAGING));
        lLogo = sObjGraficos.construirJLabel(
                null, 50, 20, 40, 40, iDimAux, null, null, null, "c"
        );
        pIzquierda.add(lLogo);
        
        iDimAux = new ImageIcon(iSvg.getImage().getScaledInstance(500, 345, Image.SCALE_AREA_AVERAGING));
        lSvg = sObjGraficos.construirJLabel(
                null, 100, 100, 500, 345, iDimAux, null, null, null, "c"
        );
        pIzquierda.add(lSvg);
        
        iDimAux = new ImageIcon(iFacebook.getImage().getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING));
        lFacebook = sObjGraficos.construirJLabel(
                null, 20, 460, 30, 30, iDimAux, null, null, null, "c"
        );
        pIzquierda.add(lFacebook);

        iDimAux = new ImageIcon(iTwitter.getImage().getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)); 
        lTwitter = sObjGraficos.construirJLabel(
                null, 60, 460, 30, 30, iDimAux, null, null, null, "c"
        );
        pIzquierda.add(lTwitter);

        iDimAux = new ImageIcon(iYoutube.getImage().getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING));
        lYoutube = sObjGraficos.construirJLabel(
                null, 100, 460, 30, 30, iDimAux, null, null, null, "c"
        );
        pIzquierda.add(lYoutube);
        
        iDimAux = new ImageIcon(iFondo.getImage().getScaledInstance(600, 600, Image.SCALE_AREA_AVERAGING));//Dimension de la imagen a través de la variable auxiliar
        lFondo = sObjGraficos.construirJLabel(
                null, 0, 0, 600, 600, iDimAux, null, null, null, "c"
        );
        pIzquierda.add(lFondo);
        
        iDimAux = new ImageIcon(iUsuario.getImage().getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING));
        lUsuario = sObjGraficos.construirJLabel(
                null, 40, 140, 30, 30, iDimAux, null, null, null, "c"
        );
        pDerecha.add(lUsuario);

        iDimAux = new ImageIcon(iClave.getImage().getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING));
        lClave = sObjGraficos.construirJLabel(
                null, 40, 270, 30, 30, iDimAux, null, null, null, "c"
        );
        pDerecha.add(lClave);
    }
    
    
    //Metodos Get
    public JButton getBCerrar(){
        return this.bCerrar;
    }

    public JButton getBEntrar(){
        return this.bEntrar;
    }

    public JButton getBRegistrarse(){
        return this.bRegistrarse;
    }

    public JButton getBOpcion1(){
        return this.bOpcion1;
    }

    public JTextField getTNombreUsuario(){
        return this.tNombreUsuario;
    }

    public JPasswordField getTClaveUsuario(){
        return this.tClaveUsuario;
    }

    public JComboBox<String> getCbTipoUsuario(){
        return this.cbTipoUsuario;
    }

    public JCheckBox getCheckSi(){
        return this.checkSi;
    }

    public JCheckBox getCheckNo(){
        return this.checkNo;
    }
   
}

