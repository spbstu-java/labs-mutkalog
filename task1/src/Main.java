public class Main {
    public static void main(String[] args) {
        Hero regularHero = new Hero();
        regularHero.move(new Crawl());
        regularHero.move(new Run());
        regularHero.move(new Cycling());
    }
}





