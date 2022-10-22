/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio.avaliação.pkg1;

import java.util.Scanner;

/**
 *
 * @author Francisco António Da Cruz Faria
 * numero de estudante ->2019227649
 * TP5
 */
public class ExercicioAvaliacao1 {
    public static void main(String[] args) {
        
        System.out.println("---------INICIO---------------");
        
        /*
        Pedir ao utilizador o numero de linhas pretendido para a piramide e guardar 
        esse valor na variavel N
        */
        System.out.print("insira o numero de linhas:");
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();

        /*
        verificar se o numero de linhas esta dentro dos aceites,isto é se esta entre 1 e 12,caso nao esteja 
        informa-se o utilizador deste erro e indica-se o intervalo possivel para N
        */
        if (N>=1 && N<=12){
             triangulo(N);
        }
        else{
            System.out.println("o numero inserido nao e valido, tem de pertencer ao intervalo de 1 a 12");
        }
        
        System.out.println("-------------FIM---------------");
    }
    
    /**
     * recebe um número inteiro, calcula e devolve o seu fatorial;
     * @param n numero inteiro do qual se quer saber o fatorial
     * @return devolve o fatorial de n
     */
    public static int fatorial (int n){
        
        //variavel na qual ira estar o valor do fatorial
        int fat=1;
        
        //ciclo onde se calcula o fatorial
        while(n>0){
            fat=fat*n;
            n=n-1;
        }
        
        //devolve-se o fatorial de n
        return fat;
    }
    /**
     * recebe o numero de linhas do triangulo pretendido e apresenta-o.
     * as letras apresentadas correspondem aos valores entre 1 e 26,sendo ‘A’´o 1 e ‘Z’ o 26, Caso seja ultrapassado o valor 26, volta ao início do alfabeto.
     * determina-se a letra a usar calculando as combinaçoes de n, k a k, em que n é o número da linha do triângulo e k é o k-ésimo elemento dessa linha.
     * @param linhas numero de linhas da piramide 
     */
    public static void triangulo (int linhas) {
        
        //n e a linha que esta a ser escrita,sendo que a primeira linha corresponde a zero
        int n=0;
        
        //variavel onde se vai guardar o num de combinacoes para um determinado n e k
        int numComb;
        
        //ciclo que apresenta o triangulo
        while(n<linhas){
            
            //insere os espaços antes do numero de modo a ganhar a forma de piramide,a medida que se vai escrevendo linhas vai-se diminuindo o numero de espaços
            for(int i=1;i<linhas-n;i++){
                System.out.print(" ");
            }
            
            //este ciclo calcula e imprime as letras
            for (int k=0;k<=n;k++){
                
                numComb=fatorial(n)/(fatorial(k)*fatorial(n-k));
                
                //reduz o numComb de modo a pertencer ao intervalo descrito pelas letras
                while(numComb>26){
                    numComb=numComb-26;
                }
                
                //adiciona-se o 64 pois o caracter A corresponde ao codigo ascii 65
                numComb=numComb+64;
                
                //imprime a letra
                System.out.printf("%c ",numComb);
                
            }
            //muda-se de linha
            System.out.println();
            n++;
            
        }
    }
}
