/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.SQLException;

/**
 *
 * @author drextar
 */
public class Main {
    public static void main(String[] args){
        //ESTA CLASSE APENAS VERIFICA A CONEXAO COM O BANCO DE DADOS
      try {
            //Testa conexão com o banco
            System.out.println("Abrindo a conexão...");
            Database.abreConexao();
            System.out.println("Conexão estabelecida...");
            System.out.println("Fechando conexão...");
            Database.fecharConexao();
        } catch (SQLException ex) {
            System.out.println("Erro SQL: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro Classe: " + ex.getMessage());
        }
    }
}
