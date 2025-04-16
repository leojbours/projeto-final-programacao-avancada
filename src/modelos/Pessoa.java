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
public class Pessoa {

    private Integer codPessoa;
    private String nomePessoa;
    private String cpf;
    private String passsaporte;
    private LocalDate dataNascimento;
    private Character sexo;
    private String numCelular;
    private String estadoCivil;
    private String logradouro;
    private String numero;
    private String bairro;
    private Cidade cidade; 

    public Pessoa() {
        
    }
    
    public Pessoa(String nomePessoa, String documento, boolean isCpf, LocalDate dataNascimento, Character sexo, String numCelular, String estadoCivil, String logradouro, String numero, String bairro, Cidade cidade) {
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
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pessoa{");
        sb.append("codPessoa=").append(codPessoa);
        sb.append(", nomePessoa=").append(nomePessoa);
        sb.append(", cpf=").append(cpf);
        sb.append(", passsaporte=").append(passsaporte);
        sb.append(", dataNascimento=").append(dataNascimento);
        sb.append(", sexo=").append(sexo);
        sb.append(", numCelular=").append(numCelular);
        sb.append(", estadoCivil=").append(estadoCivil);
        sb.append(", logradouro=").append(logradouro);
        sb.append(", numero=").append(numero);
        sb.append(", bairro=").append(bairro);
        sb.append(", cidade=").append(cidade);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    public Integer getCodPessoa() {
        return codPessoa;
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

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
