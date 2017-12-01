import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        String str = "hello";
        System.out.println(str);
        Class<?> clazz = str.getClass();
        try {
            Field field = clazz.getDeclaredField("value");
            field.setAccessible(true);
            byte[] crs = new byte[] {'w', 'o', 'r', 'l', 'd'};
            field.set(str, crs);
            System.out.println(str);
            System.out.println("hello");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        clazz = UnaryArithmeticOperation.class;
        try {
            Constructor constructor = clazz.getConstructor(double.class);
            UnaryArithmeticOperation uao = (UnaryArithmeticOperation) constructor.newInstance(123.05);
            Field field = clazz.getDeclaredField("value");
            field.setAccessible(true);
            System.out.println(field.get(uao));
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method: methods) {
                System.out.println(method.getName());
                if (method.getParameterCount() == 0) {
                    method.invoke(uao);
                }
                else {
                    method.invoke(uao, 100.0);
                }
                System.out.println(uao);
            }
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException
                | InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
