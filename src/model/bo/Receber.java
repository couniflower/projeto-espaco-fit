package model.bo;

public class Receber extends Impressao {
   private int id;
   private Venda venda;

   public Receber() {
   }

   public Receber(int id, Venda venda, String dtEmissao, String dtVencimento, String dtPagamento, float valorEmitido, float valorDesconto, float valorAcrescimo, float valorPago, int status) {
      super(dtEmissao, dtVencimento, dtPagamento, valorEmitido, valorDesconto, valorAcrescimo, valorPago, status);
      this.id = id;
      this.venda = venda;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public Venda getVenda() {
      return venda;
   }

   public void setVenda(Venda venda) {
      this.venda = venda;
   }
}
