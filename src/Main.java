import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean start = true;

        while (start) {
            System.out.println("Enter 'start' to start or 'quit' to quit:");
            String command = sc.nextLine();

            if (command.equalsIgnoreCase("quit")) {
                start = false;
            } else {
                System.out.print("Enter userID: ");
                String userID = sc.nextLine();

                System.out.print("Enter password: ");
                String password = sc.nextLine();

                System.out.println("Logged In");

                System.out.print("Enter the number of items: ");
                int n = sc.nextInt();
                int[] items = new int[n];

                for (int i = 0; i < n; i++) {
                    System.out.print("Enter price: ");
                    items[i] = sc.nextInt();
                }

                System.out.print("Is VAT to be charged? (true/false): ");
                boolean vat = sc.nextBoolean();

                double total = 0;
                for (int i = 0; i < n; i++) {
                    total += items[i];
                }

                if (vat) {
                    total = total * 1.13;
                    System.out.println("Total with VAT: " + total);
                } else {
                    System.out.println("VAT not charged");
                }

                System.out.print("Is discount to be applied? (true/false): ");
                boolean discount = sc.nextBoolean();

                if (discount) {
                    System.out.print("Enter discount percentage: ");
                    double discountValue = sc.nextInt();
                    total = total - (total * discountValue / 100);
                    System.out.println("Total after discount: " + total);
                } else {
                    System.out.println("Discount not applied");
                }

                System.out.print("Enter the amount of cash you want to give: ");
                int money = sc.nextInt();

                if (money >= total) {
                    int change = (int) (money - total);

                    if (change > 0) {
                        System.out.println("Change: " + change);
                        giveChange(change);
                    } else {
                        System.out.println("Exact amount given, no change.");
                    }
                } else {
                    System.out.println("Insufficient funds provided.");
                }
            }
        }

        sc.close();
    }

    private static void giveChange(int money) {
        int[] denominations = {1000, 500, 100, 50, 20, 10, 5, 2, 1};

        for (int i = 0; i < denominations.length; i++) {
            int count = money / denominations[i];
            if (count > 0) {
                System.out.println(denominations[i] + " : " + count);
                money -= count * denominations[i];
            }
        }
    }
}
