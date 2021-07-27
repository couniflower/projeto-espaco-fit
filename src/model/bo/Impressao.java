package model.bo;

public class Impressao {
   private String dtEmissao;
   private String dtVencimento;
   private String dtPagamento;
   private float valorEmitido;
   private float valorDesconto;
   private float valorAcrescimo;
   private float valorPago;
   private int status;

   public Impressao() {
   }

   public Impressao(String dtEmissao, String dtVencimento, String dtPagamento, float valorEmitido, float valorDesconto, float valorAcrescimo, float valorPago, int status) {
      this.dtEmissao = dtEmissao;
      this.dtVencimento = dtVencimento;
      this.dtPagamento = dtPagamento;
      this.valorEmitido = valorEmitido;
      this.valorDesconto = valorDesconto;
      this.valorAcrescimo = valorAcrescimo;
      this.valorPago = valorPago;
      this.status = status;
   }

   public String getDtEmissao() {
      return dtEmissao;
   }

   public void setDtEmissao(String dtEmissao) {
      this.dtEmissao = dtEmissao;
   }

   public String getDtVencimento() {
      return dtVencimento;
   }

   public void setDtVencimento(String dtVencimento) {
      this.dtVencimento = dtVencimento;
   }

   public String getDtPagamento() {
      return dtPagamento;
   }

   public void setDtPagamento(String dtPagamento) {
      this.dtPagamento = dtPagamento;
   }

   public float getValorEmitido() {
      return valorEmitido;
   }

   public void setValorEmitido(float valorEmitido) {
      this.valorEmitido = valorEmitido;
   }

   public float getValorDesconto() {
      return valorDesconto;
   }

   public void setValorDesconto(float valorDesconto) {
      this.valorDesconto = valorDesconto;
   }

   public float getValorAcrescimo() {
      return valorAcrescimo;
   }

   public void setValorAcrescimo(float valorAcrescimo) {
      this.valorAcrescimo = valorAcrescimo;
   }

   public float getValorPago() {
      return valorPago;
   }

   public void setValorPago(float valorPago) {
      this.valorPago = valorPago;
   }

   public int getStatus() {
      return status;
   }

   public void setStatus(int status) {
      this.status = status;
   }
}
