import java.util.Scanner;

public class Task8TabelPerkalian {
    //main
    public static void main(String[] args) {
        //objek scanner
        Scanner sc = new Scanner(System.in);

        //Input
        System.out.print("Input bilangan : ");
        int inputBilangan = sc.nextInt();

        //process
        tabelPerkalian(inputBilangan);

    }

    //method tabel perkalian
    private static void tabelPerkalian(int inputBilangan) {
        
        //nested for untuk matriks 2 dimensi
        for (int i = 1; i <= inputBilangan; i++) {
            for (int j = 1; j <= inputBilangan; j++) {
                System.out.print((i*j)+"\t");
            }
            //ganti line
            System.out.println("");
        }
        
    }

}