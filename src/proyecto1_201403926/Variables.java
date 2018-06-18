package proyecto1_201403926;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MKJR
 */
public class Variables {
    private int tam=0,tiempo=0,vida1=0,vida2=0,mov=0,turno=0,duracion;
    public int [][] interior;
    private String pl1,pl2;
    public int[] orden =new int[6];
    public int[] abc=new int[6];
    public int[] posperx= new int[6];
    public int[] pospery= new int[6];
    public boolean[] atk=new boolean[6];
    public String[] per=new String[6];

    public int getMov() {
        return mov;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    public void setMov(int mov) {
        this.mov = mov;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
    
    public int getTam() {
        return tam;
    }

    public int getVida1() {
        return vida1;
    }

    public void setVida1(int vida1) {
        this.vida1 = vida1;
    }

    public int getVida2() {
        return vida2;
    }

    public void setVida2(int vida2) {
        this.vida2 = vida2;
    }
    
    public void setTam(int tam) {
        this.tam = tam;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public String getPl1() {
        return pl1;
    }

    public void setPl1(String pl1) {
        this.pl1 = pl1;
    }

    public String getPl2() {
        return pl2;
    }

    public void setPl2(String pl2) {
        this.pl2 = pl2;
    }
    
}
