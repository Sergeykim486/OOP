import java.util.Scanner;

public class MainMenu {
    Scanner scanner = new Scanner(System.in);
    String [] menu = {
        "1. Add product",
        "2. Show products",
        "0. exit"
    };

    public void MenuActions(int ActionNum) {
        System.out.println("Вы нажали " + ActionNum);
    }

    public void ShowMenu() {
        while (true) {
            System.out.println("Main Menu.");
            for(String line: menu) {
                System.out.println(line);
            }
            MenuActions(scanner.nextInt());
        }
    }

}

