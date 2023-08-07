package org.example;

public class Main {

    public static String removeFirstAndLastOccurrences(String str, char letterToRemove) {
        int firstIndex = str.indexOf(letterToRemove);
        int lastIndex = str.lastIndexOf(letterToRemove);

       if(str.length() <= 1 || str.length() >= 100 ){
           return str;
       }

        if (firstIndex == -1 || firstIndex == lastIndex) {
            // Se a letra não estiver presente ou houver apenas uma ocorrência, retorna a string original
            return str;
        } else {
            // Remove a primeira ocorrência e a última ocorrência da letra
            return str.substring(0, firstIndex) + str.substring(firstIndex + 1, lastIndex) + str.substring(lastIndex + 1);
        }
    }

    public static void main(String[] args) {
        String originalString = "a";
        char letterToRemove = 'a';
        String modifiedString = removeFirstAndLastOccurrences(originalString, letterToRemove);
        System.out.println(modifiedString);// Output: "bnan"
        System.out.println(letterToRemove);
    }
}