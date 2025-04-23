/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.util.ArrayList;
import modelos.Pessoa;

/**
 *
 * @author leonardo.bourscheid
 */
public class ControlaPessoa {

    ArrayList<Pessoa> pessoas = new ArrayList<>();

    public void salvar(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    //recuperar
    public ArrayList<Pessoa> recuperarTudo() {
        return pessoas;
    }

}

//editar
    
    //deletar
