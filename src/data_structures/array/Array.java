import java.util.Scanner;

public class Array{
    public static void main(String[] args) {
        int []array_1 = {1, 2, 3};

        int []array_2 = new int[3];

        print_array(array_1);

        array_2= write_array(array_2);
        print_array(array_2);
    }

    public static int[] write_array(int[] arr){
        Scanner scanner = new Scanner(System.in);

        for(int i=0; i<arr.length; i++){
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    public static void print_array(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            System.out.printf("%d, ", arr[i]);
        }
        System.out.printf("%d\n", arr[arr.length-1]);
    }
}