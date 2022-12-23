import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int i,j,temp = 0;
        int size = scanner.nextInt();
        int [] array = new int[size];
        for (i =0; i< array.length;i++){
            array[i]= scanner.nextInt();
        }
        for (i=0;i<array.length;i++){
            for (j=i+1;j< array.length;j++){
                if (array[j]<array[i]){
                    temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
        System.out.println(array[0]);
    }
}