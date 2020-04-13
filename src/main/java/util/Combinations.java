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
public class Combinations{
    //arr es el arreglo que contiene los simbolos posibles, size es el tamaño de "palabra"
    public static <T> LinkedList<LinkedList<T>> comb (LinkedList<T> list,int size){
        LinkedList<LinkedList<T>> comb=new LinkedList<>();
        LinkedList<T> newlist=new LinkedList<>();
        for (int i=0;i<list.size();i++){
                newlist.add(list.getFirst());
             } 
        return combaux(list,newlist,size,0,comb);
    }
    
    //pass e iter son componentes recursivos, comb es la lista de las combinaciones
    private static <T> LinkedList<LinkedList<T>> combaux (LinkedList<T> list,LinkedList<T> pass,int size,int iter,LinkedList<LinkedList<T>> comb){
        
        if (iter!=size){
         for (int i=0;i<list.size();i++){
             LinkedList<T> aux=pass;
             aux.set(iter,list.get(i));
             comb.add(aux);
             combaux(list,aux,size,iter++,comb);
         }
        }
        return comb;
    }
}
