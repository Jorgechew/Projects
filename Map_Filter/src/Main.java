import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        String message = "I'll send an SOS to the garbage world, " +
                "I hope that someone garbage gets my message in a garbage bottle.";

        start(message);
    }

    public static  void start(String message){

        String reduce = Stream.of(message.split(" "))
                .filter(newMessage -> !newMessage.equals("garbage"))
                .map(newMessage -> newMessage.toUpperCase())
                //.collect(Collectors.toList())
                //.forEach(newMessage -> System.out.print(newMessage + " "));
                .reduce("",(acc,newMessage) -> acc.isEmpty() ? newMessage : acc + " " + newMessage);

        System.out.println(reduce);

    }



}