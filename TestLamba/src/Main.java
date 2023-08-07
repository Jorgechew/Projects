public class Main {
    public static void main(String[] args) {

        Machine machine = new Machine();

        int calc = machine.monoOperation.mono(6);
        boolean compare = machine.compare.doubles(5,4);
        int doubles = machine.multiply.doubles(1,2);


        System.out.println(calc);
        System.out.println(compare);
        System.out.println(doubles);
    }
}