import java.util.Scanner;

public class ParkingMenu {

    private Parking parking;
    private Scanner scanner;

    public ParkingMenu(Parking parking){
        this.parking = parking;
        this.scanner = new Scanner(System.in);
    }

    public void startLoop() {
        while (true){
            printMenu();
        }
    }

    private void printMenu() {
        System.out.println("Cash miasta: " + parking.getCash());
        System.out.println("1. Zajmij miejsce");
        System.out.println("2. Zwolnij wszystkie");
        System.out.println("3. Odbierz zaplate");
        System.out.println("4. Wykup nowe miejsce");

        checkAnswer(scanner.nextLine());
    }

    private void checkAnswer(String s) {
        switch (s){
            case "1": {
                park();
                break;
            }
            case "2": {
                freeAll();
                break;
            }
            case "3": {
                createPayment();
                break;
            }
            case "4": {
                buyNewPlace();
                break;
            }
        }
    }

    private void buyNewPlace() {
        System.out.print("Podaj typ miejsca (CAR, TRUCK, MOTO): ");
        ParkingPlace.PlaceType placeType = ParkingPlace.PlaceType.valueOf(scanner.nextLine());
        int toPay = parking.calculateCashForNewPlace(placeType);

        System.out.println("Bedziesz musial zaplacic: " + toPay);
        System.out.print("Czy akceptujesz? (tak/nie): ");

        if(scanner.nextLine().equals("yes")){
            System.out.println(parking.buyNewPlace(placeType));
        }else{
            System.out.println("OK, slabeusz");
        }
    }

    private void createPayment() {
        System.out.print("Podaj kwote zaplaty: ");
        int cash = Integer.valueOf(scanner.nextLine());

        String message = parking.createPayment(cash);
        System.out.println(message);
    }

    private void freeAll() {
        if (parking.freeAllPlaces()) {
            System.out.println("Zwolniono wszystkie miejsca poprawnie!");
        }
    }

    private void park() {
        System.out.print("Podaj id miejsca: ");
        int placeId = Integer.valueOf(scanner.nextLine());

        System.out.print("Podaj typ parkingu: ");
        ParkingPlace.PlaceType placeType = ParkingPlace.PlaceType.valueOf(scanner.nextLine());

        if(parking.isIdFree(placeId)){
            System.out.println("Nie ma takiego miejsca parkingowego");
            return;
        }

        if(parking.park(placeId, placeType)){
            System.out.println("Dodano poprawnie!");
        }else{
            System.out.println("Miejsce jest zajete, lub podales nieprawidlowy rodzaj pojazdu");
        }
    }
}
