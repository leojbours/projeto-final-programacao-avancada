package apoio;

/**
 *
 * @author fabricio.pretto - cria conexao com o BD e estrutura da classe
 *
 * @author mateus.roveda 16/05/2023 - criado metodos para consulta e updates;
 * atualizada documentacao.
 */
import java.sql.*;
import java.io.*;
import java.util.*;

public class ConexaoBD {

    private static ConexaoBD instancia = null;
    private Connection conexao = null;

    public ConexaoBD() {
        try {
            
            String arquivo = System.getProperty("db.config");
            if (arquivo == null || arquivo.trim().isEmpty()) {
                arquivo = "db.properties";
            }
            
            // Carrega informações do arquivo de propriedades
            Properties prop = new Properties();
            prop.load(new FileInputStream(arquivo));
            String dbdriver = prop.getProperty("db.driver");
            String dburl = prop.getProperty("db.url");
            String dbuser = prop.getProperty("db.user");
            String dbsenha = prop.getProperty("db.senha");

            // Carrega Driver do Banco de Dados
            Class.forName(dbdriver);

            conexao = DriverManager.getConnection(dburl, dbuser, dbsenha);

        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }

    /**
     * Retorna instância
     *
     * @return ConexaoBD
     */
    public static ConexaoBD getInstance() {
        if (instancia == null) {
            instancia = new ConexaoBD();
        }
        return instancia;
    }

    /**
     * Retorna conexo
     *
     * @return conexao
     */
    public Connection getConnection() {
        if (conexao == null) {
            throw new RuntimeException("conexao==null");
        }
        return conexao;
    }

    /**
     * Executa um insert/update no banco de dados
     *
     * @param sql: query a ser executada
     * @return int
     * @throws java.sql.SQLException
     */
    public static int executeUpdate(String sql) throws SQLException {
        return ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);
    }
    
        /**
     * Executa uma consulta no banco de dados recebendo constante
     *
     * @param sql: query a ser executada
     * @param constante: ex: RETURN_GENERATED_KEYS
     * @return ResultSet
     * @throws java.sql.SQLException
     */
    public static int executeUpdateReturnId(String sql) throws SQLException {
        Statement st = ConexaoBD.getInstance().getConnection().createStatement();
        st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet chave = st.getGeneratedKeys();
        chave.next();
        int id = chave.getInt(1);
        return id;
    }

    /**
     * Executa uma consulta no banco de dados
     *
     * @param sql: query a ser executada
     * @return ResultSet
     * @throws java.sql.SQLException
     */
    public static ResultSet executeQuery(String sql) throws SQLException {
        return ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);
    }

    /**
     * Efetua o fechamento da conexao
     */
    public void shutdown() {
        try {
            conexao.close();
            instancia = null;
            conexao = null;
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

}
