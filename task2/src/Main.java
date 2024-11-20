public class Main {
    public static void main(String[] args) {
        try {
            MethodInvoker.invoke();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
