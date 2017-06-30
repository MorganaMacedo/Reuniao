/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reuniaoprogit;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author morga
 */
public class CorpoFuncionario {

    private List<FuncionarioEmpresa> lista;

    public List<FuncionarioEmpresa> getLista() {
        return lista;
    }

    public void setLista(List<FuncionarioEmpresa> lista) {
        this.lista = lista;
    }

    public CorpoFuncionario(List<FuncionarioEmpresa> lista) {
        this.lista = lista;
    }

    private String horaReunião(int j) {
        String saida;

        if (j == 0) {
            saida = "0" + (j + 7) + ":00 - " + "0" + (j + 8) + ":00";
        } else if (j == 1) {
            saida = "0" + (j + 7) + ":00 - " + (j + 8) + ":00";
        } else {
            saida = (j + 7) + ":00 - " + (j + 8) + ":00";
        }

        return saida;
    }
    private String integrantes(int i, int j) {
       String saida = "";

        for (FuncionarioEmpresa fe : lista) {
            if (fe.getReuniao()[i][j] == 0) {
                saida = saida + fe.getNome() + "\n";
            }
        }

        return saida;
    }
 public String marcaReuniao() {
        int[][] matriz = new int[16][31];
        int i, j, k = 0, l = 0, m = 0;

        for (i = 0; i < 16; i++) {
            for (j = 0; j < 31; j++) {
                matriz[i][j] = 0;
            }
        }

        for (FuncionarioEmpresa fe : lista) {
            for (i = 0; i < 16; i++) {
                for (j = 0; j < 31; j++) {
                    if (fe.getReuniao()[i][j] == 0) {
                        matriz[i][j]++;
                    }
                }
            }
        }

        for (j = 0; j < 31; j++) {
            for (i = 0; i < 16; i++) {
                if (matriz[i][j] > m) {
                    k = i;
                    l = j;
                    m = matriz[i][j];
                }
            }
        }

        for (i = 0; i < 16; i++) {
            for (j = 0; j < 31; j++) {
                System.out.print(" " + matriz[i][j]);
            }
            System.out.println("\n");
        }

        return "A próxima data disponível para a reunião é dia "+(l+1)+" no horário "+horaReunião(k)+". Poderão participar:\n\n"+integrantes(k, l);
    }
    public CorpoFuncionario() {
         this.lista = new ArrayList<>();
    }
      public void insere(FuncionarioEmpresa fe) {
        lista.add(fe);
    }


}
