/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import apoio.ConexaoBD;
import javax.swing.JOptionPane;
import telas.TelaPrincipal;

/**
 *
 * @author leonardo
 */
public class Main {

    public static void main(String[] args) {
        try {
            ConexaoBD.getInstance().getConnection();
            TelaPrincipal telaPrincipal = new TelaPrincipal();
            telaPrincipal.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de conexão com o banco de dados");
        } finally {
            ConexaoBD.getInstance().shutdown();
        }

    }
}
