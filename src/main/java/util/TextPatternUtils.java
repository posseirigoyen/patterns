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
        
        
    }

}
