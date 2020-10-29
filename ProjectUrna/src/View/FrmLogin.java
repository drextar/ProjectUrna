/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Client;
import Controller.UrnaPublisher;
import Model.Administrador;
import Model.Eleitor;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author matheus
 */
public class FrmLogin extends javax.swing.JFrame {
    private Client client;
    private Eleitor eleitor;
    private Administrador administrador;
    private FrmUrna u;
    private FrmApuracao a;

    /**
     * Creates new form FrmLogin
     */
    public FrmLogin() {
        initComponents();
        preparaFormulario();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnAcessarUrna = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbPerfil = new javax.swing.JComboBox<>();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Area Login ELEITOR");

        btnAcessarUrna.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        btnAcessarUrna.setText("Acessar Urna");
        btnAcessarUrna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcessarUrnaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel1.setText("Urna de Votação Eletrônica");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setText("Título de Eleitor");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setText("CPF");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setText("Perfil");

        cmbPerfil.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cmbPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ELEITOR", "ADMINISTRADOR" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnAcessarUrna, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSenha, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbPerfil, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAcessarUrna, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcessarUrnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcessarUrnaActionPerformed
        //valida o perfil
        if(validaCampos())
            return;
        String perfil = validarPerfil();
        
        
        if (perfil.equals(""))
            JOptionPane.showMessageDialog(rootPane, "Preencha o perfil");
        else if (perfil.equals("ELEITOR"))
            validaEleitor();
        else if(perfil.equals("ADMINISTRADOR"))
            validaAdministrador();
        else
            JOptionPane.showMessageDialog(rootPane, "Tipo de perfil inexistente");
        limparCamposLogin();
    }//GEN-LAST:event_btnAcessarUrnaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcessarUrna;
    private javax.swing.JComboBox<String> cmbPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
public String validarPerfil(){
    switch(cmbPerfil.getSelectedItem().toString()){
        case "ELEITOR":
            return "ELEITOR";
        case "ADMINISTRADOR":
            return "ADMINISTRADOR";
        default:
            return "";
    }
}

public void preparaFormulario(){
    client = new Client();
    eleitor = new Eleitor();
    administrador = new Administrador();

    limparCamposLogin();
}

public void validaEleitor(){
    eleitor.setCpf(txtSenha.getText());
    eleitor.setTituloEleitor(txtLogin.getText());
    
        try {
            if (client.verificaELeitor(eleitor)){
                //JOptionPane.showMessageDialog(rootPane, "Eleitor existente!!!");
                abrirUrna();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Eleitor inválido ou já exerceu seu voto!!!");
                limparCamposLogin();
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro Class not found: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Erro SQL: " + ex.getMessage());
        }
}

public void validaAdministrador(){
    administrador.setLogin(txtLogin.getText());
    administrador.setSenha(txtSenha.getText());
    
        try {
            if (client.verificaAdministrador(administrador))
                abrirApuracao();
            else {
                JOptionPane.showMessageDialog(rootPane, "Administrador Inválido");
                limparCamposLogin();
            }   } catch (SQLException ex) {
            System.out.println("Erro Class not found: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro SQL: " + ex.getMessage());
        }
        
}

public void abrirApuracao(){
    if (a == null)
        a = new FrmApuracao();
    a.setVisible(true);
}

public void abrirUrna(){
    u = null;
    if (u == null)
        u = new FrmUrna();
    u.setVisible(true);
}

public boolean validaCampos(){
    if (txtLogin.getText().equals("") || txtSenha.getText().equals("")) {
        JOptionPane.showMessageDialog(rootPane, "Preencha os campos corretamente");
        return true;
    }
    
    return false;
}

public void limparCamposLogin(){
    txtLogin.setText("");
    txtSenha.setText("");
    cmbPerfil.setSelectedIndex(0);
    txtLogin.requestFocus();
}

public void bloquearLogin(){
    btnAcessarUrna.setEnabled(false);
}

}