/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.util.ArrayList;
import modelos.Cidade;
import java.sql.SQLException;
import modelos.DAO.CidadeDAO;

/**
 *
 * @author leonardo.bourscheid
 */
public class ControlaCidade {
    
    CidadeDAO cidadeDAO = new CidadeDAO();
    
    public Cidade recuperarCidade(Integer codCidade) {
        Cidade cidade = null;
        
        try{
           cidade = cidadeDAO.recuperarCidade(codCidade);
           return cidade;
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar do banco: " + e.getMessage());
        }
        
        return cidade;
    }
    
    public ArrayList<Cidade> recuperarTudo() {
        ArrayList<Cidade> cidades = null;
        
        try {
            cidades = cidadeDAO.recuperaTodos();
            return cidades;
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar do banco: " + e.getMessage());
        }
        
        return cidades;
    }
    
    //editar
    
    //deletar
}
