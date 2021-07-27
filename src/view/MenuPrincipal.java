/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerFaturamento;
import controller.busca.*;
import view.telasBusca.*;
import view.telasCadastro.*;
import controller.cadastro.ControllerProduto;
import controller.cadastro.ControllerCompra;
import controller.cadastro.ControllerFornecedor;
import controller.cadastro.ControllerPersonal;
import controller.cadastro.ControllerAluno;
import controller.cadastro.ControllerCep;
import controller.cadastro.ControllerBairro;
import controller.cadastro.ControllerCidade;
import controller.cadastro.ControllerVenda;

/**
 *
 * @author julia
 */
public class MenuPrincipal extends javax.swing.JFrame {

   /**
    * Creates new form MenuPrincipal
    */
   public MenuPrincipal() {
      initComponents();
      setExtendedState(MAXIMIZED_BOTH);
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jMenuBar1 = new javax.swing.JMenuBar();
      novo = new javax.swing.JMenu();
      bairro = new javax.swing.JMenuItem();
      cidade = new javax.swing.JMenuItem();
      cep = new javax.swing.JMenuItem();
      jSeparator1 = new javax.swing.JPopupMenu.Separator();
      aluno = new javax.swing.JMenuItem();
      personal = new javax.swing.JMenuItem();
      fornecedor = new javax.swing.JMenuItem();
      jSeparator2 = new javax.swing.JPopupMenu.Separator();
      produto = new javax.swing.JMenuItem();
      jSeparator3 = new javax.swing.JPopupMenu.Separator();
      sair = new javax.swing.JMenuItem();
      movimentos = new javax.swing.JMenu();
      compra = new javax.swing.JMenuItem();
      venda = new javax.swing.JMenuItem();
      faturamento = new javax.swing.JMenuItem();
      arquivo = new javax.swing.JMenu();
      estoque = new javax.swing.JMenuItem();
      jSeparator4 = new javax.swing.JPopupMenu.Separator();
      pagar = new javax.swing.JMenuItem();
      receber = new javax.swing.JMenuItem();
      jSeparator5 = new javax.swing.JPopupMenu.Separator();
      listaBairro = new javax.swing.JMenuItem();
      listaCidade = new javax.swing.JMenuItem();
      listaCep = new javax.swing.JMenuItem();
      jSeparator6 = new javax.swing.JPopupMenu.Separator();
      listaFornecedor = new javax.swing.JMenuItem();
      listaPersonal = new javax.swing.JMenuItem();
      listaAluno = new javax.swing.JMenuItem();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      novo.setText("Novo");

      bairro.setText("Bairro");
      bairro.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            bairroActionPerformed(evt);
         }
      });
      novo.add(bairro);

      cidade.setText("Cidade");
      cidade.setToolTipText("");
      cidade.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            cidadeActionPerformed(evt);
         }
      });
      novo.add(cidade);

      cep.setText("CEP");
      cep.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            cepActionPerformed(evt);
         }
      });
      novo.add(cep);
      novo.add(jSeparator1);

      aluno.setText("Aluno");
      aluno.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            alunoActionPerformed(evt);
         }
      });
      novo.add(aluno);

      personal.setText("Personal");
      personal.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            personalActionPerformed(evt);
         }
      });
      novo.add(personal);

      fornecedor.setText("Fornecedor");
      fornecedor.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            fornecedorActionPerformed(evt);
         }
      });
      novo.add(fornecedor);
      novo.add(jSeparator2);

      produto.setText("Produto");
      produto.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            produtoActionPerformed(evt);
         }
      });
      novo.add(produto);
      novo.add(jSeparator3);

      sair.setText("Sair");
      sair.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            sairActionPerformed(evt);
         }
      });
      novo.add(sair);

      jMenuBar1.add(novo);

      movimentos.setText("Movimentos");

      compra.setText("Compra");
      compra.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            compraActionPerformed(evt);
         }
      });
      movimentos.add(compra);

      venda.setText("Venda");
      venda.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            vendaActionPerformed(evt);
         }
      });
      movimentos.add(venda);

      faturamento.setText("Faturamento");
      faturamento.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            faturamentoActionPerformed(evt);
         }
      });
      movimentos.add(faturamento);

      jMenuBar1.add(movimentos);

      arquivo.setText("Arquivo");

      estoque.setText("Estoque");
      estoque.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            estoqueActionPerformed(evt);
         }
      });
      arquivo.add(estoque);
      arquivo.add(jSeparator4);

      pagar.setText("Contas à Pagar");
      pagar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            pagarActionPerformed(evt);
         }
      });
      arquivo.add(pagar);

      receber.setText("Contas à Receber");
      receber.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            receberActionPerformed(evt);
         }
      });
      arquivo.add(receber);
      arquivo.add(jSeparator5);

      listaBairro.setText("Bairros");
      listaBairro.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            listaBairroActionPerformed(evt);
         }
      });
      arquivo.add(listaBairro);

      listaCidade.setText("Cidades");
      listaCidade.setToolTipText("");
      listaCidade.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            listaCidadeActionPerformed(evt);
         }
      });
      arquivo.add(listaCidade);

      listaCep.setText("CEPs");
      listaCep.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            listaCepActionPerformed(evt);
         }
      });
      arquivo.add(listaCep);
      arquivo.add(jSeparator6);

      listaFornecedor.setText("Fornecedores");
      listaFornecedor.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            listaFornecedorActionPerformed(evt);
         }
      });
      arquivo.add(listaFornecedor);

      listaPersonal.setText("Personais");
      listaPersonal.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            listaPersonalActionPerformed(evt);
         }
      });
      arquivo.add(listaPersonal);

      listaAluno.setText("Alunos");
      listaAluno.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            listaAlunoActionPerformed(evt);
         }
      });
      arquivo.add(listaAluno);

      jMenuBar1.add(arquivo);

      setJMenuBar(jMenuBar1);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 400, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 276, Short.MAX_VALUE)
      );

      pack();
      setLocationRelativeTo(null);
   }// </editor-fold>//GEN-END:initComponents

   private void bairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bairroActionPerformed
      TelaCadastroBairro telaCadastroBairro = new TelaCadastroBairro();
      ControllerBairro controllerBairro = new ControllerBairro(telaCadastroBairro);
      telaCadastroBairro.setVisible(true);
   }//GEN-LAST:event_bairroActionPerformed

   private void listaBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaBairroActionPerformed
      TelaBuscaBairro telaBuscaBairro = new TelaBuscaBairro(null, true);
      ControllerBbairro controllerBbairro = new ControllerBbairro(telaBuscaBairro);
      telaBuscaBairro.setVisible(true);
   }//GEN-LAST:event_listaBairroActionPerformed

   private void cidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cidadeActionPerformed
      TelaCadastroCidade telaCadastroCidade = new TelaCadastroCidade();
      ControllerCidade controllerCidade = new ControllerCidade(telaCadastroCidade);
      telaCadastroCidade.setVisible(true);
   }//GEN-LAST:event_cidadeActionPerformed

   private void cepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cepActionPerformed
      TelaCadastroCep telaCadastroCep = new TelaCadastroCep();
      ControllerCep controllerCep = new ControllerCep(telaCadastroCep);
      telaCadastroCep.setVisible(true);
   }//GEN-LAST:event_cepActionPerformed

   private void alunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alunoActionPerformed
      TelaCadastroAluno telaCadastroAluno = new TelaCadastroAluno();
      ControllerAluno controllerAluno = new ControllerAluno(telaCadastroAluno);
      telaCadastroAluno.setVisible(true);
   }//GEN-LAST:event_alunoActionPerformed

   private void personalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personalActionPerformed
      TelaCadastroPersonal telaCadastroPersonal = new TelaCadastroPersonal();
      ControllerPersonal controllerPersonal = new ControllerPersonal(telaCadastroPersonal);
      telaCadastroPersonal.setVisible(true);
   }//GEN-LAST:event_personalActionPerformed

   private void fornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fornecedorActionPerformed
      TelaCadastroFornecedor telaCadastroFornecedor = new TelaCadastroFornecedor();
      ControllerFornecedor controllerFornecedor = new ControllerFornecedor(telaCadastroFornecedor);
      telaCadastroFornecedor.setVisible(true);
   }//GEN-LAST:event_fornecedorActionPerformed

   private void compraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compraActionPerformed
      TelaCadastroCompra telaCadastroCompra = new TelaCadastroCompra();
      TelaAddItem tela = new TelaAddItem();
      ControllerCompra controllerCompra = new ControllerCompra(telaCadastroCompra, tela);
      telaCadastroCompra.setVisible(true);
   }//GEN-LAST:event_compraActionPerformed

   private void vendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendaActionPerformed
      TelaCadastroVenda telaCadastroVenda = new TelaCadastroVenda();
      TelaAddItem tela = new TelaAddItem();
      ControllerVenda controllerVenda = new ControllerVenda(telaCadastroVenda, tela);
      telaCadastroVenda.setVisible(true);
   }//GEN-LAST:event_vendaActionPerformed

   private void produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtoActionPerformed
      TelaCadastroProduto telaCadastroProduto = new TelaCadastroProduto();
      ControllerProduto controllerProduto = new ControllerProduto(telaCadastroProduto);
      telaCadastroProduto.setVisible(true);
   }//GEN-LAST:event_produtoActionPerformed

   private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
      dispose();
   }//GEN-LAST:event_sairActionPerformed

   private void listaCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaCidadeActionPerformed
      TelaBuscaCidade telaBuscaCidade = new TelaBuscaCidade(null, true);
      ControllerBcidade controllerBcidade = new ControllerBcidade(telaBuscaCidade);
      telaBuscaCidade.setVisible(true);
   }//GEN-LAST:event_listaCidadeActionPerformed

   private void listaCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaCepActionPerformed
      TelaBuscaCep telaBuscaCep = new TelaBuscaCep(null, true);
      ControllerBcep controllerBcep = new ControllerBcep(telaBuscaCep);
      telaBuscaCep.setVisible(true);
   }//GEN-LAST:event_listaCepActionPerformed

   private void listaAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaAlunoActionPerformed
      TelaBuscaAluno telaBuscaAluno = new TelaBuscaAluno(null, true);
      ControllerBaluno controllerBaluno = new ControllerBaluno(telaBuscaAluno);
      telaBuscaAluno.setVisible(true);
   }//GEN-LAST:event_listaAlunoActionPerformed

   private void listaPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaPersonalActionPerformed
      TelaBuscaPersonal telaBuscaPersonal = new TelaBuscaPersonal(null, true);
      ControllerBpersonal controllerBpersonal = new ControllerBpersonal(telaBuscaPersonal);
      telaBuscaPersonal.setVisible(true);
   }//GEN-LAST:event_listaPersonalActionPerformed

   private void listaFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaFornecedorActionPerformed
      TelaBuscaFornecedor telaBuscaFornecedor = new TelaBuscaFornecedor(null, true);
      ControllerBfornecedor controllerBfornecedor = new ControllerBfornecedor(telaBuscaFornecedor);
      telaBuscaFornecedor.setVisible(true);
   }//GEN-LAST:event_listaFornecedorActionPerformed

   private void receberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receberActionPerformed
      TelaBuscaVenda telaBuscaVenda = new TelaBuscaVenda(null, true);
      ControllerBvenda controllerBvenda = new ControllerBvenda(telaBuscaVenda);
      telaBuscaVenda.setVisible(true);
      TelaCadastroVenda telaCadastroVenda = new TelaCadastroVenda();
      TelaAddItem tela = new TelaAddItem();
      ControllerVenda controllerVenda = new ControllerVenda(telaCadastroVenda, tela);
   }//GEN-LAST:event_receberActionPerformed

   private void pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagarActionPerformed
      TelaBuscaCompra telaBuscaCompra = new TelaBuscaCompra(null, true);
      ControllerBcompra controllerBcompra = new ControllerBcompra(telaBuscaCompra);
      telaBuscaCompra.setVisible(true);
      TelaCadastroCompra telaCadastroCompra = new TelaCadastroCompra();
      TelaAddItem tela = new TelaAddItem();
      ControllerCompra controllerCompra = new ControllerCompra(telaCadastroCompra, tela);
   }//GEN-LAST:event_pagarActionPerformed

   private void faturamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_faturamentoActionPerformed
      TelaVendas telaVendas = new TelaVendas();
      ControllerFaturamento controllerVenda = new ControllerFaturamento(telaVendas);
      telaVendas.setVisible(true);
   }//GEN-LAST:event_faturamentoActionPerformed

   private void estoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estoqueActionPerformed
      TelaBuscaProduto telaBuscaProduto = new TelaBuscaProduto(null, true);
      ControllerBproduto controllerBproduto = new ControllerBproduto(telaBuscaProduto);
      telaBuscaProduto.setVisible(true);
   }//GEN-LAST:event_estoqueActionPerformed

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
         java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new MenuPrincipal().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JMenuItem aluno;
   private javax.swing.JMenu arquivo;
   private javax.swing.JMenuItem bairro;
   private javax.swing.JMenuItem cep;
   private javax.swing.JMenuItem cidade;
   private javax.swing.JMenuItem compra;
   private javax.swing.JMenuItem estoque;
   private javax.swing.JMenuItem faturamento;
   private javax.swing.JMenuItem fornecedor;
   private javax.swing.JMenuBar jMenuBar1;
   private javax.swing.JPopupMenu.Separator jSeparator1;
   private javax.swing.JPopupMenu.Separator jSeparator2;
   private javax.swing.JPopupMenu.Separator jSeparator3;
   private javax.swing.JPopupMenu.Separator jSeparator4;
   private javax.swing.JPopupMenu.Separator jSeparator5;
   private javax.swing.JPopupMenu.Separator jSeparator6;
   private javax.swing.JMenuItem listaAluno;
   private javax.swing.JMenuItem listaBairro;
   private javax.swing.JMenuItem listaCep;
   private javax.swing.JMenuItem listaCidade;
   private javax.swing.JMenuItem listaFornecedor;
   private javax.swing.JMenuItem listaPersonal;
   private javax.swing.JMenu movimentos;
   private javax.swing.JMenu novo;
   private javax.swing.JMenuItem pagar;
   private javax.swing.JMenuItem personal;
   private javax.swing.JMenuItem produto;
   private javax.swing.JMenuItem receber;
   private javax.swing.JMenuItem sair;
   private javax.swing.JMenuItem venda;
   // End of variables declaration//GEN-END:variables
}
