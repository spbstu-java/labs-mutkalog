public class TestClass {
     // Публичные методы
    public void publicMethod1() {
        System.out.println("Executing publicMethod1");
    }

    public void publicMethod2() {
        System.out.println("Executing publicMethod2");
    }

    // Защищенные методы
    @RunTimes(3)  // Метод будет вызван 3 раза
    protected void protectedMethod1(int a) {
        System.out.println("Executing protectedMethod1 with param: " + a);
    }

    @RunTimes(2)  // Метод будет вызван 2 раза
    protected void protectedMethod2(String message) {
        System.out.println("Executing protectedMethod2 with message: " + message);
    }

    // Приватные методы
    @RunTimes(4)  // Метод будет вызван 4 раза
    private void privateMethod1() {
        System.out.println("Executing privateMethod1");
    }

    @RunTimes(1)  // Метод будет вызван 1 раз
    private void privateMethod2(double d) {
        System.out.println("Executing privateMethod2 with double param: " + d);
    }
}
