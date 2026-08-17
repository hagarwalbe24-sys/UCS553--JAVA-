package food.model;

public abstract class FoodOrder {

    private int orderId;
    private String customerName;
    private double amount;

    static String restaurantName = "Tasty Bites";
    private static int count = 0;

    public FoodOrder(int orderId, String customerName, double amount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
        count++;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public static void displayTotalOrders() {
        System.out.println("Total Orders : " + count);
    }


    public abstract double calculateDeliveryCharge();


    public void displayBill() {
        System.out.println("Order ID : " + orderId);
        System.out.println("Customer : " + customerName);
        System.out.println("Amount : " + amount);
    }
}