import java.util.ArrayList;
import java.util.List;

public class Parking {
    
    private List<ParkingPlace> parkingPlaces; 
    private ParkingMenu menu; 
    private ParkingGenerator generator; 
    
    public Parking(){
        parkingPlaces = new ArrayList<>();
        menu = new ParkingMenu(this);
    }
    
    public void start(){ 
        generator = new ParkingGenerator();
        parkingPlaces.addAll(generator.getRandomParkingPlaces(100));
    }
    
    
    public boolean park() { 
        
    }
    
    
    private ParkingPlace findParkById(int id){
        for (ParkingPlace parkingPlace : parkingPlaces) {
            
        }
    }
}
