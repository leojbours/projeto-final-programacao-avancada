/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package apoio;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author leonardobourscheid
 */
public class ConexaoTestDBTest {
    
    public ConexaoTestDBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testaConexaoTeste() throws SQLException {
        
        System.setProperty("db.config", "db-test.properties");
        
        Connection conn = ConexaoBD.getInstance().getConnection();
        
        assertNotNull("A conexao nao pode ser nula!", conn);
        
        assertFalse("A conexao nao pode estar fechada!", conn.isClosed());
        
    }
}
