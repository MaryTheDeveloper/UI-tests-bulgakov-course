package homework.lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FruitsList {

    public static void printFruitsList() {
        List<String> fruitsList = new ArrayList<>(Arrays
                .asList("Яблоко", "Банан", "Апельсин", "Мандарин", "Груша"));

        for (int i = 0; i < fruitsList.size(); i++) {
            System.out.println((i + 1) + ". " + fruitsList.get(i));
        }
    }

    public static void main(String[] args) {
        printFruitsList();
    }
}
