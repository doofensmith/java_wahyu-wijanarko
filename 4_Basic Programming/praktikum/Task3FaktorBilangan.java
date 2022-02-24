import java.util.Scanner;

public class Task3FaktorBilangan {
    //main
    public static void main(String[] args) {
        //objek Scanner unput input
        Scanner sc = new Scanner(System.in);

        //input number
        System.out.print("Input bilangan : ");
        int inputNumber = sc.nextInt();

        //process
        faktorBilangan(inputNumber);

    }

    //method mencari faktor bilangan
    private static void faktorBilangan(int number) {

        //perulangan untuk mencari faktor bilangan
        System.out.println("Faktor bilangan : ");
        for (int i = 1; i <= number; i++) {
            if (number%i == 0) {
                System.out.println(i);
            }
        }

    }
}