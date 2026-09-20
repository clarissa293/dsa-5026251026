package lw01.prelab;

abstract public class PrintJob implements Chargeable {
    private String id;
    private int pages;

    public PrintJob(String id, int pages) {
        this.id=id;
        this.pages=pages;
    }

    public String getId() {
        return this.id;
    }

    public int getPages() {
        return this.pages;
    }

    abstract public int calculateCharge();

    public int calculateCharge(int copies) {
        return copies * calculateCharge();
    }

    public String label() {
        return "Print";
    }

    public String summary() {
        return this.id + " | " + label() + " | " + calculateCharge();
    }

}
