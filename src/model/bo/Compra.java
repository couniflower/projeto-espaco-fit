package model.bo;

public class Compra {
   private Fornecedor fornecedor;
   private int id;
   private String identificacao;
   private String data;
   private float valorTotal;
   private String obs;

   public Compra() {
   }

   public Compra(Fornecedor fornecedor, int id, String identificacao, String data, float valorTotal, String obs) {
      this.fornecedor = fornecedor;
      this.id = id;
      this.identificacao = identificacao;
      this.data = data;
      this.valorTotal = valorTotal;
      this.obs = obs;
   }

   public Fornecedor getFornecedor() {
      return fornecedor;
   }

   public void setFornecedor(Fornecedor fornecedor) {
      this.fornecedor = fornecedor;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getIdentificacao() {
      return identificacao;
   }

   public void setIdentificacao(String identificacao) {
      this.identificacao = identificacao;
   }

   public String getData() {
      return data;
   }

   public void setData(String data) {
      this.data = data;
   }

   public float getValorTotal() {
      return valorTotal;
   }

   public void setValorTotal(float valorTotal) {
      this.valorTotal = valorTotal;
   }

   public String getObs() {
      return obs;
   }

   public void setObs(String obs) {
      this.obs = obs;
   }
}