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
    
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        fileReader();
    }
    
    public static void fileReader() throws FileNotFoundException, IOException{
        BufferedReader br=new BufferedReader(new FileReader("sample.java"));
        String temp="";
        
        while((temp=br.readLine())!=null){
              int length=temp.length();
              
              String temp2="";
              
              for (int i = 0; i <length ; i++) {
                if(temp.charAt(i)==';'){
                     removeDS(temp2);
                     process(temp2);
                     
                    temp2=""; 
                }else{
                   temp2=temp2+temp.charAt(i);
                }
                
            }
              
              if(!temp.contains(";")){
                   removeDS(temp);
                   process(temp);
                }
              
        
        
        }// End of reading whole file
        
        
        
    }// End of function fileReader
    
    
    public static String removeDS(String s){
       s=s.trim();
      String temp=s.charAt(0)+"";
       for (int i = 1; i <s.length(); i++) {
          if(s.charAt(i)==' '){
             if(s.charAt(i-1)!=' '){
                temp=temp+s.charAt(i);
             }
          }else{
             temp=temp+s.charAt(i);
          }
          
       }
       System.out.println(temp);
       return temp;
    }
    
    
    public static void process(String s){
        s=s.trim();
        int length=s.length();
        int bp_s=0;
        int bp_e=0;
        for (int i = 0; i < length; i++) {
           // If we look at the regex expressions for int float we have got keywords/\
            if(s.charAt(i)==' '){
               
            }
        }
     
    }
    
    public static void keyWords(){
       
    }
    
    public static int searchByChar(String ar[], char q[]){
       for (int i = 0; i < ar.length; i++) {
          for (int j = 0; j < q.length; j++) {
             if(ar[i].charAt(j)!=q[j]){
                return -1;
             }
          }
          return i;
       }
       
       return -1;
    }// End of method searchbyChar
}
