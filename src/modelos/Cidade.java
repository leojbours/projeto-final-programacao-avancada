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
    private String cidade;
    private Character uf;
    private String cep;

    public Cidade(String cidade, char uf) {
        this.cidade = cidade;
        this.uf = uf;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cidade{").append("\n");
        sb.append("codCidade: ").append(codCidade).append("\n");
        sb.append("cidade: ").append(cidade).append("\n");
        sb.append("uf: ").append(uf).append("\n");
        sb.append('}');
        return sb.toString();
    }

    public Integer getCodCidade() {
        return codCidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Character getUf() {
        return uf;
    }

    public void setUf(char uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
