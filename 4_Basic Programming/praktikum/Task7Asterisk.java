import java.util.Scanner;

public class Task7Asterisk {
    //main
    public static void main(String[] args) {
        //objek Scanner
        Scanner sc = new Scanner(System.in);

        //Input
        System.out.print("Input N : ");
        int n = sc.nextInt();

        //proses
        segitigaAsterisk(n);

    }

    private static void segitigaAsterisk(int n) {
        
        for (int i = 0; i < n; i++) {
            
            //perulangan untuk spasi
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }
            //perulangan untuk bintang
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            
            //ganti line
            System.out.println("");
        }
        
    }

}