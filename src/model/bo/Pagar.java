package model.bo;

public class Pagar extends Impressao {
   private int id;
   private Compra compra;

   public Pagar() {
   }

   public Pagar(int id, Compra compra, String dtEmissao, String dtVencimento, String dtPagamento, float valorEmitido, float valorDesconto, float valorAcrescimo, float valorPago, int status) {
      super(dtEmissao, dtVencimento, dtPagamento, valorEmitido, valorDesconto, valorAcrescimo, valorPago, status);
      this.id = id;
      this.compra = compra;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public Compra getCompra() {
      return compra;
   }

   public void setCompra(Compra compra) {
      this.compra = compra;
   }
}
