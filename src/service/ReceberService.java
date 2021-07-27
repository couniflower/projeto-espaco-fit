package service;

import java.util.List;
import model.DAO.ReceberDAO;
import model.bo.Receber;

public class ReceberService {
   public static void Incluir(Receber objeto){
      ReceberDAO receberDao = new ReceberDAO();
      receberDao.Create(objeto);
   }
   
   public static List<Receber> Listar(){
      ReceberDAO receberDao = new ReceberDAO();
      return receberDao.Retrieve();
   }
   
   public static Receber Listar(int id){
      ReceberDAO receberDao = new ReceberDAO();
      return receberDao.Retrieve(id);
   }
   
   public static void Atualizar(Receber objeto){
      ReceberDAO receberDao = new ReceberDAO();
      receberDao.Update(objeto);
   }
   
   public static void Excluir(Receber objeto){
      ReceberDAO receberDao = new ReceberDAO();
      receberDao.Delete(objeto);
   }
}
