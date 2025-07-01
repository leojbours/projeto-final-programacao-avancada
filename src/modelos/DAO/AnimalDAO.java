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

        animal.setCodAnimal(ConexaoBD.executeUpdateReturnId(sql));
        
        String updateResumo = "UPDATE animal set resumo_pet = '" + animal.getResumoPet() + "' where cod_animal = " + animal.getCodAnimal();
        
        ConexaoBD.executeUpdate(updateResumo);
    }

    public Animal recuperarAnimal(int codAnimal) throws SQLException {
        Animal animal = null;

        String sql = "SELECT * FROM animal WHERE cod_animal = " + codAnimal;

        resultadoQ = ConexaoBD.executeQuery(sql);

        if (resultadoQ.next()) {
            animal = new Animal(resultadoQ.getInt("cod_animal"), resultadoQ.getString("nom_animal"),
                    resultadoQ.getString("tipo_animal"), LocalDate.parse(resultadoQ.getString("dat_encontro")),
                    resultadoQ.getString("raca"), resultadoQ.getInt("idade"), resultadoQ.getString("cor"),
                    resultadoQ.getString("sexo").charAt(0), resultadoQ.getString("local_encontro"),
                    resultadoQ.getString("resumo_pet"));
        }

        return animal;
    }

    public ArrayList<Animal> recuperarTodos() throws SQLException {
        ArrayList<Animal> animais = new ArrayList<>();

        String sql = ""
                + "SELECT * FROM animal";

        resultadoQ = ConexaoBD.executeQuery(sql);
        while (resultadoQ.next()) {
            if (resultadoQ.getBoolean("ativo")) {
                Animal animal = new Animal(
                        resultadoQ.getInt("cod_animal"),
                        resultadoQ.getString("nom_animal"),
                        resultadoQ.getString("tipo_animal"), 
                        LocalDate.parse(resultadoQ.getString("dat_encontro")),
                        resultadoQ.getString("raca"), 
                        resultadoQ.getInt("idade"), 
                        resultadoQ.getString("cor"),
                        resultadoQ.getString("sexo").charAt(0), 
                        resultadoQ.getString("local_encontro"),
                        resultadoQ.getString("resumo_pet"));
                animais.add(animal);
            }
        }

        return animais;
    }

    public void editar (Animal animal) throws SQLException {
        
        String sql = "UPDATE animal SET "
                + "cod_animal = " + animal.getCodAnimal() + ", "
                + "nom_animal = '" + animal.getNome() + "', "
                + "tipo_animal = '" + animal.getTipo() + "', "
                + "dat_encontro = '" + animal.getDataEncontro() + "', "
                + "raca = '" + animal.getRaca() + "', "
                + "idade = " + animal.getIdade() + ", "
                + "cor = '" + animal.getCor() + "', "
                + "sexo = '" + animal.getSexo() + "', "
                + "local_encontro = '" + animal.getLocalDeEncontro() + "', "
                + "resumo_pet = '" + animal.getResumoPet() + "' "
                + "WHERE cod_animal = " + animal.getCodAnimal();
        
        ConexaoBD.executeUpdate(sql);
    }
    
    public void deletar(Integer codAnimal) throws SQLException {

        String sql = "UPDATE animal SET ativo = false WHERE cod_animal = " + codAnimal;

        ConexaoBD.executeUpdate(sql);

    }

}
