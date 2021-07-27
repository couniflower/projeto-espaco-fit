package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.bo.ItemCompra;

public class ItemCompraDAO implements InterfaceDAO<ItemCompra> {

   @Override
   public void Create(ItemCompra objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "insert into ItensCompra (idProduto, idCompras, quantidade, subtotal) values (?,?,?,?)";
      PreparedStatement pstm = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, objeto.getProduto().getId());
         pstm.setInt(2, objeto.getCompra().getId());
         pstm.setInt(3, objeto.getQuantidade());
         pstm.setFloat(4, objeto.getSubtotal());
         pstm.executeUpdate();
      }catch(Exception ex){
         ex.printStackTrace();
      }
      
      ConnectionFactory.closeConnection(conexao, pstm);
   }

   @Override
   public List<ItemCompra> Retrieve() {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "select id, idProduto, idCompras, quantidade, subtotal from itensCompra";
      PreparedStatement pstm = null;
      ResultSet rs = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         rs = pstm.executeQuery();
         List<ItemCompra> itens = new ArrayList();
         
         while(rs.next()){
            ItemCompra item = new ItemCompra();
            item.setId(rs.getInt("id"));
            item.setQuantidade(rs.getInt("quantidade"));
            item.setSubtotal(rs.getFloat("subtotal"));
            
            item.setProduto(service.ProdutoService.Listar(rs.getInt("idProduto")));
            item.setCompra(service.CompraService.Listar(rs.getInt("idCompras")));
            
            itens.add(item);
         }
         
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return itens;
      }catch(Exception ex){
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return null;
      }
   }

   @Override
   public ItemCompra Retrieve(int id) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "select id, idProduto, idCompras, quantidade, subtotal from itensCompra where itensCompra.id = ?";
      PreparedStatement pstm = null;
      ResultSet rs = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, id);
         rs = pstm.executeQuery();
         ItemCompra item = new ItemCompra();
         
         while(rs.next()){
            item.setId(rs.getInt("id"));
            item.setQuantidade(rs.getInt("quantidade"));
            item.setSubtotal(rs.getFloat("subtotal"));
            
            item.setProduto(service.ProdutoService.Listar(rs.getInt("idProduto")));
            item.setCompra(service.CompraService.Listar(rs.getInt("idCompras")));
         }
         
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return item;
      }catch(Exception ex){
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return null;
      }
   }

   @Override
   public void Update(ItemCompra objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "update itensCompra set idProduto = ?, idCompras = ?, quantidade = ?, subtotal = ? where id = ?";
      PreparedStatement pstm = null;
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, objeto.getProduto().getId());
         pstm.setInt(2, objeto.getCompra().getId());
         pstm.setInt(3, objeto.getQuantidade());
         pstm.setFloat(4, objeto.getSubtotal());
         pstm.setInt(5, objeto.getId());
         pstm.executeUpdate();
      }catch(Exception ex){
         ex.printStackTrace();
      }
      
      ConnectionFactory.closeConnection(conexao, pstm);
   }

   @Override
   public void Delete(ItemCompra objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "delete from itensCompra where id = ?";
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
