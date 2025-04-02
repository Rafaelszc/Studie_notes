#include <stdio.h>

void swap(int *first, int *second){
    int temp;

    temp = *first;
    *first = *second;
    *second = temp;
}

void selection_sort(int *array, int len){
    int i, j, min, temp;

    for (i=0; i < len-1; i++){
        min = i;

        for (j=i+1; j < len; j++){
            if (array[j] < array[min]){
                min = j;
            }
        }
        swap(&array[i], &array[min]);
    }
}

void print_array(int *array, int len){
    for (int i=0; i<len; i++){
        printf("%d", array[i]);
        if (i < len-1){
            printf(", ");
        }
        else{
            printf("\n");
        }
    }
}

void main(){
    int array[10] = {213, 2, 54, 12, 53, 2, 75, 4, 674, 24};

    print_array(array, 10);

    selection_sort(array, 10);

    print_array(array, 10);
}