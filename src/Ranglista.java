
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TeszTa
 */
public class Ranglista extends javax.swing.JFrame {

    Vector<String> nev; Vector<Integer> pont;
    public Ranglista() {
        initComponents();
        setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        setLocationRelativeTo(null);
        nev=new Vector();
        pont=new Vector();
        beolvasas();
    }
    public Ranglista(int pontok) {
        initComponents();
        setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        setLocationRelativeTo(null);
        jLabel2.setText(pontok+"");
        nev=new Vector();
        pont=new Vector();
        beolvasas();
        setIconImage(new ImageIcon(getClass().getResource("/design/logo.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 210, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("20");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 40, 40));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("N??v:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jButton1.setBackground(new java.awt.Color(153, 204, 0));
        jButton1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton1.setText("Ment??s");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, -1, 30));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 300, 220));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design/ranglista.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, 409));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            if (jTextField1.getText().length()<=8){
            BufferedWriter bw=new BufferedWriter(new FileWriter(new File(getClass().getResource("/rang/ranglista.txt").getFile())));
           /* for (int i=0;i<pont.size();i++){
              /*  if (Integer.valueOf(jLabel2.getText())>=pont.get(i)){
                    if (i!=0){
                    out=out+"\n"+jTextField1.getText()+"\t"+Integer.valueOf(jLabel2.getText());
                    }
                    else{
                        out=out+jTextField1.getText()+"\t"+Integer.valueOf(jLabel2.getText());
                    }
                }
                out=out+nev.get(i)+"\t"+pont.get(i)+"\n";
            }*/
           pont.add(Integer.valueOf(jLabel2.getText()));
           nev.add(jTextField1.getText());
           int seged; String segeds;
            for (int i=0;i<pont.size()-1;i++){
                for (int j=i+1;j<pont.size();j++){
                    if(pont.get(i)<pont.get(j)){
                        seged=pont.get(i);
                        pont.set(i, pont.get(j));
                        pont.set(j, seged);
                        
                        segeds=nev.get(i);
                        nev.set(i, nev.get(j));
                        nev.set(j, segeds);
                    }
            } 
            } 
             for (int i=0;i<pont.size();i++){
             bw.write(nev.get(i)+"\t"+pont.get(i)+"\n");}
            
            bw.close();
            jTextArea1.selectAll();
            jTextArea1.replaceSelection("");
            beolvasas();
            jButton1.setEnabled(false);
            }
            System.exit(0);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ranglista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ranglista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ranglista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ranglista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ranglista().setVisible(true);
            }
        });
    }
    
    public void beolvasas(){
        try{
            BufferedReader bf=new BufferedReader(new FileReader(new File(getClass().getResource("/rang/ranglista.txt").getFile())));
            String sor;
            while((sor=bf.readLine())!=null){
                String t[]=sor.split("\t");
                nev.add(t[0]);
                pont.add(Integer.valueOf(t[1]));
            }
            bf.close();
            for (int i=0;i<nev.size();i++){
                jTextArea1.append(nev.get(i)+"\t\t"+pont.get(i)+"\n");
            }
        }catch(Exception e){
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
