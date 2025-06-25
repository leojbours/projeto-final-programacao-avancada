/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.time.LocalDate;

/**
 * @author leonardo
 */
public class Pessoa {

    private int codPessoa;
    private String nomePessoa;
    private String cpf;
    private String passsaporte;
    private String documento;
    private LocalDate dataNascimento;
    private Character sexo;
    private String numCelular;
    private String estadoCivil;

    private Endereco endereco;

    public Pessoa(int codPessoa, String nomePessoa, String cpf, String passsaporte, LocalDate dataNascimento, Character sexo, String numCelular, String estadoCivil, Endereco endereco) {
        this.codPessoa = codPessoa;
        this.nomePessoa = nomePessoa;
        this.cpf = cpf;
        this.passsaporte = passsaporte;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.numCelular = numCelular;
        this.estadoCivil = estadoCivil;
        this.endereco = endereco;
    }

    public Pessoa(String nomePessoa, LocalDate dataNascimento, Character sexo, String numCelular, String estadoCivil, Endereco endereco) {
        this.nomePessoa = nomePessoa;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.numCelular = numCelular;
        this.estadoCivil = estadoCivil;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(codPessoa).append(";");
        sb.append(nomePessoa).append(";");
        sb.append(cpf).append(";");
        sb.append(passsaporte).append(";");
        sb.append(dataNascimento).append(";");
        sb.append(sexo).append(";");
        sb.append(numCelular).append(";");
        sb.append(estadoCivil).append(";");
        sb.append(endereco).append(";");
        return sb.toString();
    }

    public String imprimeAtributos() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pessoa{ \n");
        sb.append("codPessoa: ").append(codPessoa).append("\n");
        sb.append("nomePessoa: ").append(nomePessoa).append("\n");
        sb.append("cpf: ").append(cpf).append("\n");
        sb.append("passsaporte: ").append(passsaporte).append("\n");
        sb.append("dataNascimento: ").append(dataNascimento).append("\n");
        sb.append("sexo: ").append(sexo).append("\n");
        sb.append("numCelular: ").append(numCelular).append("\n");
        sb.append("estadoCivil: ").append(estadoCivil).append("\n");
        sb.append("endereco: ").append(endereco).append("\n");
        sb.append('}');
        return sb.toString();
    }

//    public String getEndereco() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(logradouro).append(", ");
//        sb.append(numero).append(". ");
//        sb.append(bairro).append(". ");
//        sb.append(cidade.getNomeCidade()).append(" - ");
//        sb.append(cidade.getUf());
//        return sb.toString();
//    }


    public Integer getCodPessoa() {
        return codPessoa;
    }
    
    public void setCodPessoa(int codPessoa) {
        this.codPessoa = codPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getCpf() {
        if (cpf == null || cpf.trim().equals("null")) {
            return "";
        } else {
            return cpf;
        }
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

    public String getDocumento() {
        defineDocumento();
        if (documento == null) {
            return "N/A";
        } else {
            return documento;
        }
    }

    public void defineDocumento() {
        if (cpf == null || cpf.trim().equals("null") || cpf.isBlank()) {
            this.documento = this.passsaporte;
        } else {
            this.documento = this.cpf;
        }
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
