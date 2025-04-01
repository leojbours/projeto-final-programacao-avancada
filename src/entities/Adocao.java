/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.time.LocalDate;

/**
 *
 * @author leonardo
 */
public class Adocao {
    
    Integer codAdocao;
    Integer codAnimal;
    LocalDate dataAdocao;

    public Adocao(Integer codAdocao, Integer codAnimal, LocalDate dataAdocao) {
        this.codAdocao = codAdocao;
        this.codAnimal = codAnimal;
        this.dataAdocao = dataAdocao;
    }

    public Integer getCodAdocao() {
        return codAdocao;
    }

    public void setCodAdocao(Integer codAdocao) {
        this.codAdocao = codAdocao;
    }

    public Integer getCodAnimal() {
        return codAnimal;
    }

    public void setCodAnimal(Integer codAnimal) {
        this.codAnimal = codAnimal;
    }

    public LocalDate getDataAdocao() {
        return dataAdocao;
    }

    public void setDataAdocao(LocalDate dataAdocao) {
        this.dataAdocao = dataAdocao;
    }
    
}
