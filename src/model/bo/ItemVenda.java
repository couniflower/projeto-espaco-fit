package model.bo;

public class ItemVenda extends Item {
   private int id;
   private Venda venda;

   public ItemVenda() {
   }

   public ItemVenda(Produto produto, int quantidade) {
      super(produto, quantidade);
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