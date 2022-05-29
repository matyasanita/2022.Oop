package Hajogyar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ShipDepot {
    private ArrayList<Ship> ships = new ArrayList<>();

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public Ship getShipById(String shipId){
        for(Ship ship:ships){
            if (ship.getShipId().equals(shipId)){
                return ship;
            }
        }
        return null;
    }

    public void addShip(Ship ship){
        if (ships.contains(ship)) System.out.println("The ship is already in the list!");
        else{
            ships.add(ship);
        }
    }

    public void addShipFromFile(String fileName){
        try (Scanner sc = new Scanner(new File(fileName))){
            while(sc.hasNextLine()){
                String line;
                line=sc.nextLine();
                if (line.isEmpty()){
                    continue;
                }
                String[] items = line.split(" ");
                try{
                    String shipId = items[0].strip();
                    String manufacturer = items[1].strip();
                    String type = items[2].strip();
                    int yearOfProduction = Integer.parseInt(items[3].strip());
                    int price = Integer.parseInt(items[4].strip());
                    if (items[5].contains(",")){
                        items[5] = items[5].replace(",",".");
                    }
                    double weight = Double.parseDouble(items[5].strip());
                    addShip(new Ship(shipId,manufacturer,type,yearOfProduction,price,weight));
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException){
                    System.out.println("Incomplete line: " + line);
                }
                catch (NumberFormatException numberFormatException){
                    System.out.println("Number format exception: "+ line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ShipDepot(String fileName){
        try (Scanner sc = new Scanner(new File(fileName))){
            while(sc.hasNextLine()){
                String line;
                line=sc.nextLine();
                if (line.isEmpty()){
                    continue;
                }
                String[] items = line.split(" ");
                try{
                    String shipId = items[0].strip();
                    String manufacturer = items[1].strip();
                    String type = items[2].strip();
                    int yearOfProduction = Integer.parseInt(items[3].strip());
                    int price = Integer.parseInt(items[4].strip());
                    if (items[5].contains(",")){
                        items[5] = items[5].replace(",",".");
                    }
                    double weight = Double.parseDouble(items[5].strip());
                    ships.add(new Ship(shipId,manufacturer,type,yearOfProduction,price,weight));
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException){
                    System.out.println("Incomplete line: " + line);
                }
                catch (NumberFormatException numberFormatException){
                    System.out.println("Number format exception: "+ line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void sortShips(){
        Collections.sort(ships);
    }

    public void listShipsBetween(int startYear, int endYear){
        int i=0;
        while(ships.get(i).getYearOfProfuction() < startYear){
            i++;
        }
        while(ships.get(i).getYearOfProfuction() <= endYear){
            System.out.println(ships.get(i));
            i++;
        }
    }

    public void listShipsLetter(String c){

        for (Ship ship : ships){
            if (ship.getManufacturer().toLowerCase().contains(c)){
                System.out.println(ship);
            }
        }
    }

    @Override
    public String toString() {
        String res="Ships: \n";
        for (Ship ship : ships){
            res += ship + "\n";
        }
        return res;
    }
}
