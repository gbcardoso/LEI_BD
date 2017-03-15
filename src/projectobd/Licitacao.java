package projectobd;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author g_per
 */
public class Licitacao {
    protected String user;
    protected int id, preco;
    
    public void setUser(String user){
        this.user=user;
    }
    
    public String getUser(){
        return user;
    }
    
    public void setID(int id){
        this.id=id;
    }
    
    public int getID(){
        return id;
    }
    
    public void setPreco(int preco){
        this.preco=preco;
    }
    
    public int getPreco(){
        return preco;
    }
    
    Licitacao(String user, int id, int preco){
        this.user=user;
        this.id=id;
        this.preco=preco;
    }
}
