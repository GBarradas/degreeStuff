import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ExercisePets {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Pet> pets = new ArrayList<Pet>();

        String line = new String();

        try {
            while ((line = s.nextLine()) != null) {

                try {
                    if (line.substring(0, 2).equals("d ") || line.substring(0, 2).equals("c ")) {

                        System.out.println("OK");
                        if (line.substring(0, 1).equals("d")) {
                            Dog dog = new Dog(line.substring(2, line.length()));
                            pets.add(dog);
                        } else {
                            Cat cat = new Cat(line.substring(2, line.length()));
                            pets.add(cat);
                        }

                    } else {
                        System.out.println("ERR");

                    }

                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("ERR");
                }
            }

        } catch (NoSuchElementException e) {
            s.close();

            for (var x : pets) {
                System.out.println(x.toString());
            }

        }

    }

}