/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns;

import java.util.*;
import util.TextPatternUtils;

/**
 *
 * @author Emi
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Set<String> test=TextPatternUtils.mostFrequentPatterns("AAGTAAGACCCACTGATCAC", 3);
        System.out.println(test);
    }
    
}
