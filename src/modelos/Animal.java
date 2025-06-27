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
    
    private int codAnimal;
    private String nome = null;
    private String tipo;
    private LocalDate dataEncontro;
    private String raca;
    private Integer idade = null;
    private String cor;
    private Character sexo;
    private String localDeEncontro;
    private String resumoPet;
    
    //Construtor usado para salvar da tela
    public Animal(String tipo, LocalDate dataEncontro, String raca, String cor, Character sexo, String localDeEncontro) {
        this.tipo = tipo;
        this.dataEncontro = dataEncontro;
        this.raca = raca;
        this.cor = cor;
        this.sexo = sexo;
        this.localDeEncontro = localDeEncontro;
    }

    //Construtor para recuperar do banco
    public Animal(Integer codAnimal, String nome, String tipo, LocalDate dataEncontro, String raca, Integer idade, String cor, Character sexo, String localDeEncontro, String resumoPet) {
        this.codAnimal = codAnimal;
        this.nome = nome;
        this.tipo = tipo;
        this.dataEncontro = dataEncontro;
        this.raca = raca;
        this.idade = idade;
        this.cor = cor;
        this.sexo = sexo;
        this.localDeEncontro = localDeEncontro;
        this.resumoPet = resumoPet;
    }

    private void resumoPet() {
        StringBuilder sb = new StringBuilder();
        sb.append(codAnimal).append(" - ");
        if (nome != null && !nome.isBlank() && !nome.equals("null")) {
            sb.append(nome).append(". ");
        }
        sb.append(tipo).append(", ").append(raca);
        sb.append(" - ").append(cor);
        
        this.resumoPet = sb.toString();
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
    
    public void setCodAnimal(int id) {
        this.codAnimal = id;
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
    
    public String getResumoPet() 
    {
        this.resumoPet();
        
        return resumoPet;
    }
}
