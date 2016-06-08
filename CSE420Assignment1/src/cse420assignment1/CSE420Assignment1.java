/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse420assignment1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

/**
 *
 * @author Koushik
 */
public class CSE420Assignment1 {

    /**
     * @param args the command line arguments
     */
    
    static String keyWords[]={"int", "float", "double", "String", "while", "for", "if", "else if", "else"};
    static Stack<String> keywordsS=new Stack<String>();
    
    
    static String MOperators[]={"+", "-", "=", "*", "/"};
    static Stack<String> MOperatorsS=new Stack<String>();
    
    static String LOperators[]={"==", ">", "<", ">=", "<=", "!", "!="};
    static Stack<String> LOperatorsS=new Stack<String>();
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static void fileReader() throws FileNotFoundException, IOException{
        BufferedReader br=new BufferedReader(new FileReader("sample.txt"));
        String temp="";
        
        while((temp=br.readLine())!=null){
              int length=temp.length();
              
              String temp2="";
              
              for (int i = 0; i <length ; i++) {
                if(temp.charAt(i)==';'){
                     process(temp2);
                    temp2=""; 
                }
            }
        
        
        }// End of reading whole file
        
        
        
    }// End of function fileReader
    
    public static void process(String s){
        s=s.trim();
        int length=s.length();
        
        for (int i = 0; i < length; i++) {
            
        }
     
    }
}
