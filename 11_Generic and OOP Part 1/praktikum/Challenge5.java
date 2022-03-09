import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Challenge5 {
    public static void main(String[] args) {

        Board board = new Board();
        board.mainMenu();

    }
}

class Board {

    private Scanner scanner;
    //private int jumlahKandang;
    private List<Kandang> kandangList;

    public Board() {
        this.scanner = new Scanner(System.in);
        this.kandangList = new ArrayList<>();
    }

    public void mainMenu() {

        mainMenuLoop:
        while (true) {
            System.out.println("------------------------");
            System.out.println("\tTEBAK KANDANG");
            System.out.println("------------------------");
            System.out.println("1. Jumlah Kandang\n" +
                    "99. Exit");
            System.out.print("Pilih menu: ");
            int selectMenu = scanner.nextInt();

            switch (selectMenu) {
                case 1: jumlahKandang();
                    break;
                case 99:
                    break mainMenuLoop;
                default:
                    System.out.println("Menu tidak tersedia.");
            }
        }

    }

    private void jumlahKandang() {
        System.out.print("\nMasukkan jumlah kandang : ");
        int jumlahKandang = scanner.nextInt();
        randomKandang(jumlahKandang);
        gamePlay(jumlahKandang);
    }

    private void randomKandang(int jumlahKandang) {

        //1 : kambing
        //2 : bebek
        //3 : zebra

        for (int i = 0; i < jumlahKandang; i++) {
            int random = (int)(Math.random()*3)+1;

            switch (random) {
                case 1:
                    kandangList.add(new KandangKambing());
                    break;
                case 2:
                    kandangList.add(new KandangBebek());
                    break;
                case 3:
                    kandangList.add(new KandangZebra());
                    break;
                default: break;
            }
        }

    }

    private void gamePlay(int jumlahKandang) {
        int tebakanBenar = 0;
        while (tebakanBenar < jumlahKandang) {

            for (int i = 0; i < kandangList.size(); i++) {
                if (kandangList.get(i).isTertebak()) {
                    kandangList.get(i).bukaKandang(kandangList.get(i).getIsiKandang());
                }else {
                    kandangList.get(i).bukaKandang(String.valueOf(i+1));
                }
            }


            System.out.print("Pilih kandang yang ingin dibuka : ");
            int buka = scanner.nextInt();
            System.out.println("---PILIHAN---\n" +
                    "K: Kambing\n" +
                    "B: Bebek\n" +
                    "Z: Zebra");
            System.out.print("Masukkan tebakan : ");
            String tebak = scanner.next();

            if (kandangList.get(buka-1).getIsiKandang().equals(tebak)) {
                System.out.println("\nTebakan benar!\n");
                kandangList.get(buka-1).setTertebak(true);
                tebakanBenar++;
            }else {
                System.out.println("\nTebakan salah!\n");
            }

        }
    }

}

class Kandang {

    private String isiKandang;
    private boolean tertebak;

    public Kandang(String isiKandang) {
        this.isiKandang = isiKandang;
    }

    public String getIsiKandang() {
        return isiKandang;
    }

    public void setIsiKandang(String isiKandang) {
        this.isiKandang = isiKandang;
    }

    public boolean isTertebak() {
        return tertebak;
    }

    public void setTertebak(boolean tertebak) {
        this.tertebak = tertebak;
    }

    //METHOD
    //buat kandang
    public void buatKandang(int jumlahKandang) {

        for (int i = 1; i <= jumlahKandang; i++) {
            System.out.println(
                    "|||\n" +
                    "|"+i+"|\n" +
                    "|||\n");
        }

    }

    //buka kandang
    public void bukaKandang(String isiKandang) {
        System.out.println(
                        "|||\n" +
                        "|"+isiKandang+"|\n" +
                        "|||\n");
    }
}

class KandangKambing extends Kandang {

    public KandangKambing() {
        super("K");
    }

}

class KandangBebek extends Kandang {

    public KandangBebek() {
        super("B");
    }

}

class KandangZebra extends Kandang {

    public KandangZebra() {
        super("Z");
    }

}

