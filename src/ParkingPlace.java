public class ParkingPlace {
    enum PlaceType{
        CAR, MOTO, TRUCK;
    }

    private boolean isFree;
    private int id;
    private PlaceType placeType;


    public ParkingPlace(boolean isFree, int id, PlaceType placeType) {
        this.isFree = isFree;
        this.id = id;
        this.placeType = placeType;
    }

    public ParkingPlace() {

    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlaceType getPlaceType() {
        return placeType;
    }

    public void setPlaceType(PlaceType placeType) {
        this.placeType = placeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParkingPlace that = (ParkingPlace) o;

        if (isFree != that.isFree) return false;
        if (id != that.id) return false;
        return placeType != null ? placeType.equals(that.placeType) : that.placeType == null;
    }

    @Override
    public int hashCode() {
        int result = (isFree ? 1 : 0);
        result = 31 * result + id;
        result = 31 * result + (placeType != null ? placeType.hashCode() : 0);
        return result;
    }
}
