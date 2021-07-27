package service;

import java.util.List;
import model.DAO.ItemCompraDAO;
import model.bo.ItemCompra;

public class ItemCompraService {
   public static void Incluir(ItemCompra objeto){
      ItemCompraDAO itemCompraDao = new ItemCompraDAO();
      itemCompraDao.Create(objeto);
   }
   
   public static List<ItemCompra> Listar(){
      ItemCompraDAO itemCompraDao = new ItemCompraDAO();
      return itemCompraDao.Retrieve();
   }
   
   public static ItemCompra Listar(int id){
      ItemCompraDAO itemCompraDao = new ItemCompraDAO();
      return itemCompraDao.Retrieve(id);
   }
   
   public static void Atualizar(ItemCompra objeto){
      ItemCompraDAO itemCompraDao = new ItemCompraDAO();
      itemCompraDao.Update(objeto);
   }
   
   public static void Excluir(ItemCompra objeto){
      ItemCompraDAO itemCompraDao = new ItemCompraDAO();
      itemCompraDao.Delete(objeto);
   }
}
