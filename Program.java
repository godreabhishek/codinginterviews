package com.algoexpert;

import java.util.*;

class Program {
    public static class StringChain {
        String nextString;
        Integer maxChainLength;

        public StringChain(String nextString, Integer maxChainLength){
            this.nextString=nextString;
            this.maxChainLength=maxChainLength;
        }

        public static List<String> longestStringChain(List<String> strings){
           Map<String, StringChain> stringChains = new HashMap<>();
           for(String string : strings){
               System.out.println(" Putting string in hashmap "+string);
               stringChains.put(string,new StringChain("",1));
           }
           List<String> sortedStrings = new ArrayList<>(strings);
           sortedStrings.sort((a,b) -> a.length() - b.length());

           for(String string : sortedStrings){
               findLongestStringChain(string,stringChains);
           }

           return buildLongestStringChain(strings,stringChains);
        }



        private static void findLongestStringChain(String string, Map<String, StringChain> stringChains) {
            for (int i = 0; i < string.length(); i++) {
                String smallerString = getSmallerString(string,i);
                if(!stringChains.containsKey(smallerString)) continue;
                tryUpdateLongestStringChain(string,smallerString,stringChains);
            }


        }

        private static String getSmallerString(String string, int index) {
            return string.substring(0,index) + string.substring(index+1);

        }

        private static void tryUpdateLongestStringChain(String currentString, String smallerString, Map<String, StringChain> stringChains) {
               int smallerStringChainLength=stringChains.get(smallerString).maxChainLength;
               int currentStringChainLength=stringChains.get(currentString).maxChainLength;
               if(smallerStringChainLength + 1 > currentStringChainLength){
                   stringChains.get(currentString).maxChainLength = smallerStringChainLength+1;
                   stringChains.get(currentString).nextString=smallerString;
               }
        }

        private static List<String> buildLongestStringChain(List<String> strings, Map<String, StringChain> stringChains) {
            int maxChainLength = 0;
            String chainStartingString = "";
            for(String string:strings){
                if(stringChains.get(string).maxChainLength > maxChainLength){
                    maxChainLength = stringChains.get(string).maxChainLength;
                    chainStartingString=string;
                }
            }

            List<String> ourLongestStringChain = new ArrayList<>();
            String currentString = chainStartingString;
            while(currentString !=""){
                ourLongestStringChain.add(currentString);
                currentString = stringChains.get(currentString).nextString;
        }
            return  ourLongestStringChain.size() == 1 ? new ArrayList<String>() : ourLongestStringChain;
        }

    }

     public static void main(String[] args) {
        List<String> list = Arrays.asList("abcdef","abcde","abde","ade","ae");
        List<String> responseList = StringChain.longestStringChain(list);
         System.out.println( " Printing responseList **********"+responseList.size());
        for(String string : responseList){
            System.out.println(string);
        }
     }
}
