package com.test;
import java.util.Scanner;

public class AirTicketReservation {

    static int filled = 0;

    public static void main(String[] args) {
        char[][] selectedSeats = new char[7][4];
        for (int i = 0; i < 7; i++) {
            selectedSeats[i][0] = 'A';
            selectedSeats[i][1] = 'B';
            selectedSeats[i][2] = 'C';
            selectedSeats[i][3] = 'D';
        }

        String seatNo = " ";
        String q = " ";
        System.out.println("Welcome to the Jumbo Airlines Airplane Seating Reservation System.");
        System.out.println("Please enter the seat (e.g.- 1A) you wish to reserve.");
        System.out.println("Enter q to exit.");
        Scanner keyboard = new Scanner(System.in);
        seatNo = keyboard.nextLine();
        if (seatNo.equals("q")) {
            System.out.println("EndOfProgram.");
            System.exit(0);
        }
        // print seating pattern and put an X in the seatNo location
        while (filled < 28 && seatNo.length() > 0) {
            int row = seatNo.charAt(0) - '1';
            int col = seatNo.charAt(1) - 'A';
            if (row < 0 || row > 7 || col < 0 || col > 4) {
                System.out.println("Wrong Input. Enter seat to assign (e.g., '1A')," + "or q to quit.");
                seatNo = keyboard.nextLine();
                if (seatNo.equals("q")) {
                    System.out.println("EndOfProgram.");
                    System.exit(0);
                }
            } else {
                if (selectedSeats[row][col] != 'X') {
                    selectedSeats[row][col] = 'X';
                    filled++;
                    System.out.println(" ");
                    printselectedSeats(selectedSeats);
                }
                if (filled < 28) {
                    System.out.println("Enter seat to assign (e.g., '1A')," + "or q to quit.");
                    seatNo = keyboard.nextLine();
                    if (seatNo.equals("q")) {
                        System.out.println("EndOfProgram.");
                        System.exit(0);
                    }
                }
            }
        }
    }

    private static void printselectedSeats(char[][] selectedSeats) {
        System.out.println("Row");
        for (int i = 0; i < selectedSeats.length; i++) {
            System.out
                    .println((i + 1) + "  " + selectedSeats[i][0] + " " + selectedSeats[i][1] + "  " + selectedSeats[i][2] + " " + selectedSeats[i][3]);

        }
        int numberOfselectedSeatsAvailable = (28 - filled);
        System.out.println("There are " + numberOfselectedSeatsAvailable + " selectedSeats available.");
    } // end main
} // end class