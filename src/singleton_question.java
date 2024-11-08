import java.io.*;

class TestSingleton{
    public static void main(String[] args){
        MySingleton x = MySingleton.get_instance();
        MySingleton y =  MySingleton.get_instance();

        System.out.println("The memory hash of X is: " + System.identityHashCode(x));
        System.out.println("The memory hash of Y is: " + System.identityHashCode(y));
    }
}

class MySingleton{
    private static MySingleton instance;

    private MySingleton(){
        System.out.println("Singleton class has been instantiated");
    }

    public static MySingleton get_instance(){
        if (instance == null){
            instance = new MySingleton();
        }
        
        return instance;
    }

    public static void say_hello(String name){
        System.out.println("Hello, " + name);
    }
}