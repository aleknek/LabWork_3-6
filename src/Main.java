import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {

        Class cls = MyClass.class;

        // fields
        Field[] fields = cls.getFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].getName());
        }

        Field[] fields1 = cls.getDeclaredFields();
        for (int i = 0; i < fields1.length; i++) {
            System.out.println(fields1[i].getName());
        }

        // methods
        Method[] methods = cls.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i].getName());
        }

        Method[] methods1 = cls.getMethods();
        for (int i = 0; i < methods1.length; i++) {
            System.out.println(methods1[i].getName());
        }

        // constructors
        Constructor[] constructors = cls.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(constructors[i].getName());
        }

        Constructor[] constructors1 = cls.getDeclaredConstructors();
        for (int i = 0; i < constructors1.length; i++) {
            System.out.println(constructors1[i].getParameterCount());
            Class[] params = constructors1[i].getParameterTypes();
            for (Class param : params) {
                System.out.println(param.getName());
            }
            System.out.println(constructors1[i].getParameterTypes());
            System.out.println(constructors1[i].getName());
        }


        // set
        try {
            Object object = cls.newInstance();
            System.out.println(object);
            Field field = null;
            try {
                field = cls.getDeclaredField("a");
                field.setAccessible(true);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            field.set(object, 100);
            System.out.println(object);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        // methods
        try {
            Object object1 = null;
            try {
                object1 = cls.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            Method methods2 = cls.getMethod("test");
            try {
                methods2.invoke(object1);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
