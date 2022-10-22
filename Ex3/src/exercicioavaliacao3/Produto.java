/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicioavaliacao3;

import java.util.Scanner;

/**
 *  Francisco Antonio da Cruz Faria
 *  2019227649
 */

/**
 * 
 * 
 */
class Produto{
    //inicializacao dos atributos da class produto como private
    private String nome;
    private float preco;
    private String validade;
    private int stock;
    
    /*
     * construtores
     */
    public Produto(){
    }
    public Produto(String nome,String validade,float preco,int stock){
        //inicializa todas os atributos com os valores dados como argumentos
        setNome(nome);
        setValidade(validade);
        setPreco(preco);
        setStock(stock);
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @return the validade
     */
    public String getValidade() {
        return validade;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }
    
    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        //confirmar se o preco e valido
        if (preco>0){
            this.preco = preco;
        }
        else{
            //no caso que não seja valido informa o utilizador
            System.out.println("Preco invalido");
        }
    }

    /**
     * @param validade the validade to set
     */
    public void setValidade(String validade) {
        this.validade = validade;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        //confirmar se o valor do stock e valido
        if (stock>=0){
            this.stock = stock;
        }
        else{
            //no caso que não seja valido informa o utilizador
            System.out.println("stock invalido");
        }
    }
    
    /**
     * Venda de	produtos
     * @param quant quantidade do produto que se pretende vender 
     */
    public void sell(int quant){
        
        //verifica se tem quantidade em stock suficiente para a venda
        if (quant<=getStock()){
            
            //retirar do stock a quantidade vendida
            setStock(getStock()-quant);
            
            //informar o utilizador do sucesso na venda demonstrando o custo e o stock restante
            System.out.println("Vendido: "+getNome()+" - "+quant+ " unidades no valor de "+(getPreco()*quant)+"€");
            System.out.println("Restam "+getStock()+" unidades de "+getNome());
        }
        
        //avisa o utilizador que nao tem stock suficiente
        else{
            System.out.println("stock insuficiente!");
        }
    }
    
    /**
     * @return valor total de um determinado produto
     */
    public float totalValue(){
        return getStock()*getPreco();
    }
    
    /**
     * @return string com as atributos do produto
     */
    public String toString(){
        //inicializa o string com as informacoes pretendidas
        String a="Produto="+getNome()+"\n"+
               "Validade="+getValidade()+"\n"+
               "Preço="+getPreco()+"€\n"+
               "Stock="+getStock()+"\n";
        
        //devolve o string
        return a;
    }
}