import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int beginNumber = scanner.nextInt();
        int endNumber = scanner.nextInt();
        //loop
        for (int i = beginNumber; i <= endNumber; i++) {
            if ((i % 3 == 0)&&(i % 5 == 0)) {
                System.out.println("FizzBuzz");
            } else if (i % 5 == 0){
                System.out.println("Buzz");
            } else if (i % 3 == 0){
                System.out.println("Fizz");
            }
            else System.out.println(i);
        }
    }
}