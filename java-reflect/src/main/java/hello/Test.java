package hello;

import hello.greeting.Greeting;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by zhaoyan on 15-12-6.
 */
public class Test {

    public static  void main1(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<?> class1 = null;
        try {
            class1 = Class.forName("hello.greeting.Greeting");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(class1.getName());
        for(Method method:class1.getDeclaredMethods()){
            System.out.println(method.getName());
        }
        Object object  = class1.newInstance();
//
        class1.getDeclaredField("id").setAccessible(true);
        class1.getDeclaredField("id").setLong(object, 185l);
        System.out.println(object);
        StringBuffer sb = new StringBuffer();
        for(Field field:class1.getDeclaredFields()){
            sb.append(Modifier.toString(field.getModifiers())+" ");
            sb.append(field.getType().getSimpleName() + " ");//属性的类型的名字
            sb.append(field.getName()+";\n");//属性的名字+回车
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Greeting greeting = new Greeting();
        Class<?> class1 = greeting.getClass();
        Method targetMethod = class1.getDeclaredMethod("getContent");
        targetMethod.invoke()
    }
}
