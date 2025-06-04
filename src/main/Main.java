/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import apoio.ConexaoBD;
import javax.swing.JOptionPane;
import telas.TelaPrincipal;
import telas.TelaLogin;

/**
 *
 * @author leonardo
 */
public class Main {

    public static void main(String[] args) {
        try {
            //Faz conexao com o banco de dados
            ConexaoBD.getInstance().getConnection();
            //Inicia tela
            TelaLogin telaLogin = new TelaLogin();
            telaLogin.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão com o banco de dados");
        } finally {
            //Fecha conexao com banco de dados
            ConexaoBD.getInstance().shutdown();
        }

    }
}
