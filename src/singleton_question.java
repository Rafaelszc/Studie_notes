public class Rafael {
    String name;
    String fav_food;
    int age;

    public void say_my_name(){
        System.out.println("Hello, my name is " + name + " a'm " + age + " years old, and my favorite food is " + fav_food);
    }

    public static void main(String[] Args){
        Rafael rafael = new Rafael();
    
        rafael.name = "zozas";
        rafael.age = 18;
        rafael.fav_food = "hamburguer";
    
        rafael.say_my_name();
    }
    
}
