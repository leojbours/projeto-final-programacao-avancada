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
public class Animal {
    
    private Integer codAnimal;
    private String nome;
    private String tipo;
    private LocalDate dataEncontro;
    private String raca;
    private Integer idade;
    private String cor;
    private Character sexo;
    private String localDeEncontro;

    public Animal(Integer codAnimal, String tipo, LocalDate dataEncontro, String raca, String cor, Character sexo, String localDeEncontro) {
        this.codAnimal = codAnimal;
        this.tipo = tipo;
        this.dataEncontro = dataEncontro;
        this.raca = raca;
        this.cor = cor;
        this.sexo = sexo;
        this.localDeEncontro = localDeEncontro;
    }
    
    public Animal(String tipo, LocalDate dataEncontro, String raca, String cor, Character sexo, String localDeEncontro) {
        this.tipo = tipo;
        this.dataEncontro = dataEncontro;
        this.raca = raca;
        this.cor = cor;
        this.sexo = sexo;
        this.localDeEncontro = localDeEncontro;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Animal{").append("\n");
        sb.append("codAnimal: ").append(codAnimal).append("\n");
        sb.append("nome: ").append(nome).append("\n");
        sb.append("tipo: ").append(tipo).append("\n");
        sb.append("dataEncontro: ").append(dataEncontro).append("\n");
        sb.append("raca: ").append(raca).append("\n");
        sb.append("idade: ").append(idade).append("\n");
        sb.append("cor: ").append(cor).append("\n");
        sb.append("sexo: ").append(sexo).append("\n");
        sb.append("Local de encontro: ").append(localDeEncontro).append("\n");
        sb.append('}');
        return sb.toString();
    }
    
    public Integer getCodAnimal() {
        return codAnimal;
    }
    
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataEncontro() {
        return dataEncontro;
    }

    public void setDataEncontro(LocalDate dataEncontro) {
        this.dataEncontro = dataEncontro;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getLocalDeEncontro() {
        return localDeEncontro;
    }

    public void setLocalDeEncontro(String localDeEncontro) {
        this.localDeEncontro = localDeEncontro;
    }
}
