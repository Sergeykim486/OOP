import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Domen.Bottle;
import Domen.HotDrink;
import Domen.Product;
import vendingmachines.VendingMachine;

public class App {
    
    public static void main(String[] args) throws Exception {
        int choice;
        VendingMachine machine1 = new VendingMachine(300);
        do {
            displayMenu();
            choice = enterint("Enter your choice. ");
            switch (choice) {
                case 1:
                    int id = enterint("Enter new product's id. ");
                    String name = enterstring("Enter new product's name. ");
                    String category = enterstring("Enter new product's category. ");
                    Double price = enterdouble("Enter price. ");
                    int volium = enterint("Enter volium (int) or enter '0', if product has no volium. ");
                    int temperature = enterint("Enter temperature (int) or enter '0', if product has no volium. ");
                    if (volium != 0) {
                        Bottle nproduct = new Bottle(id, name, category, price, volium);
                        machine1.addProduct(nproduct);
                    }
                    else if (temperature != 0) {
                        HotDrink nproduct = new HotDrink(id, name, category, choice, temperature);
                        machine1.addProduct(nproduct);
                    }
                    break;
                case 2:
                    for (Product line: machine1.getProducts()) {
                        System.out.println(line.toString() + "\n");
                    }
                    break;
                case 0:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static int enterint(String text) {
        Scanner scanner = new Scanner(System.in);
        int value;

        while (true) {
            try {
                System.out.print(text);
                value = scanner.nextInt();
                scanner.nextLine(); // Потребовать символ новой строки
                break; // Выходим из цикла при правильном вводе числа
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // Очистить ввод, чтобы избежать зацикливания
            }
        }

        return value;
    }

    public static String enterstring(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(text);
        return scanner.nextLine();
    }

    public static double enterdouble(String text) {
        Scanner scanner = new Scanner(System.in);
        double value;

        while (true) {
            try {
                System.out.print(text);
                value = scanner.nextDouble();
                scanner.nextLine(); // Потребовать символ новой строки
                break; // Выходим из цикла при правильном вводе числа
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid double.");
                scanner.nextLine(); // Очистить ввод, чтобы избежать зацикливания
            }
        }

        return value;
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Add Product");
        System.out.println("2. Show Products");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
}
