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
    public static Set<String> mostFrequentPatterns(final String text, final int k) {
        LinkedList<String> dict=new LinkedList<>();
        dict.add("A");dict.add("C");dict.add("G");dict.add("T");
        LinkedList<LinkedList<String>> combin;
        combin = Combinations.comb(dict,k);  
        int maxcount=0;
        Set<String> set=new HashSet<>();
        for (int i=0;i<combin.size();i++){
            int count=patternCount(text,combin.get(i));
            if (count==maxcount){
                set.add(combin.get(i).toString());
            }
            if (count>maxcount){
                set.clear();
                set.add(combin.get(i).toString());
                maxcount=count;
            }
        }
        return set;
    }
    
    private static int patternCount(String text, LinkedList<String> pattern){
        int size=text.length();
        int patsize=pattern.size();
        int count=0;
        int aux=1;
        for (int i=0;i<=size-patsize;i++){
            String a=Character.toString(text.charAt(i));
            String b=pattern.get(0);
            if (a.equals(b)){
                    aux=0;
                    for (int j=i+1;j<i+patsize;j++){
                      String c=Character.toString(text.charAt(j));
                         String d=pattern.get(j-i);
                         if (!(c.equals(d))){
                          aux=1; 
                          break;
                         }      
                    }
                }
                if (aux==0){
                    count++;
                    i=i+2;
                }
                aux=1;
            }
        
        return count;
    }
    
    private String toString(LinkedList<String> list){
        String str=list.get(0);
        for (int i=1;i<list.size();i++){
            str.concat(list.get(i));
        }
        return str;
    }
}
