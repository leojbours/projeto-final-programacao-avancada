/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.DAO;

import apoio.ConexaoBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import modelos.Animal;

/**
 *
 * @author leonardo.bourscheid
 */
public class AnimalDAO {
    
    ResultSet resultadoQ = null;
    
    public void salvar(Animal animal) throws SQLException {
        String sql = ""
                + "insert into animal (nom_animal, tipo_animal, dat_encontro, local_encontro, raca, cor, sexo, idade) "
                + "VALUES ('" + animal.getNome() + "', '" + animal.getTipo() + "', '" + animal.getDataEncontro() + "', '"
                + animal.getLocalDeEncontro() + "', '" + animal.getRaca() + "', '" + animal.getCor() + "', '" + animal.getSexo()
                + "', " + animal.getIdade() + ")";
        
        ConexaoBD.executeUpdate(sql);
    }
    
    public ArrayList<Animal> recuperarTodos() throws SQLException {
        ArrayList<Animal> animais = new ArrayList<>();
        
        String sql = ""
                + "SELECT * FROM animal";
        
        resultadoQ = ConexaoBD.executeQuery(sql);
        
        while (resultadoQ.next()) {
            Animal animal = new Animal(resultadoQ.getInt("cod_animal"), resultadoQ.getString("nom_animal"),
                    resultadoQ.getString("tipo_animal"), LocalDate.parse(resultadoQ.getString("dat_encontro")), 
                    resultadoQ.getString("raca"), resultadoQ.getInt("idade"), resultadoQ.getString("cor"),
                    resultadoQ.toString().charAt(0), resultadoQ.getString("local_encontro"));
            animais.add(animal);
        }
        
        return animais;
    }
    
}
