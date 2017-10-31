/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passbyvalue;

/**
 *
 * @author chris_000
 */
public class PassByValue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int x= 1; 
        System.out.print("addFive " +addFive(x));
       System.out.print("\nx "+x);
 
    }
static public int addFive(int x){
    x=x+5;
    return x;
}    
}
