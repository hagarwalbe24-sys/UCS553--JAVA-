package food.model;

public class PremiumOrder extends FoodOrder implements Discountable {


    public PremiumOrder(int id,String name,double amount) {
        super(id,name,amount);
    }


    @Override
    public double calculateDeliveryCharge() {
        return 50;
    }


    @Override
    public double applyDiscount() {
        return getAmount() * 0.15;
    }

}