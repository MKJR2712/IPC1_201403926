





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
    private int ranx,rany,dim,bomb,heart,temp=0;
    private boolean per;
    
    public Posicion(Variables var){
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
        for (int i=3;i<=tam;i++){
            per=false;
            while(per==false){
                ranx = rn.nextInt(tam-1);
                rany = rn.nextInt(tam-1);
                if(var.interior[ranx][rany]==0){
                    var.interior[ranx][rany]=i;
                    per=true;
                }
            }
        }
        
    }
}
