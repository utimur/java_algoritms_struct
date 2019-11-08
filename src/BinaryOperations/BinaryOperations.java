package BinaryOperations;

public class BinaryOperations {
    public static void main(String[] args) {
        Integer x = 255;
        Integer y = 2;
        Integer z = 235;
        System.out.println("x = "+Integer.toBinaryString(x));
        System.out.println("y = "+Integer.toBinaryString(y));
        System.out.println("z = "+Integer.toBinaryString(z));
        System.out.println("Сдвиг вправо "+Integer.toBinaryString(x >> y));
        System.out.println("Сдвиг влево "+Integer.toBinaryString(x << y));
        System.out.println("Побитовое И "+Integer.toBinaryString(x & z));
        System.out.println("побитовое или "+Integer.toBinaryString(x | z));
        System.out.println("побитовый ХОР "+Integer.toBinaryString(x ^ z));
    }
}
