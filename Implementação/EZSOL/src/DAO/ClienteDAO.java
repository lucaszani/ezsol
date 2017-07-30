/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.ConnectionBD;
import Javabeans.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Alison
 */
public class ClienteDAO {
    
    private final Connection conecta;
    
    //construtor
    
    public ClienteDAO(){
        this.conecta = ConnectionBD.Conectar();
    }
    
    //Metodo Cadastrar Cliente
    
    public void CadastrarCliente(Cliente obj){
        PreparedStatement stmt = null;
        
        try {
            stmt = conecta.prepareStatement("INSERT INTO cliente (nome, cpf, telefone, endereco, celular, sexo, bairro, cidade, uf, cep) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCpf());
            stmt.setString(3, obj.getTelefone());
            stmt.setString(4, obj.getEndereco());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getSexo());
            stmt.setString(7, obj.getBairro());
            stmt.setString(8, obj.getCidade());
            stmt.setString(9, obj.getUf());
            stmt.setString(10, obj.getCep());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
        } 
            catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "ERRO " + erro);
            }
            finally{
                ConnectionBD.CloseConnection(conecta, stmt);
            }
    }
    
    //Listar Clientes
    
    public List<Cliente> ListaCliente(){
        try {
            List<Cliente> lista = new ArrayList<Cliente>();
            PreparedStatement stmt;
            stmt = conecta.prepareStatement("SELECT * FROM cliente");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Cliente v = new Cliente();
                v.setNome(rs.getString("nome"));
                v.setCpf(rs.getString("cpf"));
                v.setTelefone(rs.getString("telefone"));
                v.setCelular(rs.getString("celular"));
                v.setEndereco(rs.getString("endereco"));
                v.setBairro(rs.getString("bairro"));
                v.setCidade(rs.getString("cidade"));
                v.setUf(rs.getString("uf"));
                v.setCep(rs.getString("cep"));
                
                lista.add(v);
            }
            return lista;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO " + erro);
        }
        return null;
    }
    
    public void DeleteCliente(String CPF){
        PreparedStatement stmt = null;
        
        try {
            stmt = conecta.prepareStatement("DELETE FROM cliente WHERE cpf = ?");
            stmt.setString(1, CPF);
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
        } 
            catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "ERRO " + erro);
            }
            finally{
                ConnectionBD.CloseConnection(conecta, stmt);
            }
    }
}
