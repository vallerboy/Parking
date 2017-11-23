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
        }
    }

    private void park() {
        System.out.print("Podaj id miejsca: ");
        String place = scanner.nextLine();

        System.out.print("Podaj typ parkingu: ");
        String placeType = scanner.nextLine();


    }
}
