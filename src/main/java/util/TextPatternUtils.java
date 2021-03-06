package util;

import java.util.Set;
import java.util.*;

/**
 * Utilities for text pattern processing.
 *
 */
public final class TextPatternUtils {

    /**
     * Default constructor of class.
     * Made private to comply with style constraints.
     */
    private TextPatternUtils()  { }

    /**
     * Computes the most frequent patterns of size k in text.
     * @param text is the text where to compute the patterns
     * @param k is the size of the patterns to be computed
     * @return the set of most frequent patterns of size k in text.
     */
    public static Set<String> mostFrequentPatterns(final String text, final int k){
        
        Set<String> set=new HashSet<>();
        if (k<0){
            throw new IllegalArgumentException("k debe ser positivo");
        }
        
        if (text==null){
            throw new IllegalArgumentException("no puede ser texto nulo");
        }
        
        if (text.length()==0 || k==0 || text.length()<k){
            set.add("");
            return set;
        }
        
        //dict es mi "diccionario" de posibles simbolos, en este caso A C G T
        LinkedList<String> dict=new LinkedList<>();
        dict.add("A");dict.add("C");dict.add("G");dict.add("T");
        //perms va a tener todas las permutaciones posibles de los 4 simbolos
        LinkedList<LinkedList<String>> perms;
        perms = Permutations.permutationsWithReplacement(dict,k);  
        //maxcount lleva la cuenta de cual es la permutacion con mas apariciones.
        int maxcount=0;
        
        for (int i=0;i<perms.size();i++){
            int count=patternCount(text,perms.get(i));
            //si el patron analizado no tiene mas apariciones que el que tuvo mas, no cambia nada
            //si tiene misma cantidad que el que tuvo mas, lo agrega al set de patrones con mas apariciones
            if (count==maxcount){
                set.add(listToString(perms.get(i)));
            }
            //si el patron analizado aparece mas veces que maxcount, debo actualizar set, borrando lo que tenia
            //y añadiendo mi nuevo patron. Luego actualizo maxcount a la nueva cuenta maxima de apariciones.
            if (count>maxcount){
                set.clear();
                set.add(listToString(perms.get(i)));
                maxcount=count;
            }
        }
        return set;
    }
    
    //metodo para pasar de una linkedlist de strings a una string sola
    private static String listToString(LinkedList<String> list){
        String aux="";
        for (int i=0;i<list.size();i++){
            aux=aux.concat(list.get(i));
        }
        return aux;
    }
    //metodo que cuenta numero de apariciones de un patron en un texto
    private static int patternCount(String text, LinkedList<String> pattern){
        int size=text.length();
        int patsize=pattern.size();
        int count=0;
        int aux=1;
        //va hasta size-patsize, porque no es necesario analizar todo el texto si ya se que no me quedan suficientes 
        //caracteres para contener el patron
        for (int i=0;i<=size-patsize;i++){
            //como charAt me devuelve character y no string, lo paso de nuevo a string
            String a=Character.toString(text.charAt(i));
            String b=pattern.get(0);
            //si encuentra en el texto la misma letra con la que empieza el patron, chequea de a una las proximas letras
            //si encuentra todas, el patron esta, y aumenta la cuenta.
            //como ya se que el patron esta, salto patsize-1 letras adelante. de esta forma no me cuenta dos veces si hay un patron superpuesto con otro igual
            if (a.equals(b)){
                    aux=0;
                    for (int j=i+1;j<i+patsize;j++){
                      String c=Character.toString(text.charAt(j));
                         String d=pattern.get(j-i);
                         if (!(c.equals(d))){
                          //si una de las letras que siguen no es la correspondiente del patron, aux me lo indica
                          aux=1; 
                          break;
                         }      
                    }
                }
            //solo aumenta cuenta y cambia el i si el patron estuvo, es decir si aux es 0
                if (aux==0){
                    count++;
                    i=i+patsize-1;
                }
                aux=1;
            }
        
        return count;
    }
}
