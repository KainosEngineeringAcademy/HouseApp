import java.io.File;
import java.util.Date;

public class House {
    private Integer numRooms;
    private String energyRating;
    private Double price;
    private String address;
    private Integer numDoors;
    private Integer numBathrooms;
    private HouseType houseType;
    private Date buildDate;

    public House(Integer numRooms, String energyRating, Double price, String address, Integer numDoors, Integer numBathrooms) {
        this.numRooms = numRooms;
        this.energyRating = energyRating;
        this.price = price;
        this.address = address;
        this.numDoors = numDoors;
        this.numBathrooms = numBathrooms;
    }

    public House(Integer numRooms, String energyRating, Double price, String address, Integer numDoors,
                 Integer numBathrooms, HouseType houseType) {
        this.numRooms = numRooms;
        this.energyRating = energyRating;
        this.price = price;
        this.address = address;
        this.numDoors = numDoors;
        this.numBathrooms = numBathrooms;
        this.houseType = houseType;
    }

    public Integer getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(Integer numRooms) {
        if (numRooms < 0) {

        }
        this.numRooms = numRooms;
    }

    public String getEnergyRating() {
        return energyRating;
    }

    public void setEnergyRating(String energyRating) {
        this.energyRating = energyRating;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(Integer numDoors) {
        this.numDoors = numDoors;
    }

    public Integer getNumBathrooms() {
        return numBathrooms;
    }

    public void setNumBathrooms(Integer numBathrooms) {
        this.numBathrooms = numBathrooms;
    }

    public Date getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(Date buildDate) {
        this.buildDate = buildDate;
    }

    public double getRates() {
        switch (this.houseType) {
            case BUNGALOW:
                return 0.5;
            case DETACHED:
                return 0.6;
            case SEMI_DETACHED:
                return 0.9;
        }
        return 0;
    }

    public void printRates() {
        switch (this.houseType) {
            case BUNGALOW:
                System.out.println(0.5);
                break;
            case DETACHED:
                System.out.println(0.6);
                break;
            case SEMI_DETACHED:
                System.out.println(0.9);
                break;
        }
    }

    public void printHouseTypes() {
        for (HouseType type: HouseType.values()) {
            System.out.println(type);
        }
    }
}
