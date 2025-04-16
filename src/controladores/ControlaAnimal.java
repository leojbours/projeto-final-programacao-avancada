/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.util.ArrayList;
import modelos.Animal;

/**
 *
 * @author leonardo.bourscheid
 */
public class ControlaAnimal {
    
    ArrayList<Animal> animais = new ArrayList<>();
    
    public void salvar(Animal animal) {
        animais.add(animal);
    }
    
    //recuperar
    
    public void recuperarTudo() {
        for (Animal animal : animais) {
            System.out.println(animal.toString());
        }
    }
    
    //editar
    
    //deletar
    
}
