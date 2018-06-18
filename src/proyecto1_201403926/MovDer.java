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
public class MovDer extends Thread{
    private int cantidad,turno,tam=0, w=0,u=0,ejey,ejex,v1,v2,mov;
    public Tablero tab;
    private int[] vect;
    public Variables var;
    public Principal prin;
    public MovDer(Variables var, Principal prin, Tablero tab){
        this.prin=prin;
        this.var=var;
        this.tab = tab;
        cantidad = var.getMov();
        turno=var.getTurno();
        tam = var.getTam();
        ejey=var.pospery[turno];
        ejex=var.posperx[turno];
        vect = new int[tam];
        vect = var.interior[ejey];
        v1=var.getVida1();
        v2=var.getVida2();
        turno += 1;
        var.setTurno(turno);
    }        
    public void mover(int cantidad){
        if(cantidad==0){
            if(w==1){
                if((turno-1)%2==0){
                    var.setVida1(v1-1);
                    prin.colcor1(var);
                }else{
                    var.setVida2(v2-1);
                    prin.colcor2(var);
                }
            }else if(w==2){
                if((turno-1)%2==0){
                    var.setVida1(v1+1);
                    prin.colcor1(var);
                }else{
                    var.setVida2(v2+1);
                    prin.colcor2(var);
                }
            }
            var.setTurno(turno);
            return;
        }else{
            if ((ejex+1) > (tam-1)){
                if(tam%2==0){
                    prin.matriz[ejey][ejex].setIcon(null);
                    vect[ejex]=w;
                    var.interior[ejey]=vect;
                    CaracolPar c= new CaracolPar(var,prin);
                    tab.imprimirPersona(var, prin);
                    if((turno-1)%2==0){
                        var.setVida1(v1-1);
                        prin.colcor1(var);
                    }else{
                        var.setVida2(v2-1);
                        prin.colcor2(var);
                    }
                    mov=0;
                    mover(mov);
                }else{
                    prin.matriz[ejey][ejex].setIcon(null);
                    vect[ejex]=w;
                    var.interior[ejey]=vect;
                    CaracolImpar c= new CaracolImpar(var,prin);
                    tab.imprimirPersona(var, prin);
                    if((turno-1)%2==0){
                        var.setVida1(v1-1);
                        prin.colcor1(var);
                    }else{
                        var.setVida2(v2-1);
                        prin.colcor2(var);
                    }
                    mov=0;
                    mover(mov);
                }
            }else{
                try{
                    if(vect[ejex+1]==1 || vect[ejex+1]==2){
                        u = w;
                        w = vect[ejex+1];
                        vect[ejex+1]=vect[ejex];
                        vect[ejex] = u;
                        prin.matriz[ejey][ejex].setIcon(null);
                        var.interior[ejey][ejex] = u;
                        ejex+=1;
                        var.interior[ejey]=vect;
                        var.posperx[turno-1]=ejex;
                        tab.imprimirPersona(var, prin);
                        mov = cantidad-1;
                        Thread.sleep(500);
                        mover(mov);
                    }else if(vect[ejex+1]>2){
                        //generar random nueva direccion
                        System.out.println("personaje enfrente");
                        mov=0;
                        mover(mov);
                    }else if(vect[ejex+1]==0){
                        //mover una posicion
                        u = w;
                        w = vect[ejex+1];
                        vect[ejex+1] = vect[ejex];
                        vect[ejex] = u;
                        prin.matriz[ejey][ejex].setIcon(null);                      
                        var.interior[ejey][ejex]=u;
                        ejex+=1;
                        var.interior[ejey]=vect;
                        var.posperx[turno-1]=ejex;
                        tab.imprimirPersona(var, prin);
                        mov = cantidad-1;
                        Thread.sleep(500);
                        mover(mov);
                    }
                }   catch (InterruptedException ex) {
                    Logger.getLogger(MovDer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public void run(){
        mover(cantidad);
    }
}
