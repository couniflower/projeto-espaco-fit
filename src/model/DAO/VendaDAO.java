package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.bo.Venda;

public class VendaDAO implements InterfaceDAO<Venda> {

   @Override
   public void Create(Venda objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "insert into vendas (idPersonal, idAluno, identificacao, dataVenda, valorTotal, obs) values (?,?,?,?,?,?)";
      PreparedStatement pstm = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, objeto.getPersonal().getId());
         pstm.setInt(2, objeto.getAluno().getId());
         pstm.setString(3, objeto.getIdentificacao());
         pstm.setString(4, objeto.getData());
         pstm.setFloat(5, objeto.getValorTotal());
         pstm.setString(6, objeto.getObs());
         pstm.executeUpdate();
      }catch(Exception ex){
         ex.printStackTrace();
      }
      
      ConnectionFactory.closeConnection(conexao, pstm);
   }

   @Override
   public List<Venda> Retrieve() {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "select id, idPersonal, idAluno, identificacao, dataVenda, valorTotal, obs from vendas";
      PreparedStatement pstm = null;
      ResultSet rs = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         rs = pstm.executeQuery();
         List<Venda> vendas = new ArrayList();
         
         while(rs.next()){
            Venda venda = new Venda();
            venda.setId(rs.getInt("id"));
            venda.setIdentificacao(rs.getString("identificacao"));
            venda.setData(rs.getString("dataVenda"));
            venda.setValorTotal(rs.getFloat("valorTotal"));
            venda.setObs(rs.getString("obs"));
            
            venda.setPersonal(service.PersonalService.Listar(rs.getInt("idPersonal")));
            
            venda.setAluno(service.AlunoService.Listar(rs.getInt("idAluno")));
            
            vendas.add(venda);
         }
         
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return vendas;
      }catch(Exception ex){
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return null;
      }
   }

   @Override
   public Venda Retrieve(int id) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "select id, idPersonal, idAluno, identificacao, dataVenda, valorTotal, obs from vendas where vendas.id = ?";
      PreparedStatement pstm = null;
      ResultSet rs = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, id);
         rs = pstm.executeQuery();
         Venda venda = new Venda();
         
         while(rs.next()){
            venda.setId(rs.getInt("id"));
            venda.setIdentificacao(rs.getString("identificacao"));
            venda.setData(rs.getString("dataVenda"));
            venda.setValorTotal(rs.getFloat("valorTotal"));
            venda.setObs(rs.getString("obs"));
            
            venda.setPersonal(service.PersonalService.Listar(rs.getInt("idPersonal")));
            
            venda.setAluno(service.AlunoService.Listar(rs.getInt("idAluno")));
         }
         
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return venda;
      }catch(Exception ex){
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return null;
      }
   }

   @Override
   public void Update(Venda objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "update vendas set idPersonal = ?, idAluno = ?, identificacao = ?, dataVenda = ?, valorTotal = ?, obs = ? where id = ?";
      PreparedStatement pstm = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, objeto.getPersonal().getId());
         pstm.setInt(2, objeto.getAluno().getId());
         pstm.setString(3, objeto.getIdentificacao());
         pstm.setString(4, objeto.getData());
         pstm.setFloat(5, objeto.getValorTotal());
         pstm.setString(6, objeto.getObs());
         pstm.setInt(7, objeto.getId());
         pstm.executeUpdate();
      }catch(Exception ex){
         ex.printStackTrace();
      }
      
      ConnectionFactory.closeConnection(conexao, pstm);
   }

   @Override
   public void Delete(Venda objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "delete from vendas where id = ?";
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
