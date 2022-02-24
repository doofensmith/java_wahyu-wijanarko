import java.util.Scanner;

public class Task1VokalKonsonan {
    public static void main(String[] args) {
        //Objek untuk input (Scanner)
        Scanner sc = new Scanner(System.in);
        
        //[INPUT]:
        System.out.print("Input teks : ");
        String inputString = sc.nextLine();

        //[PROSES]:
        process(inputString);

    }

    //Method for process
    private static void process(String inputString) {
        //[PROSES]:
        //array huruf vokal dan konsonan
        char[] hurufVokal = {'a','i','u','e','o'};
        char[] hurufKonsonan = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};
        
        //Perulangan untuk mencari jumlah huruf vokal dan konsonan
        int jumlahHurufVokal = 0;
        int jumlahHurufKonsonan = 0;
        for (int i = 0; i < inputString.length(); i++) {
            //Jumlah Huruf Konsonan
            for (int j = 0; j < hurufKonsonan.length; j++) {
                if (inputString.toLowerCase().charAt(i) == hurufKonsonan[j]) {
                    jumlahHurufKonsonan++;
                }
            }
            
            //Jumlah Huruf Vokal
            for (int j = 0; j < hurufVokal.length; j++) {
                if (inputString.toLowerCase().charAt(i) == hurufVokal[j]) {
                    jumlahHurufVokal++;
                }
            }
            
        }
        
        //Output
        System.out.println("Jumlah Huruf Vokal = "+jumlahHurufVokal);
        System.out.println("Jumlah Huruf Konsonan = "+jumlahHurufKonsonan);
        System.out.println("Total Karakter = "+(jumlahHurufVokal+jumlahHurufKonsonan));
        
    }

}