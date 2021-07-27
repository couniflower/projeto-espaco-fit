package service;

import java.util.List;
import model.DAO.CidadeDAO;
import model.bo.Cidade;

public class CidadeService {
   public static void Incluir(Cidade objeto){
      CidadeDAO cidadeDao = new CidadeDAO();
      cidadeDao.Create(objeto);
   }
   
   public static List<Cidade> Listar(){
      CidadeDAO cidadeDao = new CidadeDAO();
      return cidadeDao.Retrieve();
   }
   
   public static Cidade Listar(int id){
      CidadeDAO cidadeDao = new CidadeDAO();
      return cidadeDao.Retrieve(id);
   }
   
   public static void Atualizar(Cidade objeto){
      CidadeDAO cidadeDao = new CidadeDAO();
      cidadeDao.Update(objeto);
   }
   
   public static void Excluir(Cidade objeto){
      CidadeDAO cidadeDao = new CidadeDAO();
      cidadeDao.Delete(objeto);
   }
}
