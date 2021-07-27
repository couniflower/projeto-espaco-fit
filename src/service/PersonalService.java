package service;

import java.util.List;
import model.DAO.PersonalDAO;
import model.bo.Personal;

public class PersonalService {
   public static void Incluir(Personal objeto){
      PersonalDAO personalDao = new PersonalDAO();
      personalDao.Create(objeto);
   }
   
   public static List<Personal> Listar(){
      PersonalDAO personalDao = new PersonalDAO();
      return personalDao.Retrieve();
   }
   
   public static Personal Listar(int id){
      PersonalDAO personalDao = new PersonalDAO();
      return personalDao.Retrieve(id);
   }
   
   public static void Atualizar(Personal objeto){
      PersonalDAO personalDao = new PersonalDAO();
      personalDao.Update(objeto);
   }
   
   public static void Excluir(Personal objeto){
      PersonalDAO personalDao = new PersonalDAO();
      personalDao.Delete(objeto);
   }
}
