import java.util.Scanner;

public class Task5Palindrom {
    //main
    public static void main(String[] args) {
        //objek input dengan Scanner
        Scanner sc = new Scanner(System.in);

        //Input
        System.out.print("Input string : ");
        String inputString = sc.next();

        //proses
        palindrom(inputString);

    }

    //method cek palindrom
    private static void palindrom(String inputString) {
        
        //variabel index karakter terakhir
        int charIndex = inputString.length()-1;
        //perulangan untuk cek karakter
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) != inputString.charAt(charIndex)) {
                System.out.println("Bukan Palindrom");
                System.exit(0);
            }
            charIndex--;
        }
              
        System.out.println("Palindrom");
        
    }
}