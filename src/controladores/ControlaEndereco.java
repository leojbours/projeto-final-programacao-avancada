/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import modelos.DAO.EnderecoDAO;
import modelos.Endereco;

import java.sql.SQLException;

/**
 *
 * @author leonardo
 */
public class ControlaEndereco {

    EnderecoDAO enderecoDAO = new EnderecoDAO();

    private static ControlaEndereco instance;

    public static ControlaEndereco getInstance() {
        if (instance == null) {
            instance = new ControlaEndereco();
        }
        return instance;
    }

    public boolean salvar(Endereco endereco) {

        try {
            enderecoDAO.salvar(endereco);
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao salvar endereco: " + e.getMessage());
            return false;
        }

    }

    public Endereco recuperarEndereco(Endereco endereco) {
        Endereco enderecoRecuperado = null;

        try {
            enderecoRecuperado = enderecoDAO.recuperarEndereco(endereco);
            return enderecoRecuperado;
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar endereço: " + e.getMessage());
            return enderecoRecuperado;
        }

    }
    
}
