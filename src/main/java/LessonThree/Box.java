package LessonThree;

import java.util.ArrayList;

public class Box <B> {

    ArrayList<B> fruit = new ArrayList<>();
    float  fruitWeight;

    public Box (float fruitWeight) {
        this.fruitWeight = fruitWeight;
    }
    public void addFruits (B Fruit) {
        fruit.add (Fruit);}
    public double getTheWeightOfBox(){
        return fruit.size() * fruitWeight;
    }

    public boolean Compare (Box<?> box){
        return Math.abs(getTheWeightOfBox() - box.getTheWeightOfBox()) < 0.1;
    }

    public void addFruitsToBox (Box<B> Box){
        System.out.println("Перед добавлением в первую коробку  " + fruit.size());
        System.out.println("Перед добавлением во вторую коробку " + Box.fruit.size());
        fruit.addAll(Box.fruit);
        Box.fruit.clear();
        Box.fruit.trimToSize();
        System.out.println("После добавление в первую коробку " + fruit.size());
        System.out.println("После добавление во вторую коробку " + Box.fruit.size());
        System.out.println("           ");

    }


}

