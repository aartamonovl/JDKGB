package homework3;

public class Main {
    public static void main(String[] args) {

        System.out.println("Task 1");

        System.out.println(Calculator.sum(2, 2));
        System.out.println(Calculator.multiply(2, 2.2f));
        System.out.println(Calculator.divide(2, 2.2f));
        System.out.println(Calculator.subtract(2, 2.2f));
        System.out.println();

        System.out.println("Task 2.");

        Integer[] array1 = {1, 2, 3};
        Integer[] array2 = {1, 2, 3, 3};
        Integer[] array3 = {1, 2, 3};
        String[] arrayStr = {"1", "2", "3"};
        Object[] objects = new Object[]{1, 2, 3};

        MyArray array = new MyArray();
        System.out.println(array.compareArrays(array1, array2));
        System.out.println(array.compareArrays(array1, array3));
        System.out.println(array.compareArrays(array1, objects));
        System.out.println(array.compareArrays(array1, arrayStr));
        System.out.println(array.compareArrays(arrayStr, objects));
        System.out.println();

        System.out.println("Task 3");

        Pair<Integer, String> pair = new Pair<>(1, "a");
        System.out.println(pair);
        Pair<Float, Float> fPair = new Pair<>(1.0f, 8.555f);
        System.out.println(fPair);
    }
}
