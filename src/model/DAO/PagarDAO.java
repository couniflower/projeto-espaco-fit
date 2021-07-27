package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.bo.Pagar;

public class PagarDAO implements InterfaceDAO<Pagar> {

   @Override
   public void Create(Pagar objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "insert into pagar (idCompras, dataEmissao, dataVencimento, dataPagamento, valorEmitido, valorDesconto, valorAcrescimo, valorPago, statusPagar) values (?,?,?,?,?,?,?,?,?)";
      PreparedStatement pstm = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, objeto.getCompra().getId());
         if(objeto.getDtEmissao() == null){
            pstm.setString(2, null);
         }else{
            pstm.setString(2, objeto.getDtEmissao());
         }
         if(objeto.getDtVencimento() == null){
            pstm.setString(3, null);
         }else{
            pstm.setString(3, objeto.getDtVencimento());
         }
         if(objeto.getDtPagamento() == null){
            pstm.setString(4, null);
         }else{
            pstm.setString(4, objeto.getDtPagamento());
         }
         pstm.setFloat(5, objeto.getValorEmitido());
         pstm.setFloat(6, objeto.getValorDesconto());
         pstm.setFloat(7, objeto.getValorAcrescimo());
         pstm.setFloat(8, objeto.getValorPago());
         pstm.setInt(9, objeto.getStatus());
         pstm.executeUpdate();
      }catch(Exception ex){
         ex.printStackTrace();
      }
      
      ConnectionFactory.closeConnection(conexao, pstm);
   }

   @Override
   public List<Pagar> Retrieve() {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "select id, idCompras, dataEmissao, dataVencimento, dataPagamento, valorEmitido, valorDesconto, valorAcrescimo, valorPago, obs from pagar";
      PreparedStatement pstm = null;
      ResultSet rs = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         rs = pstm.executeQuery();
         List<Pagar> pagamentos = new ArrayList();
         
         while(rs.next()){
            Pagar pagar = new Pagar();
            pagar.setId(rs.getInt("id"));
            pagar.setDtEmissao(rs.getString("dataEmissao"));
            pagar.setDtVencimento(rs.getString("dataVencimento"));
            pagar.setDtPagamento(rs.getString("dataPagamento"));
            pagar.setValorEmitido(rs.getFloat("valorEmitido"));
            pagar.setValorDesconto(rs.getFloat("valorDesconto"));
            pagar.setValorAcrescimo(rs.getFloat("valorAcrescimo"));
            pagar.setValorPago(rs.getFloat("valorPago"));
            pagar.setStatus(rs.getInt("statusPagar"));
            
            pagar.setCompra(service.CompraService.Listar(rs.getInt("idCompras")));
            
            pagamentos.add(pagar);
         }
         
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return pagamentos;
      }catch(Exception ex){
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return null;
      }
   }

   @Override
   public Pagar Retrieve(int id) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "select id, idCompras, dataEmissao, dataVencimento, dataPagamento, valorEmitido, valorDesconto, valorAcrescimo, valorPago, statusPagar from pagar where pagar.id = ?";
      PreparedStatement pstm = null;
      ResultSet rs = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, id);
         rs = pstm.executeQuery();
         Pagar pagar = new Pagar();
         
         while(rs.next()){
            pagar.setId(rs.getInt("id"));
            pagar.setDtEmissao(rs.getString("dataEmissao"));
            pagar.setDtVencimento(rs.getString("dataVencimento"));
            pagar.setDtPagamento(rs.getString("dataPagamento"));
            pagar.setValorEmitido(rs.getFloat("valorEmitido"));
            pagar.setValorDesconto(rs.getFloat("valorDesconto"));
            pagar.setValorAcrescimo(rs.getFloat("valorAcrescimo"));
            pagar.setValorPago(rs.getFloat("valorPago"));
            pagar.setStatus(rs.getInt("statusPagar"));
            
            pagar.setCompra(service.CompraService.Listar(rs.getInt("idCompras")));
         }
         
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return pagar;
      }catch(Exception ex){
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return null;
      }
   }

   @Override
   public void Update(Pagar objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "update pagar set idCompras = ?, dataEmissao = ?, dataVencimento = ?, dataPagamento = ?, valorEmitido = ?, valorDesconto = ?, valorAcrescimo = ?, valorPago = ?, statusPagar = ? where id = ?";
      PreparedStatement pstm = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, objeto.getCompra().getId());
         if(objeto.getDtEmissao() == null){
            pstm.setString(2, null);
         }else{
            pstm.setString(2, objeto.getDtEmissao());
         }
         if(objeto.getDtVencimento() == null){
            pstm.setString(3, null);
         }else{
            pstm.setString(3, objeto.getDtVencimento());
         }
         if(objeto.getDtPagamento() == null){
            pstm.setString(4, null);
         }else{
            pstm.setString(4, objeto.getDtPagamento());
         }
         pstm.setFloat(5, objeto.getValorEmitido());
         pstm.setFloat(6, objeto.getValorDesconto());
         pstm.setFloat(7, objeto.getValorAcrescimo());
         pstm.setFloat(8, objeto.getValorPago());
         pstm.setInt(9, objeto.getStatus());
         pstm.setInt(10, objeto.getId());
         pstm.executeUpdate();
      }catch(Exception ex){
         ex.printStackTrace();
      }
      
      ConnectionFactory.closeConnection(conexao, pstm);
   }

   @Override
   public void Delete(Pagar objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "delete from pagar where id = ?";
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
