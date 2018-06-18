/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_201403926;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author MKJR
 */
public class Principal extends javax.swing.JFrame{
    /**
     * Creates new form Principal
     */
    
    private JPanel vid1,vid2;
    public JLabel [][] matriz,vd1,vd2;
    private int tammat=0,mov=0,turno=0,taml;
    public Tablero tab;
    public int sec=0,min=0,tiempo=0;
    private String pl1,pl2;
    public Imagenes img = new Imagenes();
    public Variables var;
    public boolean juego = true;
    public void init(){
        setLayout(null);
        setSize(1200, 720);
        setVisible(true);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        
    }
    public Principal(Variables var){
        this.var = var;
        pl1 = var.getPl1();
        pl2 = var.getPl2();
        tammat = var.getTam();
        taml=700/tammat;
        tab = new Tablero(var,this);
        init();
        initComponents();
        nuevo.setVisible(false);
        jLabel1.setText(pl1);
        jLabel2.setText(pl2);
        add(getVid1());
        add(getVid2());
        Posicion pos = new Posicion(var);
        add(getTablero());
        dado.setIcon(img.Dado1());
        jLabel5.setText(var.per[0]);
        jLabel6.setText(var.per[2]);
        jLabel7.setText(var.per[4]);
        jLabel11.setText(var.per[1]);
        jLabel8.setText(var.per[3]);
        jLabel10.setText(var.per[5]);
        this.tiempo = var.getTiempo();
        Temporizador temp=new Temporizador(this);
    }
    public JPanel getTablero(){
        tablero = new JPanel();
        matriz= new JLabel[tammat][tammat];
        tablero.setLayout(new GridLayout(tammat,tammat));
        tablero.setBounds(0,0,700,700);
        for(int i=0; i<tammat;i++){
            for(int j=0; j<tammat;j++){
                matriz[i][j]=new JLabel();
                matriz[i][j].setBounds(i*taml, j*taml, taml, taml);
                matriz[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                matriz[i][j].setOpaque(false);
                tablero.add(matriz[i][j],BorderLayout.CENTER);
            }
        }
        tab.imprimirPersona(var, this);
        return tablero;
    }    
    public void colcor1(Variables var){
        int i = var.getVida1()/4;
        int j = var.getVida1()%4;
        JLabel lab;
        if (j!=0){
            i += 1;
            for (int z=0; z<i ; z++){
                if(z == i - 1){
                    for(int w=0; w<j; w++){
                        vd1[z][w].setIcon(img.corazon(20));
                        vid1.repaint(z*35, w*35, 35, 35);
                    }
                    for(int t=j; t<4; t++){
                        vd1[z][t].setIcon(null);
                        vid1.repaint(z*35, t*35, 35, 35);
                    }
                }else{
                    for(int w=0; w<4; w++){
                        vd1[z][w].setIcon(img.corazon(20));
                        vid1.repaint(z*35, w*35, 35, 35);
                    }
                }
            }
        }else{
            for (int z=0; z<i ; z++){
                for(int w=0; w<4; w++){
                    vd1[z][w].setIcon(img.corazon(20));
                    vid1.repaint(z*35, w*35, 35, 35);
                }
            }
            for(int t=i; t<4;t++){
                for(int w=0;w<4;w++){
                    vd1[t][w].setIcon(null);
                    vid1.repaint(t*35, w*35, 35, 35);
                }
            }
        }
    }
    public void colcor2(Variables var){
        int i = var.getVida2()/4;
        int j = var.getVida2()%4;
        JLabel lab;
        if (j!=0){
            i += 1;
            for (int z=0; z<i ; z++){
                if(z == i-1){
                    for(int w=0; w<j; w++){
                        vd2[z][w].setIcon(img.corazon(20));
                        vid2.repaint(z*35, w*35, 35, 35);
                    }
                    for(int t=j;t<4;t++){
                        vd2[z][t].setIcon(null);
                        vid2.repaint(z*35, t*35, 35, 35);
                    }
                }else{
                    for(int w=0; w<4; w++){
                        vd2[z][w].setIcon(img.corazon(20));
                        vid2.repaint(z*35, w*35, 35, 35);
                    }
                }
            }
        }else{
            for (int z=0; z<i ; z++){
                for(int w=0; w<4; w++){
                    vd2[z][w].setIcon(img.corazon(20));
                    vid2.repaint(z*35, w*35, 35, 35);
                }
            }
            for(int t=i; t<4;t++){
                for(int w=0;w<4;w++){
                    vd2[t][w].setIcon(null);
                    vid2.repaint(t*35, w*35, 35, 35);
                }
            }
        }
    }
    
    public JPanel getVid1(){
        vid1 = new JPanel();
        vd1 = new JLabel[4][4];
        vid1.setLayout(new GridLayout(4,4));
        vid1.setBounds(780,80,140,140);
        vid1.setBackground(Color.black);
        for(int i=0; i<4;i++){
            for(int j=0; j<4;j++){
                vd1[i][j]=new JLabel();
                vd1[i][j].setBounds(i*35, j*35, 35, 35);
                vd1[i][j].setBorder(BorderFactory.createLineBorder(Color.white));
                vd1[i][j].setOpaque(false);
                vid1.add(vd1[i][j],BorderLayout.CENTER);
            }
        }
        colcor1(var);
        return vid1;
    }
    
    public JPanel getVid2(){
        vid2 = new JPanel();
        vd2 = new JLabel[4][4];
        vid2.setLayout(new GridLayout(4,4));
        vid2.setBounds(780,265,140,140);
        vid2.setBackground(Color.black);
        for(int i=0; i<4;i++){
            for(int j=0; j<4;j++){
                vd2[i][j]=new JLabel();
                vd2[i][j].setBounds(i*35, j*35, 35, 35);
                vd2[i][j].setBorder(BorderFactory.createLineBorder(Color.white));
                vd2[i][j].setOpaque(false);
                vid2.add(vd2[i][j],BorderLayout.CENTER);
            }
        }
        colcor2(var);
        return vid2;
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
        tablero = new javax.swing.JPanel();
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
        arriba = new javax.swing.JButton();
        der = new javax.swing.JButton();
        izq = new javax.swing.JButton();
        abajo = new javax.swing.JButton();
        nuevo = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MEDIEVIL");
        setBounds(new java.awt.Rectangle(100, 50, 800, 500));
        setSize(new java.awt.Dimension(800, 500));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Jugador 1");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Jugador2");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        timer.setBackground(new java.awt.Color(255, 255, 255));
        timer.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        timer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 255), null, null));
        timer.setOpaque(true);

        tablero.setOpaque(false);

        javax.swing.GroupLayout tableroLayout = new javax.swing.GroupLayout(tablero);
        tablero.setLayout(tableroLayout);
        tableroLayout.setHorizontalGroup(
            tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        tableroLayout.setVerticalGroup(
            tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 705, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tiempo");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel3.setOpaque(true);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Personajes");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Personajes");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Personajes");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Personajes");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Personajes");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Personajes");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Personajes");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Personajes");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        dado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        dado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        tirar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tirar.setText("Tirar");
        tirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tirarActionPerformed(evt);
            }
        });

        arriba.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        arriba.setText("Arriba");
        arriba.setEnabled(false);
        arriba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arribaActionPerformed(evt);
            }
        });

        der.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        der.setText("Derecha");
        der.setEnabled(false);
        der.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                derActionPerformed(evt);
            }
        });

        izq.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        izq.setText("Izquierda");
        izq.setEnabled(false);
        izq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izqActionPerformed(evt);
            }
        });

        abajo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        abajo.setText("Abajo");
        abajo.setEnabled(false);
        abajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abajoActionPerformed(evt);
            }
        });

        nuevo.setText("Juego Nuevo");
        nuevo.setEnabled(false);
        nuevo.setOpaque(false);
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(arriba, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(abajo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(dado, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tirar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(izq)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(der))
                            .addComponent(nuevo))))
                .addContainerGap(50, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(dado, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addGap(106, 106, 106)
                        .addComponent(nuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tirar)))
                .addGap(24, 24, 24)
                .addComponent(arriba)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(izq)
                    .addComponent(der))
                .addGap(10, 10, 10)
                .addComponent(abajo)
                .addContainerGap(72, Short.MAX_VALUE))
            .addComponent(tablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tirarActionPerformed
        mov=(int)((Math.random()*6)+1);
        var.setMov(mov);
        turno=var.getTurno();
        if (turno>=6){
            turno=0;
        }
        var.setTurno(turno);
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
        tirar.setEnabled(false);
        arriba.setEnabled(true);
        abajo.setEnabled(true);
        izq.setEnabled(true);
        der.setEnabled(true);
    }//GEN-LAST:event_tirarActionPerformed

    private void arribaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arribaActionPerformed
        arriba.setEnabled(false);
        der.setEnabled(false);
        izq.setEnabled(false);
        abajo.setEnabled(false);
        tirar.setEnabled(true);
        MovUp movup = new MovUp(var,this,tab);
        movup.start();
    }//GEN-LAST:event_arribaActionPerformed

    private void derActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_derActionPerformed
        arriba.setEnabled(false);
        der.setEnabled(false);
        izq.setEnabled(false);
        abajo.setEnabled(false);
        tirar.setEnabled(true);
        MovDer movder = new MovDer(var,this,tab);
        movder.start();
    }//GEN-LAST:event_derActionPerformed

    private void izqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izqActionPerformed
        arriba.setEnabled(false);
        der.setEnabled(false);
        izq.setEnabled(false);
        abajo.setEnabled(false);
        tirar.setEnabled(true);
        MovIzq movizq = new MovIzq(var,this,tab);
        movizq.start();
    }//GEN-LAST:event_izqActionPerformed

    private void abajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abajoActionPerformed
        arriba.setEnabled(false);
        der.setEnabled(false);
        izq.setEnabled(false);
        abajo.setEnabled(false);
        tirar.setEnabled(true);
        MovDown movdown = new MovDown(var,this,tab);
        movdown.start();
    }//GEN-LAST:event_abajoActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        Inicio ini = new Inicio();
    }//GEN-LAST:event_nuevoActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton abajo;
    public javax.swing.JButton arriba;
    private javax.swing.JLabel dado;
    public javax.swing.JButton der;
    public javax.swing.JButton izq;
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
    public javax.swing.JButton nuevo;
    public javax.swing.JPanel tablero;
    public javax.swing.JLabel timer;
    public javax.swing.JButton tirar;
    // End of variables declaration//GEN-END:variables
}
