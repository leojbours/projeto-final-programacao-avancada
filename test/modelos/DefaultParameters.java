/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.time.LocalDate;

/**
 *
 * @author leonardo
 */
public class DefaultParameters {
    
    public static final class Pessoa {
        public static final int COD_PESSOA = 1;
        public static final String NOME_PESSOA = "LEO";
        public static final String CPF = "12345678910";
        public static final String PASSAPORTE = "ABC1234";
        public static final LocalDate DATA_NASCIMENTO = LocalDate.parse("2005-09-15");
        public static final Character SEXO = 'M';
        public static final String NUM_CELULAR = "51987654321";
        public static final String ESTADO_CIVIL = "SOLTEIRO";
        
        public static final String NOME_EDITADO = "LEO2";
        public static final String CPF_EDITADO = "10987654321";
        
        public static final String CREATE_TABLE = "CREATE TABLE pessoa ( cod_pessoa SERIAL NOT NULL, "
                                                + "cod_endereco INT NOT NULL, "
                                                + "nom_pessoa VARCHAR(255) NOT NULL, "
                                                + "cpf CHAR(11), "
                                                + "passaporte VARCHAR(16), "
                                                + "dat_nascimento DATE NOT NULL, "
                                                + "sexo CHAR(1) NOT NULL, "
                                                + "num_celular CHAR(11) NOT NULL, "
                                                + "estado_civil VARCHAR(64) NOT NULL, "
                                                + "ativo BOOLEAN NOT NULL DEFAULT TRUE, "
                                                + "CONSTRAINT PK_pessoa PRIMARY KEY (cod_pessoa), "
                                                + "CONSTRAINT FK_pessoa_endereco FOREIGN KEY (cod_endereco) REFERENCES endereco );";
        
        public static final String TRUNCATE_TABLE = "TRUNCATE TABLE pessoa RESTART IDENTITY;";
        
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS pessoa CASCADE";
    }
    
    public static final class Cidade {
        public static final int COD_CIDADE = 1;
        public static final String NOME_CIDADE = "SANTA CLARA DO SUL";
        public static final String UF = "RS";
        
        public static final String CREATE_TABLE = "CREATE TABLE cidade ( cod_cidade SERIAL NOT NULL, "
                                                + "nom_cidade VARCHAR(255) NOT NULL, "
                                                + "uf CHAR(2) NOT NULL, "
                                                + "ativo BOOLEAN NOT NULL DEFAULT TRUE, "
                                                + "CONSTRAINT PK_cidade PRIMARY KEY (cod_cidade));";
        
        public static final String TRUNCATE_TABLE = "TRUNCATE TABLE cidade RESTART IDENTITY CASCADE;";
        
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS cidade CASCADE";
    }
    
    public static final class Endereco {
        public static final int COD_ENDERECO = 1;
        public static final String CEP = "95915000";
        public static final String LOGRADOURO = "AVENIDA 28 DE MAIO";
        public static final String NUMERO = "S/N";
        public static final String COMPLEMENTO = "COMPLEMENTO";
        public static final String BAIRRO = "CENTRO";
        
        public static final String CREATE_TABLE = "CREATE TABLE endereco ( cod_endereco SERIAL NOT NULL, "
                                                + "cod_cidade INT NOT NULL, "
                                                + "logradouro VARCHAR(255) NOT NULL, "
                                                + "numero VARCHAR(32) NOT NULL, "
                                                + "bairro VARCHAR(255) NOT NULL, "
                                                + "complemento VARCHAR(255) NOT NULL, "
                                                + "cep VARCHAR(8) NOT NULL, "
                                                + "CONSTRAINT PK_endereco PRIMARY KEY (cod_endereco),"
                                                + "CONSTRAINT FK_endereco_cidade FOREIGN KEY (cod_cidade) REFERENCES cidade);";
        
        public static final String TRUNCATE_TABLE = "TRUNCATE TABLE endereco RESTART IDENTITY CASCADE;";
        
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS endereco CASCADE";
    }
}
