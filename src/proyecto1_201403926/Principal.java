/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201403926;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author MKJR
 */
public class Principal extends javax.swing.JFrame {
    /**
     * Creates new form Principal
     */
    
    private JPanel tablero,vid1,vid2;
    private JLabel [][] matriz,vd1,vd2;
    private int tammat, tiempo,mov;
    private String pl1,pl2;
    public Imagenes fondo;
    public void init(){
        setLayout(null);
        setSize(1200, 720);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        

    }
    public Principal(Variables var){
        this.pl1 = var.getPl1();
        this.pl2 = var.getPl2();
        this.tammat = var.getTam();
        init();
        initComponents();
        jLabel1.setText(pl1);
        jLabel2.setText(pl2);
        var.setVida1(5);
        var.setVida2(5);
        add(getTablero());
        add(getVid1());
        add(getVid2());
        Imagenes img=new Imagenes();
        dado.setIcon(img.Dado1());
        Posicion pos = new Posicion(var);
        imprimirPersona(var,img);
        colcor1(var,img);
        colcor2(var,img);
        jLabel5.setText(var.per[0]);
        jLabel6.setText(var.per[2]);
        jLabel7.setText(var.per[4]);
        jLabel10.setText(var.per[1]);
        jLabel11.setText(var.per[3]);
        jLabel8.setText(var.per[5]);
        
        this.tiempo = var.getTiempo();
        
    }
    public void colcor1(Variables var,Imagenes img){
        int as = 20;
        int i = var.getVida1()/4;
        int j = var.getVida1()%4;
        if (j!=0){
            i += 1;
        }else{
            for (int z=0; z<i ; z++){
                for(int w=0; w<4; w++){
                    vd1[z][w].setIcon(img.corazon(as));
                }
            }
        }
        for (int z=0; z<i ; z++){
            if(z == i-1){
                for(int w=0; w<j; w++){
                    vd1[z][w].setIcon(img.corazon(as));
                }
            }else{
                for(int w=0; w<4; w++){
                    vd1[z][w].setIcon(img.corazon(as));
                }
            }
        }
    }
    public void colcor2(Variables var,Imagenes img){
        int as = 20;
        int i = var.getVida2()/4;
        int j = var.getVida2()%4;
        if (j!=0){
            i += 1;
        }else{
            for (int z=0; z<i ; z++){
                for(int w=0; w<4; w++){
                    vd2[z][w].setIcon(img.corazon(as));
                }
            }
        }
        for (int z=0; z<i ; z++){
            if(z == i-1){
                for(int w=0; w<j; w++){
                    vd2[z][w].setIcon(img.corazon(as));
                }
            }else{
                for(int w=0; w<4; w++){
                    vd2[z][w].setIcon(img.corazon(as));
                }
            }
        }
    }
    public JPanel getTablero() {
        JPanel tablero = new JPanel();
        matriz = new JLabel[tammat][tammat];
        tablero.setLayout(new GridLayout(tammat, tammat));
        tablero.setBounds(20, 20, 650, 650);
        for (int i=0; i<tammat;i++){
            for(int j=0; j<tammat;j++){
                matriz [i][j] = new JLabel("");
                tablero.add(matriz[i][j]);
                matriz[i][j].setBorder(BorderFactory.createLineBorder(Color.black));                
            }
        }
        
        return tablero;
    }
    public JPanel getVid1(){
        JPanel vid1 = new JPanel();
        vd1 = new JLabel[4][4];
        vid1.setLayout(new GridLayout(4,4));
        vid1.setBounds(840,80,140,140);
        vid1.setBackground(Color.black);
        for (int i=0; i<4;i++){
            for(int j=0; j<4;j++){
                vd1 [i][j] = new JLabel("");
                vid1.add(vd1[i][j]);
                vd1[i][j].setBorder(BorderFactory.createLineBorder(Color.white));                
            }
        }
        
        return vid1;
    }
    
    public JPanel getVid2(){
        JPanel vid2 = new JPanel();
        vd2 = new JLabel[4][4];
        vid2.setLayout(new GridLayout(4,4));
        vid2.setBounds(840,260,140,140);
        vid2.setBackground(Color.black);
        for (int i=0; i<4;i++){
            for(int j=0; j<4;j++){
                vd2 [i][j] = new JLabel("");
                vid2.add(vd2[i][j]);
                vd2[i][j].setBorder(BorderFactory.createLineBorder(Color.white));                
            }
        }
        
        return vid2;
    }
    
    public void imprimirPersona(Variables var, Imagenes img){
        for (int i=0; i<var.getTam();i++){
            for (int j=0;j<var.getTam();j++){
                switch(var.interior[i][j]){
                    case 1:
                        matriz[i][j].setIcon(img.bomba(tammat));
                    break;
                    case 2:
                        matriz[i][j].setIcon(img.corazon(tammat));
                    break;
                    case 3:
                        matriz[i][j].setIcon(img.Cab1(tammat));
                    break;
                    case 4:
                        matriz[i][j].setIcon(img.Mag1(tammat));
                    break;
                    case 5:
                        matriz[i][j].setIcon(img.Prin1(tammat));
                    break;
                    case 6:
                        matriz[i][j].setIcon(img.Cab2(tammat));
                    break;
                    case 7:
                        matriz[i][j].setIcon(img.Mag2(tammat));
                    break;
                    case 8:
                        matriz[i][j].setIcon(img.Prin2(tammat));
                    break;
                }
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        timer = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        dado = new javax.swing.JLabel();
        tirar = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MEDIEVIL");
        setBounds(new java.awt.Rectangle(100, 50, 800, 500));
        setSize(new java.awt.Dimension(800, 500));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Jugador 1");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Jugador2");

        timer.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        timer.setEnabled(false);

        jPanel1.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tiempo");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Personajes");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Personajes");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Personajes");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Personajes");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Personajes");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Personajes");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Personajes");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Personajes");

        dado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        dado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        tirar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tirar.setText("Tirar");
        tirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tirarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(dado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tirar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(dado, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addGap(140, 140, 140)
                        .addComponent(tirar)))
                .addContainerGap(190, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tirarActionPerformed
        mov=(int)(Math.random()*7);
        Imagenes img = new Imagenes();
        switch(mov){
            case 1:
                dado.setIcon(img.Dado1());
                break;
            case 2:
                dado.setIcon(img.Dado2());
                break;
            case 3:
                dado.setIcon(img.Dado3());
                break;
            case 4:
                dado.setIcon(img.Dado4());
                break;
            case 5:
                dado.setIcon(img.Dado5());
                break;
            case 6:
                dado.setIcon(img.Dado6());
                break;
        }
    }//GEN-LAST:event_tirarActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel timer;
    private javax.swing.JButton tirar;
    // End of variables declaration//GEN-END:variables
}
