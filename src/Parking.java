import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Parking {
    
    private List<ParkingPlace> parkingPlaces; 
    private ParkingMenu menu; 
    private ParkingGenerator generator;
    private int cash;
    
    public Parking(int staringCash){
        parkingPlaces = new ArrayList<>();
        menu = new ParkingMenu(this);
        cash = staringCash;


    }
    
    public void start(){ 
        generator = new ParkingGenerator();
        parkingPlaces.addAll(generator.getRandomParkingPlaces(100));
        menu.startLoop();
    }
    
    
    public boolean park(int id, ParkingPlace.PlaceType placeType) {
        ParkingPlace parkingPlace = findParkById(id);
        if(parkingPlace.isFree() && parkingPlace.getPlaceType() == placeType){
            parkingPlace.setFree(false);
            return true;
        }
        return false;
    }

    public boolean freeAllPlaces() {
        for (ParkingPlace parkingPlace : parkingPlaces) {
            parkingPlace.setFree(true);
        }
        return true;
    }
    
    
    private ParkingPlace findParkById(int id){
        for (ParkingPlace parkingPlace : parkingPlaces) {
            if(parkingPlace.getId() == id){
                return parkingPlace;
            }
        }
        return null;
    }

    public String createPayment(int howMany) {
        int howManyRunAway = 0;
        if(howMany > 5){
            howManyRunAway = runAwayFromParking();
        }
        cash += countNotFreeSpaces() * howMany;
        return "Budzet wynosi juz: " + cash + ", a po zebraniu haraczu ucieklo " + howManyRunAway;
    }

    private int countNotFreeSpaces() {
        int counter = 0;
        for (ParkingPlace parkingPlace : parkingPlaces) {
            if(!parkingPlace.isFree()){
                counter++;
            }
        }
        return counter;
    }

    private int runAwayFromParking(){
        Random random = new Random();
        int elements = random.nextInt(parkingPlaces.size());
        for (int i = 0; i < elements; i++) {
            if(!parkingPlaces.get(i).isFree()){
                parkingPlaces.get(i).setFree(true);
            }else{
                i -= 1;
            }
        }
        return elements;
    }

    public int calculateCashForNewPlace(ParkingPlace.PlaceType placeType) {
        switch (placeType){
            case CAR: return 100;
            case MOTO: return 50;
            case TRUCK: return 200;
        }
        return 0;
    }

    private int generateId() {
        Random random = new Random();
        int randomInt;
        do{
            randomInt = random.nextInt(Integer.MAX_VALUE);
        }while (!isIdFree(randomInt));
        return randomInt;
    }

    public  boolean isIdFree(int id){
        for (ParkingPlace parkingPlace : parkingPlaces) {
            if(parkingPlace.getId() == id){
                return false;
            }
            System.out.println(parkingPlace.getId());

        }
        return true;
    }

    public String buyNewPlace(ParkingPlace.PlaceType placeType) {
        if(cash - calculateCashForNewPlace(placeType) <= 0){
            return "Nie masz wystarczajaco kasy";
        }
        cash -= calculateCashForNewPlace(placeType);

        ParkingPlace place = new ParkingPlace();
        place.setId(generateId());
        place.setPlaceType(placeType);
        place.setFree(true);

        parkingPlaces.add(place);
        return "Kupiono nowe miejsce";
    }

    public int getCash() {
        return cash;
    }
}
