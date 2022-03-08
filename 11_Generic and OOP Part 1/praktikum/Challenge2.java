import java.util.Scanner;

public class Challenge2 {

    public static void main(String[] args) {
        CalculatorImplement implement = new CalculatorImplement();
        implement.mainMenu();
    }

}

abstract class Calculator {

    //METHOD
    abstract void mainMenu();

    abstract void calculatorMenu();

    abstract void inputValue();

    abstract void showResult(int operation);

    abstract double addition(double value1, double value2);

    abstract double substraction(double value1, double value2);

    abstract double multiplication(double value1, double value2);

    abstract double division(double value1, double value2);

}

class CalculatorImplement extends Calculator {

    //ATTRIBUT
    private double value1;
    private double value2;
    private Scanner scanner;

    //CONSTRUCTOR
    public CalculatorImplement(double value1, double value2) {
        this.value1 = value1;
        this.value2 = value2;
        this.scanner = new Scanner(System.in);
    }

    public CalculatorImplement() {
        this.scanner = new Scanner(System.in);
    }

    //GETTER AND SETTER

    public double getValue1() {
        return value1;
    }

    public void setValue1(double value1) {
        this.value1 = value1;
    }

    public double getValue2() {
        return value2;
    }

    public void setValue2(double value2) {
        this.value2 = value2;
    }


    //IMPLEMENTS METHOD

    @Override
    void mainMenu() {

        mainMenuLoop:
        while (true) {
            System.out.println("\n++++++++++ CALCULATOR ++++++++++\n" +
                    "1: Open Calculator\n" +
                    "99: Exit");
            System.out.print("Masukkan pilihan anda : ");
            int selectMenu = scanner.nextInt();

            switch (selectMenu) {
                case 1: inputValue();
                break;
                case 99: break mainMenuLoop;
                default:
                    System.out.println("Menu tidak tersedia.");
            }

        }

    }

    @Override
    void inputValue() {
        System.out.println("\n++++++++++ CALCULATOR ++++++++++");
        System.out.print("Masukkan value 1 : ");
        setValue1(scanner.nextDouble());
        System.out.print("Masukkan value 2 : ");
        setValue2(scanner.nextDouble());
        calculatorMenu();
    }

    @Override
    void calculatorMenu() {

        calculatorMenuLoop:
        while (true) {
            System.out.println("\n++++++++++ CALCULATOR ++++++++++\n" +
                    "Please Enter Calculation Operation:\n" +
                    "1. Add Value\n" +
                    "2. Substract Value\n" +
                    "3. Multiply Value\n" +
                    "4. Divide Value");
            System.out.print("Pilihan anda : ");
            int selectMenu = scanner.nextInt();
            switch (selectMenu) {
                case 1: showResult(1);
                break calculatorMenuLoop;
                case 2: showResult(2);
                break calculatorMenuLoop;
                case 3: showResult(3);
                break calculatorMenuLoop;
                case 4: showResult(4);
                break calculatorMenuLoop;
                default:
                    System.out.println("Menu tidak tersedia.");

            }
        }

    }

    @Override
    void showResult(int operation) {
        System.out.println("\n++++++++++ CALCULATOR ++++++++++");
        switch (operation) {
            case 1:
                System.out.println("Hasil : "+addition(value1, value2));
                break;
            case 2:
                System.out.println("Hasil : "+substraction(value1, value2));
                break;
            case 3:
                System.out.println("Hasil : "+multiplication(value1, value2));
                break;
            case 4:
                System.out.println("Hasil : "+division(value1, value2));
                break;
            default: calculatorMenu();
        }
    }

    @Override
    double addition(double value1, double value2) {
        return value1 + value2;
    }

    @Override
    double substraction(double value1, double value2) {
        return value1 - value2;
    }

    @Override
    double multiplication(double value1, double value2) {
        return value1 * value2;
    }

    @Override
    double division(double value1, double value2) {
        return value1 / value2;
    }

}
