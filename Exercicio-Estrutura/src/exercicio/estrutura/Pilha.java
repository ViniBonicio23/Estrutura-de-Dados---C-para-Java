/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio.estrutura;

/**
 *
 * @author arthu
 */
public class Pilha {
    public int capacidade = 5;
    public Funcionario[] dados = new Funcionario[capacidade];
    public int topo = -1;
    
    public int tamanho() {
        return topo + 1;
    }
    
    public void empilha(Funcionario p_valor) throws Exception{
        if (tamanho() != capacidade){
            topo++;
            dados[topo] = p_valor;
        }
        else {
            throw new Exception("A pilha está cheia!!!");
        }
    }
    
    public Funcionario desempilha() throws Exception {
        if (tamanho() == 0){
            throw new Exception("A pilha está vazia!!!");
        } else {
            Funcionario retorno = dados[topo];
            dados[topo] = null;
            topo--;
            return retorno;
        }
    }
    
    public Funcionario retornaTopo() throws Exception {
        if (tamanho() == 0)
            throw new Exception("A pilha está vazia!!!");
        else
            return dados[topo];
    }
}
