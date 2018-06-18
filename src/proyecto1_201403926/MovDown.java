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
public class MovDown extends Thread{
    private int cantidad,turno,tam=0, w=0,u=0,ejey,ejex,v1,v2,mov;
    public Tablero tab;
    private int[] vect;
    public Variables var;
    public Principal prin;
    public MovDown(Variables var, Principal prin, Tablero tab){
        this.prin=prin;
        this.var=var;
        this.tab = tab;
        cantidad = var.getMov();
        turno=var.getTurno();
        tam = var.getTam();
        ejey=var.pospery[turno];
        ejex=var.posperx[turno];
        vect = new int[tam];
        for(int i=0;i<tam;i++){
            vect[i] = var.interior[i][ejex];
        }
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
                    Validar v= new Validar(var,prin);
                }else{
                    var.setVida2(v2-1);
                    prin.colcor2(var);
                    Validar v= new Validar(var,prin);
                }
            }else if(w==2){
                if((turno-1)%2==0){
                    var.setVida1(v1+1);
                    prin.colcor1(var);
                    Validar v= new Validar(var,prin);
                }else{
                    var.setVida2(v2+1);
                    prin.colcor2(var);
                    Validar v= new Validar(var,prin);
                }
            }
            if(var.atk[turno-1]==true){
                Atacar at = new Atacar(var);
                Validar v= new Validar(var,prin);
            }else{
                if((turno-1)%2==0){
                    var.setVida1(v1-1);
                    prin.colcor1(var);
                    Validar v= new Validar(var,prin);
                }else{
                    var.setVida2(v2-1);
                    prin.colcor2(var);
                    Validar v= new Validar(var,prin);
                }
                var.atk[turno-1]=true;
            }
            var.setTurno(turno);
            return;
        }else{
            if ((ejey+1) > (tam-1)){
                if(tam%2==0){
                    prin.matriz[ejey][ejex].setIcon(null);
                    vect[ejey]=w;
                    for(int i=0;i<tam;i++){
                        var.interior[i][ejex] = vect[i];
                    }
                    CaracolPar c= new CaracolPar(var,prin);
                    tab.imprimirPersona(var, prin);
                    if((turno-1)%2==0){
                        var.setVida1(v1-1);
                        prin.colcor1(var);
                        Validar v= new Validar(var,prin);
                    }else{
                        var.setVida2(v2-1);
                        prin.colcor2(var);
                        Validar v= new Validar(var,prin);
                    }
                    mov=0;
                    return;
                }else{
                    prin.matriz[ejey][ejex].setIcon(null);
                    vect[ejey]=w;
                    for(int i=0;i<tam;i++){
                        var.interior[i][ejex] = vect[i];
                    }
                    CaracolImpar c= new CaracolImpar(var,prin);
                    tab.imprimirPersona(var, prin);
                    if((turno-1)%2==0){
                        var.setVida1(v1-1);
                        prin.colcor1(var);
                        Validar v= new Validar(var,prin);
                    }else{
                        var.setVida2(v2-1);
                        prin.colcor2(var);
                        Validar v= new Validar(var,prin);
                    }
                    mov=0;
                    return;
                }
            }else{
                try{
                    if(vect[ejey+1]==1 || vect[ejey+1]==2){
                        u = w;
                        w = vect[ejey+1];
                        vect[ejey+1]=vect[ejey];
                        vect[ejey] = u;
                        prin.matriz[ejey][ejex].setIcon(null);
                        var.interior[ejey][ejex] = u;
                        ejey+=1;
                        for(int i=0;i<tam;i++){
                            var.interior[i][ejex] = vect[i];
                        }
                        var.pospery[turno-1]=ejey;
                        tab.imprimirPersona(var, prin);
                        mov = cantidad-1;
                        Thread.sleep(500);
                        mover(mov);
                    }else if(vect[ejey+1]>2){
                        int g= (int)(Math.random());
                        mov = cantidad;
                        var.setMov(mov);
                        turno-=1;
                        var.setTurno(turno);
                        if (g%2==0){
                            MovIzq movd=new MovIzq(var,prin,tab);
                            movd.start();
                        }else{
                            MovDer movd=new MovDer(var,prin,tab);
                            movd.start();
                        }
                    }else if(vect[ejey+1]==0){
                        //mover una posicion
                        u = w;
                        w = vect[ejey+1];
                        vect[ejey+1] = vect[ejey];
                        vect[ejey] = u;
                        prin.matriz[ejey][ejex].setIcon(null);                      
                        var.interior[ejey][ejex]=u;
                        ejey+=1;
                        for(int i=0;i<tam;i++){
                            var.interior[i][ejex] = vect[i];
                        }
                        var.pospery[turno-1]=ejey;
                        tab.imprimirPersona(var, prin);
                        mov = cantidad-1;
                        Thread.sleep(500);
                        mover(mov);
                    }
                }   catch (InterruptedException ex) {
                    Logger.getLogger(MovDown.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public void run(){
        mover(cantidad);
    }
}
