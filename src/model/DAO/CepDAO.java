package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.bo.Cep;

public class CepDAO implements InterfaceDAO<Cep> {

   @Override
   public void Create(Cep objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "insert into cep (idCidade, idBairro, cep, logradouro, obs) values (?,?,?,?,?)";
      PreparedStatement pstm = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, objeto.getCidade().getId());
         pstm.setInt(2, objeto.getBairro().getId());
         pstm.setString(3, objeto.getCep());
         pstm.setString(4, objeto.getLogradouro());
         pstm.setString(5, objeto.getObs());
         pstm.executeUpdate();
      }catch(Exception ex){
         ex.printStackTrace();
      }
      
      ConnectionFactory.closeConnection(conexao, pstm);
   }

   @Override
   public List<Cep> Retrieve() {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "select id, idCidade, idBairro, cep, logradouro, obs from cep";
      PreparedStatement pstm = null;
      ResultSet rs = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         rs = pstm.executeQuery();
         List<Cep> ceps = new ArrayList();
         
         while(rs.next()){
            Cep cep = new Cep();
            cep.setId(rs.getInt("id"));
            cep.setLogradouro(rs.getString("logradouro"));
            cep.setObs(rs.getString("obs"));
            cep.setCep(rs.getString("cep"));
            
            cep.setBairro(service.BairroService.Listar(rs.getInt("idBairro")));
            cep.setCidade(service.CidadeService.Listar(rs.getInt("idCidade")));
            
            ceps.add(cep);
         }
         
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return ceps;
      }catch(Exception ex){
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return null;
      }
   }

   @Override
   public Cep Retrieve(int id) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "select id, idCidade, idBairro, cep, logradouro, obs from cep where cep.id = ?";
      PreparedStatement pstm = null;
      ResultSet rs = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, id);
         rs = pstm.executeQuery();
         Cep cep = new Cep();
         
         while(rs.next()){
            cep.setId(rs.getInt("id"));
            cep.setLogradouro(rs.getString("logradouro"));
            cep.setObs(rs.getString("obs"));
            cep.setCep(rs.getString("cep"));
            
            cep.setBairro(service.BairroService.Listar(rs.getInt("idBairro")));
            cep.setCidade(service.CidadeService.Listar(rs.getInt("idCidade")));
         }
         
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return cep;
      }catch(Exception ex){
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return null;
      }
   }

   @Override
   public void Update(Cep objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "update cep set idCidade = ?, idBairro = ?, cep = ?, logradouro = ?, obs = ? where id = ?";
      PreparedStatement pstm = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, objeto.getCidade().getId());
         pstm.setInt(2, objeto.getBairro().getId());
         pstm.setString(3, objeto.getCep());
         pstm.setString(4, objeto.getLogradouro());
         pstm.setString(5, objeto.getObs());
         pstm.setInt(6, objeto.getId());
         pstm.executeUpdate();
      }catch(Exception ex){
         ex.printStackTrace();
      }
      
      ConnectionFactory.closeConnection(conexao, pstm);
   }

   @Override
   public void Delete(Cep objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "delete from cep where id = ?";
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
