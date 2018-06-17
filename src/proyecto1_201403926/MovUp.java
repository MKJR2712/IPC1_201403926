/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201403926;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MKJR
 */
public class MovUp extends Thread{
    private int cantidad =0,turno=0,tam=0, w=0,u=0,ejey,ejex;
    public Tablero tab=null;
    public int[] vect;
    public Variables var;
    public Principal prin;
    public MovUp(Variables var, Principal prin, Tablero tab){
        cantidad = var.getMov();
        turno = var.getTurno();
        tam = var.getTam();
        this.prin=prin;
        this.var=var;
        vect = new int[tam];
        this.tab = tab;
        for (int i=0 ; i<tam;i++){
            vect[i]=var.interior[i][var.posperx[turno]];
        }
        ejey=var.pospery[turno];
        ejex=var.posperx[turno];
    }
    public boolean comprobar(){
        if(ejey <= 0){
            return true;
        }
        return false;
    }
    
    
    public void mover(int cantidad){
        if(cantidad==0){          
            return;
        }
        if (comprobar()){
            //regresamos el personaje a la posicion 0
            cantidad = 0;                        
            return;
        }else{
            try{
                if(vect[ejey-1]==1||vect[ejey-1]==2){
                    cantidad=0;
                    return;
                }else if(vect[ejey-1]>2){
                    //generar random nueva direccion
                    cantidad=0;
                    return;
                }else if(vect[ejey-1]==0){
                    //mover una posicion
                    vect[ejey] = 0;
                    tab.matriz[ejey][ejex].setIcon(null);
                    for (int i=0 ; i<tam;i++){
                        var.interior[i][ejex]=vect[i];
                    }
                    var.pospery[turno]=ejey;
                    tab.repintarColumna(var, prin);
                    ejey-=1;
                    vect[ejey]=var.orden[turno];
                    for (int i=0 ; i<tam;i++){
                        var.interior[i][ejex]=vect[i];
                    }
                    var.pospery[turno]=ejey;
                    tab.repintarColumna(var, prin);
                    cantidad--;
                    Thread.sleep(500);
                    mover(cantidad);
                }
        }   catch (InterruptedException ex) {
                Logger.getLogger(MovUp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void run(){
        mover(cantidad);
    }
}
