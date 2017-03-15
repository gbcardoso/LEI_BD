/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectobd;

import java.sql.Date;

/**
 *
 * @author g_per
 */
public class Leilao {
    protected int id, id_produto;
    protected double preco;
    protected String titulo, descricao, detalhes;
    protected Date data_criacao, deadline;
    
    public void setID(int id){
        this.id=id;
    }
    
    public int getID(){
        return id;
    }
    
    public void setIDProduto(int id_produto){
        this.id_produto=id_produto;
    }
    
    public int getIDProduto(){
        return id_produto;
    }
    
    public void setDataCriacao(Date data_criacao){
        this.data_criacao=data_criacao;
    }
    
    public Date getDataCriacao(){
        return data_criacao;
    }
    
    public void setPreco(double preco){
        this.preco=preco;
    }
    
    public double getPreco(){
        return preco;
    }
    
    public void setDeadline(Date deadline){
        this.deadline=deadline;
    }
    
    public Date getDeadline(){
        return deadline;
    }
    
    public void setTitulo(String titulo){
        this.titulo=titulo;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public void setDescricao(String descricao){
        this.descricao=descricao;
    }
    
    public String getDescricao(){
        return descricao;
    }
    
    public void setDetalhes(String detalhes){
        this.descricao=descricao;
    }
    
    public String getDetalhes(){
        return detalhes;
    }
    Leilao(int id, int id_produto, Date data_criacao, double preco, Date deadline, String titulo, String descricao, String detalhes){
        this.id=id;
        this.id_produto=id_produto;
        this.data_criacao=data_criacao;
        this.preco=preco;
        this.deadline=deadline;
        this.titulo=titulo;
        this.descricao=descricao;
        this.detalhes=detalhes;
    }
}
