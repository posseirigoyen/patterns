
package patterns;

import java.util.*;
import util.TextPatternUtils;


public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Set<String> test=TextPatternUtils.mostFrequentPatterns("ACAACTATGCATACTATCGGGAACTATCCT", 5);
        System.out.println(test);
    }
    
}
