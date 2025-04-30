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

    public Cidade recuperarCidade(Integer codCidade) throws SQLException {
        String sql = ""
                + "SELECT * FROM cidade WHERE cod_cidade = " + codCidade;

        resultadoQ = ConexaoBD.executeQuery(sql);

        Cidade cidade = new Cidade(resultadoQ.getInt("cod_cidade"), resultadoQ.getString("nom_cidade"),
                resultadoQ.getString("uf"), resultadoQ.getString("cep"));
        
        return cidade;
    }

    public ArrayList<Cidade> recuperaTodos() throws SQLException {
        ArrayList<Cidade> cidades = new ArrayList<>();

        String sql = ""
                + "SELECT * FROM cidade";

        resultadoQ = ConexaoBD.executeQuery(sql);

        while (resultadoQ.next()) {
            Cidade cidade = new Cidade(resultadoQ.getInt("cod_cidade"), resultadoQ.getString("nom_cidade"),
                    resultadoQ.getString("uf"), resultadoQ.getString("cep"));

            cidades.add(cidade);
        }

        return cidades;
    }

}
