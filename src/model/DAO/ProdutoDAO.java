package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.bo.Produto;

public class ProdutoDAO implements InterfaceDAO<Produto> {

   @Override
   public void Create(Produto objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "insert into produto (descricao, unidadeCompra, unidadeVenda, correlacaoUnidade, valor, quantidadeEstoque, codigoBarra, obs) values (?,?,?,?,?,?,?,?)";
      PreparedStatement pstm = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setString(1, objeto.getDescricao());
         pstm.setInt(2, objeto.getUnidCompra());
         pstm.setInt(3, objeto.getUnidVenda());
         pstm.setFloat(4, objeto.getCorrelacao());
         pstm.setFloat(5, objeto.getValor());
         pstm.setInt(6, objeto.getQtdEstoque());
         pstm.setString(7, objeto.getCodigoBarra());
         pstm.setString(8, objeto.getObs());
         pstm.executeUpdate();
      }catch(Exception ex){
         ex.printStackTrace();
      }
      
      ConnectionFactory.closeConnection(conexao, pstm);
   }

   @Override
   public List<Produto> Retrieve() {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "select id, descricao, unidadeCompra, unidadeVenda, correlacaoUnidade, valor, quantidadeEstoque, codigoBarra, obs from produto";
      PreparedStatement pstm = null;
      ResultSet rs = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         rs = pstm.executeQuery();
         List<Produto> produtos = new ArrayList();
         
         while(rs.next()){
            Produto produto = new Produto();
            produto.setId(rs.getInt("id"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setUnidCompra(rs.getInt("unidadeCompra"));
            produto.setUnidVenda(rs.getInt("unidadeVenda"));
            produto.setCorrelacao(rs.getInt("correlacaoUnidade"));
            produto.setValor(rs.getFloat("valor"));
            produto.setQtdEstoque(rs.getInt("quantidadeEstoque"));
            produto.setCodigoBarra(rs.getString("codigoBarra"));
            produto.setObs(rs.getString("obs"));
            
            produtos.add(produto);
         }
         
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return produtos;
      }catch(Exception ex){
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return null;
      }
   }

   @Override
   public Produto Retrieve(int id) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "select id, descricao, unidadeCompra, unidadeVenda, correlacaoUnidade, valor, quantidadeEstoque, codigoBarra, obs from produto where produto.id = ?";
      PreparedStatement pstm = null;
      ResultSet rs = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, id);
         rs = pstm.executeQuery();
         Produto produto = new Produto();
         
         while(rs.next()){
            produto.setId(rs.getInt("id"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setUnidCompra(rs.getInt("unidadeCompra"));
            produto.setUnidVenda(rs.getInt("unidadeVenda"));
            produto.setCorrelacao(rs.getInt("correlacaoUnidade"));
            produto.setValor(rs.getFloat("valor"));
            produto.setQtdEstoque(rs.getInt("quantidadeEstoque"));
            produto.setCodigoBarra(rs.getString("codigoBarra"));
            produto.setObs(rs.getString("obs"));
         }
         
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return produto;
      }catch(Exception ex){
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return null;
      }
   }

   @Override
   public void Update(Produto objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "update produto set descricao = ?, unidadeCompra = ?, unidadeVenda = ?, correlacaoUnidade = ?, valor = ?, quantidadeEstoque = ?, codigoBarra = ?, obs = ? where id = ?";
      PreparedStatement pstm = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setString(1, objeto.getDescricao());
         pstm.setInt(2, objeto.getUnidCompra());
         pstm.setInt(3, objeto.getUnidVenda());
         pstm.setFloat(4, objeto.getCorrelacao());
         pstm.setFloat(5, objeto.getValor());
         pstm.setInt(6, objeto.getQtdEstoque());
         pstm.setString(7, objeto.getCodigoBarra());
         pstm.setString(8, objeto.getObs());
         pstm.setInt(9, objeto.getId());
         pstm.executeUpdate();
      }catch(Exception ex){
         ex.printStackTrace();
      }
      
      ConnectionFactory.closeConnection(conexao, pstm);
   }

   @Override
   public void Delete(Produto objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "delete from produto where id = ?";
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
