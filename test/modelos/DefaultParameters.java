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
        public static final String NOME_PESSOA = "Leo";
        public static final String CPF = "12345678910";
        public static final String PASSAPORTE = "ABC1234";
        public static final LocalDate DATA_NASCIMENTO = LocalDate.parse("2005-09-15");
        public static final char SEXO = 'M';
        public static final String NUM_CELULAR = "51987654321";
        public static final String ESTADO_CIVIL = "Solteiro";
    }
    
    public static final class Cidade {
        public static final int COD_CIDADE = 1;
        public static final String NOME_CIDADE = "Santa Clara do Sul";
        public static final String UF = "RS";
    }
    
    public static final class Endereco {
        public static final int COD_ENDERECO = 1;
        public static final String CEP = "95915000";
        public static final String LOGRADOURO = "Avenida 28 de Maio";
        public static final String NUMERO = "S/N";
        public static final String COMPLEMENTO = "Complemento";
        public static final String BAIRRO = "Centro";
    }
}
