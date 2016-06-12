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
    
    static String keyWords[]={"int", "float", "double", "String", "while", "for", "if", "else if", "else", "char"};
    static Stack<String> keywordsS=new Stack<String>();
    static Stack<String> idendifiersS=new Stack<String>();
    static Stack<Character> quotes=new Stack<Character>();
    static Stack<Character> values=new Stack<Character>();
    
    static String MOperators[]={"+", "-", "=", "*", "/"};
    static Stack<String> MOperatorsS=new Stack<String>();
    
    static String LOperators[]={"==", ">", "<", ">=", "<=", "!", "!="};
    static Stack<String> LOperatorsS=new Stack<String>();
    
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        fileReader();
        System.out.println("Keywords : "+keywordsS.toString());
        System.out.println("Identifiers: "+idendifiersS.toString());
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
       //System.out.println(temp);
       return temp;
    }
    
    
    public static void process(String s){
        System.out.println(s);
       char temp[]=s.toCharArray();
       int length=temp.length;
        
       /*
        So, I have taken the string in the char array . 
        Now a loop is needed to complete the thing . 
        The loop will start from 0 and will go through the whole array . 
       */
        String t="";
        for (int i = 0; i < length; i++) {
             // As we don't need to do anything if we see a space
            
            if (temp[i]!=' ' && temp[i]!=',' && temp[i]!= '=') {
                
                // The below if condition is for checking the double or single quote thing
                if(temp[i]=='\'' || temp[i]=='"'){
                    
                    if(quotes.peek()==temp[i]){
                        quotes.pop();
                    }else{
                       quotes.push(temp[i]); 
                    } 
                }// If condition for quotes end here
                
                /*
                The actual work /process is starting here 
                */
               
                if(quotes.empty()){
                    t=t+String.valueOf(temp[i]); 
                    // Sob kichu jomacchi checking er jonne 
                }
            }// if Condition for space checking is done here
            
            //When we got a space we know that we have got a keyword . Bcz in java there must be a space after an int , string or double etc
            else if(temp[i]==' '){
                // Now we have got a thing which can be a keyword or can be an identifier.
                // First check for a key word .
                if (keyWords(t)) {
                    // We have not previously inserted it Then 
                   // System.out.println(keywordsS.indexOf(t));
                    if(keywordsS.indexOf(t)==-1){
                        keywordsS.push(t);
                    }
                     t="";
                }// End of data type checking 
                
                
                
               
            }// End of else if found space
            //System.out.println(temp[i]);
            else if(temp[i]==','){
                 if(idendifiersS.indexOf(t)==-1 && (t!="") || (t!=" ")){
                    idendifiersS.push(t);
                 }
                t="";
            }// This is for if we have found ,
            
            /*
             else if(temp[i]=='='){
                 
                 if(MOperatorsS.indexOf(temp[i])==-1 && t!=""){
                    MOperatorsS.push(t);
                 }
                 System.out.println(t);
                 if(idendifiersS.indexOf(t)==-1 && t!=""){
                    idendifiersS.push(t);
                 }
                t="";
            }// This is for if we have found ,
            */
        }// The for the loop which iterates through the whole char array namely temp
        
        

     
    }// End of function process
    
    public static boolean keyWords(String s){
        int length =keyWords.length;
        char searc[]=s.toCharArray();
        for (int i = 0; i < keyWords.length; i++) {
            char temp[]=keyWords[i].toCharArray();
            if(searc.length==temp.length){
                for (int j = 0; j < temp.length; j++) {
                if (searc[j]!=temp[j]) {
                    break;
                }
                if(j==temp.length-1){
                    return true;
                }
            }
            }
        }
        
        return false;
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
