package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.bo.Compra;

public class CompraDAO implements InterfaceDAO<Compra> {

   @Override
   public void Create(Compra objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "insert into compras (idFornecedor, identificacao, dataCompra, valorTotal, obs) values (?,?,?,?,?)";
      PreparedStatement pstm = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, objeto.getFornecedor().getId());
         pstm.setString(2, objeto.getIdentificacao());
         pstm.setString(3, objeto.getData());
         pstm.setFloat(4, objeto.getValorTotal());
         pstm.setString(5, objeto.getObs());
         pstm.executeUpdate();
      }catch(Exception ex){
         ex.printStackTrace();
      }
      
      ConnectionFactory.closeConnection(conexao, pstm);
   }

   @Override
   public List<Compra> Retrieve() {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "select id, idFornecedor, identificacao, dataCompra, valorTotal, obs from compras";
      PreparedStatement pstm = null;
      ResultSet rs = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         rs = pstm.executeQuery();
         List<Compra> compras = new ArrayList();
         
         while(rs.next()){
            Compra compra = new Compra();
            compra.setId(rs.getInt("id"));
            compra.setIdentificacao(rs.getString("identificacao"));
            compra.setData(rs.getString("dataCompra"));
            compra.setValorTotal(rs.getFloat("valorTotal"));
            compra.setObs(rs.getString("obs"));
            
            compra.setFornecedor(service.FornecedorService.Listar(rs.getInt("idFornecedor")));
            
            compras.add(compra);
         }
         
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return compras;
      }catch(Exception ex){
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return null;
      }
   }

   @Override
   public Compra Retrieve(int id) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "select id, idFornecedor, identificacao, dataCompra, valorTotal, obs from compras where compras.id = ?";
      PreparedStatement pstm = null;
      ResultSet rs = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, id);
         rs = pstm.executeQuery();
         Compra compra = new Compra();
         
         while(rs.next()){
            compra.setId(rs.getInt("id"));
            compra.setIdentificacao(rs.getString("identificacao"));
            compra.setData(rs.getString("dataCompra"));
            compra.setValorTotal(rs.getFloat("valorTotal"));
            compra.setObs(rs.getString("obs"));
            
            compra.setFornecedor(service.FornecedorService.Listar(rs.getInt("idFornecedor")));
         }
         
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return compra;
      }catch(Exception ex){
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return null;
      }
   }

   @Override
   public void Update(Compra objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "update compras set idFornecedor = ?, identificacao = ?, dataCompra = ?, valorTotal = ?, obs = ? where id = ?";
      PreparedStatement pstm = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, objeto.getFornecedor().getId());
         pstm.setString(2, objeto.getIdentificacao());
         pstm.setString(3, objeto.getData());
         pstm.setFloat(4, objeto.getValorTotal());
         pstm.setString(5, objeto.getObs());
         pstm.setInt(6, objeto.getId());
         pstm.executeUpdate();
      }catch(Exception ex){
         ex.printStackTrace();
      }
      
      ConnectionFactory.closeConnection(conexao, pstm);
   }

   @Override
   public void Delete(Compra objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "delete from compras where id = ?";
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
