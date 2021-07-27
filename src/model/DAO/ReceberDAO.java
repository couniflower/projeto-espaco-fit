package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.bo.Receber;

public class ReceberDAO implements InterfaceDAO<Receber> {

   @Override
   public void Create(Receber objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "insert into receber (idVendas, dataEmissao, dataVencimento, dataPagamento, valorEmitido, valorDesconto, valorAcrescimo, valorPago) values (?,?,?,?,?,?,?,?)";
      PreparedStatement pstm = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, objeto.getVenda().getId());
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
         pstm.executeUpdate();
      }catch(Exception ex){
         ex.printStackTrace();
      }
      
      ConnectionFactory.closeConnection(conexao, pstm);
   }

   @Override
   public List<Receber> Retrieve() {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "select id, idVendas, dataEmissao, dataVencimento, dataPagamento, valorEmitido, valorDesconto, valorAcrescimo, valorPago from receber";
      PreparedStatement pstm = null;
      ResultSet rs = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         rs = pstm.executeQuery();
         List<Receber> recebimentos = new ArrayList();
         
         while(rs.next()){
            Receber receber = new Receber();
            receber.setId(rs.getInt("id"));
            receber.setDtEmissao(rs.getString("dataEmissao"));
            receber.setDtVencimento(rs.getString("dataVencimento"));
            receber.setDtPagamento(rs.getString("dataPagamento"));
            receber.setValorEmitido(rs.getFloat("valorEmitido"));
            receber.setValorDesconto(rs.getFloat("valorDesconto"));
            receber.setValorAcrescimo(rs.getFloat("valorAcrescimo"));
            receber.setValorPago(rs.getFloat("valorPago"));
            
            receber.setVenda(service.VendaService.Listar(rs.getInt("idVendas")));
            
            recebimentos.add(receber);
         }
         
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return recebimentos;
      }catch(Exception ex){
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return null;
      }
   }

   @Override
   public Receber Retrieve(int id) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "select id, idVendas, dataEmissao, dataVencimento, dataPagamento, valorEmitido, valorDesconto, valorAcrescimo, valorPago from receber where receber.id = ?";
      PreparedStatement pstm = null;
      ResultSet rs = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, id);
         rs = pstm.executeQuery();
         Receber receber = new Receber();
         
         while(rs.next()){
            receber.setId(rs.getInt("id"));
            receber.setDtEmissao(rs.getString("dataEmissao"));
            receber.setDtVencimento(rs.getString("dataVencimento"));
            receber.setDtPagamento(rs.getString("dataPagamento"));
            receber.setValorEmitido(rs.getFloat("valorEmitido"));
            receber.setValorDesconto(rs.getFloat("valorDesconto"));
            receber.setValorAcrescimo(rs.getFloat("valorAcrescimo"));
            receber.setValorPago(rs.getFloat("valorPago"));
            
            receber.setVenda(service.VendaService.Listar(rs.getInt("idVendas")));
         }
         
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return receber;
      }catch(Exception ex){
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return null;
      }
   }

   @Override
   public void Update(Receber objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "update receber set idVendas = ?, dataEmissao = ?, dataVencimento = ?, dataPagamento = ?, valorEmitido = ?, valorDesconto = ?, valorAcrescimo = ?, valorPago = ? where id = ?";
      PreparedStatement pstm = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, objeto.getVenda().getId());
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
         pstm.setInt(9, objeto.getId());
         pstm.executeUpdate();
      }catch(Exception ex){
         ex.printStackTrace();
      }
      
      ConnectionFactory.closeConnection(conexao, pstm);
   }

   @Override
   public void Delete(Receber objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "delete from receber where id = ?";
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
