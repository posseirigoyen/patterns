package util;
import java.util.*;


public class Permutations{
    //permut me contiene todas las permutaciones con reemplazo
    //newList es la lista que en todas las posiciones tiene el primer elemento
    public static <T> LinkedList<LinkedList<T>> permutationsWithReplacement (LinkedList<T> list,int size){
        LinkedList<LinkedList<T>> permut=new LinkedList<>();
        LinkedList<T> newList=new LinkedList<>();
        for (int i=0;i<size;i++){
                newList.add(list.getFirst());
             } 
        permut.add(newList);
        permutationsRecursion(list,newList,size,0,permut);
        return permut;
    }
    
    //Pass e iter son componentes de la recursion, perms es la lista de permutaciones
    private static <T> void permutationsRecursion (LinkedList<T> list,LinkedList<T> pass,int size,int iter,LinkedList<LinkedList<T>> perms){
          if (iter<size){
            for (int i=0;i<list.size();i++){
                 //crea una nueva lista, va a contener una permutacion
                 LinkedList<T> newPerm=new LinkedList<>();
                 //añade todo lo que habia en la lista pasada por recursion
                 newPerm.addAll(pass);
                 T aux2=list.get(i);
                 T aux3=newPerm.get(iter);
                 //cambia la letra en la posicion dada por el iterador recursivo, por la letra dada por el for, siempre que sean diferentes
                 //de esta forma, va creando cada nueva permutacion de a una
                 if (aux3!=aux2){
                     newPerm.set(iter,aux2);
                     //añade la nueva permutacion a la lista de permutaciones
                     perms.addLast(newPerm);
                 }
            //llama a la recursion con mi nueva permutacion, e incrementando en 1 el iterador de la recursion
            permutationsRecursion(list,newPerm,size,iter+1,perms);
         }
        }
    }
}
