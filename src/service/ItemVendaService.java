package service;

import java.util.List;
import model.DAO.ItemVendaDAO;
import model.bo.ItemVenda;

public class ItemVendaService {
   public static void Incluir(ItemVenda objeto){
      ItemVendaDAO itemVendaDao = new ItemVendaDAO();
      itemVendaDao.Create(objeto);
   }
   
   public static List<ItemVenda> Listar(){
      ItemVendaDAO itemVendaDao = new ItemVendaDAO();
      return itemVendaDao.Retrieve();
   }
   
   public static ItemVenda Listar(int id){
      ItemVendaDAO itemVendaDao = new ItemVendaDAO();
      return itemVendaDao.Retrieve(id);
   }
   
   public static void Atualizar(ItemVenda objeto){
      ItemVendaDAO itemVendaDao = new ItemVendaDAO();
      itemVendaDao.Update(objeto);
   }
   
   public static void Excluir(ItemVenda objeto){
      ItemVendaDAO itemVendaDao = new ItemVendaDAO();
      itemVendaDao.Delete(objeto);
   }
}
