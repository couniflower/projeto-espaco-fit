package service;

import java.util.List;
import model.DAO.AlunoDAO;
import model.bo.Aluno;

public class AlunoService {
   public static void Incluir(Aluno objeto){
      AlunoDAO alunoDao = new AlunoDAO();
      alunoDao.Create(objeto);
   }
   
   public static List<Aluno> Listar(){
      AlunoDAO alunoDao = new AlunoDAO();
      return alunoDao.Retrieve();
   }
   
   public static Aluno Listar(int id){
      AlunoDAO alunoDao = new AlunoDAO();
      return alunoDao.Retrieve(id);
   }
   
   public static void Atualizar(Aluno objeto){
      AlunoDAO alunoDao = new AlunoDAO();
      alunoDao.Update(objeto);
   }
   
   public static void Excluir(Aluno objeto){
      AlunoDAO alunoDao = new AlunoDAO();
      alunoDao.Delete(objeto);
   }
}
