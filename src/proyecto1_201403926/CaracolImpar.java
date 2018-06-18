/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201403926;

/**
 *
 * @author MKJR
 */

public class CaracolImpar {
    private int a,b,c,i,j,tam,tur;
    private boolean x;
    Tablero tab;
    Variables var;
    Principal prin;
    int [][]m;
    public CaracolImpar(Variables var,Principal prin){
        m = new int[tam][tam];
        this.var=var;
        this.prin=prin;
        m = var.interior;
        tur=var.getTurno();
        tam = var.getTam();
        a = (tam-1)/2;
        x = false;
        b=a;
        c=a;
        while(x==false){
            j=c;
            for(i=b; i>=c-1; i--){
                if (m[i][j]==0){
                    m[i][j]=var.orden[tur-1];
                    x=true;
                    return;
                }
            }
            i++;
            for(j=i+2; j<=b+1; j++){
                if (m[i][j]==0){
                    m[i][j]=var.orden[tur-1];
                    x=true;
                    return;
                }
            }
            j--;
            for(i=c; i<=b+1; i++){
                if (m[i][j]==0){
                    m[i][j]=var.orden[tur-1];
                    x=true;
                    return;
                }
            }
            i--;
            for( j=b; j>=c; j--){
                if (m[i][j]==0){
                    m[i][j]=var.orden[tur-1];
                    x=true;
                    return;
                }
            }
            b++;
            c--;
        }
        return;
    }
}
