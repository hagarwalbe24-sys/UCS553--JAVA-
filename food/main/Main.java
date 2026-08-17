package food.main;


import food.model.*;
import food.utility.OrderUtility;


public class Main {


    public static void main(String args[]){


        FoodOrder orders[] = new FoodOrder[6];


        orders[0] = new RegularOrder(1,"harshil",300);
        orders[1] = new PremiumOrder(2,"rajesh",600);
        orders[2] = new RegularOrder(3,"raman deep",900);
        orders[3] = new PremiumOrder(4,"Neha",1000);
        orders[4] = new RegularOrder(5,"ramkishore",400);
        orders[5] = new PremiumOrder(6,"sameer",900);



        for(FoodOrder order : orders){


            OrderUtility.generateSummary(order);


            Discountable d = (Discountable)order;


            double discount = d.applyDiscount();

            double delivery = order.calculateDeliveryCharge();


            double finalAmount =
                    order.getAmount()
                    - discount
                    + delivery;


            System.out.println("Discount : " + discount);

            System.out.println("Final Payable Amount : "
                    + finalAmount);

            System.out.println("-------------------------");

        }


        FoodOrder.displayTotalOrders();

    }

}