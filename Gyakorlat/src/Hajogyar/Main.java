package Hajogyar;

public class Main {
    public static void main(String[] args) {
        ShipDepot shipDepot = new ShipDepot("ships.txt");
        System.out.println(shipDepot);

        //add new ship
        shipDepot.addShip(new Ship("f214134","Romania","caravel",1920,13098013,6));
        System.out.println(shipDepot);
        shipDepot.addShip(new Ship("f123456789","Spain", "caravel", 1920 ,10000000, 5));
        System.out.println(shipDepot.getShipById("f214134"));
        shipDepot.sortShips();
        System.out.println(shipDepot);

        //List the ships between 1940 and 2005
        System.out.println("Ships between 1940 and 2005: ");
        shipDepot.listShipsBetween(1940,2005);

        //List ships with the letter i in it:
        System.out.println("Ships containing the letter i:");
        shipDepot.listShipsLetter("i");


    }
}
