/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author leonardo
 */
public class Cidade {
    
    private Integer codCidade;
    private String nomeCidade;
    private String uf;
    private String cep;

    public Cidade(Integer codCidade, String nomeCidade, String uf, String cep) {
        this.codCidade = codCidade;
        this.nomeCidade = nomeCidade;
        this.uf = uf;
        this.cep = cep;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cidade{").append("\n");
        sb.append("codCidade: ").append(codCidade).append("\n");
        sb.append("cidade: ").append(nomeCidade).append("\n");
        sb.append("uf: ").append(uf).append("\n");
        sb.append("cep: ").append(cep).append("\n");
        sb.append('}');
        return sb.toString();
    }

    public Integer getCodCidade() {
        return codCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
