public class Machine {



    BiOperation<Boolean,Integer> compare = (i1, i2) -> {
        return i1 > i2;
    };
    MonoOperation<Integer> monoOperation = value -> value *2;

    BiOperation<Integer,Integer> multiply =((i1, i2) -> i1 * i2);



}
