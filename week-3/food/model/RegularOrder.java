package food.model;

public class RegularOrder extends FoodOrder implements Discountable {


    public RegularOrder(int id, String name, double amount) {
        super(id,name,amount);
    }


    @Override
    public double calculateDeliveryCharge() {
        return 80;
    }


    @Override
    public double applyDiscount() {
        return getAmount() * 0.10;
    }

}