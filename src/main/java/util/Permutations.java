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
public class Permutations{
    //arr es el arreglo que contiene los simbolos posibles, size es el tamaño de "palabra"
    public static <T> LinkedList<LinkedList<T>> permutationsWithReplacement (LinkedList<T> list,int size){
        LinkedList<LinkedList<T>> comb=new LinkedList<>();
        LinkedList<T> newlist=new LinkedList<>();
        for (int i=0;i<size;i++){
                newlist.add(list.getFirst());
             } 
        comb.add(newlist);
        permutationsRecursion(list,newlist,size,0,comb);
        return comb;
    }
    
    //pass e iter son componentes recursivos, comb es la lista de las combinaciones
    private static <T> void permutationsRecursion (LinkedList<T> list,LinkedList<T> pass,int size,int iter,LinkedList<LinkedList<T>> comb){
        
        if (iter<size){
         for (int i=0;i<list.size();i++){
             LinkedList<T> aux=new LinkedList<>();
             aux.addAll(pass);
             T aux2=list.get(i);
             T aux3=aux.get(iter);
             if (aux3!=aux2){
                aux.set(iter,aux2);
                comb.addLast(aux);
             }
             permutationsRecursion(list,aux,size,iter+1,comb);
         }
        }
    }
}
