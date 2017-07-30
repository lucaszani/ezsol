/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBC.ConnectionBD;
import Javabeans.OrdemServico;
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
public class OrdemServicoDAO {
    private Connection conecta;
    
    //construtor
    
    public OrdemServicoDAO(){
        this.conecta = ConnectionBD.Conectar();
    }
    
    //Metodo Cadastrar Tecnico
    
    public void CadastrarOrdem(OrdemServico obj){
        PreparedStatement stmt = null;
        
        try {
            stmt = conecta.prepareStatement("INSERT INTO ordem_servico (nome_cliente, nome_tecnico, descricao_equipamento, relato_cliente, status_os, problema_identificado, relato_servico) VALUES (?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, obj.getNome_Cliente());
            stmt.setString(2, obj.getNome_Tecnico());
            stmt.setString(3, obj.getDescricaoEquipamento());
            stmt.setString(4, obj.getRelato_cliente());
            stmt.setString(5, obj.getStatus());
            stmt.setString(6, obj.getProblemaIdentificado());
            stmt.setString(7, obj.getRelatoServico());
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
    
    //Listar Tecnico
    
    public List<OrdemServico> ListaOrdemServico(){
        try {
            List<OrdemServico> lista = new ArrayList<OrdemServico>();
            PreparedStatement stmt;
            stmt = conecta.prepareStatement("SELECT * FROM ordem_servico");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                OrdemServico v = new OrdemServico();
                v.setNome_Cliente(rs.getString("nome_cliente"));
                v.setNome_Tecnico(rs.getString("nome_tecnico"));
                v.setDescricaoEquipamento(rs.getString("descricao_equipamento"));
                v.setRelato_cliente(rs.getString("relato_cliente"));
                v.setStatus(rs.getString("status_os"));
                v.setProblemaIdentificado(rs.getString("problema_identificado"));
                v.setRelatoServico(rs.getString("relato_servico"));
                v.setIdOrdem(rs.getInt("id_ordem"));
                
                lista.add(v);
            }
            return lista;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO " + erro);
        }
        return null;
    }
}

