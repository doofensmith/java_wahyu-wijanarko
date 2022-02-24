import java.util.Scanner;

public class Task4BilanganPrima {
    //main
    public static void main(String[] args) {
        //input dengan Scanner
        Scanner sc = new Scanner(System.in);

        //Input
        System.out.print("Input bilangan : ");
        int inputNumber = sc.nextInt();

        //process
        bilanganPrima(inputNumber);

    }

    //method cek bilangan prima
    private static void bilanganPrima(int number) {
        //variabel boolean bilangan prima untuk mempermudah
        Boolean prima = false;
        
        //bilangan kurang dari 1 bukan prima
        if (number <= 1) {
            System.out.println("Bukan Bilangan Prima");
        }else {
            //perulangan untuk cek bilangan prima
            for (int i = 2; i <= number/2; i++) {
                if(number%i == 0) {
                    System.out.println("Bukan Bilangan Prima");
                    System.exit(0);
                }
            }
            System.out.println("Bilangan Prima");
        }
        
        
    }
}