package controller.cadastro;

import controller.ControllerItemVenda;
import controller.busca.ControllerBvenda;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.bo.Aluno;
import model.bo.ItemVenda;
import model.bo.Personal;
import model.bo.Receber;
import model.bo.Venda;
import service.AlunoService;
import service.PersonalService;
import view.TelaAddItem;
import view.telasBusca.TelaBuscaVenda;
import view.telasCadastro.TelaCadastroVenda;

public class ControllerVenda implements ActionListener {

   // NUNCA MAIS SEU OTÁRIO
   
   public static TelaCadastroVenda tela = new TelaCadastroVenda();
   TelaAddItem addItem = new TelaAddItem();
   public static int codigo;
   public static int status;
   public static float valor;
   public static List<ItemVenda> listaItens = new ArrayList();
   public static DefaultTableModel tabela;

   public ControllerVenda(TelaCadastroVenda telaCadastroVenda, TelaAddItem telaAddItem) {
      this.tela = telaCadastroVenda;
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
      this.tela.getListaAluno().removeAll();
      this.tela.getListaAluno().addItem(" - ");
      for(Aluno aluno : AlunoService.Listar()){
         this.tela.getListaAluno().addItem(aluno.getNome());
      }
      
      this.tela.getListaPersonal().removeAll();
      this.tela.getListaPersonal().addItem(" - ");
      for(Personal personal : PersonalService.Listar()){
         this.tela.getListaPersonal().addItem(personal.getNome());
      }
      
      LimpaEstadoComponentes(false);
      
      if(codigo != 0){
         Ativa(false);
         LimpaEstadoComponentes(true);
         listaItens.clear();
         Receber receber = service.ReceberService.Listar(codigo);
         Venda venda = receber.getVenda();
         this.valor = venda.getValorTotal();
         for(ItemVenda i : service.ItemVendaService.Listar()){
            if(i.getVenda().getIdentificacao().equals(venda.getIdentificacao())){
               listaItens.add(i);
               String subt = String.valueOf(i.getSubtotal());
               this.tabela.addRow(new Object[]{i.getProduto().getDescricao(), i.getQuantidade(), "R$ " + subt.replace(".", ",")});
            }
         }
         
         this.tela.getTextoValorTotal().setText("R$ " + String.format("%.2f", this.valor));
         this.tela.getTextoObs().setText(venda.getObs());
         this.tela.getListaAluno().setSelectedItem(venda.getAluno().getNome().replace("<html>", "").replace("</html>", ""));
         this.tela.getListaPersonal().setSelectedItem(venda.getPersonal().getNome().replace("<html>", "").replace("</html>", ""));
         
         String acrescimo = String.valueOf(receber.getValorAcrescimo());
         this.tela.getTextoAcrescimo().setText(acrescimo.substring(0, acrescimo.indexOf(".")));
         this.tela.getTextoAcrescimoCents().setText(acrescimo.substring((acrescimo.indexOf(".") + 1), acrescimo.length()));

         String desconto = String.valueOf(receber.getValorDesconto());
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
         ControllerItemVenda.produtos.clear();
         LimpaEstadoComponentes(false);
      }
      
      if(e.getSource() == this.tela.getGravar()){
         Venda venda = new Venda();
         Date dataHora = new Date();
         
         String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHora);
         String dataFormat = data.substring(6, 10) + "-" + data.substring(3, 5) + "-" + data.substring(0, 2);
         venda.setData(dataFormat);

         data = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(dataHora);
         venda.setIdentificacao("Venda " + data);
         
         venda.setObs(this.tela.getTextoObs().getText());
         
         for(Aluno aluno : AlunoService.Listar()){
            if(aluno.getNome().equals(this.tela.getListaAluno().getSelectedItem().toString())){
               venda.setAluno(AlunoService.Listar(aluno.getId()));
            }
         }
         
         for(Personal personal : PersonalService.Listar()){
            if(personal.getNome().equals(this.tela.getListaPersonal().getSelectedItem().toString())){
               venda.setPersonal(PersonalService.Listar(personal.getId()));
            }
         }
         
         valor = 0;
         for(var item : listaItens){
            valor += item.getSubtotal();
         }
         venda.setValorTotal(valor);
         
         if(codigo == 0){
            service.VendaService.Incluir(venda);
         }else{
            venda.setId(service.ReceberService.Listar(codigo).getVenda().getId());
            service.VendaService.Atualizar(venda);
         }
         
         for(Venda v : service.VendaService.Listar()){
            if(v.getIdentificacao().equals(venda.getIdentificacao())){
               venda = v;
               break;
            }
         }

         List<ItemVenda> listinha = new ArrayList<>();
         listinha.addAll(service.ItemVendaService.Listar());
         if(codigo != 0){
            for(ItemVenda i : listinha){
               if(i.getVenda().getId() == venda.getId()){
                  service.ItemVendaService.Excluir(i);
               }
            }
         }

         for(ItemVenda item : listaItens){
            item.setVenda(venda);
            service.ItemVendaService.Incluir(item);
         }

         Receber receber = new Receber();
         Calendar calendario = Calendar.getInstance();
         calendario.setTime(dataHora); 
         calendario.add(Calendar.MONTH, 2);
         dataHora = calendario.getTime();
         String vencimento = new SimpleDateFormat("dd/MM/yyyy").format(dataHora);
         String vFormat = vencimento.substring(6, 10) + "-" + vencimento.substring(3, 5) + "-" + vencimento.substring(0, 2);
         venda.setData(dataFormat);
         
         receber.setVenda(venda);
         receber.setDtEmissao(dataFormat);
         receber.setDtVencimento(vFormat);
         
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
         
         receber.setValorAcrescimo(Float.parseFloat(acrescimo));
         
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
         
         receber.setValorDesconto(Float.parseFloat(desconto));
         
         receber.setStatus(0); // 0 - não pago e 1 - pago

         receber.setValorEmitido(venda.getValorTotal() - receber.getValorDesconto() + receber.getValorAcrescimo());

         if(codigo == 0) {
            service.ReceberService.Incluir(receber);
         }else{
            receber.setId(service.ReceberService.Listar(codigo).getId());
            service.ReceberService.Atualizar(receber);
         }
         
         Ativa(true);
         LimpaEstadoComponentes(false);
      }
      
      if(e.getSource() == this.tela.getBuscar()){
         codigo = 0;
         view.telasBusca.TelaBuscaVenda telaBusca = new TelaBuscaVenda(null, true);
         ControllerBvenda controller = new ControllerBvenda(telaBusca);
         telaBusca.setVisible(true);

         if(codigo != 0){
            Ativa(false);
            LimpaEstadoComponentes(true);
            listaItens.clear();
            Receber receber = service.ReceberService.Listar(codigo);
            Venda venda = receber.getVenda();
            this.valor = venda.getValorTotal();
            for(ItemVenda i : service.ItemVendaService.Listar()){
               if(i.getVenda().getIdentificacao().equals(venda.getIdentificacao())){
                  listaItens.add(i);
                  String subt = String.valueOf(i.getSubtotal());
                  this.tabela.addRow(new Object[]{i.getProduto().getDescricao(), i.getQuantidade(), "R$ " + subt.replace(".", ",")});
               }
            }

            this.tela.getTextoValorTotal().setText("R$ " + String.format("%.2f", this.valor));
            this.tela.getTextoObs().setText(venda.getObs());
            this.tela.getListaAluno().setSelectedItem(venda.getAluno().getNome().replace("<html>", "").replace("</html>", ""));
            this.tela.getListaPersonal().setSelectedItem(venda.getPersonal().getNome().replace("<html>", "").replace("</html>", ""));

            String acrescimo = String.valueOf(receber.getValorAcrescimo());
            this.tela.getTextoAcrescimo().setText(acrescimo.substring(0, acrescimo.indexOf(".")));
            this.tela.getTextoAcrescimoCents().setText(acrescimo.substring((acrescimo.indexOf(".") + 1), acrescimo.length()));

            String desconto = String.valueOf(receber.getValorDesconto());
            this.tela.getTextoDesconto().setText(desconto.substring(0, desconto.indexOf(".")));
            this.tela.getTextoDescontoCents().setText(desconto.substring((desconto.indexOf(".") + 1), desconto.length()));
         }
      }
      
      if(e.getSource() == this.tela.getAdicionar()){
         TelaAddItem telaAddItem = new TelaAddItem();
         ControllerItemVenda controller = new ControllerItemVenda(telaAddItem);
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
                  ControllerItemVenda.produtos.add(item.getProduto());
                  listaItens.remove(item);
                  break;
               }
            }

            Collections.sort(ControllerItemVenda.produtos);
            tabela.removeRow(this.tela.getjTable1().getSelectedRow());
            this.tela.getDelete().setEnabled(false);
         }
      }
      
      if(e.getSource() == this.tela.getSair()){
         this.tela.dispose();
      }
   }

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
