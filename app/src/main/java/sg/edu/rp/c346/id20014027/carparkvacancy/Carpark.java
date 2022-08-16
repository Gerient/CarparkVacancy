package sg.edu.rp.c346.id20014027.carparkvacancy;

public class Carpark {

    private String totalLots;
    private String lotType;
    private String availLots;

    public Carpark(String totalLots, String lotType, String availLots) {
        this.totalLots = totalLots;
        this.lotType = lotType;
        this.availLots = availLots;
    }

    public String getTotalLots() {
        return totalLots;
    }

    public void setTotalLots(String totalLots) {
        this.totalLots = totalLots;
    }

    public String getLotType() {
        return lotType;
    }

    public void setLotType(String lotType) {
        this.lotType = lotType;
    }

    public String getAvailLots() {
        return availLots;
    }

    public void setAvailLots(String availLots) {
        this.availLots = availLots;
    }

    @Override
    public String toString() {
        return "Carpark{" +
                "Total Lots='" + totalLots + '\'' +
                ", Lot Type='" + lotType + '\'' +
                ", Available Lots='" + availLots + '\'' +
                '}';
    }
}
