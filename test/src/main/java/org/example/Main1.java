package org.example;

public class Main1 {

    public static  String  removeFirstAndLast(String str, char c){

        int firstIndex = str.indexOf(c);
        int lastIndex = str.lastIndexOf(c);

        if(str.length() < 1 || str.length() > 100){
            System.out.println("The string has more than 100 characters and cannot be divided");
            return str;
        }

        if (firstIndex == -1 && lastIndex == -1 && firstIndex == lastIndex) {
            System.out.println("Erro");
            return str;
        }

        if(str.length() == 1 && firstIndex == lastIndex) {
            System.out.println("1 char");
            return "";
        }


        str = str.substring(0,firstIndex) + str.substring(firstIndex+1);
        lastIndex--;
        str = str.substring(0, lastIndex) + str.substring(lastIndex+1);
        System.out.println("+ que 1 char");
        return str;
    }

    public static void main(String[] args) {

        String string = "carro";
        char c = 'a';
        String result = removeFirstAndLast(string,c);
        System.out.println(result);



    }
}














