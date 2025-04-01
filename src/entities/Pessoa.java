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
public class Pessoa {

    private String nomePessoa;
    private String cpf;
    private String passsaporte;
    private LocalDate dataNascimento;
    private Character sexo;
    private String numCelular;
    private String estadoCivil;
    private Endereco endereco;

    public Pessoa(String nomePessoa, String documento, boolean isCpf, LocalDate dataNascimento, Character sexo, String numCelular, String estadoCivil, Endereco endereco) {
        this.nomePessoa = nomePessoa;
        if (isCpf){
            this.cpf = documento;
        } else {
            this.passsaporte = documento;
        }
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.numCelular = numCelular;
        this.estadoCivil = estadoCivil;
        this.endereco = endereco;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPasssaporte() {
        return passsaporte;
    }

    public void setPasssaporte(String passsaporte) {
        this.passsaporte = passsaporte;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getNumCelular() {
        return numCelular;
    }

    public void setNumCelular(String numCelular) {
        this.numCelular = numCelular;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
