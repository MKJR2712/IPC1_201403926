/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201403926;

import javax.swing.JOptionPane;

/**
 *
 * @author MKJR
 */
public class Validar {
    Variables var;
    Principal prin;
    int min,sec,duracion,i=0;
    Temporizador tem;
    Persona[] per;
    public Validar(Variables var, Principal prin){
        min=tem.min;
        sec=tem.sec;
    }
    public void validarVida(Variables var, Principal prin){    
        if(var.getVida1()==0){
            tem.t.cancel();
            JOptionPane.showInputDialog("Ganador: " + var.getPl2());
            min = tem.min;
            sec = tem.sec;
            duracion=(min*60)+sec;
            var.setDuracion(duracion);
            per[i].setNombre(var.getPl2());
            per[i].setTiempo(duracion);
            i++;
            prin.tirar.setEnabled(false);
                prin.abajo.setEnabled(false);
                prin.arriba.setEnabled(false);
                prin.izq.setEnabled(false);
                prin.der.setEnabled(false);
                prin.nuevo.setEnabled(true);
        }else if(var.getVida2()==0){
            tem.t.cancel();
            JOptionPane.showInputDialog("Ganador: " + var.getPl1());
            min = tem.min;
            sec = tem.sec;
            duracion=(min*60)+sec;
            var.setDuracion(duracion);
            per[i].setNombre(var.getPl1());
            per[i].setTiempo(duracion);
            i++;
            prin.tirar.setEnabled(false);
                prin.abajo.setEnabled(false);
                prin.arriba.setEnabled(false);
                prin.izq.setEnabled(false);
                prin.der.setEnabled(false);
                prin.nuevo.setEnabled(true);
        }
    }
    public void validarTiempo(Principal prin){
        tem=new Temporizador(var ,prin);
        if(var.getTiempo()==min){
            if(var.getVida1() > var.getVida2()){
                JOptionPane.showInputDialog("Ganador: " + var.getPl1());
                prin.tirar.setEnabled(false);
                prin.abajo.setEnabled(false);
                prin.arriba.setEnabled(false);
                prin.izq.setEnabled(false);
                prin.der.setEnabled(false);
                prin.nuevo.setEnabled(true);
            }else if(var.getVida1()<var.getVida2()){
                JOptionPane.showInputDialog("Ganador: " + var.getPl2());
                prin.tirar.setEnabled(false);
                prin.abajo.setEnabled(false);
                prin.arriba.setEnabled(false);
                prin.izq.setEnabled(false);
                prin.der.setEnabled(false);
                prin.nuevo.setEnabled(true);
            }else if(var.getVida1() == var.getVida2()){
                JOptionPane.showInputDialog("Empate");
                prin.tirar.setEnabled(false);
                prin.abajo.setEnabled(false);
                prin.arriba.setEnabled(false);
                prin.izq.setEnabled(false);
                prin.der.setEnabled(false);
                prin.nuevo.setEnabled(true);
            }
        }
    }
}
