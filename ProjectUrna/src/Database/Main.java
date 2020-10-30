/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author drextar
 */
public class Main {
    public static void main(String[] args) throws InstantiationException{
        //ESTA CLASSE APENAS VERIFICA A CONEXAO COM O BANCO DE DADOS
      try {
          try {
              //Testa conexão com o banco
              UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
          } catch (IllegalAccessException ex) {
              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
          } catch (UnsupportedLookAndFeelException ex) {
              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
          }
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
