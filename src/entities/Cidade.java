/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author leonardo
 */
public class Cidade {
    
    private Integer codEndereco;
    private String cidade;
    private Character uf;

    public Cidade(String cidade, char uf) {
        this.cidade = cidade;
        this.uf = uf;
    }

    public Integer getCodEndereco() {
        return codEndereco;
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
