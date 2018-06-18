/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201403926;

import javax.swing.ImageIcon; 
import java.awt.Image;
/**
 *
 * @author MKJR
 */

public class Imagenes {
    public int posper = 0;
    public ImageIcon imagper;
    
    public ImageIcon Fondo (){
        ImageIcon fon = new ImageIcon(getClass().getResource("/Imagenes/background.jpg"));
        Image fondo = fon.getImage();
        Image imgtam = fondo.getScaledInstance(700,700,Image.SCALE_SMOOTH);
        fon = new ImageIcon(imgtam);
        return fon;
    }
    public ImageIcon bomba (int tamx){
        ImageIcon bom = new ImageIcon(getClass().getResource("/Imagenes/bomba.png"));
        Image fondo = bom.getImage();
        Image imgtam=fondo.getScaledInstance(700/tamx, 700/tamx, Image.SCALE_SMOOTH);
        bom = new ImageIcon(imgtam);
        return bom;
    }
    public ImageIcon corazon (int tamx){
        ImageIcon cor = new ImageIcon(getClass().getResource("/Imagenes/corazon.png"));
        Image fondo = cor.getImage();
        Image imgtam=fondo.getScaledInstance(700/tamx, 700/tamx, Image.SCALE_SMOOTH);
        cor = new ImageIcon(imgtam);
        return cor;
    }
    public ImageIcon Prin1 (int tamx){
        ImageIcon zelda = new ImageIcon(getClass().getResource("/Imagenes/adutlzelda.png"));
        Image fondo = zelda.getImage();
        Image imgtam=fondo.getScaledInstance(700/tamx, 700/tamx, Image.SCALE_SMOOTH);
        zelda = new ImageIcon(imgtam);
        return zelda;
    }
    public ImageIcon Prin2 (int tamx){
        ImageIcon toonzelda = new ImageIcon(getClass().getResource("/Imagenes/toonzelda.png"));
        Image fondo = toonzelda.getImage();
        Image imgtam=fondo.getScaledInstance(700/tamx, 700/tamx, Image.SCALE_SMOOTH);
        toonzelda = new ImageIcon(imgtam);
        return toonzelda;
    }
    public ImageIcon Cab1 (int tamx){
        ImageIcon link = new ImageIcon(getClass().getResource("/Imagenes/Link_TP.png"));
        Image fondo = link.getImage();
        Image imgtam=fondo.getScaledInstance(700/tamx, 700/tamx, Image.SCALE_SMOOTH);
        link = new ImageIcon(imgtam);
        return link;
    }
    public ImageIcon Cab2 (int tamx){
        ImageIcon toonlink = new ImageIcon(getClass().getResource("/Imagenes/toon link.png"));
        Image fondo = toonlink.getImage();
        Image imgtam=fondo.getScaledInstance(700/tamx, 700/tamx, Image.SCALE_SMOOTH);
        toonlink = new ImageIcon(imgtam);
        return toonlink;
    }
    public ImageIcon Mag1 (int tamx){
        ImageIcon ganon = new ImageIcon(getClass().getResource("/Imagenes/ganon.png"));
        Image fondo = ganon.getImage();
        Image imgtam=fondo.getScaledInstance(700/tamx, 700/tamx, Image.SCALE_SMOOTH);
        ganon = new ImageIcon(imgtam);
        return ganon;
    }
    public ImageIcon Mag2 (int tamx){
        ImageIcon toonganon = new ImageIcon(getClass().getResource("/Imagenes/toon ganon.png"));
        Image fondo = toonganon.getImage();
        Image imgtam=fondo.getScaledInstance(700/tamx, 700/tamx, Image.SCALE_SMOOTH);
        toonganon = new ImageIcon(imgtam);
        return toonganon;
    }
    public ImageIcon Dado1 (){
        ImageIcon d1 = new ImageIcon(getClass().getResource("/Imagenes/dado1.jpg"));
        Image fondo = d1.getImage();
        Image imgtam = fondo.getScaledInstance(95,95,Image.SCALE_SMOOTH);
        d1 = new ImageIcon(imgtam);
        return d1;
    }
    public ImageIcon Dado2 (){
        ImageIcon d2 = new ImageIcon(getClass().getResource("/Imagenes/dado2.jpg"));
        Image fondo = d2.getImage();
        Image imgtam = fondo.getScaledInstance(95,95,Image.SCALE_SMOOTH);
        d2 = new ImageIcon(imgtam);
        return d2;
    }
    public ImageIcon Dado3 (){
        ImageIcon d3 = new ImageIcon(getClass().getResource("/Imagenes/dado3.jpg"));
        Image fondo = d3.getImage();
        Image imgtam = fondo.getScaledInstance(95,95,Image.SCALE_SMOOTH);
        d3 = new ImageIcon(imgtam);
        return d3;
    }
    public ImageIcon Dado4 (){
        ImageIcon d4 = new ImageIcon(getClass().getResource("/Imagenes/dado4.jpg"));
        Image fondo = d4.getImage();
        Image imgtam = fondo.getScaledInstance(95,95,Image.SCALE_SMOOTH);
        d4 = new ImageIcon(imgtam);
        return d4;
    }
    public ImageIcon Dado5 (){
        ImageIcon d5 = new ImageIcon(getClass().getResource("/Imagenes/dado5.jpg"));
        Image fondo = d5.getImage();
        Image imgtam = fondo.getScaledInstance(95,95,Image.SCALE_SMOOTH);
        d5 = new ImageIcon(imgtam);
        return d5;
    }
    public ImageIcon Dado6 (){
        ImageIcon d6 = new ImageIcon(getClass().getResource("/Imagenes/dado6.jpg"));
        Image fondo = d6.getImage();
        Image imgtam = fondo.getScaledInstance(95,95,Image.SCALE_SMOOTH);
        d6 = new ImageIcon(imgtam);
        return d6;
    }
}
