/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectobd;

/**
 *
 * @author g_per
 */
public class Mensagem {
    protected String user, conteudo;
    protected int id;
    
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
    
    public void setConteudo(String conteudo){
        this.conteudo=conteudo;
    }
    
    Mensagem(String user, int id, String conteudo){
        this.user=user;
        this.id=id;
        this.conteudo=conteudo;
    }
}
