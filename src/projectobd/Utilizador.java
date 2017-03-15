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
public class Utilizador {
    protected String user, password;
    protected int type, status;
    
    public void setUser(String user){
        this.user=user;
    }
    
    public String getUser(){
        return user;
    }
    
    public void setPassword(String password){
        this.password=password;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setType(int type){
        this.type=type;
    }
    
    public int getType(){
        return type;
    }
    
    public void setStatus(int status){
        this.status=status;
    }
    
    public int getStatus(){
        return status;
    }
    
    Utilizador(String user, String password, int type, int status){
        this.user=user;
        this.password=password;
        this.type=type;
        this.status=status;
    }
}
