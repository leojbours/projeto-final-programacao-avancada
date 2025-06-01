


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.DAO;

import apoio.ConexaoBD;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelos.Cidade;
import java.sql.SQLException;

/**
 *
 * @author leonardo.bourscheid
 */
public class CidadeDAO {

    ResultSet resultadoQ = null;

    public void salvar(Cidade cidade) throws SQLException {
        String sql = ""
                + "INSERT INTO CIDADE (nom_cidade, uf) values ('"
                + cidade.getNomeCidade().toUpperCase() + "', '" 
                + cidade.getUf().toUpperCase() + "')";
        
        ConexaoBD.executeUpdate(sql);
    }

    public Cidade recuperarCidade(String nome, String uf) throws SQLException {
        Cidade cidade = null;

        String sql = "SELECT * FROM cidade WHERE nom_cidade = '" + nome.toUpperCase() + "' AND uf = '" + uf.toUpperCase() + "'";

        resultadoQ = ConexaoBD.executeQuery(sql);

        if (resultadoQ.next()) {
            cidade = new Cidade(resultadoQ.getInt("cod_cidade"), resultadoQ.getString("nom_cidade"),
                    resultadoQ.getString("uf"));
        }

        return cidade;
    }

    public Cidade recuperarCidade(Integer codCidade) throws SQLException {
        Cidade cidade = null;

        String sql = ""
                + "SELECT * FROM cidade WHERE cod_cidade = " + codCidade;

        resultadoQ = ConexaoBD.executeQuery(sql);

       if (resultadoQ.next()) {
            cidade = new Cidade(resultadoQ.getInt("cod_cidade"), resultadoQ.getString("nom_cidade"),
                    resultadoQ.getString("uf"));
        }

        return cidade;
    }

    public ArrayList<Cidade> recuperaTodos() throws SQLException {
        ArrayList<Cidade> cidades = new ArrayList<>();

        String sql = ""
                + "SELECT * FROM cidade";

        resultadoQ = ConexaoBD.executeQuery(sql);

        while (resultadoQ.next()) {
            Cidade cidade = new Cidade(resultadoQ.getInt("cod_cidade"), resultadoQ.getString("nom_cidade"),
                    resultadoQ.getString("uf"));

            cidades.add(cidade);
        }

        return cidades;
    }

}
