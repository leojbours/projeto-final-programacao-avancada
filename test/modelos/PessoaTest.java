/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package modelos;

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
    private Cidade cidade;
    private Endereco endereco;
    
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
    }
    
    @Test
    public void testaDocumentoCompleto() {
        pessoa.defineDocumento();
        assertEquals(DefaultParameters.Pessoa.CPF, pessoa.getDocumento());
    }
    
    @Test
    public void testaDocumentoSemCpf() {
        pessoa.setCpf("");
        pessoa.setPasssaporte(DefaultParameters.Pessoa.PASSAPORTE);
        pessoa.defineDocumento();
        assertEquals(DefaultParameters.Pessoa.PASSAPORTE, pessoa.getDocumento());
    }
    
    @Test
    public void testaDocumentoSemPassaporte() {
        pessoa.setCpf(DefaultParameters.Pessoa.CPF);
        pessoa.setPasssaporte("");
        pessoa.defineDocumento();
        assertEquals(DefaultParameters.Pessoa.CPF, pessoa.getDocumento());
    }
}
