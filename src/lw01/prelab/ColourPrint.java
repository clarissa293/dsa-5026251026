package lw01.prelab;

public class ColourPrint extends PrintJob {

    public ColourPrint(String id, int pages) {
        super(id, pages);
    }

    @Override
    public int calculateCharge() {
        if (super.getPages() <= 10) {
            return (super.getPages() * 1500) + 2000;
        } else {
            return 15000 + (super.getPages()%10 * 1000) + 2000;
        }
    }

    @Override
    public String label() {
        return "Colour";
    }
    
}
