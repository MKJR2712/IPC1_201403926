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
    int ranx,rany,dim,bomb,heart,temp=0;
    
    public Posicion(Variables var){
        int tam = var.getTam();
        dim = tam*tam;
        bomb = dim/10;
        heart = dim/20;
        Random rn= new Random();
        while(temp < bomb){
            ranx = rn.nextInt(tam) + 1;
            rany = rn.nextInt(tam) + 1;
            if(var.getInterior()[ranx][rany]==0){
                
            }
        }
        
    }
}
