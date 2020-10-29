package Database;

import java.sql.*;

public class Database {
    //ESTA CLASSE POSSUI A CONFIGURACAO DE ACESSO AO BANCO DE DADOS
    public static String servidor,nomeBanco,usuario,senha;
    public static int porta;
    public static Connection conexao = null;
    
    static{
        servidor = "localhost";
        nomeBanco = "urna";
        usuario = "root";
        senha = "";
        porta = 3306;
    }
    
      public static void abreConexao() throws SQLException, ClassNotFoundException{
        String url = "jdbc:mysql://" + servidor + ":" + porta + "/" + nomeBanco;
        //Carrega o Driver
        Class.forName("com.mysql.jdbc.Driver");
        conexao = DriverManager.getConnection(url,usuario,senha);
    }
    
     public static void fecharConexao() throws SQLException{
        conexao.close();
    }
}
