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
 * @author leonardobourscheid
 */
public class AnimalTest {
    
    Animal animal;
    
    public AnimalTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        animal = new Animal(DefaultParameters.Animal.COD_ANIMAL,
                                   DefaultParameters.Animal.NOME,
                                   DefaultParameters.Animal.TIPO,
                                   DefaultParameters.Animal.DATA_ENCONTRO,
                                   DefaultParameters.Animal.RACA,
                                   DefaultParameters.Animal.IDADE,
                                   DefaultParameters.Animal.COR,
                                   DefaultParameters.Animal.SEXO,
                                   DefaultParameters.Animal.LOCAL_ENCONTRO, null);
    }
    
    @After
    public void tearDown() {
        animal = null;
    }

    @Test
    public void testeResumoPet() {
        String obtido = animal.getResumoPet();
        String esperado = DefaultParameters.Animal.RESUMO_ESPERADO;
        
        assertEquals(esperado, obtido);
    }
    
}
