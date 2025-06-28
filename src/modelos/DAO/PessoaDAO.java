/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.DAO;

import apoio.ConexaoBD;
import java.sql.ResultSet;
import java.util.ArrayList;

import modelos.Endereco;
import modelos.Pessoa;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author leonardo.bourscheid
 */
public class PessoaDAO {

    ResultSet resultadoQ = null;
    EnderecoDAO enderecoDAO = new EnderecoDAO();

    public void salvar(Pessoa pessoa) throws SQLException {

        String sql = ""
                + "INSERT INTO pessoa (cod_endereco, nom_pessoa, cpf, passaporte, dat_nascimento, sexo, num_celular, estado_civil, ativo) VALUES ("
                + pessoa.getEndereco().getCodEndereco() + ", '"
                + pessoa.getNomePessoa() + "', '"
                + pessoa.getCpf().trim() + "', '"
                + pessoa.getPasssaporte() + "', '"
                + pessoa.getDataNascimento() + "', '"
                + pessoa.getSexo() + "', '"
                + pessoa.getNumCelular() + "', '"
                + pessoa.getEstadoCivil() + "', "
                + "TRUE) RETURNING cod_pessoa";

        pessoa.setCodPessoa(ConexaoBD.executeUpdateReturnId(sql));
    }

    public Pessoa recuperarPessoa(int codPessoa) throws SQLException {
        Pessoa pessoa = null;

        String sql = "SELECT * FROM pessoa WHERE cod_pessoa = " + codPessoa +
                     " AND ativo = true";

        resultadoQ = ConexaoBD.executeQuery(sql);

        if (resultadoQ.next()) {
            Endereco endereco = enderecoDAO.recuperarEndereco(resultadoQ.getInt("cod_endereco"));
            pessoa = new Pessoa(resultadoQ.getInt("cod_pessoa"),
                    resultadoQ.getString("nom_pessoa"),
                    resultadoQ.getString("cpf"),
                    resultadoQ.getString("passaporte"),
                    LocalDate.parse(resultadoQ.getString("dat_nascimento")),
                    resultadoQ.getString("sexo").charAt(0),
                    resultadoQ.getString("num_celular"),
                    resultadoQ.getString("estado_civil"),
                    endereco);
        }

        return pessoa;
    }

    public ArrayList<Pessoa> recuperarTodos() throws SQLException {
        ArrayList<Pessoa> pessoas = new ArrayList<>();

        String sql = ""
                + "SELECT * FROM pessoa";

        resultadoQ = ConexaoBD.executeQuery(sql);

        while (resultadoQ.next()) {
            if (resultadoQ.getBoolean("ativo")) {
                Endereco endereco = enderecoDAO.recuperarEndereco(resultadoQ.getInt("cod_endereco"));

                Pessoa pessoa = new Pessoa(resultadoQ.getInt("cod_pessoa"),
                        resultadoQ.getString("nom_pessoa"),
                        resultadoQ.getString("cpf"),
                        resultadoQ.getString("passaporte"),
                        LocalDate.parse(resultadoQ.getString("dat_nascimento")),
                        resultadoQ.getString("sexo").charAt(0),
                        resultadoQ.getString("num_celular"),
                        resultadoQ.getString("estado_civil"),
                        endereco);

                pessoas.add(pessoa);
            }
        }

        return pessoas;
    }

    public void editar(Pessoa pessoa) throws SQLException {

        Endereco endereco = pessoa.getEndereco();

        enderecoDAO.editar(endereco);

        String sql = "UPDATE pessoa SET "
                + "nom_pessoa = '" + pessoa.getNomePessoa() + "', "
                + "cpf = '" + pessoa.getCpf() + "', "
                + "dat_nascimento = '" + pessoa.getDataNascimento() + "', "
                + "sexo = '" + pessoa.getSexo() + "', "
                + "num_celular = '" + pessoa.getNumCelular() + "', "
                + "estado_civil = '" + pessoa.getEstadoCivil() + "' "
                + "WHERE cod_pessoa = " + pessoa.getCodPessoa();
                
        ConexaoBD.executeUpdate(sql);
    }

    public void deletar(Integer codPessoa) throws SQLException {
        String sql = "UPDATE pessoa SET ativo = false WHERE cod_pessoa = " + codPessoa;

        ConexaoBD.executeUpdate(sql);
    }

}
