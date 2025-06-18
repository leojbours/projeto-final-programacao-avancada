/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package modelos;

import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leonardo.bourscheid
 */
public class PessoaTest {
    
    private Pessoa pessoa;
    
    private int codPessoa = 1;
    private String nomePessoa = "Leo";
    private String cpf = "12345678910";
    private String passaporte = "ABC1234";
    private LocalDate dataNascimento = LocalDate.parse("2005-09-15");
    private char sexo = 'M';
    private String numCelular = "51987654321";
    private String estadoCivil = "Solteiro";
    private int codCidade = 1;
    private String nomeCidade = "Santa Clara do Sul";
    private String uf = "RS";
    private Cidade cidade = new Cidade(codCidade, nomeCidade, uf); 
    private int codEndereco = 1;
    private String cep = "95915000";
    private String logradouro = "Avenida 28 de Maio";
    private String numero = "S/N";
    private String complemento = "Complemento";
    private String bairro = "Centro";
    private Endereco endereco = new Endereco(codEndereco, cep, logradouro, numero, complemento, bairro, cidade );
                        
    
    public PessoaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pessoa = new Pessoa( codPessoa, nomePessoa, cpf, passaporte, dataNascimento, sexo, numCelular, estadoCivil, endereco);
    }

    @After
    public void tearDown() {
        pessoa = null;
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testaDocumentoCompleto() {
        pessoa.defineDocumento();
        assertEquals( "12345678910", pessoa.getDocumento() );
    }
    
    @Test
    public void testaDocumentoSemCpf() {
        pessoa.setCpf("");
        pessoa.defineDocumento();
        assertEquals("ABC1234", pessoa.getDocumento() );
    }
    
    @Test
    public void testaDocumentoSemPassaporte() {
        pessoa.setPasssaporte("");
        pessoa.defineDocumento();
        assertEquals("ABC1234", pessoa.getPasssaporte());
    }
}
