import java.util.Scanner;

public class Main {

    public static int sign(int number) {
        // write your code here
        int answer = 0;
        if (number>0) answer=1;
        else if (number==0) answer=0;
        else if (number<0) answer=-1;
        return answer;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        System.out.println(sign(n));
    }
}