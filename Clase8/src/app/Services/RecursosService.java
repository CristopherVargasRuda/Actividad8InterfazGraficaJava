package app.Services;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;


public class RecursosService {
    
        private Color colorAzul, colorGrisOscuro, colorMorado, colorGrisClaro;
        private Font fontBotones, fontPequeña, fontTPrincipal, fontTitulo, fontSubtitulo;
        private Cursor cMano;
        private Border borderInferiorAzul, borderGris;
        private ImageIcon iCerrar;
        
    static private RecursosService servicio;
    
    private RecursosService(){
        
        colorAzul= new Color(60,78,120);
        colorGrisOscuro= new Color(80, 80, 80);
        colorMorado = new Color(151, 0, 158);
        colorGrisClaro = new Color(249, 249, 249);
        
        fontTPrincipal= new Font("Rockwell Extra Bold", Font.PLAIN, 20);
        fontTitulo = new Font("LuzSans-Book", Font.BOLD, 17);
        fontSubtitulo= new Font("Forte", Font.PLAIN, 13);
        fontBotones = new Font("LuzSans-Book", Font.PLAIN, 15);
        fontPequeña = new Font("LuzSans-Book", Font.PLAIN, 12);
        
        cMano= new Cursor(Cursor.HAND_CURSOR);
        
        borderInferiorAzul= BorderFactory.createMatteBorder(0, 0, 2, 0, colorAzul);
        borderGris = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true);
        
        iCerrar= new ImageIcon("resources/img/cerrar.png");
        
    }
    
    public static RecursosService getService(){
        if(servicio == null){
            servicio = new RecursosService();
        }
        return servicio;
    }
    
    public Color getColorAzul(){
    return colorAzul;
    }

    public Color getColorMorado(){
        return colorMorado;
    }
    
    public Color getColorGrisOscuro(){
        return colorGrisOscuro;
    }

    public Font getFontTPrincipal(){
        return fontTPrincipal;
    }

    public Font getFontTitulo(){
        return fontTitulo;
    }

    public Font getFontSubtitulo(){
        return fontSubtitulo;
    }
    
    public Font getFontBotones(){
        return fontBotones;
    }

    public Font getFontPequeña(){
        return fontPequeña;
    }

    public Cursor getCMano(){
        return cMano;
    }

    public Border getBorderInferiorAzul(){
        return borderInferiorAzul;
    }

    public ImageIcon getICerrar(){
        return iCerrar;
    }
    
    public Color getColorGrisClaro(){
        return colorGrisClaro;
    }
    
    public Border getBorderGris(){
        return borderGris;
    }
}
