package LessonFour;

public class Main {

    public static void main(String[] args) {
     SecondPoint();
     Array wordsArray = new Array((FirstPoint()));
     wordsArray.doFirstPoint();
    }

    private static String[] FirstPoint() {
        String [] strings = new String[7];
        strings[0] = "Apple";
        strings[1] = "Orange";
        strings[2] = "Apple";
        strings[3] = "Grape";
        strings[4] = "Melon";
        strings[5] = "Mandarin";
        strings[6] = "Melon";
        return strings;
    }

    private static void SecondPoint() {
        PhoneDirectory phoneDirectory = new PhoneDirectory();

        phoneDirectory.addElementToPhoneDirectory("Kane","+7926666666");
        phoneDirectory.addElementToPhoneDirectory("Kane","+7927777777");
        phoneDirectory.addElementToPhoneDirectory("Kane","+7927777777");
        phoneDirectory.addElementToPhoneDirectory("De Gea","1111111");
        phoneDirectory.addElementToPhoneDirectory("De Gea","+733333333");
        phoneDirectory.addElementToPhoneDirectory("De Gea","833333333");
        phoneDirectory.addElementToPhoneDirectory("Edinson","+79266346473");

        System.out.println("Kane: " + phoneDirectory.getPhonesByContact("Kane"));
        System.out.println("De Gea: " + phoneDirectory.getPhonesByContact("De Gea"));
        System.out.println("Edinson: " + phoneDirectory.getPhonesByContact("Edinson"));
        System.out.println("Marcus: " + phoneDirectory.getPhonesByContact("Marcus"));
        }


}