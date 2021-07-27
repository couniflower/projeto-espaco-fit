package model.DAO;

import java.util.List;
import model.bo.Bairro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BairroDAO implements InterfaceDAO<Bairro> {

   @Override
   public void Create(Bairro objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "insert into bairro (descricao) values (?)";
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
   public List<Bairro> Retrieve() {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "select id, descricao from bairro";
      PreparedStatement pstm = null;
      ResultSet rs = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         rs = pstm.executeQuery();
         List<Bairro> bairros = new ArrayList();
         
         while(rs.next()){
            Bairro bairro = new Bairro();
            bairro.setId(rs.getInt("id"));
            bairro.setDescricao(rs.getString("descricao"));
            bairros.add(bairro);
         }
         
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return bairros;
      }catch(Exception ex){
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return null;
      }
   }

   @Override
   public Bairro Retrieve(int id) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "select id, descricao from bairro where bairro.id = ?";
      PreparedStatement pstm = null;
      ResultSet rs = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, id);
         rs = pstm.executeQuery();
         Bairro bairro = new Bairro();
         
         while(rs.next()){
            bairro.setId(rs.getInt("id"));
            bairro.setDescricao(rs.getString("descricao"));
         }
         
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return bairro;
      }catch(Exception ex){
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return null;
      }
   }

   @Override
   public void Update(Bairro objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "update bairro set descricao = ? where id = ?";
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
   public void Delete(Bairro objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "delete from bairro where id = ?";
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
