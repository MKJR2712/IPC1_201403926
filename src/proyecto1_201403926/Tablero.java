/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201403926;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author MKJR
 */
public class Tablero {
    public Imagenes img=new Imagenes();
    public int tam=0,taml=0;
    public Variables var;
    public Principal prin;
    private int i=0,j=0;
    
    public Tablero(Variables var, Principal prin){
        this.var=var;
        tam=var.getTam();        
        this.prin=prin;        
    }    
    public void imprimirPersona(Variables var, Principal prin){
        this.prin=prin;
        this.var=var;
        taml=tam/700;
        for(i=0; i<tam; i++){
            for(j=0; j<tam; j++){
                JLabel table;
                switch(var.interior[i][j]){
                    case 0:
                        prin.matriz[i][j].setIcon(null);
                        break;
                    case 1:
                        prin.matriz[i][j].setIcon(img.bomba(tam));
                        prin.tablero.repaint(i*taml, j*taml, taml, taml);
                        break;
                    case 2:
                        prin.matriz[i][j].setIcon(img.corazon(tam));
                        prin.tablero.repaint(i*taml, j*taml, taml, taml);
                        break;
                    case 3:
                        prin.matriz[i][j].setIcon(img.Cab1(tam));
                        prin.tablero.repaint(i*taml, j*taml, taml, taml);
                        break;
                    case 4:
                        prin.matriz[i][j].setIcon(img.Cab2(tam));
                        break;
                    case 5:
                        prin.matriz[i][j].setIcon(img.Mag1(tam));
                        prin.tablero.repaint(i*taml, j*taml, taml, taml);
                        break;
                    case 6:
                        prin.matriz[i][j].setIcon(img.Mag2(tam));
                        prin.tablero.repaint(i*taml, j*taml, taml, taml);
                        break;
                    case 7:
                        prin.matriz[i][j].setIcon(img.Prin1(tam));
                        prin.tablero.repaint(i*taml, j*taml, taml, taml);
                        break;
                    case 8:
                        prin.matriz[i][j].setIcon(img.Prin2(tam));
                        prin.tablero.repaint(i*taml, j*taml, taml, taml);
                        break;
                }
            }
        }
    }
}
