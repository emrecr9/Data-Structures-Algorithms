package com.example.Algorithms.DynamicProg;

import com.example.Algorithms.DynamicProg.Numbers.Fibonacci;
import com.example.Algorithms.DynamicProg.Numbers.bestSum;
import com.example.Algorithms.DynamicProg.Numbers.canSum;
import com.example.Algorithms.DynamicProg.Numbers.gridTraveler;
import com.example.Algorithms.DynamicProg.Numbers.howSum;
import com.example.Algorithms.DynamicProg.Strings.allConstruct;
import com.example.Algorithms.DynamicProg.Strings.canConstruct;
import com.example.Algorithms.DynamicProg.Strings.countConstruct;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Tester
{

    public static void main (String [] args)
    {
        /*
        Fibonacci fib = new Fibonacci();

        System.out.println(fib.fib(6));
        System.out.println(fib.fib(7));
        System.out.println(fib.fib(8));
        System.out.println(fib.fib(50));



        System.out.println(fib.fib(6, new HashMap<Integer, Integer>()));
        System.out.println(fib.fib(7, new HashMap<Integer, Integer>()));
        System.out.println(fib.fib(8, new HashMap<Integer, Integer>()));
        System.out.println(fib.fib(47, new HashMap<Integer, Integer>()));*/
        //-------------------------------------------------------------------
        /*
        gridTraveler gt = new gridTraveler();

        System.out.println(gt.gridTraveler(1, 1));
        System.out.println(gt.gridTraveler(2, 3));
        System.out.println(gt.gridTraveler(2, 3));
        System.out.println(gt.gridTraveler(3, 3));
        System.out.println(gt.gridTraveler(18, 18));

        System.out.println(gt.gridTraveler(1, 1, new HashMap<String, Integer>()));
        System.out.println(gt.gridTraveler(2, 3, new HashMap<String, Integer>()));
        System.out.println(gt.gridTraveler(2, 3, new HashMap<String, Integer>()));
        System.out.println(gt.gridTraveler(3, 3, new HashMap<String, Integer>()));
        System.out.println(gt.gridTraveler(10, 10, new HashMap<String, Integer>()));*/
        //----------------------------------------------------------------------------------
        /*canSum cs = new canSum();

        System.out.println(cs.canSum(7, new int[]{2, 3}));
        System.out.println(cs.canSum(7, new int[]{5,3,4,7}));
        System.out.println(cs.canSum(7, new int[]{2, 4}));
        System.out.println(cs.canSum(8, new int[]{2, 3, 5}));
        System.out.println(cs.canSum(300, new int[]{7, 14}));

        System.out.println(cs.canSum(7, new int[]{2, 3}, new HashMap<Integer, Boolean>()));
        System.out.println(cs.canSum(7, new int[]{5,3,4,7}, new HashMap<Integer, Boolean>()));
        System.out.println(cs.canSum(7, new int[]{2, 4}, new HashMap<Integer, Boolean>()));
        System.out.println(cs.canSum(8, new int[]{2, 3, 5}, new HashMap<Integer, Boolean>()));
        System.out.println(cs.canSum(300, new int[]{7, 14}, new HashMap<Integer, Boolean>()));
        */
        //----------------------------------------------------------------------------------

      /* howSum hs = new howSum();

        System.out.println(Arrays.toString(hs.howSum(7, new int[]{2, 3})));
        System.out.println(Arrays.toString(hs.howSum(7, new int[]{5,3,4,7})));
        System.out.println(Arrays.toString(hs.howSum(7, new int[]{2, 4})));
        System.out.println(Arrays.toString(hs.howSum(8, new int[]{2, 3, 5})));
        System.out.println(Arrays.toString(hs.howSum(300, new int[]{7, 14})));
        System.out.println(Arrays.toString(hs.howSum(7, new int[]{2, 3}, new HashMap<Integer, int []>())));
        System.out.println(Arrays.toString(hs.howSum(7, new int[]{5,3,4,7}, new HashMap<Integer, int []>())));
        System.out.println(Arrays.toString(hs.howSum(7, new int[]{2, 4}, new HashMap<Integer, int []>())));
        System.out.println(Arrays.toString(hs.howSum(8, new int[]{2, 3, 5}, new HashMap<Integer, int []>())));
        System.out.println(Arrays.toString(hs.howSum(300, new int[]{7, 14}, new HashMap<Integer, int []>())));
        */
        //----------------------------------------------------------------------------------
        /*bestSum bs = new bestSum();

        System.out.println(Arrays.toString(bs.bestSum(7, new int[]{5, 3, 4, 7})));
        System.out.println(Arrays.toString(bs.bestSum(8, new int[]{2,3,5})));
     //   System.out.println(Arrays.toString(bs.bestSum(7, new int[]{5, 3, 4, 7}, new HashMap<Integer, int []>())));
      //  System.out.println(Arrays.toString(bs.bestSum(8, new int[]{2,3,5}, new HashMap<Integer, int []>())));
      //  System.out.println(Arrays.toString(bs.bestSum(4, new int[]{1,2,3}, new HashMap<Integer, int []>())));
        //System.out.println(Arrays.toString(bs.bestSum(100, new int[]{1,2,5,25}, new HashMap<Integer, int []>())));
           */
        //----------------------------------------------------------------------------------

      //  String a = "pot", b = "potato";
      //  System.out.println(b.substring(a.length()));

        /*canConstruct cc = new canConstruct();

        System.out.println(cc.canConstruct("abcdef", new String[] {"ab", "abc", "cd", "def","abcd"}));
        System.out.println(cc.canConstruct("enterapotentpot", new String[] {"a", "p", "ent", "enter","ot", "o", "t"}));
        System.out.println(cc.canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[] {"e", "ee", "eee", "eeee","eeeee", "eeeeee"}));

        System.out.println(cc.canConstruct("abcdef", new String[] {"ab", "abc", "cd", "def","abcd"}, new HashMap<String, Boolean>()));
        System.out.println(cc.canConstruct("skateboard", new String[] {"bo", "rd", "ate", "t","ska", "sk", "boar"}, new HashMap<String, Boolean>()));
        System.out.println(cc.canConstruct("enterapotentpot", new String[] {"a", "p", "ent", "enter","ot", "o", "t"}, new HashMap<String, Boolean>()));
        System.out.println(cc.canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[] {"e", "ee", "eee", "eeee","eeeee", "eeeeee"}, new HashMap<String, Boolean>()));
        */
        /*countConstruct ctc = new countConstruct();

        System.out.println(ctc.countConstruct("purple", new String[] {"purp", "p", "ur", "le","purpl"}));
        System.out.println(ctc.countConstruct("abcdef", new String[] {"ab", "abc", "cd", "def","abcd"}));
        System.out.println(ctc.countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[] {"e", "ee", "eee", "eeee","eeeee", "eeeeee"}));
        System.out.println(ctc.countConstruct("purple", new String[] {"purp", "p", "ur", "le","purpl"}, new HashMap<String, Integer>()));
        System.out.println(ctc.countConstruct("abcdef", new String[] {"ab", "abc", "cd", "def","abcd"}, new HashMap<String, Integer>()));
        System.out.println(ctc.countConstruct("skateboard", new String[] {"bo", "rd", "ate", "t","ska", "sk", "boar"}, new HashMap<String, Integer>()));
        System.out.println(ctc.countConstruct("enterapotentpot", new String[] {"a", "p", "ent", "enter","ot", "o", "t"}, new HashMap<String, Integer>()));
        System.out.println(ctc.countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[] {"e", "ee", "eee", "eeee","eeeee", "eeeeee"}, new HashMap<String, Integer>()));
        */

        allConstruct alc = new allConstruct();

        System.out.println(alc.allConstruct("purple", new String[] {"purp", "p", "ur", "le","purpl"}));
        System.out.println(alc.allConstruct("abcdef", new String[] {"ab", "abc", "cd", "def","abcd", "ef", "c"}));
        System.out.println(alc.allConstruct("skateboard", new String[] {"bo", "rd", "ate", "t","ska", "sk", "boar"}));
   //     System.out.println(alc.allConstruct("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaz", new String[] {"a", "aa", "aaa", "aaaa","aaaaa"}));
       /* System.out.println(alc.allConstruct("purple", Arrays.asList("purp", "p", "ur", "le","purpl")));
        System.out.println(alc.allConstruct("abcdef", Arrays.asList("ab", "abc", "cd", "def","abcd", "ef", "c"),new HashMap<String, List<List<String>>>()));
        System.out.println(alc.allConstruct("skateboard", Arrays.asList("bo", "rd", "ate", "t","ska", "sk", "boar"),new HashMap<String, List<List<String>>>()));
        System.out.println(alc.allConstruct("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaz", Arrays.asList("a", "aa", "aaa", "aaaa","aaaaa")));*/


    }


}
