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
    
    public Animal recuperarAnimal(Integer codAnimal) {
        Animal animal = null;
        try {
            animal = animalDAO.recuperarAnimal(codAnimal);
            return animal;
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar do banco: " + e.getMessage());
            return animal;
        }
    }
    
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

    public boolean editar(Animal animal) {
        try {
            animalDAO.editar(animal);
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao editar: " + e.getMessage());
            return false;
        }
    }
    
    public boolean deletar(Integer codAnimal) {
        try {
            animalDAO.deletar(codAnimal);
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
            return false;
        }
    }
    
}
