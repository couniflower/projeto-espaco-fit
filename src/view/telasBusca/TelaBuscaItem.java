/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.telasBusca;

import javax.swing.*;

/**
 *
 * @author julia
 */
public class TelaBuscaItem extends javax.swing.JDialog {

   /**
    * Creates new form NewJDialog
    */
   public TelaBuscaItem(java.awt.Frame parent, boolean modal) {
      super(parent, modal);
      initComponents();
      jTable1.setRowHeight(40);
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      north = new javax.swing.JPanel();
      titulo = new javax.swing.JLabel();
      south = new javax.swing.JPanel();
      carregar = new javax.swing.JButton();
      center = new javax.swing.JPanel();
      jScrollPane1 = new javax.swing.JScrollPane();
      jTable1 = new javax.swing.JTable();
      sair = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

      north.setBackground(new java.awt.Color(255, 204, 0));
      north.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
      north.setPreferredSize(new java.awt.Dimension(1000, 50));

      titulo.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
      titulo.setForeground(new java.awt.Color(0, 0, 0));
      titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      titulo.setText("ESCOLHA O ITEM");

      javax.swing.GroupLayout northLayout = new javax.swing.GroupLayout(north);
      north.setLayout(northLayout);
      northLayout.setHorizontalGroup(
         northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(northLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
      );
      northLayout.setVerticalGroup(
         northLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(northLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
            .addContainerGap())
      );

      south.setPreferredSize(new java.awt.Dimension(0, 50));

      carregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/buscar.png"))); // NOI18N
      carregar.setText("Carregar");
      carregar.setPreferredSize(new java.awt.Dimension(100, 40));

      javax.swing.GroupLayout southLayout = new javax.swing.GroupLayout(south);
      south.setLayout(southLayout);
      southLayout.setHorizontalGroup(
         southLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(southLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(carregar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      southLayout.setVerticalGroup(
         southLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(southLayout.createSequentialGroup()
            .addComponent(carregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 10, Short.MAX_VALUE))
      );

      jTable1.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {

         },
         new String [] {
            "ID", "PRODUTO", "VALOR", "QTD", "SUBTOTAL"
         }
      ));
      jScrollPane1.setViewportView(jTable1);
      if (jTable1.getColumnModel().getColumnCount() > 0) {
         jTable1.getColumnModel().getColumn(0).setMaxWidth(70);
         jTable1.getColumnModel().getColumn(3).setMaxWidth(1000);
      }

      javax.swing.GroupLayout centerLayout = new javax.swing.GroupLayout(center);
      center.setLayout(centerLayout);
      centerLayout.setHorizontalGroup(
         centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1035, Short.MAX_VALUE)
      );
      centerLayout.setVerticalGroup(
         centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
      );

      sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
      sair.setText("Sair");
      sair.setPreferredSize(new java.awt.Dimension(74, 40));

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(north, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1035, Short.MAX_VALUE)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(south, javax.swing.GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
         .addComponent(center, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addComponent(north, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(center, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(south, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
      );

      pack();
      setLocationRelativeTo(null);
   }// </editor-fold>//GEN-END:initComponents

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
         java.util.logging.Logger.getLogger(TelaBuscaItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(TelaBuscaItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(TelaBuscaItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(TelaBuscaItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>
      //</editor-fold>

      /* Create and display the dialog */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            TelaBuscaItem dialog = new TelaBuscaItem(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
               @Override
               public void windowClosing(java.awt.event.WindowEvent e) {
                  System.exit(0);
               }
            });
            dialog.setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton carregar;
   private javax.swing.JPanel center;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTable jTable1;
   private javax.swing.JPanel north;
   private javax.swing.JButton sair;
   private javax.swing.JPanel south;
   private javax.swing.JLabel titulo;
   // End of variables declaration//GEN-END:variables

   public JButton getCarregar() {
      return carregar;
   }

   public JButton getSair() {
      return sair;
   }

   public JTable getjTable1() {
      return jTable1;
   }
}
