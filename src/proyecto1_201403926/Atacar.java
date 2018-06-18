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
public class Atacar {
    Variables var;
    private int tur,ejex,ejey,v2,v1,tam;
    
    Principal prin;
    public Atacar(Variables var,Principal prin){
        tur = var.getTurno()-1;
        ejey=var.pospery[tur];
        ejex=var.posperx[tur];
        v2=var.getVida2();
        v1=var.getVida1();
        tam=var.getTam()-1;
        switch(var.orden[tur]){
            case 3:
                for(int i=1;i<3;i++){
                    if(ejey-i>0){
                        if(var.interior[ejey-i][ejex]==4||var.interior[ejey-i][ejex]==6||var.interior[ejey-i][ejex]==8){
                            var.setVida2(v2-2);
                            prin.colcor2(var);
                        }
                    }
                    if(ejey+i<tam){
                        if(var.interior[ejey+i][ejex]==4||var.interior[ejey+i][ejex]==6||var.interior[ejey+i][ejex]==8){
                            var.setVida2(v2-2);
                            prin.colcor2(var);
                        }
                    }
                    if(ejex+i<tam){
                        if(var.interior[ejey][ejex+i]==4||var.interior[ejey][ejex+i]==6||var.interior[ejey][ejex+i]==8){
                            var.setVida2(v2-2);
                            prin.colcor2(var);
                        }
                    }
                    if(ejex-i>0){
                        if(var.interior[ejey][ejex-i]==4||var.interior[ejey][ejex-i]==6||var.interior[ejey][ejex-i]==8){
                            var.setVida2(v2-2);
                            prin.colcor2(var);
                        }
                    }
                }
            break;
            case 5:
                for(int i=1;i<5;i++){
                    if(ejey-i>0){
                        if(var.interior[ejey-i][ejex]==4||var.interior[ejey-i][ejex]==6||var.interior[ejey-i][ejex]==8){
                            var.setVida2(v2-1);
                            prin.colcor2(var);
                        }
                    }
                    if(ejey+i<tam){
                        if(var.interior[ejey+i][ejex]==4||var.interior[ejey+i][ejex]==6||var.interior[ejey+i][ejex]==8){
                            var.setVida2(v2-1);
                            prin.colcor2(var);
                        }
                    }
                    if(ejex+i<tam){
                        if(var.interior[ejey][ejex+i]==4||var.interior[ejey][ejex+i]==6||var.interior[ejey][ejex+i]==8){
                            var.setVida2(v2-1);
                            prin.colcor2(var);
                        }
                    }
                    if(ejex-i>0){
                        if(var.interior[ejey][ejex-i]==4||var.interior[ejey][ejex-i]==6||var.interior[ejey][ejex-i]==8){
                            var.setVida2(v2-1);
                            prin.colcor2(var);
                        }
                    }
                }
            break;
            case 7:
                if(ejey-1<0){
                    if(var.interior[ejey-1][ejex]==4){
                        for(int i=0;i<6;i++){
                            if(var.orden[i]==4){
                                var.atk[i]=false;
                            }
                        }
                    }
                    if(var.interior[ejey-1][ejex]==6){
                        for(int i=0;i<6;i++){
                            if(var.orden[i]==6){
                                var.atk[i]=false;
                            }
                        }
                    }
                    if(var.interior[ejey-1][ejex]==8){
                        for(int i=0;i<6;i++){
                            if(var.orden[i]==8){
                                var.atk[i]=false;
                            }
                        }
                    }
                }
                if(ejex-1>0){
                    if(var.interior[ejey][ejex-1]==4){
                        for(int i=0;i<6;i++){
                            if(var.orden[i]==4){
                                var.atk[i]=false;
                            }
                        }
                    }
                    if(var.interior[ejey][ejex-1]==6){
                        for(int i=0;i<6;i++){
                            if(var.orden[i]==6){
                                var.atk[i]=false;
                            }
                        }
                    }
                    if(var.interior[ejey][ejex-1]==8){
                        for(int i=0;i<6;i++){
                            if(var.orden[i]==8){
                                var.atk[i]=false;
                            }
                        }
                    }
                }
                if(ejey+1<tam){
                    if(var.interior[ejey+1][ejex]==4){
                        for(int i=0;i<6;i++){
                            if(var.orden[i]==4){
                                var.atk[i]=false;
                            }
                        }
                    }
                    if(var.interior[ejey+1][ejex]==6){
                        for(int i=0;i<6;i++){
                            if(var.orden[i]==6){
                                var.atk[i]=false;
                            }
                        }
                    }
                    if(var.interior[ejey+1][ejex]==8){
                        for(int i=0;i<6;i++){
                            if(var.orden[i]==8){
                                var.atk[i]=false;
                            }
                        }
                    }
                }
                if(ejex+1<tam){
                    if(var.interior[ejey][ejex+1]==4){
                        for(int i=0;i<6;i++){
                            if(var.orden[i]==4){
                                var.atk[i]=false;
                            }
                        }
                    }
                    if(var.interior[ejey][ejex+1]==6){
                        for(int i=0;i<6;i++){
                            if(var.orden[i]==6){
                                var.atk[i]=false;
                            }
                        }
                    }
                    if(var.interior[ejey][ejex+1]==8){
                        for(int i=0;i<6;i++){
                            if(var.orden[i]==8){
                                var.atk[i]=false;
                            }
                        }
                    }
                }
            case 4:
                for(int i=1;i<3;i++){
                    if(ejey-i>0){
                        if(var.interior[ejey-i][ejex]==3||var.interior[ejey-i][ejex]==5||var.interior[ejey-i][ejex]==7){
                            var.setVida1(v1-2);
                            prin.colcor1(var);
                        }
                    }
                    if(ejey+i<tam){
                        if(var.interior[ejey+i][ejex]==3||var.interior[ejey+i][ejex]==5||var.interior[ejey+i][ejex]==7){
                            var.setVida1(v1-1);
                            prin.colcor1(var);
                        }
                    }
                    if(ejex+i<tam){
                        if(var.interior[ejey][ejex+i]==3||var.interior[ejey][ejex+i]==5||var.interior[ejey][ejex+i]==7){
                            var.setVida1(v1-2);
                            prin.colcor1(var);
                        }
                    }
                    if(ejex-i>0){
                        if(var.interior[ejey][ejex-i]==3||var.interior[ejey][ejex-i]==2||var.interior[ejey][ejex-i]==7){
                            var.setVida1(v1-2);
                            prin.colcor1(var);
                        }
                    }
                }
            break;
            case 6:
                for(int i=1;i<5;i++){
                    if(ejey-i>0){
                        if(var.interior[ejey-i][ejex]==3||var.interior[ejey-i][ejex]==5||var.interior[ejey-i][ejex]==7){
                            var.setVida1(v1-1);
                            prin.colcor1(var);
                        }
                    }
                    if(ejey+i<tam){
                        if(var.interior[ejey+i][ejex]==3||var.interior[ejey+i][ejex]==5||var.interior[ejey+i][ejex]==7){
                            var.setVida1(v1-1);
                            prin.colcor1(var);
                        }
                    }
                    if(ejex+i<tam){
                        if(var.interior[ejey][ejex+i]==3||var.interior[ejey][ejex+i]==5||var.interior[ejey][ejex+i]==7){
                            var.setVida1(v1-1);
                            prin.colcor1(var);
                        }
                    }
                    if(ejex-i>0){
                        if(var.interior[ejey][ejex-i]==3||var.interior[ejey][ejex-i]==5||var.interior[ejey][ejex-i]==7){
                            var.setVida1(v1-1);
                            prin.colcor1(var);
                        }
                    }
                }
            break;
            case 8:
                if(ejey-1<0){
                    if(var.interior[ejey-1][ejex]==3){
                        for(int i=0;i<6;i++){
                            if(var.orden[i]==3){
                                var.atk[i]=false;
                            }
                        }
                    }
                    if(var.interior[ejey-1][ejex]==5){
                        for(int i=0;i<6;i++){
                            if(var.orden[i]==5){
                                var.atk[i]=false;
                            }
                        }
                    }
                    if(var.interior[ejey-1][ejex]==7){
                        for(int i=0;i<6;i++){
                            if(var.orden[i]==7){
                                var.atk[i]=false;
                            }
                        }
                    }
                }
                if(ejex-1>0){
                    if(var.interior[ejey][ejex-1]==3){
                        for(int i=0;i<6;i++){
                            if(var.orden[i]==3){
                                var.atk[i]=false;
                            }
                        }
                    }
                    if(var.interior[ejey][ejex-1]==3){
                        for(int i=0;i<6;i++){
                            if(var.orden[i]==3){
                                var.atk[i]=false;
                            }
                        }
                    }
                    if(var.interior[ejey][ejex-1]==7){
                        for(int i=0;i<6;i++){
                            if(var.orden[i]==7){
                                var.atk[i]=false;
                            }
                        }
                    }
                }
                if(ejey+1<tam){
                    if(var.interior[ejey+1][ejex]==3){
                        for(int i=0;i<6;i++){
                            if(var.orden[i]==3){
                                var.atk[i]=false;
                            }
                        }
                    }
                    if(var.interior[ejey+1][ejex]==5){
                        for(int i=0;i<6;i++){
                            if(var.orden[i]==5){
                                var.atk[i]=false;
                            }
                        }
                    }
                    if(var.interior[ejey+1][ejex]==7){
                        for(int i=0;i<6;i++){
                            if(var.orden[i]==7){
                                var.atk[i]=false;
                            }
                        }
                    }
                }
                if(ejex+1<tam){
                    if(var.interior[ejey][ejex+1]==3){
                        for(int i=0;i<6;i++){
                            if(var.orden[i]==3){
                                var.atk[i]=false;
                            }
                        }
                    }
                    if(var.interior[ejey][ejex+1]==5){
                        for(int i=0;i<6;i++){
                            if(var.orden[i]==5){
                                var.atk[i]=false;
                            }
                        }
                    }
                    if(var.interior[ejey][ejex+1]==7){
                        for(int i=0;i<6;i++){
                            if(var.orden[i]==7){
                                var.atk[i]=false;
                            }
                        }
                    }
                }
            }            
        }
    }
