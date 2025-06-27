/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.Objects;

/**
 *
 * @author leonardo
 */
public class Cidade {

    private int codCidade;
    @com.google.gson.annotations.SerializedName("localidade")
    private String nomeCidade;
    private String uf;

    public Cidade(Integer codCidade, String nomeCidade, String uf) {
        this.codCidade = codCidade;
        this.nomeCidade = nomeCidade;
        this.uf = uf;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cidade{").append("\n");
        sb.append("codCidade: ").append(codCidade).append("\n");
        sb.append("cidade: ").append(nomeCidade).append("\n");
        sb.append("uf: ").append(uf).append("\n");
        sb.append('}');
        return sb.toString();
    }

    public int getCodCidade() {
        return codCidade;
    }
    
    public void setCodCidade(int id) {
        this.codCidade = id;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.nomeCidade);
        hash = 83 * hash + Objects.hashCode(this.uf);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cidade other = (Cidade) obj;
        if (!Objects.equals(this.nomeCidade, other.nomeCidade)) {
            return false;
        }
        return Objects.equals(this.uf, other.uf);
    }

    
}
