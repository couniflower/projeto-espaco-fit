package service;

import java.util.List;
import model.DAO.PagarDAO;
import model.bo.Pagar;

public class PagarService {
   public static void Incluir(Pagar objeto){
      PagarDAO pagarDao = new PagarDAO();
      pagarDao.Create(objeto);
   }
   
   public static List<Pagar> Listar(){
      PagarDAO pagarDao = new PagarDAO();
      return pagarDao.Retrieve();
   }
   
   public static Pagar Listar(int id){
      PagarDAO pagarDao = new PagarDAO();
      return pagarDao.Retrieve(id);
   }
   
   public static void Atualizar(Pagar objeto){
      PagarDAO pagarDao = new PagarDAO();
      pagarDao.Update(objeto);
   }
   
   public static void Excluir(Pagar objeto){
      PagarDAO pagarDao = new PagarDAO();
      pagarDao.Delete(objeto);
   }
}
