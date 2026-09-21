package lw01.unguided;

public class LaptopRental extends Rental {

    public LaptopRental(String id, int days) {
        super(id, days);
    }

    @Override 
    public int calculateCharge() {
        int price=super.getDays()*40000;

        return price + 10000;
    }

    @Override 
    public String label() {
        return "Laptop";
    }
    
}
