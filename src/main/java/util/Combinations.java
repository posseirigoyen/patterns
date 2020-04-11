/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.util.*;
/**
 *
 * @author Emi
 */
public class Combinations {
    //arr es el arreglo que contiene los simbolos posibles, size es el tamaño de "palabra"
    public static LinkedList<Object[]> comb (Object[] arr,int size){
        LinkedList<Object[]> comb=new LinkedList<>();
        Object[] newarr=new Object[size];
        for (int i=0;i<newarr.length;i++){
                newarr[i]=arr[0];
             } 
        return combaux(arr,newarr,size,0,comb);
    }
    
    //pass e iter son componentes recursivos, comb es la lista de las combinaciones
    private static LinkedList<Object[]> combaux (Object[] arr,Object[] pass,int size,int iter,LinkedList<Object[]> comb){
        
        if (iter!=size){
         for (int i=0;i<arr.length;i++){
             Object[] aux=pass;
             aux[iter]=arr[i];
             comb.add(aux);
             combaux(arr,aux,size,iter++,comb);
         }
        }
        return comb;
    }
}
