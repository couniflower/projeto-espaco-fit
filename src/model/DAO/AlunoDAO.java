package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.bo.Aluno;

public class AlunoDAO implements InterfaceDAO<Aluno> {

   @Override
   public void Create(Aluno objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "insert into aluno (idCep, nome, rg, cpf, dataNasc, complementoEndereco, fone1, fone2, email, obs) values (?,?,?,?,?,?,?,?,?,?)";
      PreparedStatement pstm = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, objeto.getCep().getId());
         pstm.setString(2, objeto.getNome());
         pstm.setString(3, objeto.getRg());
         pstm.setString(4, objeto.getCpf());
         if(objeto.getDtNasc() == "não especificado"){
            pstm.setString(5, null);
         }else{
            pstm.setString(5, objeto.getDtNasc());
         }
         pstm.setString(6, objeto.getCompleEndereco());
         pstm.setString(7, objeto.getFone1());
         pstm.setString(8, objeto.getFone2());
         pstm.setString(9, objeto.getEmail());
         pstm.setString(10, objeto.getObs());
         pstm.executeUpdate();
      }catch(Exception ex){
         ex.printStackTrace();
      }
      
      ConnectionFactory.closeConnection(conexao, pstm);
   }

   @Override
   public List<Aluno> Retrieve() {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "select id, idCep, nome, rg, cpf, dataNasc, complementoEndereco, fone1, fone2, email, obs from aluno";
      PreparedStatement pstm = null;
      ResultSet rs = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         rs = pstm.executeQuery();
         List<Aluno> alunos = new ArrayList();
         
         while(rs.next()){
            Aluno aluno = new Aluno();
            aluno.setId(rs.getInt("id"));
            aluno.setNome(rs.getString("nome"));
            aluno.setRg(rs.getString("rg"));
            aluno.setCpf(rs.getString("cpf"));
            aluno.setDtNasc(rs.getString("dataNasc"));
            aluno.setCompleEndereco(rs.getString("complementoEndereco"));
            aluno.setFone1(rs.getString("fone1"));
            aluno.setFone2(rs.getString("fone2"));
            aluno.setEmail(rs.getString("email"));
            aluno.setObs(rs.getString("obs"));
            
            aluno.setCep(service.CepService.Listar(rs.getInt("idCep")));
            
            alunos.add(aluno);
         }
         
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return alunos;
      }catch(Exception ex){
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return null;
      }
   }

   @Override
   public Aluno Retrieve(int id) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "select id, idCep, nome, rg, cpf, dataNasc, complementoEndereco, fone1, fone2, email, obs from aluno where aluno.id = ?";
      PreparedStatement pstm = null;
      ResultSet rs = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, id);
         rs = pstm.executeQuery();
         Aluno aluno = new Aluno();
         
         while(rs.next()){
            aluno.setId(rs.getInt("id"));
            aluno.setNome(rs.getString("nome"));
            aluno.setRg(rs.getString("rg"));
            aluno.setCpf(rs.getString("cpf"));
            aluno.setDtNasc(rs.getString("dataNasc"));
            aluno.setCompleEndereco(rs.getString("complementoEndereco"));
            aluno.setFone1(rs.getString("fone1"));
            aluno.setFone2(rs.getString("fone2"));
            aluno.setEmail(rs.getString("email"));
            aluno.setObs(rs.getString("obs"));
            
            aluno.setCep(service.CepService.Listar(rs.getInt("idCep")));
         }
         
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return aluno;
      }catch(Exception ex){
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return null;
      }
   }

   @Override
   public void Update(Aluno objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "update aluno set idCep = ?, nome = ?, rg = ?, cpf = ?, dataNasc = ?, complementoEndereco = ?, fone1 = ?, fone2 = ?, email = ?, obs = ? where id = ?";
      PreparedStatement pstm = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, objeto.getCep().getId());
         pstm.setString(2, objeto.getNome());
         pstm.setString(3, objeto.getRg());
         pstm.setString(4, objeto.getCpf());
         if(objeto.getDtNasc() == "não especificado"){
            pstm.setString(5, null);
         }else{
            pstm.setString(5, objeto.getDtNasc());
         }
         pstm.setString(6, objeto.getCompleEndereco());
         pstm.setString(7, objeto.getFone1());
         pstm.setString(8, objeto.getFone2());
         pstm.setString(9, objeto.getEmail());
         pstm.setString(10, objeto.getObs());
         pstm.setInt(11, objeto.getId());
         pstm.executeUpdate();
      }catch(Exception ex){
         ex.printStackTrace();
      }
      
      ConnectionFactory.closeConnection(conexao, pstm);
   }

   @Override
   public void Delete(Aluno objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "delete from aluno where id = ?";
      PreparedStatement pstm = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, objeto.getId());
         pstm.executeUpdate();
      }catch(Exception ex){
         ex.printStackTrace();
      }
      
      ConnectionFactory.closeConnection(conexao, pstm);
   }

}
