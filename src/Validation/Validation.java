package Validation;

import Model.Product;

import java.util.Scanner;

public class Validation {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    private final static Scanner sc = new Scanner(System.in);


    //check user input string
    public static String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println(ANSI_RED + "Not empty" + ANSI_RESET);
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    //check quantity  product input number limit
    public static double checkInputQuantityLimit(Product product) {
        //loop until user input correct
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine().trim());
                if (result > product.getTotal()) {
                    System.out.println(ANSI_RED + "The total product now is " + product.getTotal() + "." + ANSI_RESET);
                    System.out.print("Enter again: ");
                } else if (result <= 0) {
                    System.out.println(ANSI_RED + "Your input should bigger than 0" + "." + ANSI_RESET);
                    System.out.print("Enter again: ");
                } else if (product.isSale() && (result + result / product.getBuy() * product.getBonus() > product.getTotal())) {
                    System.out.println(ANSI_RED + "The total product in ware is not enough for bonus."+ ANSI_RESET);
                    System.out.print("Enter again: ");
                } else {
                    return result;
                }
            } catch (NumberFormatException ex) {
                System.out.println(ANSI_RED + "Your input should be number" + ANSI_RESET);
                System.out.print("Enter again: ");
            }

        }
    }

    //check user input number limit
    public static int checkInputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "The menu option in range [" + min + ", " + max + "]" + ANSI_RESET);
                System.out.print("Enter again: ");
            }
        }
    }
}
