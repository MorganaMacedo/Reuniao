/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reuniaoprogit;

/**
 *
 * @author morga
 */
import java.util.Random;

public class FuncionarioEmpresa {

    private String nome;
    private int[][] reuniao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int[][] getReuniao() {
        return reuniao;
    }

    public void setReuniao(int[][] reuniao) {
        this.reuniao = reuniao;
    }

    public FuncionarioEmpresa(String nome, int[][] reuniao) {
        this.nome = nome;
        this.reuniao = reuniao;
    }

    public void reuniaoMetodo() {
        this.reuniao = new int[16][31];
        Random ram = new Random();
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 31; j++) {
                this.reuniao[i][j] = ram.nextInt(8);
            }
        }
    }

    public FuncionarioEmpresa(String nome) {
        this.nome = nome;
        reuniaoMetodo();
    }

    public String[][] retornoReuniao(int inicio) {
        String[][] agendamentoRetorno;
        int fim;
        if (inicio + 6 >= 31) {
            fim = 31;
            agendamentoRetorno = new String[16][3];
        } else {
            fim = inicio + 6;
            agendamentoRetorno = new String[16][7];
        }

        for (int i = 0; i < 16; i++) {
            for (int j = inicio - 1; j < fim; j++) {
                switch (this.reuniao[i][j]) {
                    case 0:
                        agendamentoRetorno[i][j - inicio + 1] = "Ocioso";
                        break;
                    case 1:
                        agendamentoRetorno[i][j - inicio + 1] = "VHDL: Otimização circuitos";
                        break;
                    case 2:
                        agendamentoRetorno[i][j - inicio + 1] = "Performance";
                        break;
                    case 3:
                        agendamentoRetorno[i][j - inicio + 1] = "Novo Computador";
                        break;
                    case 4:
                        agendamentoRetorno[i][j - inicio + 1] = "Novo Smartphone";
                        break;
                    case 5:
                        agendamentoRetorno[i][j - inicio + 1] = "Processador";
                        break;
                    case 6:
                        agendamentoRetorno[i][j - inicio + 1] = "Memória";
                        break;
                    case 7:
                        agendamentoRetorno[i][j - inicio + 1] = "Jogos";
                        break;
                    default:
                        break;
                }
            }
        }
        return agendamentoRetorno;
    }

    public String[] retornaAgendamento(int inicio) {
        String[] retorno;
        int fim;
        if (inicio + 6 >= 31) {
            fim = 31;
            retorno = new String[3];
        } else {
            fim = inicio + 6;
            retorno = new String[7];
        }

        for (int j = inicio - 1; j < fim; j++) {
            retorno[j - inicio + 1] = "Dia " + (j + 1);
        }
        return retorno;
    }


}
