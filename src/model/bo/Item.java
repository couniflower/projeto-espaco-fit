package model.bo;

public class Item {
   private Produto produto;
   private int quantidade;
   private float subtotal;

   public Item() {
   }

   public Item(Produto produto, int quantidade) {
      this.produto = produto;
      this.quantidade = quantidade;
      this.subtotal = this.produto.getValor() * this.quantidade;
   }

   public Produto getProduto() {
      return produto;
   }

   public void setProduto(Produto produto) {
      this.produto = produto;
   }

   public int getQuantidade() {
      return quantidade;
   }

   public void setQuantidade(int quantidade) {
      this.quantidade = quantidade;
   }

   public float getSubtotal() {
      return subtotal;
   }

   public void setSubtotal(float subtotal) {
      this.subtotal = subtotal;
   }
}
