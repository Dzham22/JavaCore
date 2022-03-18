package LessonThree;

import java.util.Arrays;

public class Main {
    public static void main (String [] args) {
        SolveTheTask();

        String[] ArrayOfStrings = {"A", "B", "C", "D", "E"};
        SolveTheTaskArray(ArrayOfStrings, 1, 2);

        Integer[] Ger = {1, 2, 3, 4, 5};
        SolveTheTaskArray(Ger, 1, 2);

    }

    public static void SolveTheTaskArray (Object[] B, int firstOne, int secondOne) {
        Object A = B [firstOne];
        B [firstOne] = B[secondOne];
        B[secondOne] = A;
        displayArray(B);
    }
    private static void displayArray(Object[] B) {
        System.out.println(Arrays.toString(B));}

    public static void SolveTheTask () {
        Box<Apple> appleBox = new Box<>(1);
        Box<Orange> orangeBox = new Box<>(3);
        Box<Orange>  orangeBoxOne = new Box<>(1);

    for (int i =0; i<2; i++) {
        appleBox.addFruits (new Apple());
        orangeBox.addFruits (new Orange());
        orangeBoxOne.addFruits (new Orange ());

        orangeBox.addFruits (new Orange());
        orangeBoxOne.addFruits (new Orange ());



        System.out.println("Вес коробки с яблоками: " + appleBox.getTheWeightOfBox() + " кг");
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getTheWeightOfBox() + " кг");
        System.out.println("Равны ли по весу коробки  - " + orangeBox.Compare(appleBox));
        System.out.println("           ");

        orangeBox.addFruitsToBox(orangeBoxOne);
    }
    }

}
