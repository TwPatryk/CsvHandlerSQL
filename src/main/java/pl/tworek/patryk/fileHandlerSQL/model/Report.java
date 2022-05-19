package pl.tworek.patryk.fileHandlerSQL.model;

public class Report {

    private int buy;
    private int supply;
    private int result;

    public Report() {
    }

    public Report(int buy, int supply, int result) {
        this.buy = buy;
        this.supply = supply;
        this.result = result;
    }

    public int getBuy() {
        return buy;
    }

    public void setBuy(int buy) {
        this.buy = buy;
    }

    public int getSupply() {
        return supply;
    }

    public void setSupply(int supply) {
        this.supply = supply;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
