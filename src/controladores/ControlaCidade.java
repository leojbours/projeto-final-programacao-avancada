/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.util.ArrayList;
import modelos.Cidade;
import java.sql.SQLException;
import java.util.List;
import modelos.DAO.CidadeDAO;

/**
 *
 * @author leonardo.bourscheid
 */
public class ControlaCidade {

    CidadeDAO cidadeDAO = new CidadeDAO();

    private static ControlaCidade instance;

    public static ControlaCidade getInstance() {
        if (instance == null) {
            instance = new ControlaCidade();
        }
        return instance;
    }

    public boolean salvar(Cidade cidade) {

        try {

            ArrayList<Cidade> cidades = recuperarTudo();

            boolean existe = false;
            
            for (Cidade c : cidades) {

                if ((cidade.getNomeCidade().toUpperCase().equals(c.getNomeCidade()) && cidade.getUf().toUpperCase().equals(c.getUf()))) {
                    cidade.setCodCidade(c.getCodCidade());
                    existe = true;
                    break;
                }

            }

            if (!existe) {
                cidadeDAO.salvar(cidade);
            }

            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao salvar no banco: ");
            e.printStackTrace();
            return false;
        }

    }

    public Cidade recuperarCidade(Integer codCidade) {
        Cidade cidade = null;

        try {
            cidade = cidadeDAO.recuperarCidade(codCidade);
            return cidade;
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar do banco: " + e.getMessage());
            return cidade;
        }

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
