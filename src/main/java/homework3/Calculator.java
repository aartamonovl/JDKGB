package homework3;

public class Calculator {
    public static <T extends Number, S extends Number> double sum(T num1, S num2) {
        return num1.doubleValue() + num2.doubleValue();
    }

    public static <T extends Number, S extends Number> double multiply(T num1, S num2) {
        return num1.doubleValue() * num2.doubleValue();
    }

    public static <T extends Number, S extends Number> double divide(T num1, S num2) {
        return (!num2.equals(0)) ? (num1.doubleValue() / num2.doubleValue()): -1;
    }

    public static <T extends Number, S extends Number> double subtract(T num1, S num2) {
        return num1.doubleValue() - num2.doubleValue();
    }
}
