package modelos.DAO;


import apoio.ConexaoBD;
import modelos.Adocao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import static modelos.Adocao.Status.CONFIRMADO;
import static modelos.Adocao.Status.DEVOLVIDO;
import static modelos.Adocao.Status.PENDENTE;
import modelos.Animal;
import modelos.Pessoa;

/**
 *
 * @author leonardobourscheid
 */
public class AdocaoDAO {
    
    ResultSet resultadoQ = null;
    
    public void salvar(Adocao adocao) throws SQLException {
        
        String sql = "INSERT INTO adocao(cod_animal, cod_pessoa, status) VALUES ('" +
                     adocao.getAnimal().getCodAnimal() + "', " +
                     adocao.getPessoa().getCodPessoa() + ", '" +
                     adocao.getStatus().getNome() + "')";
        
        adocao.setCodAdocao(ConexaoBD.executeUpdateReturnId(sql));
        
    }
    
    public ArrayList<Adocao> recuperarTodos() throws SQLException {
        
        ArrayList<Adocao> adocoes = new ArrayList<>();
        
        String sql = "SELECT * FROM adocao WHERE ativo = true";
        
        resultadoQ = ConexaoBD.executeQuery(sql);
        
        while(resultadoQ.next()) {
            Pessoa p = new PessoaDAO().recuperarPessoa(resultadoQ.getInt("cod_pessoa"));
            Animal a = new AnimalDAO().recuperarAnimal(resultadoQ.getInt("cod_animal"));
            
            switch (Adocao.Status.valueOf(resultadoQ.getString("status"))) {
                
                case PENDENTE -> {
                    adocoes.add(new Adocao(resultadoQ.getInt("cod_adocao"), p, a,
                                           Adocao.Status.valueOf(resultadoQ.getString("status"))));
                }
                
                case CONFIRMADO -> {
                    adocoes.add(new Adocao(resultadoQ.getInt("cod_adocao"), p, a,
                                           Adocao.Status.valueOf(resultadoQ.getString("status")),
                                           LocalDate.parse(resultadoQ.getString("dat_adocao"))));
                }
                
                case DEVOLVIDO -> {
                    adocoes.add(new Adocao(resultadoQ.getInt("cod_adocao"),
                                   LocalDate.parse(resultadoQ.getString("dat_adocao")),
                                   LocalDate.parse(resultadoQ.getString("dat_devolucao")),
                                   resultadoQ.getString("mot_devolucao"),
                                   p, a, Adocao.Status.valueOf(resultadoQ.getString("status"))));
                }
                
            }
            
        }
        
        return adocoes;
    }
    
    public Adocao recuperarPorId(int id) throws SQLException {
        
        Adocao adocao = null;
        
        String sql = "SELECT * FROM adocao WHERE cod_adocao = " 
                     + id + " AND ativo = true";
        
        resultadoQ = ConexaoBD.executeQuery(sql);
        
        if (resultadoQ.next()) {
            Pessoa p = new PessoaDAO().recuperarPessoa(resultadoQ.getInt("cod_pessoa"));
            Animal a = new AnimalDAO().recuperarAnimal(resultadoQ.getInt("cod_animal"));
           
            switch (Adocao.Status.valueOf(resultadoQ.getString("status"))) {
                
                case PENDENTE -> {
                    adocao = new Adocao(resultadoQ.getInt("cod_adocao"), p, a,
                                         Adocao.Status.valueOf(resultadoQ.getString("status")));
                }
                
                case CONFIRMADO -> {
                    adocao = new Adocao(resultadoQ.getInt("cod_adocao"), p, a,
                                        Adocao.Status.valueOf(resultadoQ.getString("status")),
                                        LocalDate.parse(resultadoQ.getString("dat_adocao")));
                }
                
                case DEVOLVIDO -> {
                    adocao = new Adocao(resultadoQ.getInt("cod_adocao"),
                                        LocalDate.parse(resultadoQ.getString("dat_adocao")),
                                        LocalDate.parse(resultadoQ.getString("dat_devolucao")),
                                        resultadoQ.getString("mot_devolucao"),
                                        p, a, Adocao.Status.valueOf(resultadoQ.getString("status")));
                }
                
            }
            
        }
        
        return adocao;
    }
    
    public void editar(Adocao adocao) throws SQLException {
        
        String sql = "UPDATE adocao SET " +
                     "cod_pessoa = "      + adocao.getPessoa().getCodPessoa() + ", " +
                     "cod_animal = "      + adocao.getAnimal().getCodAnimal() + ", " +
                     "status = '"         + adocao.getStatus().getNome()      + "'";
        
        switch (adocao.getStatus()) {

            case CONFIRMADO -> {
                sql += ", dat_adocao = '" + adocao.getDataAdocao() + "'";
            }

            case DEVOLVIDO -> {
                sql += ", dat_devolucao = '" + adocao.getDataDevolucao()         + "', " +
                       "mot_devolucao = '"   + adocao.getMotivoDevolucao()       + "'" ;
            }
            
        }
        
        sql += " where cod_adocao = " + adocao.getCodAdocao();
        
        ConexaoBD.executeUpdate(sql);
    }
    
    public void deletar(int id) throws SQLException {
        
        String sql = "UPDATE adocao SET ativo = false WHERE cod_adocao = " + id;
        
        ConexaoBD.executeUpdate(sql);
    }
}