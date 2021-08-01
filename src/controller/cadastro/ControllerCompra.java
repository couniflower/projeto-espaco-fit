package controller.cadastro;

import controller.ControllerItemCompra;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.busca.ControllerBcompra;
import controller.busca.ControllerBvenda;
import model.bo.*;
import service.FornecedorService;
import view.TelaAddItem;
import view.telasBusca.TelaBuscaCompra;
import view.telasBusca.TelaBuscaVenda;
import view.telasCadastro.TelaCadastroCompra;

public class ControllerCompra implements ActionListener {

   // VAI MUDAR DEPOIS NEM SE PREOCUPA

   public static TelaCadastroCompra tela = new TelaCadastroCompra();
   TelaAddItem addItem = new TelaAddItem();
   public static int codigo;
   public static int status;
   public static float valor;
   public static List<ItemCompra> listaItens = new ArrayList();
   public static DefaultTableModel tabela;
   
   public ControllerCompra(TelaCadastroCompra telaCadastroCompra, TelaAddItem telaAddItem) {
      this.tela = telaCadastroCompra;
      this.addItem = telaAddItem;

      this.tela.getNovo().addActionListener(this);
      this.tela.getCancelar().addActionListener(this);
      this.tela.getBuscar().addActionListener(this);
      this.tela.getSair().addActionListener(this);
      this.tela.getGravar().addActionListener(this);
      this.tela.getAdicionar().addActionListener(this);
      this.tela.getDelete().addActionListener(this);
      this.tela.getDelete().setEnabled(false);
      this.tela.getTextoValorTotal().setEditable(false);

      this.tabela = (DefaultTableModel) this.tela.getjTable1().getModel();
      this.valor = 0;
      this.tela.getTextoValorTotal().setText("R$ 0,00");
      listaItens.clear();

      Ativa(true);
      
      //combobox
      this.tela.getListaFornecedor().removeAll();
      this.tela.getListaFornecedor().addItem(" - ");
      for(Fornecedor fornecedor : FornecedorService.Listar()){
         this.tela.getListaFornecedor().addItem(fornecedor.getNome());
      }

      LimpaEstadoComponentes(false);

      if(codigo != 0){
         Ativa(false);
         LimpaEstadoComponentes(true);
         listaItens.clear();
         Pagar pagar = service.PagarService.Listar(codigo);
         Compra compra = pagar.getCompra();
         this.valor = compra.getValorTotal();
         for(ItemCompra i : service.ItemCompraService.Listar()){
            if(i.getCompra().getIdentificacao().equals(compra.getIdentificacao())){
               listaItens.add(i);
               String subt = String.valueOf(i.getSubtotal());
               this.tabela.addRow(new Object[]{i.getProduto().getDescricao(), i.getQuantidade(), "R$ " + subt.replace(".", ",")});
            }
         }

         this.tela.getTextoValorTotal().setText("R$ " + String.format("%.2f", this.valor));
         this.tela.getTextoObs().setText(compra.getObs());
         this.tela.getListaFornecedor().setSelectedItem(compra.getFornecedor().getNome().replace("<html>", "").replace("</html>", ""));

         String acrescimo = String.valueOf(pagar.getValorAcrescimo());
         this.tela.getTextoAcrescimo().setText(acrescimo.substring(0, acrescimo.indexOf(".")));
         this.tela.getTextoAcrescimoCents().setText(acrescimo.substring((acrescimo.indexOf(".") + 1), acrescimo.length()));

         String desconto = String.valueOf(pagar.getValorDesconto());
         this.tela.getTextoDesconto().setText(desconto.substring(0, desconto.indexOf(".")));
         this.tela.getTextoDescontoCents().setText(desconto.substring((desconto.indexOf(".") + 1), desconto.length()));
      }
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource() == this.tela.getNovo()){
         Ativa(false);
         LimpaEstadoComponentes(true);
         ((DefaultTableModel) this.tela.getjTable1().getModel()).setRowCount(0);
         this.tela.getTextoValorTotal().setText("R$ 0,00");
         codigo = 0;
      }
      
      if(e.getSource() == this.tela.getCancelar()){
         Ativa(true);
         ((DefaultTableModel) this.tela.getjTable1().getModel()).setRowCount(0);
         listaItens.clear();
         ControllerItemCompra.produtos.clear();
         LimpaEstadoComponentes(false);
      }
      
      if(e.getSource() == this.tela.getGravar()){
         Compra compra = new Compra();
         Date dataHora = new Date();

         String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHora);
         String dataFormat = data.substring(6, 10) + "-" + data.substring(3, 5) + "-" + data.substring(0, 2);
         compra.setData(dataFormat);

         data = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(dataHora);
         compra.setIdentificacao("Compra " + data);

         compra.setObs(this.tela.getTextoObs().getText());
         
         for(Fornecedor fornecedor : FornecedorService.Listar()){
            if(fornecedor.getNome().equals(this.tela.getListaFornecedor().getSelectedItem().toString())){
               compra.setFornecedor(FornecedorService.Listar(fornecedor.getId()));
            }
         }

         valor = 0;
         for(var item : listaItens){
            valor += item.getSubtotal();
         }
         compra.setValorTotal(valor);

         if(codigo == 0){
            service.CompraService.Incluir(compra);
         }else{
            compra.setId(service.PagarService.Listar(codigo).getCompra().getId());
            service.CompraService.Atualizar(compra);
         }

         for(Compra c : service.CompraService.Listar()){
            if(c.getIdentificacao().equals(compra.getIdentificacao())){
               compra = c;
               break;
            }
         }

         List<ItemCompra> listinha = new ArrayList<>();
         listinha.addAll(service.ItemCompraService.Listar());
         if(codigo != 0){
            for(ItemCompra i : listinha){
               if(i.getCompra().getId() == compra.getId()){
                  service.ItemCompraService.Excluir(i);
               }
            }
         }

         for(ItemCompra item : listaItens){
            item.setCompra(compra);
            service.ItemCompraService.Incluir(item);
         }
         
         Pagar pagar = new Pagar();
         Calendar calendario = Calendar.getInstance();
         calendario.setTime(dataHora);
         calendario.add(Calendar.MONTH, 2);
         dataHora = calendario.getTime();
         String vencimento = new SimpleDateFormat("dd/MM/yyyy").format(dataHora);
         String vFormat = vencimento.substring(6, 10) + "-" + vencimento.substring(3, 5) + "-" + vencimento.substring(0, 2);
         compra.setData(dataFormat);

         pagar.setCompra(compra);
         pagar.setDtEmissao(dataFormat);
         pagar.setDtVencimento(vFormat);

         String desconto = "", acrescimo = "";

         if(this.tela.getTextoAcrescimo().getText().isEmpty()){
            acrescimo += "0";
         }else{
            acrescimo += this.tela.getTextoAcrescimo().getText();
         }

         if(this.tela.getTextoAcrescimoCents().getText().isEmpty()){
            acrescimo += ".0";
         }else{
            acrescimo += "." + this.tela.getTextoAcrescimoCents().getText();
         }

         pagar.setValorAcrescimo(Float.parseFloat(acrescimo));

         if(this.tela.getTextoDesconto().getText().isEmpty()){
            desconto += "0";
         }else{
            desconto += this.tela.getTextoDesconto().getText();
         }

         if(this.tela.getTextoDescontoCents().getText().isEmpty()){
            desconto += ".0";
         }else{
            desconto += "." + this.tela.getTextoDescontoCents().getText();
         }

         pagar.setValorDesconto(Float.parseFloat(desconto));

         //pagar.setStatus(0); // 0 - não pago e 1 - pago
         
         pagar.setValorEmitido(compra.getValorTotal() + pagar.getValorAcrescimo() - pagar.getValorDesconto());

         if(codigo == 0) {
            service.PagarService.Incluir(pagar);
         }else{
            pagar.setId(service.PagarService.Listar(codigo).getId());
            service.PagarService.Atualizar(pagar);
         }

         Ativa(true);
         LimpaEstadoComponentes(false);
      }
      
      if(e.getSource() == this.tela.getBuscar()){
         codigo = 0;
         view.telasBusca.TelaBuscaCompra telaBusca = new TelaBuscaCompra(null, true);
         ControllerBcompra controller = new ControllerBcompra(telaBusca);
         controller.setTela(0);
         telaBusca.setVisible(true);

         if(codigo != 0){
            Ativa(false);
            LimpaEstadoComponentes(true);
            listaItens.clear();
            Pagar pagar = service.PagarService.Listar(codigo);
            Compra compra = pagar.getCompra();
            this.valor = compra.getValorTotal();
            for(ItemCompra i : service.ItemCompraService.Listar()){
               if(i.getCompra().getIdentificacao().equals(compra.getIdentificacao())){
                  listaItens.add(i);
                  String subt = String.valueOf(i.getSubtotal());
                  this.tabela.addRow(new Object[]{i.getProduto().getDescricao(), i.getQuantidade(), "R$ " + subt.replace(".", ",")});
               }
            }

            this.tela.getTextoValorTotal().setText("R$ " + String.format("%.2f", this.valor));
            this.tela.getTextoObs().setText(compra.getObs());
            this.tela.getListaFornecedor().setSelectedItem(compra.getFornecedor().getNome().replace("<html>", "").replace("</html>", ""));

            String acrescimo = String.valueOf(pagar.getValorAcrescimo());
            this.tela.getTextoAcrescimo().setText(acrescimo.substring(0, acrescimo.indexOf(".")));
            this.tela.getTextoAcrescimoCents().setText(acrescimo.substring((acrescimo.indexOf(".") + 1), acrescimo.length()));

            String desconto = String.valueOf(pagar.getValorDesconto());
            this.tela.getTextoDesconto().setText(desconto.substring(0, desconto.indexOf(".")));
            this.tela.getTextoDescontoCents().setText(desconto.substring((desconto.indexOf(".") + 1), desconto.length()));
         }
      }

      if(e.getSource() == this.tela.getAdicionar()){
         TelaAddItem telaAddItem = new TelaAddItem();
         ControllerItemCompra controller = new ControllerItemCompra(telaAddItem);
         telaAddItem.setVisible(true);
      }

      if(e.getSource() == this.tela.getDelete()){
         DefaultTableModel tabela = (DefaultTableModel) this.tela.getjTable1().getModel();
         if(this.tela.getjTable1().getSelectedRowCount() > 0){
            String obj = this.tela.getjTable1().getValueAt(this.tela.getjTable1().getSelectedRow(), 2).toString().replace("R$ ", "").replace(",", ".");
            this.valor -= Float.parseFloat(obj);
            this.tela.getTextoValorTotal().setText("R$ " + String.format("%.2f", this.valor));

            for(var item : listaItens){
               if(this.tela.getjTable1().getValueAt(this.tela.getjTable1().getSelectedRow(), 0).toString().equals(item.getProduto().getDescricao())){
                  ControllerItemCompra.produtos.add(item.getProduto());
                  listaItens.remove(item);
                  break;
               }
            }

            Collections.sort(ControllerItemCompra.produtos);
            tabela.removeRow(this.tela.getjTable1().getSelectedRow());
            this.tela.getDelete().setEnabled(false);
         }
      }
      
      if(e.getSource() == this.tela.getSair()){
         this.tela.dispose();
      }
   }

   //mexer nos botões
   public void Ativa(boolean estado){
      this.tela.getNovo().setEnabled(estado);
      this.tela.getCancelar().setEnabled(!estado);
      this.tela.getBuscar().setEnabled(estado);
      this.tela.getSair().setEnabled(estado);
      this.tela.getGravar().setEnabled(!estado);
      this.tela.getAdicionar().setEnabled(!estado);
   }
   
   public void LimpaEstadoComponentes(boolean estado){
      Component[] componentes = this.tela.getCenter().getComponents();
      for(Component componente : componentes){
         if(componente instanceof JTextField){
            ((JTextField) componente).setText("");
            componente.setEnabled(estado);
         }
         
         if(componente instanceof JFormattedTextField){
            ((JFormattedTextField) componente).setValue(null);
            componente.setEnabled(estado);
         }
         
         if(componente instanceof JComboBox){
            ((JComboBox) componente).setSelectedItem(0);
            componente.setEnabled(estado);
         }
      }
   }
   
   public void setCodigo(int c){
      codigo = c;
   }
   
   public void setStatus(int s){
      status = s;
   }
   
   public int getStatus(){
      return status;
   }
}
