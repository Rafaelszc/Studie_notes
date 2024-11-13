# Selection sort 

## Funcionamento

O algoritmo de ordenacão Selection Sort se comporta da seguinte maneira:

1. Inicialmente, o algoritmo determina que o primeiro index de uma lista será o index do menor valor
2. Depois, irá comparar o elemento que esse index minimo pertence a todos os outros seguintes
3. Quando encontrar um elemento menor que o elemento minimo atual, o index desse novo elemento será o index minimo
4. Para cada N elementos da lista, N trocas serão feitas. Então, ao final de cada varredura de verificacão de mínimo, o valor mínimo irá ocupar o seu devido lugar na lista

Esse algoritmo não chega a ser um dos melhores, mas é um dos mais simples a se entender. 

## Calculo de BigO

O algoritmo utiliza de dois loops, porém o segundo deles vai reduzindo o seu limite inferior a cada vez que é utilizado. Então, as comparacões feitas se comportam da seguitne forma:

```java
for (int i=0; i<len-1; i++){
    ...
    for (int j=i+1; j<len; j++){
        ...
    }
}
```
As comparacões são feitas no loop envolvendo o valor de j, então para descobrir a complexidade, é necessário saber quantas vezes j é utilizado.
De primeira, o j vai de 1 até N-1, depois vai de 2 até N-1, depois de 3 até N-1... e por aí vai, então da pra deduzir que a soma de todas as comparacões será uma progressão aritmétrica:

- (n-1)+(n-2)+(n-3)+...+1

Que isso resulta em:

- [(n-1)/2]*[(n-1)+1] = n(n-1)/2 = (n² -n)/2

Sabendo que a notacão bigO pega o grau do polinômio, então sua complexidade é de O(n²).