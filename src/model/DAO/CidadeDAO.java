package model.DAO;

import java.util.List;
import model.bo.Cidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CidadeDAO implements InterfaceDAO<Cidade> {

   @Override
   public void Create(Cidade objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "insert into cidade (descricao) values (?)";
      PreparedStatement pstm = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setString(1, objeto.getDescricao());
         pstm.executeUpdate();
      }catch(Exception ex){
         ex.printStackTrace();
      }
      
      ConnectionFactory.closeConnection(conexao, pstm);
   }

   @Override
   public List<Cidade> Retrieve() {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "select id, descricao from cidade";
      PreparedStatement pstm = null;
      ResultSet rs = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         rs = pstm.executeQuery();
         List<Cidade> cidades = new ArrayList();
         
         while(rs.next()){
            Cidade cidade = new Cidade();
            cidade.setId(rs.getInt("id"));
            cidade.setDescricao(rs.getString("descricao"));
            cidades.add(cidade);
         }
         
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return cidades;
      }catch(Exception ex){
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return null;
      }
   }

   @Override
   public Cidade Retrieve(int id) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "select id, descricao from cidade where cidade.id = ?";
      PreparedStatement pstm = null;
      ResultSet rs = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, id);
         rs = pstm.executeQuery();
         Cidade cidade = new Cidade();
         
         while(rs.next()){
            cidade.setId(rs.getInt("id"));
            cidade.setDescricao(rs.getString("descricao"));
         }
         
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return cidade;
      }catch(Exception ex){
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return null;
      }
   }

   @Override
   public void Update(Cidade objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "update cidade set descricao = ? where id = ?";
      PreparedStatement pstm = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setString(1, objeto.getDescricao());
         pstm.setInt(2, objeto.getId());
         pstm.executeUpdate();
      }catch(Exception ex){
         ex.printStackTrace();
      }
      
      ConnectionFactory.closeConnection(conexao, pstm);
   }

   @Override
   public void Delete(Cidade objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "delete from cidade where id = ?";
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
