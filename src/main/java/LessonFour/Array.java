package LessonFour;


import java.util.HashMap;
import java.util.Map;

public class Array {
    private String [] arrayWS;

    public Array (String[] array) {
        this.arrayWS = array;
    }

    public void doFirstPoint() {
        HashMap<String,Integer> words = getWords(arrayWS);
        for (Map.Entry entry: words.entrySet()) {
            if (entry.getValue().equals(1)) {
                System.out.println(entry.getKey());
            }
        }
    }

    private HashMap<String, Integer> getWords(String[] WSArray) {
        HashMap<String, Integer> words = new HashMap<>();
        for (int i = 0; i < WSArray.length; i++) {
            if (words.containsKey(WSArray[i])) {
                words.put(WSArray[i], words.get(WSArray[i]) + 1);
            }
            else {
                words.put(WSArray[i],1);
            }
        }
        return words;
    }
}