package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.bo.Personal;

public class PersonalDAO implements InterfaceDAO<Personal> {

   @Override
   public void Create(Personal objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "insert into personal (idCep, nome, rg, cpf, dataNasc, complementoEndereco, fone1, fone2, email, obs) values (?,?,?,?,?,?,?,?,?,?)";
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
   public List<Personal> Retrieve() {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "select id, idCep, nome, rg, cpf, dataNasc, complementoEndereco, fone1, fone2, email, obs from personal";
      PreparedStatement pstm = null;
      ResultSet rs = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         rs = pstm.executeQuery();
         List<Personal> personais = new ArrayList();
         
         while(rs.next()){
            Personal personal = new Personal();
            personal.setId(rs.getInt("id"));
            personal.setNome(rs.getString("nome"));
            personal.setRg(rs.getString("rg"));
            personal.setCpf(rs.getString("cpf"));
            personal.setDtNasc(rs.getString("dataNasc"));
            personal.setCompleEndereco(rs.getString("complementoEndereco"));
            personal.setFone1(rs.getString("fone1"));
            personal.setFone2(rs.getString("fone2"));
            personal.setEmail(rs.getString("email"));
            personal.setObs(rs.getString("obs"));
            
            personal.setCep(service.CepService.Listar(rs.getInt("idCep")));
            
            personais.add(personal);
         }
         
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return personais;
      }catch(Exception ex){
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return null;
      }
   }

   @Override
   public Personal Retrieve(int id) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "select id, idCep, nome, rg, cpf, dataNasc, complementoEndereco, fone1, fone2, email, obs from personal where personal.id = ?";
      PreparedStatement pstm = null;
      ResultSet rs = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, id);
         rs = pstm.executeQuery();
         Personal personal = new Personal();
         
         while(rs.next()){
            personal.setId(rs.getInt("id"));
            personal.setNome(rs.getString("nome"));
            personal.setRg(rs.getString("rg"));
            personal.setCpf(rs.getString("cpf"));
            personal.setDtNasc(rs.getString("dataNasc"));
            personal.setCompleEndereco(rs.getString("complementoEndereco"));
            personal.setFone1(rs.getString("fone1"));
            personal.setFone2(rs.getString("fone2"));
            personal.setEmail(rs.getString("email"));
            personal.setObs(rs.getString("obs"));
            
            personal.setCep(service.CepService.Listar(rs.getInt("idCep")));
         }
         
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return personal;
      }catch(Exception ex){
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return null;
      }
   }

   @Override
   public void Update(Personal objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "update personal set idCep = ?, nome = ?, rg = ?, cpf = ?, dataNasc = ?, complementoEndereco = ?, fone1 = ?, fone2 = ?, email = ?, obs = ? where id = ?";
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
   public void Delete(Personal objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "delete from personal where id = ?";
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
