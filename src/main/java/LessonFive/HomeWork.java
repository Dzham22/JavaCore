package LessonFive;

import java.util.Arrays;

public class HomeWork {

    public static void main(String[] args) {
        AppData ad = new AppData();
        ad.readTheFile("Document.csv");
        System.out.println(Arrays.toString(ad.getHeader()));
        System.out.println(Arrays.deepToString(ad.getData()));

        ad.writeToFile("Document1.csv");
    }

}



