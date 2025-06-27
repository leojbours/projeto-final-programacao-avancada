/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package modelos.DAO;

import apoio.ConexaoBD;
import java.sql.SQLException;
import modelos.Cidade;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import modelos.DefaultParameters;
import modelos.Endereco;
import modelos.Pessoa;

/**
 *
 * @author leonardo
 */
public class PessoaDAOTest {
    
    private Cidade cidade;
    private Endereco endereco;
    private Pessoa pessoa;
    
    PessoaDAO pessoaDAO;
    EnderecoDAO enderecoDAO;
    CidadeDAO cidadeDAO;
    
    public PessoaDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {

        try {
            System.setProperty("db.config", "db-test.properties");
            ConexaoBD.executeUpdate(DefaultParameters.Cidade.CREATE_TABLE);
            ConexaoBD.executeUpdate(DefaultParameters.Endereco.CREATE_TABLE);
            ConexaoBD.executeUpdate(DefaultParameters.Pessoa.CREATE_TABLE);
        } catch (SQLException e) {
            throw new RuntimeException(
            "Erro em @BeforeClass: falha ao criar tabelas 'pessoa', 'endereco', 'cidade'.\n" + e.getMessage(), e);
        }
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        
        try {
            ConexaoBD.executeUpdate(DefaultParameters.Cidade.DROP_TABLE);
            ConexaoBD.executeUpdate(DefaultParameters.Endereco.DROP_TABLE);
            ConexaoBD.executeUpdate(DefaultParameters.Pessoa.DROP_TABLE);
        } catch (SQLException e) {
            throw new RuntimeException("Erro em @AfterClass: falha ao dropar tabelas 'pessoa', 'endereco', 'cidade'.\n" + e.getMessage(), e);
        }
    }
    
    @Before
    public void setUp() {
        
        try {
            ConexaoBD.executeUpdate(DefaultParameters.Cidade.TRUNCATE_TABLE);
            ConexaoBD.executeUpdate(DefaultParameters.Endereco.TRUNCATE_TABLE);
            ConexaoBD.executeUpdate(DefaultParameters.Pessoa.TRUNCATE_TABLE);
        } catch (SQLException e) {
            throw new RuntimeException("Erro em @Before setUp(): falha ao truncar ou reiniciar serial da tabela 'pessoa', 'endereco', 'cidade'.\n" + e.getMessage(), e);
        }
        
        pessoaDAO = new PessoaDAO();
        enderecoDAO = new EnderecoDAO();
        cidadeDAO = new CidadeDAO();
        
        cidade = new Cidade(DefaultParameters.Cidade.COD_CIDADE,
                            DefaultParameters.Cidade.NOME_CIDADE,
                            DefaultParameters.Cidade.UF); 
        
        endereco = new Endereco(DefaultParameters.Endereco.COD_ENDERECO,
                                DefaultParameters.Endereco.CEP,
                                DefaultParameters.Endereco.LOGRADOURO,
                                DefaultParameters.Endereco.NUMERO,
                                DefaultParameters.Endereco.COMPLEMENTO,
                                DefaultParameters.Endereco.BAIRRO,
                                cidade );
        
        pessoa = new Pessoa(DefaultParameters.Pessoa.COD_PESSOA,
                            DefaultParameters.Pessoa.NOME_PESSOA,
                            DefaultParameters.Pessoa.CPF, DefaultParameters.Pessoa.PASSAPORTE,
                            DefaultParameters.Pessoa.DATA_NASCIMENTO,
                            DefaultParameters.Pessoa.SEXO,
                            DefaultParameters.Pessoa.NUM_CELULAR,
                            DefaultParameters.Pessoa.ESTADO_CIVIL,
                            endereco);
    }
    
    @After
    public void tearDown() {
        cidade = null;
        endereco = null;
        pessoa = null;
        
        ConexaoBD.getInstance().shutdown();
    }

    @Test
    public void testInserirERecuperarPessoa() throws SQLException {
        
        cidadeDAO.salvar(cidade);
        enderecoDAO.salvar(endereco);
        pessoaDAO.salvar(pessoa);
        
        Pessoa p = pessoaDAO.recuperarPessoa(pessoa.getCodPessoa());
        
        assertNotNull(p);
        
        Endereco e = p.getEndereco();
        Cidade c = e.getCidade();
        
        // Testa pessoa
        assertEquals(DefaultParameters.Pessoa.COD_PESSOA, (int) p.getCodPessoa());
        assertEquals(pessoa.getCodPessoa(), p.getCodPessoa());
        assertEquals(DefaultParameters.Pessoa.NOME_PESSOA, p.getNomePessoa());
        assertEquals(DefaultParameters.Pessoa.CPF, p.getCpf());
        assertEquals(DefaultParameters.Pessoa.PASSAPORTE, p.getPasssaporte());
        assertEquals(DefaultParameters.Pessoa.DATA_NASCIMENTO, p.getDataNascimento());
        assertEquals(DefaultParameters.Pessoa.SEXO, p.getSexo());
        assertEquals(DefaultParameters.Pessoa.DATA_NASCIMENTO, p.getDataNascimento());
        assertEquals(DefaultParameters.Pessoa.NUM_CELULAR, p.getNumCelular());
        assertEquals(DefaultParameters.Pessoa.ESTADO_CIVIL, p.getEstadoCivil());
        
        // Testa endereço
        assertEquals(DefaultParameters.Endereco.COD_ENDERECO, e.getCodEndereco());
        assertEquals(DefaultParameters.Endereco.CEP, e.getCep());
        assertEquals(DefaultParameters.Endereco.LOGRADOURO, e.getLogradouro());
        assertEquals(DefaultParameters.Endereco.NUMERO, e.getNumero());
        assertEquals(DefaultParameters.Endereco.COMPLEMENTO, e.getComplemento());
        assertEquals(DefaultParameters.Endereco.BAIRRO, e.getBairro());
        
        // Testa cidade
        assertEquals(DefaultParameters.Cidade.COD_CIDADE, c.getCodCidade());
        assertEquals(DefaultParameters.Cidade.NOME_CIDADE, c.getNomeCidade());
        assertEquals(DefaultParameters.Cidade.UF, c.getUf());
        
    }
    
    @Test
    public void testDeletarPessoa() throws SQLException { 
        cidadeDAO.salvar(cidade);
        enderecoDAO.salvar(endereco);
        pessoaDAO.salvar(pessoa);
        
        Pessoa p = pessoaDAO.recuperarPessoa(pessoa.getCodPessoa());
        
        assertNotNull(p);
        
        pessoaDAO.deletar(p.getCodPessoa());
        
        p = pessoaDAO.recuperarPessoa(p.getCodPessoa());
        
        assertNull(p);
        
    }
    
    @Test
    public void testEditarPessoa() throws SQLException {
        
        cidadeDAO.salvar(cidade);
        enderecoDAO.salvar(endereco);
        pessoaDAO.salvar(pessoa);
        
        Pessoa p = pessoaDAO.recuperarPessoa(pessoa.getCodPessoa());
        
        p.setNomePessoa(DefaultParameters.Pessoa.NOME_EDITADO);
        p.setCpf(DefaultParameters.Pessoa.CPF_EDITADO);
        
        pessoaDAO.editar(p);
        
        p = pessoaDAO.recuperarPessoa(p.getCodPessoa());
        
        assertEquals(DefaultParameters.Pessoa.NOME_EDITADO, p.getNomePessoa());
        assertEquals(DefaultParameters.Pessoa.CPF_EDITADO, p.getCpf());
    }
    
}
