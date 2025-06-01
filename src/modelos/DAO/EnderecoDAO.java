/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.DAO;

import apoio.ConexaoBD;
import modelos.Cidade;
import modelos.Endereco;
import modelos.Pessoa;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author bours
 */
public class EnderecoDAO {

    ResultSet resultadoQ = null;
    CidadeDAO cidadeDAO = new CidadeDAO();

    public void salvar(Endereco endereco) throws SQLException {

        String sql = ""
                + "INSERT INTO endereco (cod_cidade, logradouro, numero, bairro, complemento, cep) VALUES ("
                + endereco.getCidade().getCodCidade() + ", '"
                + endereco.getLogradouro() + "', '"
                + endereco.getNumero() + "', '"
                + endereco.getBairro() + "', '"
                + endereco.getComplemento() + "', '"
                + endereco.getCep() + "')";

        ConexaoBD.executeUpdate(sql);
    }

    public Endereco recuperarEndereco(Endereco endereco) throws SQLException {
        Endereco enderecoRecuperado = null;

        String sql;

        if (endereco.getComplemento() == null) {
            sql = "" +
                    "SELECT * FROM endereco " +
                    "WHERE logradouro = '" + endereco.getLogradouro().toUpperCase() +
                    "' AND numero = '" + endereco.getNumero().toUpperCase() +
                    "' AND complemento = 'null'" +
                    "  AND bairro = '" + endereco.getBairro().toUpperCase() +
                    "' AND cep = '" + endereco.getCep() + "'";
        } else {
            sql = "" +
                    "SELECT * FROM endereco " +
                    "WHERE logradouro = '" + endereco.getLogradouro().toUpperCase() +
                    "' AND numero = '" + endereco.getNumero().toUpperCase() +
                    "' AND bairro = '" + endereco.getBairro().toUpperCase() +
                    "' AND complemento = '" + endereco.getComplemento().toUpperCase() +
                    "' AND cep = '" + endereco.getCep() + "'";
        }

        resultadoQ = ConexaoBD.executeQuery(sql);

        if (resultadoQ.next()) {
            Cidade cidade = cidadeDAO.recuperarCidade(resultadoQ.getInt("cod_cidade"));
            enderecoRecuperado = new Endereco(
                    resultadoQ.getInt("cod_endereco"),
                    resultadoQ.getString("cep"),
                    resultadoQ.getString("logradouro"),
                    resultadoQ.getString("numero"),
                    resultadoQ.getString("complemento"),
                    resultadoQ.getString("bairro"),
                    cidade);
        }

        return enderecoRecuperado;
    }

    public Endereco recuperarEndereco(Integer codEndereco) throws SQLException {
        Endereco endereco = null;

        String sql = "SELECT * FROM endereco WHERE cod_endereco = " + codEndereco;

        resultadoQ = ConexaoBD.executeQuery(sql);

        if (resultadoQ.next()) {
            Cidade cidade = cidadeDAO.recuperarCidade(resultadoQ.getInt("cod_cidade"));
            endereco = new Endereco(
                    resultadoQ.getInt("cod_endereco"),
                    resultadoQ.getString("cep"),
                    resultadoQ.getString("logradouro"),
                    resultadoQ.getString("numero"),
                    resultadoQ.getString("complemento"),
                    resultadoQ.getString("bairro"),
                    cidade);
        }

        return endereco;
    }

    public void editar(Endereco endereco) throws SQLException {

        String sql = "UPDATE endereco SET "
                + "cod_cidade = " + endereco.getCidade().getCodCidade() + ", "
                + "logradouro = '" + endereco.getLogradouro() + "', "
                + "numero = '" + endereco.getNumero() + "', "
                + "bairro = '" + endereco.getBairro() + "', "
                + "complemento = '" + endereco.getComplemento() + "', "
                + "cep = '" + endereco.getCep() + "' "
                + "WHERE cod_endereco = " + endereco.getCodEndereco();

        ConexaoBD.executeUpdate(sql);
    }

}
