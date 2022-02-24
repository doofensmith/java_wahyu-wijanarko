import java.util.Scanner;

public class Task2XdanO {

    //main
    public static void main(String[] args) {

        //Test String
        String testString1 = "xoxoxo";
        String testString2 = "xooxo";

        //PROCESS:
        System.out.println("Input string : "+testString1);
        process(testString1);

        System.out.println("Input string : "+testString2);
        process(testString2);

    }

    //Method Process
    private static void process(String input) {
        //Variabel untuk menyimpan jumlah X dan O
        int jumlahX = 0;
        int jumlahO = 0;

        //Perulangan untuk menghitung X dan O 
        for (int i = 0; i < input.length(); i++) {
            if (input.toLowerCase().charAt(i) == 'x') {
                jumlahX++;
            }
            if (input.toLowerCase().charAt(i) == 'o') {
                jumlahO++;
            }
        }

        //output boolean jumlah sama
        boolean jumlahSama = false;
        if (jumlahX == jumlahO) {
            jumlahSama = true;
        }

        //OUTPUT:
        System.out.println(jumlahSama);
    }
}