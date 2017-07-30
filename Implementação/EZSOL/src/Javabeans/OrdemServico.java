/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Javabeans;

/**
 *
 * @author Alison
 */
public class OrdemServico {
    
    //atributos
    
    private int idOrdem;
    private String descricaoEquipamento;
    private String relato_cliente;
    private String status;
    private String problemaIdentificado;
    private String relatoServico;
    private String nome_Cliente;
    private String nome_Tecnico;
    
    //getters e setters

    /**
     * @return the idOrdem
     */
    public int getIdOrdem() {
        return idOrdem;
    }

    /**
     * @param idOrdem the idOrdem to set
     */
    public void setIdOrdem(int idOrdem) {
        this.idOrdem = idOrdem;
    }

    /**
     * @return the descricaoEquipamento
     */
    public String getDescricaoEquipamento() {
        return descricaoEquipamento;
    }

    /**
     * @param descricaoEquipamento the descricaoEquipamento to set
     */
    public void setDescricaoEquipamento(String descricaoEquipamento) {
        this.descricaoEquipamento = descricaoEquipamento;
    }

    /**
     * @return the relato_cliente
     */
    public String getRelato_cliente() {
        return relato_cliente;
    }

    /**
     * @param relato_cliente the relato_cliente to set
     */
    public void setRelato_cliente(String relato_cliente) {
        this.relato_cliente = relato_cliente;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the problemaIdentificado
     */
    public String getProblemaIdentificado() {
        return problemaIdentificado;
    }

    /**
     * @param problemaIdentificado the problemaIdentificado to set
     */
    public void setProblemaIdentificado(String problemaIdentificado) {
        this.problemaIdentificado = problemaIdentificado;
    }

    /**
     * @return the relatoServico
     */
    public String getRelatoServico() {
        return relatoServico;
    }

    /**
     * @param relatoServico the relatoServico to set
     */
    public void setRelatoServico(String relatoServico) {
        this.relatoServico = relatoServico;
    }

    /**
     * @return the nome_Cliente
     */
    public String getNome_Cliente() {
        return nome_Cliente;
    }

    /**
     * @param nome_Cliente the nome_Cliente to set
     */
    public void setNome_Cliente(String nome_Cliente) {
        this.nome_Cliente = nome_Cliente;
    }

    /**
     * @return the nome_Tecnico
     */
    public String getNome_Tecnico() {
        return nome_Tecnico;
    }

    /**
     * @param nome_Tecnico the nome_Tecnico to set
     */
    public void setNome_Tecnico(String nome_Tecnico) {
        this.nome_Tecnico = nome_Tecnico;
    }

    public void getIdOrdem(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
