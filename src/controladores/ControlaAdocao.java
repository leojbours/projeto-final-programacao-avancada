/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import modelos.DAO.AdocaoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Adocao;

/**
 *
 * @author leonardobourscheid
 */
public class ControlaAdocao {
 
    private static ControlaAdocao instance;
    
    private AdocaoDAO adocaoDAO = new AdocaoDAO();
    
    public static ControlaAdocao getInstance() {
        if(instance == null) {
            instance = new ControlaAdocao();
        }
        return instance;
    }
    
    public boolean salvar(Adocao adocao) {
        boolean deuCerto;
        
        try {
            adocaoDAO.salvar(adocao);
            deuCerto = true;
        } catch (SQLException e) {
            System.out.println("Erro ao salvar adocao: " + e.getMessage());
            deuCerto = false;
        }
        
        return deuCerto;
    }
    
    public ArrayList<Adocao> recuperarTodos() {
        ArrayList<Adocao> adocoes = new ArrayList<>();
        
        try {
            adocoes = adocaoDAO.recuperarTodos();
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar adoções: " + e.getMessage());
        }
        
        return adocoes;
    }
    
    public Adocao recuperarPorId(int id) {
        Adocao adocao = null;
        
        try {
            adocao = adocaoDAO.recuperarPorId(id);
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar adocao: " + e.getMessage());
        }
        
        return adocao;
    }
    
    public boolean editar (Adocao adocao) {
        boolean deuCerto;
        
        try {
            adocaoDAO.editar(adocao);
            deuCerto = true;
        } catch (SQLException e) {
            System.out.println("Erro ao editar adocao: " + e.getMessage());
            deuCerto = false;
        }
        
        return deuCerto;
    }
    
    public boolean deletar(int id) {
        boolean deuCerto;
        
        try {
            adocaoDAO.deletar(id);
            deuCerto = true;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir adocao: " + e.getMessage());
            deuCerto = false;
        }
        
        return deuCerto;
    }
}
