/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.util.ArrayList;

import modelos.DAO.EnderecoDAO;
import modelos.Pessoa;
import java.sql.SQLException;
import modelos.DAO.PessoaDAO;

/**
 *
 * @author leonardo.bourscheid
 */
public class ControlaPessoa {
    
    PessoaDAO pessoaDAO = new PessoaDAO();

    private static ControlaPessoa instace;

    public static ControlaPessoa getInstance() {
        if (instace == null) {
            instace = new ControlaPessoa();
        }
        return instace;
    }

    public boolean salvar(Pessoa pessoa) {
        try {
            pessoaDAO.salvar(pessoa);
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao salvar no banco: " + e.getMessage());
            return false;
        }
    }
    
    public Pessoa recuperarPessoa(int codPessoa) {
        Pessoa pessoa = null;
        
        try {
            pessoa = pessoaDAO.recuperarPessoa(codPessoa);
            return pessoa;
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar do banco: " + e.getMessage());
            return pessoa;
        }
    }
    
    public ArrayList<Pessoa> recuperarTudo() {
        ArrayList<Pessoa> pessoas = null;
        
        try {
            pessoas = pessoaDAO.recuperarTodos();
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar do banco: " + e.getMessage());
        }
        
        return pessoas;
    }

    public boolean editar(Pessoa pessoa) {
        try {
            pessoaDAO.editar(pessoa);
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao editar: " + e.getMessage());
            return false;
        }
    }
    
    public boolean deletar(Integer codPessoa) {
        try {
            pessoaDAO.deletar(codPessoa);
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
            return false;
        }
    }
    
}

