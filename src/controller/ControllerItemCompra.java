package controller;

import controller.cadastro.ControllerCompra;
import controller.cadastro.ControllerVenda;
import model.bo.ItemCompra;
import model.bo.ItemVenda;
import model.bo.Produto;
import service.ProdutoService;
import view.TelaAddItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ControllerItemCompra implements ActionListener {

   TelaAddItem tela;
   public static List<Produto> produtos = new ArrayList();

   public ControllerItemCompra(TelaAddItem telaAddItem) {
      this.tela = telaAddItem;
      
      this.tela.getCancelar().addActionListener(this);
      this.tela.getGravar().addActionListener(this);
      
      this.tela.getListaProduto().removeAll();
      this.tela.getListaProduto().addItem(" - ");
      
      if(ControllerCompra.listaItens.isEmpty()){
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
         ItemCompra item = new ItemCompra();

         for(Produto produto : service.ProdutoService.Listar()){
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
         
         ControllerCompra.listaItens.add(item);
         String subt = String.valueOf(item.getSubtotal());
         ControllerCompra.tabela.addRow(new Object[]{item.getProduto().getDescricao(), item.getQuantidade(), "R$ " + subt.replace(".", ",")});
         ControllerCompra.valor += item.getSubtotal();
         String valor = String.valueOf(ControllerCompra.valor);
         ControllerCompra.tela.getTextoValorTotal().setText("R$ " + valor.replace(".", ","));
         
         this.tela.dispose();
      }
   }
}
