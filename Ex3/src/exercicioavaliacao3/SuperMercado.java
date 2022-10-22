/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicioavaliacao3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Francisco Antonio da Cruz Faria 
 * 2019227649
 */
public class SuperMercado {
    private ArrayList<Produto> sm; 
    private int nProdutos;
    
    //construtor
    public SuperMercado(){
        //inicializa array
        sm=new ArrayList<>();
        
        //pede ao utilizador o numero maximo de produtos que o supermercado pode ter
        Scanner sc = new Scanner(System.in);
        System.out.print("Numero de produtos no supermercado:");
        int n=sc.nextInt();
        
        //atribuicao do valor n a nProdutos
        nProdutos=n;
    }
    
    public static void main(String[] args) {
        //cria um supermercado
        SuperMercado s=new SuperMercado();
        
        System.out.println("-------Start--------");
        
        int escolha;
        Scanner sc = new Scanner(System.in);
        do {// Menu
            System.out.println("1 - Adiciona produto");
            System.out.println("2 - Vender Produto");
            System.out.println("3 - Lista de produtos");
            System.out.println("4 - Valor total dos produtos");
            System.out.println("0 - Sair");
            escolha = sc.nextInt();
            switch (escolha) {
                case 1:
                    s.newProduct();
                    break;
                case 2:
                    s.sellProduct();
                    break;
                case 3:
                    s.avaiableProducts();
                    break;
                case 4:
                    s.totalValue();
                    break;
                case 0:
                    System.out.println("-------End--------");
                    System.exit(0);
                default:
                    System.out.println("invalid number");
                    break;
            }
        } while (escolha != 0);
        
    }

    /**
     * adiciona um produto ao supermercado caso este tenha espaço para tal
     */
    public void newProduct(){
        System.out.println("--------Adicionar Produto-------");
        
        //caso o supermercado esteja cheio
        if (sm.size()==nProdutos){
            //avisa o utilizador que o supermercado não pode ter mais produtos
            System.out.println("Não é possível adicionar novos produtos");
        }
        //caso tenha espaco
        else{
            Scanner sc = new Scanner(System.in);
            
            //pede ao utilizador o nome do produto e guarda esse valor na variavel nome
            System.out.print("Produto: ");
            String nome=sc.nextLine();
            
            //pede ao utilizador a validade do produto e guarda esse valor na variavel validade
            System.out.print("Validade: ");
            String validade=sc.nextLine();
            
            //pede ao utilizador o preco unitario do produto e guarda esse valor na variavel preco
            System.out.print("preço: ");
            float preco=sc.nextFloat();
            
            //se o preco nao for maior que 0 pedir um novo valor
            while (preco<=0){
                System.out.println("0 preco tem de ser maior que 0");
                System.out.print("Novo preco: ");
                preco=sc.nextInt();
            }
            
            //pede ao utilizador o stock do produto e guarda esse valor na variavel stock
            System.out.print("Stock: ");
            int stock=sc.nextInt();
            
            //se o stock nao for maior que 0 pedir um novo valor para o stock
            while(stock<=0){
                System.out.println("0 stock tem de ser maior que 0");
                System.out.print("Novo stock: ");
                stock=sc.nextInt();
            }
            
            System.out.println("");
            //cria um novo produto com os atributos indicadas
            Produto b=new Produto(nome,validade,preco,stock);
            System.out.println("Produto adicionado com sucesso");
            
            //adiciona ao array produtos
            sm.add(b);
            
            //informa o utilizador do sucesso da adicao
            System.out.println("Produto adicionado ao Supermercado");
            System.out.println(sm.get(sm.size()-1).toString());
        }
    }
    
    /**
     * tenta vender um produto avisando o utilizador de eventuais erros na compra
     */
    public void sellProduct(){
        System.out.println("-----Vender produto-----");
        
        //criar um booleano que ira estar falso se o produto não existe e verdadeiro se ele existe
        boolean n=false;
        
        Scanner sc = new Scanner(System.in);
        
        //pede ao utilizador o nome do produto que pretende vender
        System.out.print ("Produto: ");
        String nome = sc.nextLine();
        
        //ciclo for que percorre todos os valores do array sm
        for(int i=0;i<nProdutos;i++){
            //confirma se esse produto existe no supermercado
            if (nome.equals(sm.get(i).getNome())){
                
                //se o produto existir ira perguntar a quantidade que se pretende vender e guardar esse valor na variavel num
                System.out.print("Quantidade: ");
                int num= sc.nextInt();
                
                //com recurso a funcao sell da class produto atualizar o stock e informar o utilizador de erros potenciais
                sm.get(i).sell(num);
                
                //defenir n=true de modo a confirmar que o produto que o utilizador pretende vender existe
                n=true;
                break;
            }
        }
        //se não existir o produto, informar o utilizador
        if (!n){
            System.out.println("Produto inexistente");
        }
        System.out.println("");
    }
    
    /**
     * imprime a lista dos produtos disponiveis e os seus atributos
     */
    public void avaiableProducts(){
        System.out.println("------Lista de produtos-----");
        
        //inicializa o sting list como vazio
        String list="";
        
        //ciclo for que percorre todos os valores do array sm 
        for(int i=0;i<nProdutos;i++){
            
            //adiciona as informacoes dos diferentes produtos ao string list
            list=list+sm.get(i).toString();
        }
        
        //imprime a lista
        System.out.println("PRODUTOS DISPONIVEIS:\n"+list);
    }
    
    /**
     * imprime o valor total dos produtos no supermercado
     */
    public void totalValue(){
        System.out.println("------Value-----");
        
        //inicializa o float v
        float v=0;
        
        //ciclo for que percorre todos os valores do array sm
        for(int i=0;i<nProdutos;i++){
            
            //soma o valor total de um certo produto ao v utilizando a funcao totalValue da class produto
            v=v+sm.get(i).totalValue();
        }
        
        //imprime o valor v
        System.out.println("valor total dos produtos existentes:"+ v);
    }
}
