/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.util.ArrayList;
import modelos.Animal;
import modelos.DAO.AnimalDAO;
import java.sql.SQLException;

/**
 *
 * @author leonardo.bourscheid
 */
public class ControlaAnimal {

    AnimalDAO animalDAO = new AnimalDAO();

    public boolean salvar(Animal animal) {
        try {
            animalDAO.salvar(animal);
            return true;
        } catch (SQLException e) {
            System.out.println("Erro com o banco de dados: " + e.getMessage());
            return false;
        }

    }

    //recuperar
    public ArrayList<Animal> recuperarTudo() {
        ArrayList<Animal> animais = null;

        try {
            animais = animalDAO.recuperarTodos();
            return animais;
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar do banco: " + e.getMessage());
        }

        return animais;
    }

    //editar
    //deletar
}
