package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.bo.Fornecedor;

public class FornecedorDAO implements InterfaceDAO<Fornecedor> {

   @Override
   public void Create(Fornecedor objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "insert into fornecedor (idCep, nome, razaoSocial, cnpj, inscEstadual, complementoEndereco, fone1, fone2, email, obs) values (?,?,?,?,?,?,?,?,?,?)";
      PreparedStatement pstm = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, objeto.getCep().getId());
         pstm.setString(2, objeto.getNome());
         pstm.setString(3, objeto.getRazaoSocial());
         pstm.setString(4, objeto.getCnpj());
         pstm.setString(5, objeto.getInscEstadual());
         pstm.setString(6, objeto.getCompleEndereco());
         pstm.setString(7, objeto.getFone1());
         pstm.setString(8, objeto.getFone2());
         pstm.setString(9, objeto.getEmail());
         pstm.setString(10, objeto.getObs());
         pstm.executeUpdate();
      }catch(Exception ex){
         ex.printStackTrace();
      }
      
      ConnectionFactory.closeConnection(conexao, pstm);
   }

   @Override
   public List<Fornecedor> Retrieve() {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "select id, idCep, nome, razaoSocial, cnpj, inscEstadual, complementoEndereco, fone1, fone2, email, obs from fornecedor";
      PreparedStatement pstm = null;
      ResultSet rs = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         rs = pstm.executeQuery();
         List<Fornecedor> fornecedores = new ArrayList();
         
         while(rs.next()){
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId(rs.getInt("id"));
            fornecedor.setNome(rs.getString("nome"));
            fornecedor.setRazaoSocial(rs.getString("razaoSocial"));
            fornecedor.setCnpj(rs.getString("cnpj"));
            fornecedor.setInscEstadual(rs.getString("inscEstadual"));
            fornecedor.setCompleEndereco(rs.getString("complementoEndereco"));
            fornecedor.setFone1(rs.getString("fone1"));
            fornecedor.setFone2(rs.getString("fone2"));
            fornecedor.setEmail(rs.getString("email"));
            fornecedor.setObs(rs.getString("obs"));
            
            fornecedor.setCep(service.CepService.Listar(rs.getInt("idCep")));
            
            fornecedores.add(fornecedor);
         }
         
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return fornecedores;
      }catch(Exception ex){
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return null;
      }
   }

   @Override
   public Fornecedor Retrieve(int id) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "select id, idCep, nome, razaoSocial, cnpj, inscEstadual, complementoEndereco, fone1, fone2, email, obs from fornecedor where fornecedor.id = ?";
      PreparedStatement pstm = null;
      ResultSet rs = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, id);
         rs = pstm.executeQuery();
         Fornecedor fornecedor = new Fornecedor();
         
         while(rs.next()){
            fornecedor.setId(rs.getInt("id"));
            fornecedor.setNome(rs.getString("nome"));
            fornecedor.setRazaoSocial(rs.getString("razaoSocial"));
            fornecedor.setCnpj(rs.getString("cnpj"));
            
            fornecedor.setInscEstadual(rs.getString("inscEstadual"));
            fornecedor.setCompleEndereco(rs.getString("complementoEndereco"));
            fornecedor.setFone1(rs.getString("fone1"));
            fornecedor.setFone2(rs.getString("fone2"));
            fornecedor.setEmail(rs.getString("email"));
            fornecedor.setObs(rs.getString("obs"));
            
            fornecedor.setCep(service.CepService.Listar(rs.getInt("idCep")));
         }
         
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return fornecedor;
      }catch(Exception ex){
         ConnectionFactory.closeConnection(conexao, pstm, rs);
         return null;
      }
   }

   @Override
   public void Update(Fornecedor objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "update fornecedor set idCep = ?, nome = ?, razaoSocial = ?, cnpj = ?, inscEstadual = ?, complementoEndereco = ?, fone1 = ?, fone2 = ?, email = ?, obs = ? where id = ?";
      PreparedStatement pstm = null;
      
      try{
         pstm = conexao.prepareStatement(sqlExecutar);
         pstm.setInt(1, objeto.getCep().getId());
         pstm.setString(2, objeto.getNome());
         pstm.setString(3, objeto.getRazaoSocial());
         pstm.setString(4, objeto.getCnpj());
         pstm.setString(5, objeto.getInscEstadual());
         pstm.setString(6, objeto.getCompleEndereco());
         pstm.setString(7, objeto.getFone1());
         pstm.setString(8, objeto.getFone2());
         pstm.setString(9, objeto.getEmail());
         pstm.setString(10, objeto.getObs());
         pstm.setInt(11, objeto.getId());
         pstm.executeUpdate();
      }catch(Exception ex){
         ex.printStackTrace();
      }
      
      ConnectionFactory.closeConnection(conexao, pstm);
   }

   @Override
   public void Delete(Fornecedor objeto) {
      Connection conexao = ConnectionFactory.getConnection();
      String sqlExecutar = "delete from fornecedor where id = ?";
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
