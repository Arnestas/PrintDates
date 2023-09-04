package org.example;

import java.util.Scanner;

public class PrintDates {

    public static void main(String[] args) {
        System.out.println("\nThis program prints all dates between two given years that remains the same, " +
                "if numbers of the date are reversed.");
        System.out.println("In example: if year from is 2010 and year to is 2015,");
        System.out.println("the output will be 2010-01-02 and 2011-11-02\n");

        System.out.println("Please enter year from: ");
        int from = input();
        System.out.println("Please enter year to: ");
        int to = input();
        if (from < to){
            printBonusDatesBetween(from, to);
        } else System.out.println("Wrong year input!");
    }

    public static int input (){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void printBonusDatesBetween(int fromYear, int toYear) {
        String month, day;
        int quantityOfSuitableDates = 0;
        System.out.println("\nThe answer: ");
        for (int year = fromYear; year <= toYear; year++) {
            month = reverseNumbers(year % 100);
            day = reverseNumbers(year / 100);
            if (monthIsValid(month) && dayIsValid(year, month, day)){
                System.out.println(year + "-" + month + "-" + day);
                quantityOfSuitableDates++;
            }
        }
        if (quantityOfSuitableDates == 0){
            System.out.println("There are no suitable dates.");
        }
    }

    public static String reverseNumbers(int number){
        int n1 = number % 10;
        int n2 = number / 10;
        return n1 + "" + n2;
    }

    public static boolean monthIsValid(String month){
        return Integer.parseInt(month) > 0 && Integer.parseInt(month) < 13;
    }

    public static boolean dayIsValid(int year, String month, String day){
        return Integer.parseInt(day) > 0 && Integer.parseInt(day) <= checkDay(year, month) ;
    }

    public static int checkDay(int year, String m){
        int month = Integer.parseInt(m);
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (year % 4 ==0){
                    return 29;
                } else {
                    return 28;
                }
            default:
                return -1;
        }
    }
}