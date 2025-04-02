import java.util.*;

public class SelectionSort{
    public static void main(String[] args){
        int array[] = {213, 2, 54, 12, 53, 2, 75, 4, 674, 24};

        print_array(array);

        array = selection_sort(array);

        print_array(array);
    }

    public static void print_array(int[] array){
        int len = array.length;

        for (int i=0; i<len; i++){
            System.out.printf("%d", array[i]);

            if (i < len-1){
                System.out.print(", ");
            }
            else {
                System.out.print("\n");
            }
        }
    }

    public static int[] selection_sort(int[] array){
        int len = array.length;

        for (int i=0; i<len-1; i++){
            int min = i;

            for (int j=i+1; j<len; j++){
                if (array[min] > array[j]){
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }

        return array;
    }
}