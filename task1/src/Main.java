import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hero regularHero = new Hero();
        System.out.println("Press 'w' to crawl, 'r' to run, 'c' to cycle and 'q' to quit");

        Scanner scanner = new Scanner(System.in);
        char selectChar;

        while (true) {
            selectChar = scanner.next().charAt(0);
            switch (selectChar){
                case 'w':
                    regularHero.move(new Crawl());
                    break;
                case 'r':
                    regularHero.move(new Run());
                    break;
                case 'c':
                    regularHero.move(new Cycling());
                    break;
                case 'q':
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Regular Hero does not have that type of movement");
                    break;
            }
        }
    }
}





