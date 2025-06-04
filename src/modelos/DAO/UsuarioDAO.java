/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.DAO;

import apoio.ConexaoBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.Usuario;

/**
 *
 * @author leonardo.bourscheid
 */
public class UsuarioDAO {

    ResultSet resultadoQ = null;

    public Usuario validaLogin(String usuario, String senha) throws SQLException {

        Usuario usuarioRecuperado = null;

        String sql = ""
                + "SELECT * FROM usuario "
                + "WHERE nome_usuario = '" + usuario + "' "
                + "AND senha = '" + senha + "'";

        resultadoQ = ConexaoBD.executeQuery(sql);

        if (resultadoQ.next()) {

            usuarioRecuperado = new Usuario(
                    resultadoQ.getInt("cod_usuario"),
                    resultadoQ.getString("nome_usuario"),
                    resultadoQ.getString("senha")
            );

        }

        return usuarioRecuperado;

    }

}
