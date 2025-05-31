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
 *
 * @author bours
 */
public class EnderecoDAO {

    ResultSet resultadoQ = null;
    CidadeDAO cidadeDAO = new CidadeDAO();

    public void salvar(Pessoa pessoa) throws SQLException {

        Endereco endereco = pessoa.getEndereco();

        String sql = ""
                + "INSERT INTO endereco (cod_pessoa, cod_cidade, logradouro, numero, bairro, complemento, cep) VALUES ("
                + pessoa.getCodPessoa() + ", '"
                + endereco.getCidade().getCodCidade() + ", '"
                + endereco.getLogradouro() + "', '"
                + endereco.getNumero() + "', '"
                + endereco.getBairro() + "', '"
                + endereco.getComplemento() + "', '"
                + endereco.getCep() + "')";

        ConexaoBD.executeUpdate(sql);
    }

    public Endereco recuperarEndereco(Integer codEndereco) throws SQLException {
        Endereco endereco = null;

        String sql = "SELECT * FROM pessoa WHERE cod_pessoa = " + codEndereco;

        resultadoQ = ConexaoBD.executeQuery(sql);

        if (resultadoQ.next()) {
            Cidade cidade = cidadeDAO.recuperarCidade(resultadoQ.getInt("cod_cidade"));
            endereco = new Endereco(
                    resultadoQ.getInt("cod_endereco"),
                    resultadoQ.getString("logradouro"),
                    resultadoQ.getString("numero"),
                    resultadoQ.getString("bairro"),
                    resultadoQ.getString("complemento"),
                    resultadoQ.getString("cep"),
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
