package cinema;

import java.util.Scanner;


public class Cinema {
    static Scanner scanner = new Scanner(System.in);
    static int totalTicket=0;
    static int totalIncome=0;
    static int ticketBought=0;
    static int rows=0;
    static int seats=0;

    public static <totalTicket> void main(String[] args) {
        // Write your code here
        int currentIncome = 0;
//        int totalTicket=0,totalIncome=0;
        System.out.print("Enter the number of rows:\n" +
                "> ");
        rows = scanner.nextInt();
        System.out.print("Enter the number of seats in each row:\n" +
                "> ");
        seats = scanner.nextInt();
        //calculate the variables
        totalTicket=rows*seats;
        //set twoDimArray to S
        char[][] twoDimArray = new char[rows][seats];
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[i].length; j++) {
                twoDimArray[i][j] = 'S';
            }
        }

        //calculate totalIncome
        int totalSeat=rows*seats;
        if (totalSeat<60){
            totalIncome=10*totalSeat;
        }else {
            if (rows % 2 == 0) {
                totalIncome = (10 + 8) / 2 * totalSeat;
            } else {
                totalIncome = ((rows / 2) * 10 + (rows / 2 + 1) * 8) * seats;
            }
        }
        //menu
        int choice = 0;
        boolean exit = false;
        do {
            choice = menuFunction();
            if (choice== 1){
                printSeats(rows,seats,twoDimArray);
            }
            if (choice ==2){
                currentIncome+=buyTicket(rows,seats,twoDimArray);
//                ticketBought++;
//                System.out.println(currentIncome);
            };
            if (choice==3){
                Statistics (currentIncome);
            }
            if (choice==0) {exit=true;}
        } while (choice!=0&!exit);
    }

    private static void Statistics(int m_currentIncome) {
        float ticketPercentage=((float)ticketBought/(float)totalTicket)*100;
//        System.out.println(ticketBought);
//        System.out.println(totalTicket);
        System.out.println();
        System.out.println("Number of purchased tickets: "+ticketBought);
        String str = String.format("Percentage: %.2f",ticketPercentage);
        System.out.println(str+"%");
        System.out.println("Current income: $"+m_currentIncome);
        System.out.println("Total income: $"+totalIncome);

    }

    //Menu
    private static int menuFunction(){
        System.out.println();
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        System.out.print("> ");
        int choice = scanner.nextInt();
        return choice;
    }
    //buy ticket
    private static int buyTicket(int m_rows, int m_seats, char [][] m_twoDimArray) {
        int price ,priceF, priceB= 0;
        int finalPrice=0;
        int rowPosition=0;
        int seatPosition=0;
        do {
            System.out.println();
            System.out.print("Enter a row number:\n" +
                    "> ");
            rowPosition = scanner.nextInt();
            System.out.print("Enter a seat number in that row:\n" +
                    "> ");
            seatPosition = scanner.nextInt();
            System.out.println();

            if (rowPosition > rows || seatPosition > seats) {
                System.out.println("Wrong input!");
            } else if (m_twoDimArray[rowPosition - 1][seatPosition - 1] == 'B') {
                System.out.println("That ticket has already been purchased!");
            }
        }while (rowPosition > rows || seatPosition > seats||(m_twoDimArray[rowPosition - 1][seatPosition - 1] == 'B'));

        //total + logic + price
            int totalSeat = m_rows*m_seats;
            if (totalSeat<60){
                price = 10 ;
                System.out.println("Ticket price: $"+price);
                finalPrice=price;
            } else if (totalSeat>=60){
                priceF = 10;
                priceB = 8;

                if(rowPosition<=m_rows/2) {
                    System.out.println("Ticket price: $" + priceF);
                    finalPrice=priceF;
                } else{
                    System.out.println("Ticket price: $" + priceB);
                    finalPrice=priceB;
                }

            }
        m_twoDimArray[rowPosition-1][seatPosition-1]='B';
        ticketBought++;

        return finalPrice;
    }

    //print seat
    private static void printSeats(int m_rows, int m_seats, char [][] m_twoDimArray) {
        System.out.println("Cinema:");
        System.out.print(" ");

        //1st line
        for (int i = 1; i <= m_seats; i++) {
            System.out.print(" " + i);
        }
        System.out.print("\n");
        //print row
        for (int i = 0; i < m_rows; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < m_seats; j++) {
                System.out.print(" " + m_twoDimArray[i][j]);
            }
            System.out.println();
        }
    }

}