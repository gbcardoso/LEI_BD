/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectobd;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *fra
 *
 * @author g_per
 */
public class ProjectoBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ParseException {
        // TODO code application logic here
        Scanner inputstr = new Scanner(System.in);
        Connection conn=connect();
        
        String query = "SELECT * FROM utilizador";
        String menu2=null;
        System.out.println("BEM-VINDO\n\n1-Criar conta\n2-Login");
        menu2=inputstr.nextLine();
        switch(menu2){
            case "1":
                
                
                String nome, password;
        int  status;
       
       
        System.out.printf("\nNome do utilizador: ");
        nome = inputstr.nextLine();
        System.out.printf("\nPassword do utilizador: ");
        password = inputstr.nextLine();
        
       
        
       
         Do(conn,"INSERT into utilizador(user,password,type,status) VALUES ('"+nome+"','"+password+"','"+1+"','"
                +0+ "')");
        System.out.println("\nUTILIZADOR CRIADO!\n");
                
            case "2":
                
                 Utilizador user=null;
                 user=login(conn, query);
                 if(user!=null){
                     System.out.println("Bem-vindo "+user.getUser()+"!");
                      Do(conn,"UPDATE utilizador SET status=1 WHERE user='"+user.getUser()+"'");
                       getNotification(conn,user);
                       //admnistrador
                        if (user.getType() == 0) {
                            menuAdmin(conn,user);
                            return;
                        } //user normal
                        else if(user.getType()==1){
                            menuUser(conn,user);
                            return;
               
                        }
                        if(user.getType()==2){
                        System.out.println("\nUSER BANIDO!!!");
                        return;
                        }
                     }
                
             break;
            default:
                System.out.println("\nOpção inválida\n");
                
        }
        
        
        
        
        
        
        
       Utilizador user=null;
               user=login(conn, query);
        if(user!=null){
            System.out.println("Bem-vindo "+user.getUser()+"!");
            Do(conn,"UPDATE utilizador SET status=1 WHERE user='"+user.getUser()+"'");
            getNotification(conn,user);
            //admnistrador
            if (user.getType() == 0) {
                menuAdmin(conn,user);
            } //user normal
            else {
                menuUser(conn,user);
               
            }
        }
    }
    public static void menuUser(Connection conn, Utilizador user ) throws SQLException, ParseException{
    String menu = "1";
    Scanner inputstr = new Scanner(System.in);
    
            while (menu != "0") {
                System.out.println("1-Criar user");
                System.out.println("2-Listar user");
                System.out.println("3-Criar leilao");
                System.out.println("4-Listar leilões");
                System.out.println("5-Pesquisar leilão por id");
                System.out.println("6-Consultar detalhes de leilão");
                System.out.println("7-Listar leilões em que um user tenha actividade");
                System.out.println("8-Efectuar licitação");
                
                System.out.println("9-Escrever mensagem no mural de um leilão");
               
                
                
                
                System.out.println("0-Sair");
                System.out.printf("\nOpção: ");
                menu = inputstr.nextLine();
                switch (menu) {
                    case"0":
                         Do(conn,"UPDATE utilizador SET status=0 WHERE user='"+user.getUser()+"'");
                         conn.close();
                        return;
                        
                        
                    case "1":
                        criaUser(conn);
                        break;
                    case "2":
                        listUsers(conn);
                    break;
                    case "3":
                            criaLeilao(conn,user);
                        break;
                    case "4":
                        listarLeilao(conn);
                        break;
                    case "5":
                        pesquisaLeilaoIDProduto(conn);
                        break;
                    case "6":
                        consultarDetalhes(conn);
                        break;
                    case "7":
                        
                       leiloesDoUser( conn,  user);
                       
                        break;
                    case "8":
                        licitar(conn, user);
                        break;
                   
                    case "9":
                        fazerMensagem( conn, user);
                        break;
                   
                        
              
                        
                    default:
                        System.out.println("\nOpção inválida\n");
                }
                
                }
        
            }
    
    
    
    
    
    
    
    
    
    public static void menuAdmin(Connection conn, Utilizador user ) throws SQLException, ParseException{
    String menu = "1";
    Scanner inputstr = new Scanner(System.in);
    
            while (menu != "0") {
                System.out.println("1-Criar user");
                System.out.println("2-Listar user");
                System.out.println("3-Criar leilao");
                System.out.println("4-Listar leilões");
                System.out.println("5-Pesquisar leilão por id");
                System.out.println("6-Consultar detalhes de leilão");
                System.out.println("7-Listar leilões em que um user tenha actividade");
                System.out.println("8-Efectuar licitação");
                System.out.println("9-Editar propriedades de um leilão");
                System.out.println("10-Escrever mensagem no mural de um leilão");
               
                System.out.println("11-Cancelar leilão");
                System.out.println("12-Banir user");
                System.out.println("13-Obter estatísticas");
                System.out.println("0-Sair");
                System.out.printf("\nOpção: ");
                menu = inputstr.nextLine();
                switch (menu) {
                    case"0":
                         Do(conn,"UPDATE utilizador SET status=0 WHERE user='"+user.getUser()+"'");
                         conn.close();
                        return;
                        
                        
                    case "1":
                        criaUser(conn);
                        break;
                    case "2":
                        listUsers(conn);
                    break;
                    case "3":
                            criaLeilao(conn,user);
                        break;
                    case "4":
                        listarLeilao(conn);
                        break;
                    case "5":
                        pesquisaLeilaoIDProduto(conn);
                        break;
                    case "6":
                        consultarDetalhes(conn);
                        break;
                    case "7":
                        
                       leiloesDoUser( conn,  user);
                       
                        break;
                    case "8":
                        licitar(conn, user);
                        break;
                    case "9":
                        //editaLeilao( conn);
                        break;
                    case "10":
                        fazerMensagem( conn, user);
                        break;
                    case "11":
                        cancelaLeilao( conn);
                        break;
                    case "12":
                        banirUtilizador(conn);
                        break;
                    case "13":
                        getTop10(conn);
                        break;
                        
              
                        
                    default:
                        System.out.println("\nOpção inválida\n");
                }
                
                }
        
            }
    
    
            
           
    public static void listUsers(Connection conn) throws SQLException{
        System.out.println("\nUtilizadores Normais:\n\n");
        String nome;
        int status;
        
        ResultSet rs=DoQuery(conn,"SELECT * from utilizador where type=1");
         while(rs.next()){
             nome=rs.getString("user");
             status=rs.getInt("status");
             if(status==1){
             System.out.print("\t|"+nome+"|\t|ONLINE|\n");
             }else {
                System.out.print("\t|"+nome+"|\t|OFFLINE|\n");
             }
             
             
         }
         
        
        
    }
    public static Connection connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/tabelasdb";
            String username = "root";
            String password = "password";
            Connection conn = DriverManager.getConnection(url,username,password);
            System.out.println("\nConeção feita");
            
         return conn;   
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
          
        }
        return null;
    }
    public static ResultSet DoQuery(Connection conn,String query) throws SQLException{
         Statement st=null;
        try {
            st = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            ResultSet rs = null;
        try {
            conn.setAutoCommit(false);
            rs = st.executeQuery(query);
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException ex) {
            Logger.getLogger(ProjectoBD.class.getName()).log(Level.SEVERE, null, ex);
            conn.rollback();
            conn.setAutoCommit(true);
        }
            return rs;
    }
    
    public static void Do(Connection conn,String query){
         Statement st=null;
        try {
            st = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
            
         
        try {
             st.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(ProjectoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public static Utilizador login(Connection conn, String query) throws SQLException{
        String nome, password;
        Utilizador user=null;
        Scanner inputstr = new Scanner(System.in);
        System.out.printf("\nNome: ");
        nome=inputstr.nextLine();
        System.out.printf("\nPassword: ");
        password=inputstr.nextLine();
        ResultSet rs = DoQuery(conn,"SELECT* FROM utilizador");
        while ( rs.next() ) {
            if((nome == null ? rs.getString("user") == null : nome.equals(rs.getString("user"))) && (password == null ? rs.getString("password") == null : password.equals(rs.getString("password"))) ){
                System.out.println("UTILIZADOR ENCONTRADO");
                
                user=new Utilizador(rs.getString("user"),rs.getString("password"),rs.getInt("type"),rs.getInt("status"));
                System.out.print(user.getType());
                
                return user;
                
            }
            
            
        }
       return null;
        
    }
    
    public static void menuAdmin() {

    }

    public static void menuUser() {

    }

    public static void criaUser(Connection conn) {
        String nome, password;
        int tipo, status;
        Scanner inputstr = new Scanner(System.in);
        Scanner inputint = new Scanner(System.in);
        System.out.printf("\nNome do utilizador: ");
        nome = inputstr.nextLine();
        System.out.printf("\nPassword do utilizador: ");
        password = inputstr.nextLine();
        System.out.printf("\nTipo do utilizador: ");
        tipo = inputint.nextInt();
        System.out.printf("\nStatus do utilizador: ");
        status = inputint.nextInt();
       
         Do(conn,"INSERT into utilizador(user,password,type,status) VALUES ('"+nome+"','"+password+"','"+tipo+"','"
                +status+ "')");
        System.out.println("\nUTILIZADOR CRIADO!\n");
    }

    public static void criaLeilao(Connection conn, Utilizador user) throws ParseException{
        int id, id_produto;
        double preco;
        String titulo, descricao, detalhes, data_criacao1, deadline1;
        Date data_criacao, deadline;
        Scanner inputstr = new Scanner(System.in);
        Scanner inputint = new Scanner(System.in);
        
        System.out.printf("\nID de produto do leilão: ");
        id_produto = inputint.nextInt();
        
        
        java.sql.Timestamp data2;
      
        System.out.printf("\nPreço do leilao: ");
        preco = inputint.nextDouble();
        System.out.printf("\nData de fim do leilão (aaaa-mm-dd hh:mm:ss): ");
        deadline1 = inputstr.nextLine();
        data2=dateTreat(deadline1);
        
        System.out.printf("\nTitulo do leilao: ");
        titulo = inputstr.nextLine();
        System.out.printf("\nDescrição do leilão: ");
        descricao = inputstr.nextLine();
        System.out.printf("\nDetalhes do leilão: ");
       detalhes = inputstr.nextLine();
       
        
          Do(conn,"INSERT leilao(user,id_produto,preco,deadline,titulo,descricao,detalhes) VALUES ('"+user.getUser()+"','"+id_produto+"','"+preco+"','"
                +data2+ "','"+titulo+"','"+descricao+"','"+detalhes+"')");
        System.out.println("Leilao criado com sucesso");
        
        
        
       
    }

    public static void listarLeilao(Connection conn) throws SQLException{
        System.out.println("\nLISTA DE LEILÕES:\n\n");
        String nome,deadline,titulo,valorin,preco;
        int id,id_produto;
        
        ResultSet rs=DoQuery(conn,"select user,id,id_produto,data_criacao, valorin,preco, deadline, titulo, descricao, detalhes from leilao where deadline>data_criacao");
         while(rs.next()){
             nome=rs.getString("user");
             id=rs.getInt("id");
             id_produto=rs.getInt("id_produto");
             preco=rs.getString("preco");
             valorin=rs.getString("valorin");
             
             deadline=rs.getString("deadline");
             titulo=rs.getString("titulo");
             
             if(valorin==null){
             System.out.print("\n\t\tID Leilao: "+id+"\t\tID Produto: "+id_produto+"\t\tTitulo: "+titulo+"\t\tPreco: "+preco+"\t\tDeadline: "+deadline+"\t\tComprador: "+nome);
             }else{
                 System.out.print("\n\t\tID Leilao: "+id+"\t\tID Produto: "+id_produto+"\t\tTitulo: "+titulo+"\t\tPreco: "+valorin+"\t\tDeadline: "+deadline+"\t\tComprador: "+nome);
             }
             
            
             
             
         }
         System.out.println("\n\n");
        
    }
    public static void editaLeilao(Connection conn, Leilao leilao) throws ParseException {
        String str;
        int num;
        double preco;
        java.sql.Timestamp data;
        Scanner inputstr = new Scanner(System.in);
        Scanner inputint = new Scanner(System.in);
        String menu = "1";
        while (menu != "0") {
            System.out.println("1-ID do leilão");
            System.out.println("2-Preço do leilão");
            System.out.println("3-Data de fim do leilão");
            System.out.println("4-Titulo do leilão");
            System.out.println("5-Descricao do leilão");
            System.out.println("6-Detalhes do leilão");
            System.out.println("0-Sair");
            System.out.printf("\nOpção: ");
            menu = inputstr.nextLine();
            switch (menu) {
                case "1":
                    System.out.printf("\nID actual do leilão: " + leilao.getID() + "\nNovo ID do leilão: ");
                    num = inputint.nextInt();
                    Do(conn,"update leilao set id='"+num+"' where id='"+leilao.getID()+"'");
                    break;
                case "2":
                    System.out.printf("\nPreço actual do leilão: " + leilao.getPreco() + "\nNovo preço do leilão: ");
                    preco=inputint.nextDouble();
                    Do(conn,"update leilao set preco='"+preco+"' where id='"+leilao.getID()+"'");
                    break;
                case "3":
                    System.out.printf("\nData de fim actual do leilão (dd/mm/aaaa-hh:mm): " + leilao.getDeadline() + "\nNova data de fim do leilão (dd/mm/aaaa-hh:mm): ");
                    str = inputstr.nextLine();
                    data = dateTreat(str);
                    Do(conn,"update leilao set deadline='"+data+"' where id='"+leilao.getID()+"'");
                    break;
                case "4":
                    System.out.printf("\nTitulo actual do leilão: " + leilao.getTitulo() + "\nNovo titulo do leilão: ");
                    str = inputstr.nextLine();
                    Do(conn,"update leilao set titulo='"+str+"' where id='"+leilao.getID()+"'");
                    break;
                case "5":
                    System.out.printf("\nDescrição actual do leilão: " + leilao.getDescricao() + "\nNova descrição do leilão: ");
                    str = inputstr.nextLine();
                    Do(conn,"update leilao set deascricao='"+str+"' where id='"+leilao.getID()+"'");
                    break;
                case "6":
                    System.out.printf("\nDetalhes actuais do leilão: " + leilao.getDetalhes() + "\nNovos detalhes do leilão: ");
                    str = inputstr.nextLine();
                    Do(conn,"update leilao set detalhes='"+str+"' where id='"+leilao.getID()+"'");
                    break;
                case "0":
                    return;
                default:
                    System.out.printf("Opção incorrecta");
                    break;
            }
        }
    }
    
    public static void criaUtilizador(Connection conn){
        
    }
    
    
    public static java.sql.Timestamp dateTreat(String date) throws ParseException{
        
                String stringcomData = date;
                System.out.println(stringcomData+"\n\n\n\n");
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                java.sql.Timestamp data;
               
                    data = new java.sql.Timestamp(df.parse(stringcomData).getTime());
                    
                   
                     return data;
        
        
        
        
    }




////////////////////////////////

public static void pesquisaLeilaoIDProduto(Connection conn) throws SQLException{
       String nome,deadline,titulo,valorin,preco;
        int id,id_produto,num;
        
       
        Scanner inputint = new Scanner(System.in);
        System.out.println("\nID de produto do leilão que deseja pesquisar: ");
        num = inputint.nextInt();
        System.out.println("\nLISTA DE LEILÕES:\n\n");
        
        
        ResultSet rs=DoQuery(conn,"select user,id,id_produto,data_criacao, valorin,preco, deadline, titulo, descricao, detalhes from leilao where deadline>data_criacao and id_produto="+num);
         while(rs.next()){
             nome=rs.getString("user");
             id=rs.getInt("id");
             id_produto=rs.getInt("id_produto");
             preco=rs.getString("preco");
             valorin=rs.getString("valorin");
             
             deadline=rs.getString("deadline");
             titulo=rs.getString("titulo");
             
             if(valorin==null){
             System.out.print("\n\t\tID Leilao: "+id+"\t\tID Produto: "+id_produto+"\t\tTitulo: "+titulo+"\t\tPreco: "+preco+"\t\tDeadline: "+deadline+"\t\tComprador: "+nome);
             }else{
                 System.out.print("\n\t\tID Leilao: "+id+"\t\tID Produto: "+id_produto+"\t\tTitulo: "+titulo+"\t\tPreco: "+valorin+"\t\tDeadline: "+deadline+"\t\tComprador: "+nome);
             }
             
            
             
             
         }
         System.out.println("\n\n");
    

}
    public static void licitar(Connection conn, Utilizador user) throws SQLException{
        int num=0;
        float min=0, licitacao=0;
        ResultSet rs=null;
        Scanner inputint = new Scanner(System.in);
        System.out.printf("\nID do leilão em que quer licitar: ");
        num=inputint.nextInt();
        rs = DoQuery(conn, "select valorin from leilao where id="+num);
       rs.next();
        min=rs.getFloat("valorin");
       
        if (min==0){
            rs=DoQuery(conn, "select preco from leilao where id="+num);
            rs.next();
            min=rs.getFloat("preco");
        
            
        }
        System.out.printf("\nValor actual: "+min);
        System.out.printf("\nLicitação: ");
        licitacao=inputint.nextFloat();
        if(licitacao>=min){
            System.out.printf("\nNão é possivel realizar licitação, pois já existe uma menor.");
        }
        else{
            Do(conn, "update leilao set valorin="+licitacao+"where id="+num);
            Do(conn,"insert into licitacao(user,id,preco) values('"+user.getUser()+"',"+num+","+licitacao+")");
            System.out.println("\nLicitação efectuada com sucesso!");
        }
    }



public static void getNotification(Connection conn, Utilizador user) throws SQLException{
    	String conteudo;
    	int id;
        ResultSet rs = DoQuery(conn, "select * from notificacao where user = '"+user.getUser() +"'");
        if(rs== null){
        	System.out.println("Nao tem notificaçoes");
        	return;
        }
        System.out.println("###########NOTIFICAÇOES##########");
        while(rs.next()){
        	conteudo = rs.getString("conteudo");
        	id = rs.getInt("id");
        	System.out.println("Leilao:" +id+" "+conteudo+".");
        }
        Do(conn,"delete from notificacao where user = '"+user.getUser() +"'");
        System.out.println("\n##############################\n");
    }

public static void consultarDetalhes(Connection conn) throws SQLException{
     Scanner inputint = new Scanner(System.in);
    System.out.println("\nID de leilão que deseja pesquisar: ");
        int num = inputint.nextInt();
    System.out.println("\nLISTA DE LEILÕES:\n\n");
        String nome,deadline,titulo,valorin,preco;
        int id,id_produto;
        
        ResultSet rs=DoQuery(conn,"select detalhes from leilao where deadline>data_criacao and id="+num);
         while(rs.next()){
             nome=rs.getString("detalhes");
           
             System.out.println("\nDETALHES: "+nome);
             
            
             
             
         }
         System.out.println("\n\n");
}




public static void cancelaLeilao(Connection conn){
    	    	
    	int idleilao;
        Scanner inputstr = new Scanner(System.in);
        idleilao = inputstr.nextInt();
        Do(conn,"Update leilao set deadline = NOW() where id = '"+idleilao+"'");
        System.out.println("Leilao "+idleilao+"cancelado");
    }


public static void getTop10(Connection conn) throws SQLException{
        ResultSet rs = DoQuery(conn, "select user, count(*) 'n' from leilao group by(user) order by 'n'");
        String user;
        int n,i=0;
        if(rs == null){
        	System.out.println("Nao tem notificaçoes");
        	return;
        }
        System.out.println("TOP 10: Utilizadores com mais leiloes criados");
        try {
			while(rs.next() && i<10){
				i++;
				user = rs.getString("user");
				n = rs.getInt("n");
				System.out.println("Nº" +1+"user: " +user+ " criados: " +n);
			}
		} catch (SQLException e) {
			System.out.println("Erro: nao tem utilizadores com leiloes criados");
		}
    }



public static void leiloesDoUser(Connection conn, Utilizador user) throws SQLException{
        ResultSet rs = DoQuery(conn, "(select id from licitacao where user = '"+ user.getUser()+"')+ union (select id from mensagem where user = '" +user.getUser()+"')");
        String name;
        int id;
        if(rs == null){
        	System.out.println("Nao tem leiloes");
        	return;
        }
        System.out.println("Os seus leiloes:");
        try {
			while(rs.next()){
				id = rs.getInt("id");
				System.out.println("\t Leilao: " +id);
			}
		} catch (SQLException e) {
			System.out.println("Erro: nao tem licitaçoes/mensagens em leiloes");
		}
    }


public static void banirUtilizador(Connection conn){
    	Scanner sc = new Scanner(System.in);
    	String user = sc.nextLine();
    	System.out.println("Utilizador = " +user+ "vai ser banido");
        Do(conn, "Update utilizador set type = 2 where user='" +user+"'");
        Do(conn, "Update leilao set deadline = Now() where user ='"+user+"'");
        Do(conn, "Delete from licitacao where user = '" +user+"'");
    }
public static void fazerMensagem(Connection conn, Utilizador user){
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Leilao para enviar mensagem:");
    	int ileilao = sc.nextInt();
    	System.out.print("Mensagem:\t");
    	String conteudo = sc.nextLine();
    	Do(conn,"Insert into mensagem(user,id,conteudo) values('"+user.getUser()+"',"+ileilao+"," +conteudo+")");
    	System.out.println("Mensagem criada com sucesso");
    }
}