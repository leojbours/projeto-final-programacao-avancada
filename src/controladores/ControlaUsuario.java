/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import modelos.DAO.UsuarioDAO;
import java.sql.SQLException;
import modelos.Usuario;

/**
 *
 * @author leonardo.bourscheid
 */
public class ControlaUsuario {
    
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    Usuario usuarioRecuperado = null;
    
    public int validaLogin(String usuario, String senha) {
        
        try {
            
            usuarioRecuperado = usuarioDAO.validaLogin(usuario, senha);
            
            if (usuarioRecuperado != null) {
                return 1;
            } else {
                return 0;
            }
            
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return -1;
        }
    }
    
    public Usuario getUsuarioLogado() {
        return usuarioRecuperado;
    }
    
}
