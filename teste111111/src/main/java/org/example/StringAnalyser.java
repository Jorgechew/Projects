package org.example;

public class StringAnalyser {
    public String removeFirstAndLastLetter(String str, char C) {


        String test = String.valueOf(C);
        String empty = "";
        if (empty.equals(C)) {
            return "";
        }

        str = str.toLowerCase();
        char c = Character.toLowerCase(C);

        if (!str.contains(test)) {
            System.out.println("error char is not in here");
            return "";
        }

        if (str.isEmpty()) {
            System.out.println("Error - empty string");
            System.out.println("");
            return "";
        }

        if (str.length() == 1 || str.equals(c)) {
            System.out.println("empty result");
            return "";
        }

        if (str.length() > 100) {
            System.out.println("error - string is too big");
            return "";
        }
        String result = "";

        if (str.length() >= 1 && str.length() <= 100) {

            int firstIndex = str.indexOf(c);
            int lastIndex = str.lastIndexOf(c);


            if (firstIndex == 0 && firstIndex != lastIndex) {
                result = str.substring(firstIndex + 1, lastIndex) + str.substring(lastIndex, str.length() - 1);
                System.out.println("result1: " + result);
                return result;
            }

            if (firstIndex == lastIndex) {
                result = str.substring(0, firstIndex) + str.substring(firstIndex + 1, str.length());
                System.out.println("result2: " + result);
                return result;
            }

            result = str.substring(0, firstIndex) + str.substring(firstIndex + 1, lastIndex) + str.substring(lastIndex, str.length());
            System.out.println("result3: ");
            System.out.println(result);

        }
        return result;
    }

    public static void main(String[] args) {

        StringAnalyser stringAnalyser = new StringAnalyser();

        stringAnalyser.removeFirstAndLastLetter("AAna", 'A');

    }

}



















