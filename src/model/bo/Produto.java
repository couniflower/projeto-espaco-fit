package model.bo;

public class Produto implements Comparable<Produto> {
   private int id;
   private String descricao;
   private int unidCompra;
   private int unidVenda;
   private float correlacao;
   private float valor;
   private int qtdEstoque;
   private String codigoBarra;
   private String obs;

   public Produto() {
   }

   public Produto(int id, String descricao, int unidCompra, int unidVenda, float correlacao, float valor, int qtdEstoque, String codigoBarra, String obs) {
      this.id = id;
      this.descricao = descricao;
      this.unidCompra = unidCompra;
      this.unidVenda = unidVenda;
      this.correlacao = correlacao;
      this.valor = valor;
      this.qtdEstoque = qtdEstoque;
      this.codigoBarra = codigoBarra;
      this.obs = obs;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getDescricao() {
      return descricao;
   }

   public void setDescricao(String descricao) {
      this.descricao = descricao;
   }

   public int getUnidCompra() {
      return unidCompra;
   }

   public void setUnidCompra(int unidCompra) {
      this.unidCompra = unidCompra;
   }

   public int getUnidVenda() {
      return unidVenda;
   }

   public void setUnidVenda(int unidVenda) {
      this.unidVenda = unidVenda;
   }

   public float getCorrelacao() {
      return correlacao;
   }

   public void setCorrelacao(float correlacao) {
      this.correlacao = correlacao;
   }

   public float getValor() {
      return valor;
   }

   public void setValor(float valor) {
      this.valor = valor;
   }

   public int getQtdEstoque() {
      return qtdEstoque;
   }

   public void setQtdEstoque(int qtdEstoque) {
      this.qtdEstoque = qtdEstoque;
   }

   public String getCodigoBarra() {
      return codigoBarra;
   }

   public void setCodigoBarra(String codigoBarra) {
      this.codigoBarra = codigoBarra;
   }

   public String getObs() {
      return obs;
   }

   public void setObs(String obs) {
      this.obs = obs;
   }

   @Override
   public int compareTo(Produto o) {
      return descricao.compareTo(o.getDescricao());
   }
}
