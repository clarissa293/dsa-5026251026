package lw01.unguided;

abstract public class Rental implements Chargeable {
    private String id;
    private int days;

    public Rental (String id, int days) {
        this.id=id;
        this.days=days;

        if (days < 1) {
            throw new IllegalArgumentException("Days cannot be zero or negative");
        }

        if (days > 30) {
            throw new IllegalArgumentException("Days cannot exceed 30");
        }

        if (id == null) {
            throw new IllegalArgumentException("ID not valid");
        }

    }
    
        public String getId() {
            return this.id;
        }

        public int getDays() {
            return this.days;
        }

        @Override 
        abstract public int calculateCharge();

        //overload
        public int calculateCharge(int units) {
            if (units < 1) {
                throw new IllegalArgumentException("Units cannot be zero or negative");
            }
            return units * calculateCharge();
        }

        public String label() {
            return "Rental";
        }
    }
    
