package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.bo.ItemVenda;

public class ItemVendaDAO implements InterfaceDAO<ItemVenda> {

   @Override
   public void Create(ItemVenda objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "insert into ItensVenda (idProduto, idVendas, quantidade, subtotal) values (?,?,?,?)";
      PreparedStatement pstm = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, objeto.getProduto().getId());
         pstm.setInt(2, objeto.getVenda().getId());
         pstm.setInt(3, objeto.getQuantidade());
         pstm.setFloat(4, objeto.getSubtotal());
         pstm.executeUpdate();
      }catch(Exception ex){
         ex.printStackTrace();
      }
      
      ConnectionFactory.closeConnection(conexao, pstm);
   }

   @Override
   public List<ItemVenda> Retrieve() {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "select id, idProduto, idVendas, quantidade, subtotal from itensVenda";
      PreparedStatement pstm = null;
      ResultSet rs = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         rs = pstm.executeQuery();
         List<ItemVenda> itens = new ArrayList();
         
         while(rs.next()){
            ItemVenda item = new ItemVenda();
            item.setId(rs.getInt("id"));
            item.setQuantidade(rs.getInt("quantidade"));
            item.setSubtotal(rs.getFloat("subtotal"));
            
            item.setProduto(service.ProdutoService.Listar(rs.getInt("idProduto")));
            item.setVenda(service.VendaService.Listar(rs.getInt("idVendas")));
            
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
   public ItemVenda Retrieve(int id) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "select id, idProduto, idVendas, quantidade, subtotal from itensVenda where itensVenda.id = ?";
      PreparedStatement pstm = null;
      ResultSet rs = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, id);
         rs = pstm.executeQuery();
         ItemVenda item = new ItemVenda();
         
         while(rs.next()){
            item.setId(rs.getInt("id"));
            item.setQuantidade(rs.getInt("quantidade"));
            item.setSubtotal(rs.getFloat("subtotal"));
            
            item.setProduto(service.ProdutoService.Listar(rs.getInt("idProduto")));
            item.setVenda(service.VendaService.Listar(rs.getInt("idVendas")));
            
         }
         
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return item;
      }catch(Exception ex){
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return null;
      }
   }

   @Override
   public void Update(ItemVenda objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "update itensVenda set idProduto = ?, idVendas = ?, quantidade = ?, subtotal = ? where id = ?";
      PreparedStatement pstm = null;
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, objeto.getProduto().getId());
         pstm.setInt(2, objeto.getVenda().getId());
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
   public void Delete(ItemVenda objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "delete from itensVenda where id = ?";
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
