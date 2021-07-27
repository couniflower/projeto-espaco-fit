package service;

import java.util.List;
import model.DAO.ProdutoDAO;
import model.bo.Produto;

public class ProdutoService {
   public static void Incluir(Produto objeto){
      ProdutoDAO produtoDao = new ProdutoDAO();
      produtoDao.Create(objeto);
   }
   
   public static List<Produto> Listar(){
      ProdutoDAO produtoDao = new ProdutoDAO();
      return produtoDao.Retrieve();
   }
   
   public static Produto Listar(int id){
      ProdutoDAO produtoDao = new ProdutoDAO();
      return produtoDao.Retrieve(id);
   }

   public static Produto Listar(String codigo){
      ProdutoDAO produtoDao = new ProdutoDAO();
      int id = 0;
      for(Produto produto : Listar()){
         if(produto.getCodigoBarra().equalsIgnoreCase(codigo)){
            id = produto.getId();
         }
      }

      if(id == 0){
         return null;
      }

      return produtoDao.Retrieve(id);
   }
   
   public static void Atualizar(Produto objeto){
      ProdutoDAO produtoDao = new ProdutoDAO();
      produtoDao.Update(objeto);
   }
   
   public static void Excluir(Produto objeto){
      ProdutoDAO produtoDao = new ProdutoDAO();
      produtoDao.Delete(objeto);
   }
}
