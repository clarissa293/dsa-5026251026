package lw01.unguided;

public class ProjectorRental extends Rental {
    
    public ProjectorRental(String id, int days) {
        super(id, days);
    }

    @Override 
    public int calculateCharge() {
        int price;

        if (super.getDays() <= 3) {
            price=super.getDays()*60000; 
        } else {
            int days=super.getDays()-3;
            price=180000+(days*45000);
        }

        return price+20000;
    }

    @Override 
    public String label() {
        return "Projector";
    }

}
