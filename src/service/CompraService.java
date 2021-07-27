package service;

import java.util.List;
import model.DAO.CompraDAO;
import model.bo.Compra;

public class CompraService {
   public static void Incluir(Compra objeto){
      CompraDAO compraDao = new CompraDAO();
      compraDao.Create(objeto);
   }
   
   public static List<Compra> Listar(){
      CompraDAO compraDao = new CompraDAO();
      return compraDao.Retrieve();
   }
   
   public static Compra Listar(int id){
      CompraDAO compraDao = new CompraDAO();
      return compraDao.Retrieve(id);
   }
   
   public static void Atualizar(Compra objeto){
      CompraDAO compraDao = new CompraDAO();
      compraDao.Update(objeto);
   }
   
   public static void Excluir(Compra objeto){
      CompraDAO compraDao = new CompraDAO();
      compraDao.Delete(objeto);
   }
}
