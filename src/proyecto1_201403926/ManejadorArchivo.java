package proyecto1_201403926;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MKJR
 */
public class ManejadorArchivo {
    Variables var;
    Top tp;
    public void crear(){
        String ruta="Archivo.txt";
        File archivo = new File(ruta);
        PrintWriter bw;
        try {
        if(archivo.exists()){
                bw=new PrintWriter(new FileWriter(ruta,true));
                
                bw.println("jug"+",");
        }else{            
                bw=new PrintWriter(new FileWriter(ruta));
                bw.println("AAA, 900");
        }
        bw.close();
        } catch (IOException ex) {
                Logger.getLogger(ManejadorArchivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    public void mostrarContenido(String archivo) throws FileNotFoundException, IOException{
        String cadena="";
        
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        
        while((cadena=br.readLine())!=null){
            tp.lista.add(cadena, tp);
        }
        br.close();
    }
    
    public Persona[] obtenerPersonas(String archivo) throws FileNotFoundException, IOException {
        String cadena="";
        Persona[] per = new Persona[10];
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        int linea=0;
        while(((cadena=br.readLine())!=null)&&(linea<5)){
            System.out.println(cadena);
            String[] cadenap = cadena.split(",");
            per[linea]=new Persona(Integer.parseInt(cadenap[1].trim()),(cadenap[0].toString()));
            linea++;
        }
        br.close();
        return per;
    }
}
