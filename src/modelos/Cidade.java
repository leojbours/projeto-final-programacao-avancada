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

    public Cidade(String cidade, char uf) {
        this.cidade = cidade;
        this.uf = uf;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cidade{");
        sb.append("codCidade=").append(codCidade);
        sb.append(", cidade=").append(cidade);
        sb.append(", uf=").append(uf);
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
}
