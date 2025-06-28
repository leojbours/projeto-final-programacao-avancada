/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.time.LocalDate;

/**
 *
 * @author leonardo
 */
public class Adocao {
    
    private int codAdocao;
    private Pessoa pessoa;
    private Animal animal;
    private Status status;
    private LocalDate dataAdocao;
    private LocalDate dataDevolucao;
    private String motivoDevolucao;
    
    public enum Status {
        PENDENTE("PENDENTE"),
        CONFIRMADO("CONFIRMADO"),
        DEVOLVIDO("DEVOLVIDO");
        
        private final String nome;
        
        Status(String nome) {
            this.nome = nome;
        }
        
        public String getNome() {
            return nome;
        }
    }
    
    public Adocao(Pessoa pessoa, Animal animal, Status status) {
        this.pessoa = pessoa;
        this.animal = animal;
        this.status = status;
    }
    
    public Adocao(int codAdocao, Pessoa pessoa, Animal animal, Status status) {
        this.codAdocao = codAdocao;
        this.pessoa = pessoa;
        this.animal = animal;
        this.status = status;
    }

    public Adocao(int codAdocao, Pessoa pessoa, Animal animal, Status status, LocalDate dataAdocao) {
        this.codAdocao = codAdocao;
        this.pessoa = pessoa;
        this.animal = animal;
        this.status = status;
        this.dataAdocao = dataAdocao;
    }
    
    public Adocao(int codAdocao, LocalDate dataAdocao, LocalDate dataDevolucao, String motivoDevolucao, Pessoa pessoa, Animal animal, Status status) {
        this.codAdocao = codAdocao;
        this.dataAdocao = dataAdocao;
        this.dataDevolucao = dataDevolucao;
        this.motivoDevolucao = motivoDevolucao;
        this.pessoa = pessoa;
        this.animal = animal;
        this.status = status;
    }

    public int getCodAdocao() {
        return codAdocao;
    }

    public void setCodAdocao(int codAdocao) {
        this.codAdocao = codAdocao;
    }

    public LocalDate getDataAdocao() {
        return dataAdocao;
    }

    public void setDataAdocao(LocalDate dataAdocao) {
        this.dataAdocao = dataAdocao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getMotivoDevolucao() {
        return motivoDevolucao;
    }

    public void setMotivoDevolucao(String motivoDevolucao) {
        this.motivoDevolucao = motivoDevolucao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
}
