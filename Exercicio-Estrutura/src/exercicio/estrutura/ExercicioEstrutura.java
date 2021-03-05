/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio.estrutura;

import java.util.Scanner;

/**
 *
 * @author arthu
 */
public class ExercicioEstrutura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        int opcao = 0;
        String valor;
        Pilha minhaPilha = new Pilha();
        Funcionario f;
        Scanner s = new Scanner(System.in);
        
        do {
            System.out.print("\n\n Escolha: 1-> empilha 2->desempilha " +
                    " 3->topo 4-> tamanho 5->  Somar  6-> Listar " +
                    "7 -> remover a base  9-> sair : ");
            opcao = Integer.parseInt(s.nextLine());
            
            if (opcao == 1) {
            f = new Funcionario();
            System.out.print("-- Digite o nome que deseja Empilhar: ");
            f.nome = s.nextLine();
            System.out.print("-- Digite o salario que deseja Empilhar: ");
            f.salario = Double.valueOf(s.nextLine()).doubleValue();
            minhaPilha.empilha(f);
        } else if (opcao == 2) {
            f = minhaPilha.desempilha();
            System.out.printf("-- Desempilhado: %s %2f \n\n", f.nome, f.salario);
        } else if (opcao == 3) {
            f = minhaPilha.retornaTopo();
            System.out.printf("-- Topo: %s %2f", f.nome, f.salario);
            System.out.printf("-- Tipo: %s %2f", minhaPilha.retornaTopo().nome, minhaPilha.retornaTopo().salario);
        } else if (opcao == 4) {
            System.out.printf("-- Tamanho da Pilha: %d", minhaPilha.tamanho());
        } else if (opcao == 5) {
            double soma = 0;
            Pilha pilhaAux = new Pilha();
            while (minhaPilha.tamanho() > 0) {
                soma += minhaPilha.retornaTopo().salario;
                pilhaAux.empilha(minhaPilha.desempilha());
            }
            while (pilhaAux.tamanho() > 0) {
                minhaPilha.empilha(pilhaAux.desempilha());
            }
            
            System.out.printf("Soma: %2f", soma);
        } else if (opcao == 6) {
            Pilha pilhaAux = new Pilha();
            while (minhaPilha.tamanho() > 0) {
                System.out.printf("%s %2f", minhaPilha.retornaTopo().nome, minhaPilha.retornaTopo().salario);
                pilhaAux.empilha(minhaPilha.desempilha());
            }
            
            while (pilhaAux.tamanho() > 0) {
                minhaPilha.empilha(pilhaAux.desempilha());
            }
        } else if (opcao == 7) {
            Pilha pilhaAux = new Pilha();
            while (pilhaAux.tamanho() > 1) {
                minhaPilha.empilha(pilhaAux.desempilha());
            }
            System.out.printf("%s %2f", minhaPilha.retornaTopo().nome, minhaPilha.retornaTopo().salario);
            minhaPilha.desempilha();
            
            while (pilhaAux.tamanho() > 0)
                minhaPilha.empilha(pilhaAux.desempilha());
        }
        } while (opcao != 9);
    }
    
}
