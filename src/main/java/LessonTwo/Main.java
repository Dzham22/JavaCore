package LessonTwo;

public class Main {

    public static void main(String[] args) {

        String[][] Array = new String[][]{{"a", "3", "4", "4"}, {"1", "4", "3", "1"}, {"2", "3", "4", "1"}, {"4", "4", "3", "1"}};
        try {
            try {
                int result = method(Array);
                System.out.println(result);
            } catch (MyArraySizeException e) {
                System.out.println("Размер массива превышен заданному массиву (4x4)!");
            }
        }
        catch (MyArrayDataException e) {
            System.out.println("Неправильное значение введено в массиве!");
            System.out.println("Ошибка в ячейке: " + e.i + "x" + e.j);
        }

    }


    public static int method(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (array.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    count = count + Integer.parseInt(array[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }

        }
        return count;
    }

}