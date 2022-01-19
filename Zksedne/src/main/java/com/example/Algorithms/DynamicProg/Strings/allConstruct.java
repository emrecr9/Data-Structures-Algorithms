package com.example.Algorithms.DynamicProg.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class allConstruct
{
 //   private Map <String, List<List<String>>> memo = new HashMap<>();

    public List<List<String>> allConstruct(String target, List<String> wordBank)
    {
 //       if (memo.containsKey(target))
  //          return memo.get(target);

        if (target.equals(""))
            return new ArrayList<>();

        List<List<String>> result = null;

        for (String word : wordBank)
        {
            if (target.indexOf(word) == 0)
            {
                String suffix = target.substring(word.length());
                List<List<String>> suffixWays = allConstruct(suffix, wordBank);
                List<List<String>> targetWays = addTo2DList(suffixWays, word);

                if (targetWays != null)
                    result = addTo2DList(result , targetWays);

            }
        }
     //   memo.put(target, result);

        return result;
    }

    private List<List<String>> addTo2DList(List<List<String>> allCombinations, String word)
    {
        if (allCombinations == null)
            return null;

        List<List<String>> newallCombinations = new ArrayList<>();

        if (allCombinations != null && allCombinations.size() == 0)
        {
            newallCombinations.add(Arrays.asList(word));
        }

      /*  for (int i = 0; i < allCombinations.size(); i++)
        {
            List<String> combinationTmp = addToList(allCombinations.get(i), word);
            allCombinations.set(i, combinationTmp);
        }*/

        for (int i = 0; i < allCombinations.size(); i++)
        {
            List<String> combinationTmp = addToList(allCombinations.get(i), word);
            newallCombinations.add(combinationTmp);
        }

        return newallCombinations;
    }

    private List<List<String>> addTo2DList(List<List<String>> result, List<List<String>> allCombinations)
    {
        if (result == null)
            return allCombinations;

        List<List<String>> newResult = result;

        for (List<String> combination : allCombinations)
            newResult.add(combination);

        return newResult;

    }

    private List<String> addToList (List<String> combination, String word)
    {
        List<String> combinationTmp = new ArrayList<>();

        combinationTmp.add(word);

        for (String Word : combination)
        {
            combinationTmp.add(Word);
        }

        return combinationTmp;
    }
    /*
    public String [] [] allConstruct(String target, String[] wordBank)//, Map<String, String []> memo)
    {
        if (target.equals(""))
            return new String[][]{new String [] {"e"}};

        String [][] result = new String[][]{};

        for (String word : wordBank)
        {
            if (target.indexOf(word) == 0)
            {
                String suffix = target.substring(word.length());
                String suffixWays [][] = allConstruct(suffix, wordBank);
                String targetWays [][] = addTo2DArray(suffixWays, word);

                System.out.println("target = " + Arrays.deepToString(targetWays) + " suffix = " + suffix);

                result = addTo2DArray(result , targetWays);

            }
        }

        return result;
    }

    private String [][] addTo2DArray(String [][] result, String [] [] allCombinations)
    {
        if (result.length == 0)
            return allCombinations;

 //      System.out.println(Arrays.deepToString(result) + " " + Arrays.deepToString(allCombinations));


        int Length = result.length+ allCombinations.length;

        String [][] newResult = new String[Length][];

        for (int i = 0; i< result.length; i++)
        {
            newResult[i] = result[i];
        }
  //      System.out.println(result.length + " + " + allCombinations.length + " nr = " + newResult.length);

  //      System.out.println(Arrays.deepToString(result) + " + " + Arrays.deepToString(allCombinations) + " nr = " + Arrays.deepToString(newResult));

        for (int i = result.length; i< allCombinations.length + result.length; i++)
        {
            newResult[i] = allCombinations[i-result.length];
        }

    //    System.out.println(Arrays.deepToString(result) + " + " + Arrays.deepToString(allCombinations) + " nr2 = " + Arrays.deepToString(newResult));


        return newResult;
    }

    private String [][] addTo2DArray(String [][] allCombinations, String word)
    {
        if (allCombinations.length == 0)
        {
            //         System.out.println("ici");

            String [][] newAllCombination = new String[allCombinations.length+1][];
            newAllCombination[0] = new String[]{word};

            return newAllCombination;
        }
        //      System.out.println(allCombinations.length + " " + word);
        for(int i = 0; i< allCombinations.length; i++)
        {
            //           System.out.println(Arrays.toString(allCombinations[i]));

            allCombinations[i] = addToArray(allCombinations[i], word);
            //           System.out.println(Arrays.toString(allCombinations[i]) + " " + word);
            //         System.out.println(Arrays.toString(allCombinations[i]));
        }

        return allCombinations;
    }

    private String [] addToArray(String [] combination, String word)
    {
        int Length = combination.length;
        String newCombination [] = new String[Length + 1];

        newCombination[0] = word;

        for(int i = 1; i< Length + 1; i++)
        {
            newCombination[i] = combination[i-1];
        }
        return newCombination;
    }*/

    public List<List<String>> allConstruct(String target, String [] wordBank)
    {
        List<List<List<String>>> table = new ArrayList<>(Collections.nCopies(target.length() + 1, (List<List<String>>)null));

        table.set(0, new ArrayList<List<String>>());

        for (int i = 0; i <= target.length(); i++)
        {
            if (table.get(i) != null)
            {
                for (String word : wordBank)
                {
                    if (i + word.length() <= target.length())
                    {
                        if (target.substring(i, i + word.length()).equals(word))
                        {
                            List<List<String>> newCombination = addTo2DList(table.get(i), word);
                            List<List<String>> toSet =  addTo2DList(table.get(i + word.length()), newCombination);

                            table.set((i + word.length()), toSet);
                        }
                    }
                }
            }
        }
        return table.get(target.length());
    }
}
