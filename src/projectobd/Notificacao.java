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
public class Notificacao {
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
    
    Notificacao(String user, int id, String conteudo){
        this.user=user;
        this.id=id;
        this.conteudo=conteudo;
    }
}
