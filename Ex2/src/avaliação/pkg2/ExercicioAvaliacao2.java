/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaliação.pkg2;

import java.util.Scanner;

/**
 *
 * @author faria
 */
public class ExercicioAvaliacao2 {
    public static void main(String[] args) {
        System.out.println("-----Start-----");
        
        //requests the number of lines from the user and saves the value in the variable nLin
        System.out.print("number of lines of the irregular array:");
        Scanner sc=new Scanner(System.in);          
        int nLin=sc.nextInt();
        
        //requests the maximum number of columns from the user and saves the value in the variable nCol
        System.out.print("maximum number of columns:");
        sc=new Scanner(System.in);          
        int nCol=sc.nextInt();
        
        //requests the maximum array value from the user and saves the value in the variable max
        System.out.print("maximum array value:");
        sc=new Scanner(System.in);          
        int max=sc.nextInt();
        
        //requests the minimum array value from the user and saves the value in the variable min
        System.out.print("minimum array value:");
        sc=new Scanner(System.in);          
        int min=sc.nextInt();
        
        //initialize an irregular array and use the random method to fill the lines with values between min and max
        int[][] irregular = new int[nLin][];
        random(irregular,nCol+1,min,max);
        
        //displays the irregular array to be sorted
        System.out.println("-----Inicial Array-----");
        printArray(irregular);
        
        //using the method´ordMtriz arrange the array to have the sum of the lines in an ascending order
        ordArray(irregular);
        
        //display the sorted array
        System.out.println("-----Final Array-----");
        printArray(irregular);
        
        System.out.println("-----End-----");
    }
    
    
    /**
     * print the array arr
     * @param arr array of ints
     */
    public static void printArray(int[][] arr){
        
        //a takes the values of the array lines
        for (int[] a:arr){ 
            
            //b represents the values within the array a
            for(int b:a){
                
                //print b
                System.out.printf(b+"  "); 
                
            }
            
            //change the line
            System.out.println("");
        }
    }
    
    
    
    
    
    /**
     * arrange the array to have the sum of there lines in an ascending order
     * @param arr array of ints
     */
    public static void ordArray(int[][] arr){
        
        //nlin correspondes to the number of lines that the Array has
        int nLin = arr.length;
        
        //initialization of the variables where the sums will be stored
        int sum1=0;
        int sum2=0;
        
        //initialization of the arrays where the lines being compared are
        int a[];
        int b[];
        
        
        for(int i=0;i<nLin;i++){
            a=arr[i];
            
            //assign the sum of a to sum1 by using the method sumArray
            sum1=sumArray(a);
            
            for(int x=i+1;x<nLin;x++){
                //assign rows with index greater than i to b
                b=arr[x];
                
                //assign the sum of b to sum2
                sum2=sumArray(b);
                
                //if the sum of a is greater than that of b, or if the sums are equal and a has more elements than b, then switch the lines a and b
                if(sum1>sum2 || (sum1==sum2 && a.length>b.length)){
                    
                    //switch lines
                    arr[i]=b;
                    arr[x]=a;
                    
                    //update the values of index i
                    a=arr[i];
                    sum1=sumArray(a);
                    
                }
                sum2=0;
            }
            sum1=0;
        }
    }
    
    
    
    
    /**
     * recieves an array and returns the sum of the values in that array
     * @param arr array of ints
     * @return the sum of the values of arr
     */
    public static int sumArray(int[] arr){
        int sum=0;
        for(int x:arr){
                    sum+=x;
        }
        return sum;
    }
    
    
    
    /**
     * fills in the values of an irregular array
     * @param arr bi-dimensional array
     * @param maxCol max number of columns
     * @param min minimum array value
     * @param max maximum array value
     */
    public static void random(int[][] arr,int maxCol,int min,int max){
        for(int x=0;x<arr.length;x++){
            
            //determines the number of elements that will be in the line x
            int c=(int)(Math.random()*(maxCol));
            
            //memory allocation for array arr
            arr[x]=new int[c];
            
            //fill in  the line with random value sbetween min and max
            for(int y=0;y<c;y++){
                arr[x][y]=(int) ((Math.random()*(max-min))+min);
            }
            
        }
    }
}
