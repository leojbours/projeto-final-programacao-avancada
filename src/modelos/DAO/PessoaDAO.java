/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.DAO;

import apoio.ConexaoBD;
import controladores.ControlaCidade;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelos.Pessoa;
import java.sql.SQLException;
import java.time.LocalDate;
import modelos.Cidade;

/**
 *
 * @author leonardo.bourscheid
 */
public class PessoaDAO {

    ResultSet resultadoQ = null;
    ControlaCidade controlaCidade = new ControlaCidade();

    public void salvar(Pessoa pessoa) throws SQLException {
        String sql = ""
                + "INSERT INTO pessoa (cod_cidade, nom_pessoa, cpf, passaporte, dat_nascimento, sexo, num_celular, estado_civil, logradouro, numero, bairro) VALUES ("
                + pessoa.getCidade().getCodCidade() + ", '" + pessoa.getNomePessoa() + "', '" + pessoa.getCpf() + "', '" + pessoa.getPasssaporte() 
                + "', '" + pessoa.getDataNascimento() + "', '" + pessoa.getSexo() + "', '" + pessoa.getNumCelular() + "', '" + pessoa.getEstadoCivil() 
                + "', '" + pessoa.getLogradouro() + "', '" + pessoa.getNumero() + "', '" + pessoa.getBairro() + "')";   
        
        ConexaoBD.executeUpdate(sql);
    }

    public ArrayList<Pessoa> recuperarTodos() throws SQLException {
        ArrayList<Pessoa> pessoas = new ArrayList<>();

        String sql = ""
                + "SELECT * FROM pessoa";

        resultadoQ = ConexaoBD.executeQuery(sql);

        while (resultadoQ.next()) {
            Cidade cidade = controlaCidade.recuperarCidade(resultadoQ.getInt("cod_cidade"));
            Pessoa pessoa = new Pessoa(resultadoQ.getInt("cod_pessoa"), resultadoQ.getString("nom_pessoa"),
                    resultadoQ.getString("cpf"), resultadoQ.getString("passaporte"),
                    LocalDate.parse(resultadoQ.getString("dat_nascimento")), resultadoQ.getString("sexo").charAt(0),
                    resultadoQ.getString("num_celular"), resultadoQ.getString("estado_civil"),
                    resultadoQ.getString("logradouro"), resultadoQ.getString("numero"),
                    resultadoQ.getString("bairro"), cidade);
            pessoas.add(pessoa);
        }

        return pessoas;
    }

}
