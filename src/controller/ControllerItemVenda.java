package controller;

import controller.cadastro.ControllerVenda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.bo.ItemVenda;
import model.bo.Produto;
import service.ProdutoService;
import view.TelaAddItem;

public class ControllerItemVenda implements ActionListener {
   
   TelaAddItem tela;
   public static List<Produto> produtos = new ArrayList();

   public ControllerItemVenda(TelaAddItem telaAddItem) {
      this.tela = telaAddItem;
      
      this.tela.getCancelar().addActionListener(this);
      this.tela.getGravar().addActionListener(this);
      
      this.tela.getListaProduto().removeAll();
      this.tela.getListaProduto().addItem(" - ");
      
      if(ControllerVenda.listaItens.isEmpty()){
         produtos.clear();
         produtos.addAll(ProdutoService.Listar());
      }

      Collections.sort(produtos);
      
      for(Produto produto : produtos){
         this.tela.getListaProduto().addItem(produto.getDescricao());
      }
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource() == this.tela.getCancelar()){
         this.tela.dispose();
      }
      
      if(e.getSource() == this.tela.getGravar()){
         ItemVenda item = new ItemVenda();

         for(Produto produto : ProdutoService.Listar()){
            if(produto.getDescricao().equals(this.tela.getListaProduto().getSelectedItem())){
               item.setProduto(produto);
               if(this.tela.getQtdNumero().getText().isEmpty()){
                  item.setQuantidade(0);
               }else{
                  item.setQuantidade(Integer.parseInt(this.tela.getQtdNumero().getText()));
               }
               item.setSubtotal(item.getProduto().getValor() * item.getQuantidade());
               //this.tela.getListaProduto().removeItem(produto.getDescricao());
            }
         }
         
         for(var p : produtos){
            if(p.getId() == item.getProduto().getId()){
               produtos.remove(p);
               break;
            }
         }
         
         ControllerVenda.listaItens.add(item);
         String subt = String.valueOf(item.getSubtotal());
         ControllerVenda.tabela.addRow(new Object[]{item.getProduto().getDescricao(), item.getQuantidade(), "R$ " + subt.replace(".", ",")});
         ControllerVenda.valor += item.getSubtotal();
         String valor = String.valueOf(ControllerVenda.valor);
         ControllerVenda.tela.getTextoValorTotal().setText("R$ " + valor.replace(".", ","));

         //service.ItemVendaService.Incluir(item);
         
         this.tela.dispose();
      }
   }
}
