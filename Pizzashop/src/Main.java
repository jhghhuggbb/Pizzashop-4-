
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class PizzaShop {
    // Shop name
    private String shopName;
    // Address
    private String address;
    // Email
    private String email;
    // Phone number
    private String phone;
    // Menu, key is pizza name, value is price
    private Map<String, Double> menu;
    // Toppings list
    private List<String> toppings;
    // Side dishes list
    private List<String> sideDishes;
    // Beverages list
    private List<String> beverages;
    // Order ID counter
    private int orderIdCounter;

    public static final long BLACKLISTED_NUMBER = 12345678901234L;

    public PizzaShop(String shopName, String address, String email, String phone) {
        this.shopName = shopName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.menu = new HashMap<>();
        this.toppings = new ArrayList<>();
        this.sideDishes = new ArrayList<>();
        this.beverages = new ArrayList<>();
        this.orderIdCounter = 1;
    }

    // Add pizza to the menu
    public void addPizzaToMenu(String pizzaName, double price) {
        menu.put(pizzaName, price);
    }

    // Add topping
    public void addTopping(String topping) {
        toppings.add(topping);
    }

    // Add side dish
    public void addSideDish(String sideDish) {
        sideDishes.add(sideDish);
    }

    // Add beverage
    public void addBeverage(String beverage) {
        beverages.add(beverage);
    }

    // Take an order
    public Order takeOrder() {
        Scanner scanner = new Scanner(System.in);
        int ingChoice1, ingChoice2, ingChoice3;
        String ing1, ing2, ing3;

        while (true) {
            System.out.println("Please pick any three of the following ingredients:\n1. Mushroom\n2. Paprika\n3. Sun-dried tomatoes\n4. Chicken\n5. Pineapple\nEnter any three choices (1, 2, 3,…) separated by spaces:");
            String[] choices = scanner.nextLine().split(" ");
            if (choices.length == 3) {
                try {
                    ingChoice1 = Integer.parseInt(choices[0]);
                    ingChoice2 = Integer.parseInt(choices[1]);
                    ingChoice3 = Integer.parseInt(choices[2]);
                    if (ingChoice1 >= 1 && ingChoice1 <= 5 && ingChoice2 >= 1 && ingChoice2 <= 5 && ingChoice3 >= 1 && ingChoice3 <= 5) {
                        break;
                    }
                } catch (NumberFormatException e) {
                    
                }
            }
            System.out.println("Invalid choice(s). Please pick only from the given list:");
        }

        switch (ingChoice1) {
            case 1:
                ing1 = "Mushroom";
                break;
            case 2:
                ing1 = "Paprika";
                break;
            case 3:
                ing1 = "Sun-dried tomatoes";
                break;
            case 4:
                ing1 = "Chicken";
                break;
            case 5:
                ing1 = "Pineapple";
                break;
            default:
                ing1 = "";
        }

        switch (ingChoice2) {
            case 1:
                ing2 = "Mushroom";
                break;
            case 2:
                ing2 = "Paprika";
                break;
            case 3:
                ing2 = "Sun-dried tomatoes";
                break;
            case 4:
                ing2 = "Chicken";
                break;
            case 5:
                ing2 = "Pineapple";
                break;
            default:
                ing2 = "";
        }

        switch (ingChoice3) {
            case 1:
                ing3 = "Mushroom";
                break;
            case 2:
                ing3 = "Paprika";
                break;
            case 3:
                ing3 = "Sun-dried tomatoes";
                break;
            case 4:
                ing3 = "Chicken";
                break;
            case 5:
                ing3 = "Pineapple";
                break;
            default:
                ing3 = "";
        }

        int sizeChoice;
        String pizzaSize;
        while (true) {
            System.out.println("What size should your pizza be?\n1. Large\n2. Medium\n3. Small\nEnter only one choice (1, 2, or 3):");
            try {
                sizeChoice = scanner.nextInt();
                if (sizeChoice >= 1 && sizeChoice <= 3) {
                    break;
                }
            } catch (Exception e) {
                
            }
            System.out.println("Invalid choice. Please enter a valid option:");
            scanner.nextLine();
        }

        switch (sizeChoice) {
            case 1:
                pizzaSize = "Large";
                break;
            case 2:
                pizzaSize = "Medium";
                break;
            case 3:
                pizzaSize = "Small";
                break;
            default:
                pizzaSize = "";
        }

        scanner.nextLine();
        System.out.println("Do you want extra cheese (Y/N):");
        String extraCheese = scanner.nextLine();

        int sideDishChoice;
        String sideDish;
        while (true) {
            System.out.println("Following are the side dish that go well with your pizza:\n1. Calzone\n2. Garlic bread\n3. Chicken puff\n4. Muffin\n5. Nothing for me\nWhat would you like? Pick one (1, 2, 3,…):");
            try {
                sideDishChoice = scanner.nextInt();
                if (sideDishChoice >= 1 && sideDishChoice <= 5) {
                    break;
                }
            } catch (Exception e) {
                
            }
            System.out.println("Invalid choice. Please enter a valid option:");
            scanner.nextLine();
        }

        switch (sideDishChoice) {
            case 1:
                sideDish = "Calzone";
                break;
            case 2:
                sideDish = "Garlic bread";
                break;
            case 3:
                sideDish = "Chicken puff";
                break;
            case 4:
                sideDish = "Muffin";
                break;
            case 5:
                sideDish = "Nothing for me";
                break;
            default:
                sideDish = "";
        }

        scanner.nextLine();
        int drinkChoice;
        String drinks;
        while (true) {
            System.out.println("Choose from one of the drinks below. We recommend Coca Cola:\n1. Coca Cola\n2. Cold coffee\n3. Cocoa Drink\n4. No drinks for me\nEnter your choice:");
            try {
                drinkChoice = scanner.nextInt();
                if (drinkChoice >= 1 && drinkChoice <= 4) {
                    break;
                }
            } catch (Exception e) {
                // 捕获异常，处理非数字输入
            }
            System.out.println("Invalid choice. Please enter a valid option:");
            scanner.nextLine();
        }

        switch (drinkChoice) {
            case 1:
                drinks = "Coca Cola";
                break;
            case 2:
                drinks = "Cold coffee";
                break;
            case 3:
                drinks = "Cocoa Drink";
                break;
            case 4:
                drinks = "No drinks for me";
                break;
            default:
                drinks = "";
        }

        scanner.nextLine();
        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        String wantDiscount = scanner.nextLine();

        if (wantDiscount.equalsIgnoreCase("Y")) {
            isItYourBirthday();
        } else {
            makeCardPayment();
        }

        double totalPrice = 10.0;
        List<String> pizzas = new ArrayList<>();
        pizzas.add(ing1 + " " + ing2 + " " + ing3 + " Pizza");
        List<String> sides = new ArrayList<>();
        sides.add(sideDish);
        List<String> bev = new ArrayList<>();
        bev.add(drinks);

        String orderId = "SOH-" + orderIdCounter++;
        return new Order(orderId, pizzas, sides, bev, totalPrice);
    }

    public void isItYourBirthday() {
        Scanner scanner = new Scanner(System.in);
        Calendar cal = Calendar.getInstance();
        while (true) {
            System.out.println("Enter your birthday (in yyyy-MM-dd format):");
            String birthdateStr = scanner.nextLine();
            Date birthdate = new Date();
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                birthdate = sdf.parse(birthdateStr);
                cal.setTime(birthdate);
                int birthYear = cal.get(Calendar.YEAR);
                cal.setTime(new Date());
                int currentYear = cal.get(Calendar.YEAR);
                if (currentYear - birthYear < 5 || currentYear - birthYear > 120) {
                    System.out.println("Invalid date. You are either too young or too dead to order.\nPlease enter a valid date:");
                    continue;
                }
                break;
            } catch (ParseException e) {
                System.out.println("Invalid date format.");
            }
        }

        cal.setTime(birthdate);
        int birthMonth = cal.get(Calendar.MONTH);
        int birthDay = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(new Date());
        int currentMonth = cal.get(Calendar.MONTH);
        int currentDay = cal.get(Calendar.DAY_OF_MONTH);

        if (cal.get(Calendar.YEAR) - cal.get(Calendar.YEAR) < 18 && birthMonth == currentMonth && birthDay == currentDay) {
            System.out.println("Congratulations! You pay only half the price for your order");
        } else {
            System.out.println("Too bad! You do not meet the conditions to get our 50% discount");
        }
    }

    public void makeCardPayment() {
        Scanner scanner = new Scanner(System.in);
        long cardNumber;
        String expiryDate;
        int cvv;

        while (true) {
            System.out.println("Enter your card number:");
            try {
                cardNumber = scanner.nextLong();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid long number.");
                scanner.nextLine();
            }
        }

        scanner.nextLine();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
        while (true) {
            System.out.println("Enter the card's expiry date (in MM/yyyy format):");
            expiryDate = scanner.nextLine();
            try {
                Date date = sdf.parse(expiryDate);
                cal.setTime(date);
                int expYear = cal.get(Calendar.YEAR);
                int expMonth = cal.get(Calendar.MONTH) + 1;
                cal.setTime(new Date());
                int currentYear = cal.get(Calendar.YEAR);
                int currentMonth = cal.get(Calendar.MONTH) + 1;
                if (expYear < currentYear || (expYear == currentYear && expMonth < currentMonth)) {
                    System.out.println("Invalid date. The expiry date must be in the future.");
                    continue;
                }
                break;
            } catch (ParseException e) {
                System.out.println("Invalid date format.");
            }
        }

        while (true) {
            System.out.println("Enter the card's cvv number:");
            try {
                cvv = scanner.nextInt();
                if (String.valueOf(cvv).length() == 3) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a 3 - digit number.");
                scanner.nextLine();
            }
        }

        processCardPayment(cardNumber, expiryDate, cvv);
    }

    public void processCardPayment(long cardNumber, String expiryDate, int cvv) {
        while (true) {
            String cardNumberStr = Long.toString(cardNumber);
            int cardLength = cardNumberStr.length();
            if (cardLength == 14 && cardNumber != BLACKLISTED_NUMBER) {
                System.out.println("Card accepted");
                break;
            } else {
                System.out.println("Invalid card. Please enter a 14 - digit number that is not blacklisted.");
                Scanner scanner = new Scanner(System.in);
                cardNumber = scanner.nextLong();
            }
        }

        int firstCardDigit = Integer.parseInt(Long.toString(cardNumber).substring(0, 1));

        int lastFourDigits = Integer.parseInt(Long.toString(cardNumber).substring(Long.toString(cardNumber).length() - 4));

        String cardNumberToDisplay = Long.toString(cardNumber).substring(0, 1) + Long.toString(cardNumber).substring(1, Long.toString(cardNumber).length() - 4).replaceAll(".", "*") + Long.toString(cardNumber).substring(Long.toString(cardNumber).length() - 4);
        System.out.println("Card number to display: " + cardNumberToDisplay);
    }

    public void specialOfTheDay(String pizzaOfTheDay, String sideOfTheDay, String specialPrice) {
        System.out.println("Today's special:");
        System.out.println("Pizza: " + pizzaOfTheDay);
        System.out.println("Side dish: " + sideOfTheDay);
        System.out.println("Special price: " + specialPrice);
    }

    // Public method to call the private printReceipt method
    public void showReceipt(Order order) {
        System.out.println(order);
    }
}

// Order class
class Order {
    // Make orderID and orderTotal private
    private String orderID;
    private List<String> pizzas;
    private List<String> sideDishes;
    private List<String> beverages;
    private double orderTotal;
    private String pizzaIngredients;

    // Create final variables
    private static final String DEF_ORDER_ID = "DEF-SOH-099";
    private static final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    private static final double DEF_ORDER_TOTAL = 15.00;

    // Default constructor
    public Order() {
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        this.orderTotal = DEF_ORDER_TOTAL;
        this.sideDishes = new ArrayList<>();
        this.beverages = new ArrayList<>();
        this.pizzas = new ArrayList<>();
    }

    // Constructor with parameters
    public Order(String orderID, List<String> pizzas, List<String> sideDishes, List<String> beverages, double orderTotal) {
        this.orderID = orderID;
        this.pizzas = pizzas;
        this.sideDishes = sideDishes;
        this.beverages = beverages;
        this.orderTotal = orderTotal;
        this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
    }

    // Getter and Setter methods
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }