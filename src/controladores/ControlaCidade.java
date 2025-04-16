/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.util.ArrayList;
import modelos.Cidade;

/**
 *
 * @author leonardo.bourscheid
 */
public class ControlaCidade {
    
    ArrayList<Cidade> cidades = new ArrayList<>();
    
    public void salvar(Cidade cidade) {
        cidades.add(cidade);
    }
    
    //recuperar
    
    public void recuperarTudo() {
        for (Cidade cidade : cidades) {
            System.out.println(cidade.toString());
        }
    }
    
    //editar
    
    //deletar
}
