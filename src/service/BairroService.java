package service;

import java.util.List;
import model.DAO.BairroDAO;
import model.bo.Bairro;

public class BairroService {
   public static void Incluir(Bairro objeto){
      BairroDAO bairroDao = new BairroDAO();
      bairroDao.Create(objeto);
   }
   
   public static List<Bairro> Listar(){
      BairroDAO bairroDao = new BairroDAO();
      return bairroDao.Retrieve();
   }
   
   public static Bairro Listar(int id){
      BairroDAO bairroDao = new BairroDAO();
      return bairroDao.Retrieve(id);
   }
   
   public static void Atualizar(Bairro objeto){
      BairroDAO bairroDao = new BairroDAO();
      bairroDao.Update(objeto);
   }
   
   public static void Excluir(Bairro objeto){
      BairroDAO bairroDao = new BairroDAO();
      bairroDao.Delete(objeto);
   }
}
