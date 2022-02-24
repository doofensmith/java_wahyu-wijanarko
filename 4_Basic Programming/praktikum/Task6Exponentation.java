import java.util.Scanner;

public class Task6Exponentation {
    //main
    public static void main(String[] args) {
        //objek input Scanner
        Scanner sc = new Scanner(System.in);

        //Input
        System.out.print("Input x : ");
        int x = sc.nextInt();

        System.out.print("Input n : ");
        int n = sc.nextInt();

        exponent(x,n);

    }

    //method untuk mencari pangkat bilangan
    private static void exponent(int x, int n) {
        
        //variabel hasil
        int hasil = 1;

        //perulangan untuk menghitung pangkat bilangan
        for (int i = 0; i < n; i++) {
            hasil *= x;
        }

        //output hasil
        System.out.println(hasil);

    }
}