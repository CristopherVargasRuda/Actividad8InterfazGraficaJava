package app.Client.components.configuraciones;
//importa las librerias
import app.Services.ObjGraficosService;
import app.Services.RecursosService;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConfiguracionesTemplate extends JPanel {
    
    // Declaración objetos
    private ConfiguracionesComponent configuracionesComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursosService;
    private Cursor cCruz;
    private JPanel pDibujo, pDatos;

    // Declaración Labels Estáticos
    private JLabel lTitulo, lTituloPosicion, lTituloEstado;
    private JLabel lPOnClickX, lPOnClickY, lPInicialX, lPInicialY, lPFinalX, lPFinalY;
    private JLabel lPActualX, lPActualY, lLadoX, lLadoY, lZoom, lEstado;

    // Declaración Labels Dinámicos
    private JLabel lPOnClickXValor, lPOnClickYValor, lPInicialXValor, lPInicialYValor;
    private JLabel lPFinalXValor, lPFinalYValor, lPActualXValor, lPActualYValor;
    private JLabel lLadoXValor, lLadoYValor, lZoomValor, lEstadoValor;
    //Crea el metodo constructor de la clase que va a recibir como parametro un elemento ConfiguracionesComponent
    public ConfiguracionesTemplate(ConfiguracionesComponent configuracionesComponent) {
        
        //iguala la variable local al objeto que llega por parametro
        this.configuracionesComponent = configuracionesComponent;
        
        //llama el getService() de ObjGraficosService y RecursosService y los asigna 
        //a su respectiva variable de esta clase
        sObjGraficos = ObjGraficosService.getService();
        sRecursosService = RecursosService.getService();
        
        //Llama a los metodos de la clase
        this.crearObjetosDecoradores();
        this.crearJPanels();
        this.crearJLabelsEstaticos();
        this.crearJLabelsDinamicos();

        //dimesniones y propiedades del panel
        this.setSize(850, 600);
        this.setBackground(sRecursosService.getColorGrisClaro());
        this.setLayout(null);
        this.setVisible(true);
    }

    //Metodo de los objetos decoradores
    public void crearObjetosDecoradores() {
        //Crea un cursor del tipo CROSSHAIR_CURSOR
        this.cCruz = new Cursor(Cursor.CROSSHAIR_CURSOR);
    }
    
    //Metodo de los Paneles
    public void crearJPanels() {
        //asigna las caracteristicas necesarias al panel pDibujo
        pDibujo = sObjGraficos.construirJPanel(15, 15, 500, 570, Color.WHITE, sRecursosService.getBorderGris());
        pDibujo.setCursor(cCruz);
        //al panel pDibujo le agrega la capacidad de escuchar eventos tipo MouseMotionListener 
        //y tipo MouseWheelListener
        //y les ása como argumento los objetos de esta clase ConfiguracionesComponentes
        pDibujo.addMouseMotionListener(this.configuracionesComponent);
        pDibujo.addMouseWheelListener(this.configuracionesComponent);
        pDibujo.addMouseListener(this.configuracionesComponent);
        //Agrega el panel pDibujo al panel general
        this.add(pDibujo);
        
        //asigna las caracteristicas necesarias al panel pDatos
        pDatos = sObjGraficos.construirJPanel(530, 15, 305, 570, Color.WHITE, sRecursosService.getBorderGris());
        //Agrega el panel pDatos al panel general
        this.add(pDatos);
    }
//Metodo para Crear los Label Estaticos
    public void crearJLabelsEstaticos() {
        // LABEL TITULO -------------------------------------------------------------------------
        lTitulo = sObjGraficos.construirJLabel(
                "Datos de Eventos", (this.pDatos.getWidth() - 200) / 2, 15, 200, 40, null,
                sRecursosService.getColorAzul(), null, sRecursosService.getFontTitulo(), "c"
        );
        pDatos.add(lTitulo);

        // LABEL TITULO POSICIÓN-----------------------------------------------------------------
        lTituloPosicion = sObjGraficos.construirJLabel(
                "Datos de Posiciones", 20, 60, 180, 40, null, sRecursosService.getColorMorado(),
                null, sRecursosService.getFontTitulo(), "l"
        );
        pDatos.add(lTituloPosicion);

        // LABEL TITULO ESTADO--------------------------------------------------------------------
        lTituloEstado = sObjGraficos.construirJLabel(
                "Datos de Estado", 20, 440, 180, 40, null, sRecursosService.getColorMorado(),
                null, sRecursosService.getFontTitulo(), "l"
        );
        pDatos.add(lTituloEstado);

        // LABEL POSICIÓN EN X CON CLICK----------------------------------------------------------
        lPOnClickX = sObjGraficos.construirJLabel(
                "Posición en X al dar click: ", 40, 100, 160, 40, null, sRecursosService.getColorAzul(),
                null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPOnClickX);

        // LABEL POSICIÓN EN Y CON CLICK----------------------------------------------------------
        lPOnClickY = sObjGraficos.construirJLabel(
                "Posición en Y al dar click: ", 40, 120, 160, 40, null, sRecursosService.getColorAzul(),
                null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPOnClickY);

        // LABEL POSICIÓN EN X INICIAL----------------------------------------------------------
        lPInicialX = sObjGraficos.construirJLabel(
                "Posición en X inicial: ", 40, 160, 160, 40, null, sRecursosService.getColorAzul(),
                null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPInicialX);

        // LABEL POSICIÓN EN Y INICIAL----------------------------------------------------------
        lPInicialY = sObjGraficos.construirJLabel(
                "Posición en Y inicial: ", 40, 180, 160, 40, null, sRecursosService.getColorAzul(),
                null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPInicialY);

        // LABEL POSICIÓN EN X FINAL----------------------------------------------------------
        lPFinalX = sObjGraficos.construirJLabel(
                "Posición en X final: ", 40, 220, 160, 40, null, sRecursosService.getColorAzul(),
                null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPFinalX);

        // LABEL POSICIÓN EN Y FINAL----------------------------------------------------------
        lPFinalY = sObjGraficos.construirJLabel(
                "Posición en Y final: ", 40, 240, 160, 40, null, sRecursosService.getColorAzul(),
                null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPFinalY);

        // LABEL POSICIÓN EN X ACTUAL----------------------------------------------------------
        lPActualX = sObjGraficos.construirJLabel(
                "Posición en X actual: ", 40, 280, 160, 40, null, sRecursosService.getColorAzul(),
                null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPActualX);

        // LABEL POSICIÓN EN Y ACTUAL----------------------------------------------------------
        lPActualY = sObjGraficos.construirJLabel(
                "Posición en Y actual: ", 40, 300, 160, 40, null, sRecursosService.getColorAzul(),
                null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPActualY);

        // LABEL LADO EN X -------------------------------------------------------------------
        lLadoX = sObjGraficos.construirJLabel(
                "Valor lado X: ", 40, 340, 160, 40, null, sRecursosService.getColorAzul(),
                null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lLadoX);

        // LABEL LADO EN Y --------------------------------------------------------------------
        lLadoY = sObjGraficos.construirJLabel(
                "Valor lado Y: ", 40, 360, 160, 40, null, sRecursosService.getColorAzul(),
                null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lLadoY);

        // LABEL ZOOM --------------------------------------------------------------------------
        lZoom = sObjGraficos.construirJLabel(
                "Zoom en el panel: ", 40, 400, 160, 40, null, sRecursosService.getColorAzul(),
                null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lZoom);

        // LABEL ESTADO ------------------------------------------------------------------------
        lEstado = sObjGraficos.construirJLabel(
                "Estado: ", 40, 480, 160, 40, null, sRecursosService.getColorAzul(),
                null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lEstado);
    }
    //Metodo para Crear Labels Dinamicos
    public void crearJLabelsDinamicos() {

        // LABEL POSICIÓN EN X CON CLICK VALOR -----------------------------------------------------
        lPOnClickXValor = sObjGraficos.construirJLabel(
                "0", 200, 100, 160, 40, null, sRecursosService.getColorAzul(),
                null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPOnClickXValor);

        // LABEL POSICIÓN EN Y CON CLICK VALOR -----------------------------------------------------
        lPOnClickYValor = sObjGraficos.construirJLabel(
                "0", 200, 120, 160, 40, null, sRecursosService.getColorAzul(),
                null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPOnClickYValor);

        // LABEL POSICIÓN EN X INICIAL VALOR -----------------------------------------------------
        lPInicialXValor = sObjGraficos.construirJLabel(
                "0", 200, 160, 160, 40, null, sRecursosService.getColorAzul(),
                null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPInicialXValor);

        // LABEL POSICIÓN EN Y INICIAL VALOR -----------------------------------------------------
        lPInicialYValor = sObjGraficos.construirJLabel(
                "0", 200, 180, 160, 40, null, sRecursosService.getColorAzul(),
                null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPInicialYValor);

        // LABEL POSICIÓN EN X FINAL VALOR -----------------------------------------------------
        lPFinalXValor = sObjGraficos.construirJLabel(
                "0", 200, 220, 160, 40, null, sRecursosService.getColorAzul(),
                null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPFinalXValor);

        // LABEL POSICIÓN EN Y FINAL VALOR -----------------------------------------------------
        lPFinalYValor = sObjGraficos.construirJLabel(
                "0", 200, 240, 160, 40, null, sRecursosService.getColorAzul(),
                null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPFinalYValor);

        // LABEL POSICIÓN EN X ACTUAL VALOR -----------------------------------------------------
        lPActualXValor = sObjGraficos.construirJLabel(
                "0", 200, 280, 160, 40, null, sRecursosService.getColorAzul(),
                null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPActualXValor);

        // LABEL POSICIÓN EN Y ACTUAL VALOR -----------------------------------------------------
        lPActualYValor = sObjGraficos.construirJLabel(
                "0", 200, 300, 160, 40, null, sRecursosService.getColorAzul(),
                null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lPActualYValor);

        // LABEL LADO EN X VALOR --------------------------------------------------------------
        lLadoXValor = sObjGraficos.construirJLabel(
                "0", 200, 340, 160, 40, null, sRecursosService.getColorAzul(),
                null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lLadoXValor);

        // LABEL LADO EN Y VALOR ---------------------------------------------------------------
        lLadoYValor = sObjGraficos.construirJLabel(
                "0", 200, 360, 160, 40, null, sRecursosService.getColorAzul(),
                null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lLadoYValor);

        // LABEL ZOOM VALOR ----------------------------------------------------------------------
        lZoomValor = sObjGraficos.construirJLabel(
                "0", 200, 400, 160, 40, null, sRecursosService.getColorAzul(),
                null, sRecursosService.getFontPequeña(), "l"
        );
        pDatos.add(lZoomValor);

        // LABEL ESTADO VALOR -------------------------------------------------------------------
        lEstadoValor = sObjGraficos.construirJLabel(
                "NINGUNO", 80, 520, 160, 40, null, sRecursosService.getColorAzul(),
                null, sRecursosService.getFontTitulo(), "l"
        );
        pDatos.add(lEstadoValor);
    }
    
    //metodo get que retorna el label lPOnClickXValor
    public JLabel getLPOnClickXValor() {
        return lPOnClickXValor;
    }
    //metodo get que retorna el label lPOnClickYValor
    public JLabel getLPOnClickYValor() {
        return lPOnClickYValor;
    }
    //metodo get que retorna el label lPInicialXValor
    public JLabel getLPInicialXValor() {
        return lPInicialXValor;
    }
    //metodo get que retorna el label lPInicialYValor
    public JLabel getLPInicialYValor() {
        return lPInicialYValor;
    }
    //metodo get que retorna el label lPFinalXValor
    public JLabel getLPFinalXValor() {
        return lPFinalXValor;
    }
    //metodo get que retorna el label lPFinalYValor
    public JLabel getLPFinalYValor() {
        return lPFinalYValor;
    }
    //metodo get que retorna el label lPActualXValor
    public JLabel getLPActualXValor() {
        return lPActualXValor;
    }
    //metodo get que retorna el label lPActualYValor
    public JLabel getLPActualYValor() {
        return lPActualYValor;
    }
    //metodo get que retorna el label lLadoXValor
    public JLabel getLLadoXValor() {
        return lLadoXValor;
    }
    //metodo get que retorna el label lLadoYValor
    public JLabel getLLadoYValor() {
        return lLadoYValor;
    }
    //metodo get que retorna el label lZoomValor
    public JLabel getLZoomValor() {
        return lZoomValor;
    }
    //metodo get que retorna el label lEstadoValor
    public JLabel getLEstadoValor() {
        return lEstadoValor;
    }
}
