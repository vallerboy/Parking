import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class ParkingGenerator {

    private Random random;

    public ParkingGenerator() {
        random = new Random();
    }

    public List<ParkingPlace> getRandomParkingPlaces(int howMany){
        List<ParkingPlace> parkingPlaceList = new ArrayList<>();

        for (int i = 0; i < howMany; i++) {
            ParkingPlace parkingPlace = new ParkingPlace();
            parkingPlace.setFree(random.nextBoolean());
            parkingPlace.setId(i);
            parkingPlace.setPlaceType(getRandomPlaceType());
        }

        return parkingPlaceList;
    }


    private ParkingPlace.PlaceType getRandomPlaceType(){
        switch (random.nextInt(2)){
            case 0: {
                return ParkingPlace.PlaceType.CAR;
            }
            case 1: {
                return ParkingPlace.PlaceType.TRUCK;
            }
            case 2: {
                return ParkingPlace.PlaceType.MOTO;
            }
        }
        return null;
    }



}
