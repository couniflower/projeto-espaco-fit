package service;

import java.util.List;
import model.DAO.FornecedorDAO;
import model.bo.Fornecedor;

public class FornecedorService {
   public static void Incluir(Fornecedor objeto){
      FornecedorDAO fornecedorDao = new FornecedorDAO();
      fornecedorDao.Create(objeto);
   }
   
   public static List<Fornecedor> Listar(){
      FornecedorDAO fornecedorDao = new FornecedorDAO();
      return fornecedorDao.Retrieve();
   }
   
   public static Fornecedor Listar(int id){
      FornecedorDAO fornecedorDao = new FornecedorDAO();
      return fornecedorDao.Retrieve(id);
   }
   
   public static void Atualizar(Fornecedor objeto){
      FornecedorDAO fornecedorDao = new FornecedorDAO();
      fornecedorDao.Update(objeto);
   }
   
   public static void Excluir(Fornecedor objeto){
      FornecedorDAO fornecedorDao = new FornecedorDAO();
      fornecedorDao.Delete(objeto);
   }
}
