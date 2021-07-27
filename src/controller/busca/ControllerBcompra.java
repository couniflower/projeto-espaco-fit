package controller.busca;

import controller.cadastro.ControllerCompra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import jtextfields.WrapLineJtable;
import model.bo.*;
import view.telasBusca.TelaBuscaCompra;

public class ControllerBcompra implements ActionListener {

   // VAI MUDAR DEPOIS NEM SE PREOCUPA

   TelaBuscaCompra tela;
   public static int controle;
   public static int qual;

   public ControllerBcompra(TelaBuscaCompra telaBuscaCompra) {
      this.tela = telaBuscaCompra;

      this.tela.getCarregar().addActionListener(this);
      this.tela.getDeletar().addActionListener(this);
      this.tela.getSair().addActionListener(this);

      DefaultTableModel tabela = (DefaultTableModel) this.tela.getjTable1().getModel();
      if(!service.PagarService.Listar().isEmpty()){
         Ativa(true);
         for(Pagar pagar : service.PagarService.Listar()) {
            List<ItemCompra> its = new ArrayList<>();
            String itens = "";
            if(service.ItemCompraService.Listar().size() != 0){
               for(ItemCompra item : service.ItemCompraService.Listar()){
                  if(item.getCompra().getIdentificacao().equals(pagar.getCompra().getIdentificacao())){
                     its.add(item);
                  }
               }
            }

            for(ItemCompra item : its){
               if(its.indexOf(item) != (its.size() - 1)){
                  itens += item.getProduto().getDescricao() + " (" + item.getQuantidade() + ") - R$ " + String.format("%.2f", item.getSubtotal()) + "\n";
               }else{
                  itens += item.getProduto().getDescricao() + " (" + item.getQuantidade() + ") - R$ " + String.format("%.2f", item.getSubtotal());
               }
            }

            StringBuilder str = new StringBuilder();
            str.append("<html>");
            str.append(itens.replaceAll("\n","<br>"));
            str.append("</html>");

            tabela.addRow(new Object[]{pagar.getId(), new WrapLineJtable().wrapLine(pagar.getCompra().getFornecedor().getNome(), 5).toString(), str.toString(), pagar.getCompra().getValorTotal(), pagar.getValorDesconto(), pagar.getValorAcrescimo(), pagar.getValorEmitido(), new WrapLineJtable().wrapLine(pagar.getCompra().getObs(), 10).toString()});
         }
      }else{
         qual = 1;
      }

      this.tela.getjTable1().getSelectionModel().addListSelectionListener(new ListSelectionListener(){
         public void valueChanged(ListSelectionEvent event) {
            AtivaTodos(true);
         }
      });
   }


   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource() == this.tela.getCarregar()){
         ControllerCompra.codigo = (int) this.tela.getjTable1().getValueAt(this.tela.getjTable1().getSelectedRow(), 0);
         this.tela.dispose();
      }
      
      if(e.getSource() == this.tela.getDeletar()){
         DefaultTableModel tabela = (DefaultTableModel) this.tela.getjTable1().getModel();
         if((int) this.tela.getjTable1().getValueAt(this.tela.getjTable1().getSelectedRow(), 0) > 0){
            Pagar pagar = service.PagarService.Listar((int) this.tela.getjTable1().getValueAt(this.tela.getjTable1().getSelectedRow(), 0));
            Compra compra = service.CompraService.Listar(pagar.getCompra().getId());
            List<ItemCompra> itens = new ArrayList();
            if(service.ItemCompraService.Listar().size() != 0){
               for(ItemCompra item : service.ItemCompraService.Listar()){
                  if(item.getCompra().getIdentificacao().equals(compra.getIdentificacao())){
                     itens.add(item);
                  }
               }
            }
            service.PagarService.Excluir(pagar);
            service.CompraService.Excluir(compra);
            for(var item : itens){
               service.ItemCompraService.Excluir(item);
            }
            tabela.removeRow(this.tela.getjTable1().getSelectedRow());
         }
         Ativa(true);
      }
      
      if(e.getSource() == this.tela.getSair()){
         if(qual == 1){
            ControllerCompra.status = 1;
         }
         this.tela.dispose();
      }
   }
   
   public void Ativa(boolean estado){
      this.tela.getCarregar().setEnabled(!estado);
      this.tela.getDeletar().setEnabled(!estado);
      this.tela.getSair().setEnabled(estado);
   }
   
   public void AtivaTodos(boolean estado){
      this.tela.getCarregar().setEnabled(estado);
      this.tela.getDeletar().setEnabled(estado);
      this.tela.getSair().setEnabled(estado);
   }
   
   public int getControle(){
      return controle;
   }
   
   public void setTela(int tela){
      qual = tela;
   }
   
   public int getTela(){
      return qual;
   }
}
