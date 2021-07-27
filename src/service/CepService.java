package service;

import java.util.List;
import model.DAO.CepDAO;
import model.bo.Cep;

public class CepService {
   public static void Incluir(Cep objeto){
      CepDAO cepDao = new CepDAO();
      cepDao.Create(objeto);
   }
   
   public static List<Cep> Listar(){
      CepDAO cepDao = new CepDAO();
      return cepDao.Retrieve();
   }
   
   public static Cep Listar(int id){
      CepDAO cepDao = new CepDAO();
      return cepDao.Retrieve(id);
   }
   
   public static void Atualizar(Cep objeto){
      CepDAO cepDao = new CepDAO();
      cepDao.Update(objeto);
   }
   
   public static void Excluir(Cep objeto){
      CepDAO cepDao = new CepDAO();
      cepDao.Delete(objeto);
   }
}
