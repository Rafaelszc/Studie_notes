# Como garantir uma instância única em Singleton

## Destrinchando uma instância

Instância seria quando estamos executando/chamando a funcão.

Como exemplo, vamos criar a seguinte classe em Java:

```java
public class Rafael {
    String name;
    String fav_food;
    int age;

    public void say_my_name(){
        System.out.println("Hello, my name is " + name + " a'm " + age + " years old, and my favorite food is " + fav_food);
    }
```

E agora vamos instanciar essa classe, isso irá transformá-la emum objeto.

```java
public static void main(String[] Args){
    Rafael rafael = new Rafael();

    rafael.name = "zozas";
    rafael.age = 18;
    rafael.fav_food = "hamburguer";

    rafael.say_my_name();
    }
```

Aqui, o objeto da classe Rafael foi instanciado como rafael, nisso conseguimos atribuir os valores que quisermos para esse objeto. Assim, a conclusão que temos é que a instância é apenas uma chamada, uma delcaracão de que estamos usando uma determinada classe, já o objeto seria a individualizacão dessa instância.

## O que é Singleton?

Para entender melhor sobre esse [design pattern](design_patterns.md), é necessário entender sobre o que é uma Creational Design Pattern. Mas, em termos gerais, o Singleton Method Design Pattern é um padrão que garante que uma classe possuirá uma única instância. Isso é de extrema importância para sistemas que trabalham com banco de dados, sistemas de caching e game design. 
A vantagem do Singleton é a seguranca em relacão ao alocamento de memória armazenado para determinada instância, além de que essa instância é global (tal como a funcão ```say_my_name()``` no exemplo dado).

### Como o Singleton funciona?

O Singleton vai precisar de alguns parâmetros. Sendo eles:

1. O construtor da instância
2. A variável de controle da instância
3. O método de instância

Desses, o único parâmetro público será o método de instância, forcando o programa a acessar os métodos da classe apenas por ele.

Podemos observar esses parâmetros da seguinte maneira:
```java
import java.io.*

class MySingleton {
    private static MySingleton instance;
}
```

Aqui declaramos a variável de instância como sendo um método privado (só pode ser acessado dentro da prórpia classe) e estático (acessado sem precisar de uma instância de classe).

```java
    private MySingleton() {
        System.out.println("Singleton class has been instantiated");
    }
```

Aqui, o construtor da classe é definido também como um privado, para evitar que fora do escopo da classe seja acessado o construtor.

```java
    public static Singleton get_instance(){
        if (instance == null) {
            instance = new MySingleton;
        }
        return instance;
    }
```

Por último, aqui há o método de instância da classe com o tipo sendo a própria classe (importante para que seja o único método que possa ser instânciado de forma pública, já que o prórpio construtor da classe está privado), além de que o método é público assim podendo ser acessado fora do seu próprio escopo. Por fim, um método estático, impedindo que a classe seja instanciada para que esse prórpio método seja chamado, assim garantindo a porta única à classe.

Estrutura completa:
```java
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
```

Caso venhamos a testar se realmente a locagem de memória sempre será a mesma, vamos fazer alguns testes:

```java
class TestSingleton{
    public static void main(String[] args){
        MySingleton x = MySingleton.get_instance();
        MySingleton y =  MySingleton.get_instance();

        System.out.println("The memory hash of X is: " + System.identityHashCode(x));
        System.out.println("The memory hash of Y is: " + System.identityHashCode(y));
    }
}
```
Output:
```
Singleton class has been instantiated
The memory hash of X is: 1461149300
The memory hash of Y is: 1461149300
```
Caso o código tente acessar a classe de outra forma, ocorrerá um erro:

```java

class TestSingleton{
    public static void main(String[] args){
        MySingleton z = new MySingleton();

        z.say_hello("Rafael");
    }
}
```

Output:

```
main.java:11: error: MySingleton() has private access in MySingleton
        MySingleton z = new MySingleton();
                        ^
1 error
error: compilation failed
```

## Conclusão

Para garantir a instância única da classe, basta direcionar o meio de instância para uma funcão estática que retorna uma nova instância da classe, caso ainda não exista, senão retorna a instância anterior.

## Fontes:

1. https://www.geeksforgeeks.org/software-design-patterns/
2. https://www.geeksforgeeks.org/creational-design-pattern/
3. https://www.geeksforgeeks.org/singleton-design-pattern/