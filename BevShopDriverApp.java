package Assignment6;
import java.util.Scanner;

/*
 * Class: CMSC203 
 * Instructor:
 * Description: Assignment 6
 * Due: MM/DD/YYYY
 * Platform/compiler:
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Sama Akbari
*/

public class BevShopDriverApp {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        BevShop shop = new BevShop();

        System.out.println("The current order in process can have at most 3 alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is 21");

        startNewOrderProcess(keyboard, shop);

        startNewOrderProcess(keyboard, shop);

        System.out.println("\nTotal amount for all Orders: " + shop.totalMonthlySale());
    }

    private static void startNewOrderProcess(Scanner scanner, BevShop bevShop) {
        System.out.println("Start please a new order:");

        System.out.print("Would you please enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Would you please enter your age: ");
        int age = Integer.parseInt(scanner.nextLine());

        bevShop.startNewOrder(10, Day.MONDAY, name, age);

        System.out.print("Your Total Order for now is " + bevShop.getCurrentOrder().calcOrderTotal() + "\n");
        System.out.println("Your age is above 20 and you are eligible to order alcohol");

        int alcoholCount = 0;
        while (alcoholCount < 3) {
            System.out.println("Would you please add an alcohol drink (yes/no)?");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("yes")) {
                if (bevShop.isEligibleForMore()) {
                    System.out.print("The current order of drinks is " + (alcoholCount + 1) + "\n");
                    System.out.print("The Total price on the Order: " + bevShop.getCurrentOrder().calcOrderTotal() + "\n");

                    System.out.print("Would you please add a second alcohol drink: ");
                    bevShop.processAlcoholOrder("Beer", Size.LARGE);
                    alcoholCount++;
                } else {
                    System.out.println("You have a maximum alcohol drinks for this order");
                    break;
                }
            } else {
                break;
            }
        }
        System.out.print("Would you please add a COFFEE to your order: ");
        bevShop.processCoffeeOrder("Coffee", Size.MEDIUM, false, false);
        System.out.println("Total items on your order is " + bevShop.getCurrentOrder().getBeverages().size());
        System.out.println("The Total Price on the Order: " + bevShop.getCurrentOrder().calcOrderTotal());

        System.out.print("Would you please add a SMOOTHIE to your order: ");
        bevShop.processSmoothieOrder("Smoothie", Size.MEDIUM, 3, true);
        System.out.println("Total items on your order is " + bevShop.getCurrentOrder().getBeverages().size());
        System.out.println("The Total Price on the Order: " + bevShop.getCurrentOrder().calcOrderTotal());

        System.out.println("#------------------------------------#");
    }

}
