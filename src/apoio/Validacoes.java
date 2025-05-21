/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apoio;

import javax.swing.JOptionPane;
import modelos.Pessoa;
import telas.CadastroPessoa;

/**
 *
 * @author leonardo.bourscheid
 */
public class Validacoes {
    
    public static boolean validaDocumentoInsercao(CadastroPessoa cadastroPessoa, Pessoa pessoa) {
         if (cadastroPessoa.getTxtCpf().getText().trim().equals("") && !cadastroPessoa.getTxtPassaporte().getText().trim().equals("")) {
                pessoa.setPasssaporte(cadastroPessoa.getTxtPassaporte().getText());
            } else if (!cadastroPessoa.getTxtCpf().getText().trim().equals("") && cadastroPessoa.getTxtPassaporte().getText().trim().equals("")) {
                pessoa.setCpf(cadastroPessoa.getTxtCpf().getText());
            } else if (!cadastroPessoa.getTxtCpf().getText().trim().equals("") && !cadastroPessoa.getTxtPassaporte().getText().trim().equals("")) {
                pessoa.setCpf(cadastroPessoa.getTxtCpf().getText());
                pessoa.setPasssaporte(cadastroPessoa.getTxtPassaporte().getText());
            } else {
                JOptionPane.showMessageDialog(null, "ERRO: pelo menos um dos campos, CPF ou PASSAPORTE, devem ser preenchidos");
                return false;
            }
         
         return true;
    }
    
}
