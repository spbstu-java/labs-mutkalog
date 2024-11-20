import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethodInvoker {
    public static void invoke() throws Exception {
        TestClass myClass = new TestClass();

        // Получаем все методы класса MyClass
        Method[] methods = TestClass.class.getDeclaredMethods();

        // Проходим по каждому методу
        for (Method method : methods) {
            // Проверяем, аннотирован ли метод аннотацией RunTimes
            if (method.isAnnotationPresent(RunTimes.class)) {
                if (Modifier.isProtected(method.getModifiers()) | Modifier.isPrivate(method.getModifiers())) {
                    RunTimes annotation = method.getAnnotation(RunTimes.class);
                    int runTimes = annotation.value();  // Получаем значение параметра аннотации
                    // Делаем метод доступным для вызова (если он защищенный или приватный)
                    method.setAccessible(true);

                    // Вызов метода нужное количество раз
                    for (int i = 0; i < runTimes; i++) {
                        Class<?>[] parameterTypes = method.getParameterTypes();
                        Object[] arguments = null;
                        try {
                            arguments = getArguments(parameterTypes);
                            method.invoke(myClass, arguments);
                        } catch (WrongParameter e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    private static Object[] getArguments(Class<?>[] parameterType) throws WrongParameter {
        Object[] arguments = new Object[parameterType.length];
        for (int i = 0; i < parameterType.length; i++) {
            if (parameterType[i] == int.class) {
                arguments[i] = 4321;
            }
            else if (parameterType[i] == short.class) {
                arguments[i] = 42;
            }
            else if (parameterType[i] == byte.class) {
                arguments[i] = 1;
            }
            else if (parameterType[i] == long.class) {
                arguments[i] = 6543212L;
            }
            else if (parameterType[i] == float.class) {
                arguments[i] = 9312.0F;
            }
            else if (parameterType[i] == double.class) {
                arguments[i] = 1238892.0;
            }
            else if (parameterType[i] == String.class) {
                arguments[i] = "Hello World";
            }
            else if (parameterType[i] == char.class) {
                arguments[i] = 'u';
            }
            else if (parameterType[i] == boolean.class) {
                arguments[i] = true;
            } else {
                throw new WrongParameter("Unknown type in method: " + parameterType[i]);
            };
        };
        return arguments;
    }
}