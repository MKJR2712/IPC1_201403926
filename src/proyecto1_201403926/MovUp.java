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
    public int cantidad =0,turno;
    Variables var;
    Principal prin;
    public MovUp(){
        cantidad = var.getMov();
        this.turno=var.getTurno();
        for (int i=0 ; i<var.getTam();i++){
            for (int j=0; j<var.getTam();j++){
                if(var.orden[turno]==var.interior[i][j]){
                    
                    mover(cantidad);
                }
            }
        }
    }
    public boolean comprobar(){
        if(var.pospery[turno] <= 0){
            return true;
        }
        return false;
    }
    
    
    public void mover(int cantidad){
        if(cantidad<=0){
            return;
        }
        if (comprobar()){
            //regresamos el personaje a la posicion 0
            cantidad = 0;
            var.interior[var.posperx[turno]][0]=0;
            prin.matriz[var.posperx[turno]][0].setIcon(null);
            var.pospery[turno]= var.getTam()-1;
            var.interior[var.posperx[turno]][var.getTam()]=var.orden[turno];
            prin.imprimirPersona();
            return;
        }else{
            try{
                //mover una posicion
                int u = var.interior[var.posperx[turno]][var.pospery[turno]];
                int w = 0;
                if(( u== 1) || (u==2)){
                    w = var.interior[var.posperx[turno]][var.pospery[turno]];
                }else if(u>2){
                    cantidad=0;
                    return;
                }
                u = w;
                prin.matriz[var.posperx[turno]][var.pospery[turno]].setIcon(null);
                prin.imprimirPersona();
                var.pospery[turno]-=1;
                var.interior[var.posperx[turno]][var.pospery[turno]]=1;
                prin.imprimirPersona();
                cantidad --;
                Thread.sleep(400);
                mover(cantidad);
                
        }   catch (InterruptedException ex) {
                Logger.getLogger(MovUp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void run(){
        mover(cantidad);
    }
}
