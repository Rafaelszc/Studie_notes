#include <stdio.h>
#include <stdlib.h>

typedef struct
{
    size_t size;
    int *array;
} MyArray;

MyArray *alloc_array(MyArray *arr)
{
    arr->array = (int *) malloc(arr->size * sizeof(int));

    if(arr->array == NULL)
    {
        free(arr);
        exit(1);
    }

    return arr;
}

void write_array(MyArray *arr)
{
    for(int i=0; i<arr->size; i++){
        scanf("%d", &arr->array[i]);
    }
}

void print_array(MyArray *arr)
{
    for(int i=0; i<arr->size-1; i++)
    {
        printf("%d, ", arr->array[i]);
    }
    printf("%d\n", arr->array[arr->size-1]);
}

void main()
{
    // Inicialização de um array
    int array[3] = {1, 2, 3};

    // Criação de um array por uma struct
    MyArray *arr = (MyArray *) malloc(sizeof(MyArray));
    arr->size = 3;

    arr = alloc_array(arr);

    write_array(arr);
    print_array(arr);
}