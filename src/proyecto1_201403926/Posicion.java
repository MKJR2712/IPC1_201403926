





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201403926;
import java.util.Random;
/**
 *
 * @author MKJR
 */
public class Posicion {
    private int ranx=0,rany=0,dim=0,bomb=0,heart=0,temp=0;
    private boolean per;
    public Variables var;
    
    public Posicion(Variables var){
        this.var=var;
        int tam = var.getTam();
        dim = tam*tam;
        bomb = dim/10;
        heart = dim/20;
        Random rn= new Random();
        while(temp<bomb){
            ranx = rn.nextInt(tam-1);
            rany = rn.nextInt(tam-1);
            if(var.interior[ranx][rany]==0){
                var.interior[ranx][rany]=1;
                temp=temp+1;
            }
        }
        temp=0;
        while(temp<heart){
            ranx = rn.nextInt(tam-1);
            rany = rn.nextInt(tam-1);
            if(var.interior[ranx][rany]==0){
                var.interior[ranx][rany]=2;
                temp=temp+1;
            }
        }
        for (int i=3;i<=8;i++){
            per=false;
            while(per==false){
                ranx = rn.nextInt(tam-1);
                rany = rn.nextInt(tam-1);
                if(var.interior[rany][ranx]==0){
                    var.interior[rany][ranx] = var.orden[i-3];
                    var.posperx[i-3]=ranx;
                    var.pospery[i-3]=rany;
                    per=true;
                }
            }
        }
    }
}
