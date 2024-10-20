import java.lang.reflect.Method;

public class MethodInvoker {
    public static void invoke() throws Exception {
        TestClass myClass = new TestClass();

        // Получаем все методы класса MyClass
        Method[] methods = TestClass.class.getDeclaredMethods();

        // Проходим по каждому методу
        for (Method method : methods) {
            // Проверяем, аннотирован ли метод аннотацией RunTimes
            if (method.isAnnotationPresent(RunTimes.class)) {
                RunTimes annotation = method.getAnnotation(RunTimes.class);
                int runTimes = annotation.value();  // Получаем значение параметра аннотации

                // Делаем метод доступным для вызова (если он защищенный или приватный)
                method.setAccessible(true);

                // Вызов метода нужное количество раз
                for (int i = 0; i < runTimes; i++) {
                    // Определяем параметры метода и вызываем его
                    if (method.getParameterCount() == 0) {
                        // Если у метода нет параметров
                        method.invoke(myClass);
                    } else if (method.getParameterTypes()[0] == int.class) {
                        method.invoke(myClass, 10);  // Передаем int параметр
                    } else if (method.getParameterTypes()[0] == String.class) {
                        method.invoke(myClass, "Hello!");  // Передаем строку
                    } else if (method.getParameterTypes()[0] == double.class) {
                        method.invoke(myClass, 3.14);  // Передаем double параметр
                    }
                }
            }
        }
    }
}