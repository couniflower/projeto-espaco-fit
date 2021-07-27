package service;

import java.util.List;
import model.DAO.VendaDAO;
import model.bo.Venda;

public class VendaService {
   public static void Incluir(Venda objeto){
      VendaDAO vendaDao = new VendaDAO();
      vendaDao.Create(objeto);
   }
   
   public static List<Venda> Listar(){
      VendaDAO vendaDao = new VendaDAO();
      return vendaDao.Retrieve();
   }
   
   public static Venda Listar(int id){
      VendaDAO vendaDao = new VendaDAO();
      return vendaDao.Retrieve(id);
   }
   
   public static void Atualizar(Venda objeto){
      VendaDAO vendaDao = new VendaDAO();
      vendaDao.Update(objeto);
   }
   
   public static void Excluir(Venda objeto){
      VendaDAO vendaDao = new VendaDAO();
      vendaDao.Delete(objeto);
   }
}
