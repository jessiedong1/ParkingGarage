package model;

import exception.ParkingSpotOccupiedException;
import exception.UnmatchedParkingSpotException;
import model.parkingspot.ParkingSpot;
import model.parkingspot.ParkingSpotType;
import model.vehicle.Bus;
import model.vehicle.Car;
import model.vehicle.Motorcycle;
import model.vehicle.Vehicle;

class ParkingGarageMain {
    public static void main(String[] args) throws ParkingSpotOccupiedException, UnmatchedParkingSpotException, exception.NotEnoughParkingSpot {
        ParkingGarage pg = new ParkingGarage();
        Level level1 = new Level(1, 4, 12);
        for(int i=1; i<=4;i++){
            if(i==1)
            {
                for(int j=1;j<=12;j++)
                    level1.addParkingSpot(new ParkingSpot(level1,i,j,ParkingSpotType.MOTORCYCLESPOT));
            }
            if(i==2 || i==3)
            {
                for(int j=1;j<=12;j++)
                    level1.addParkingSpot(new ParkingSpot(level1,i,j,ParkingSpotType.COMPACTSPOT));
            }
            if(i==4)
            {
                for(int j=1;j<=12;j++)
                    level1.addParkingSpot(new ParkingSpot(level1,i,j,ParkingSpotType.LARGESPOT));
            }
        }
        pg.addLevel(level1);

        Vehicle motorcycle= new Motorcycle();

        Vehicle car= new Car();

        Vehicle bus = new Bus();

        pg.park(level1, bus, level1.getParkingSpot(4,12));






//        try {
//            car.park(level1.getParkingSpot(2,1));
//        } catch (UnmatchedParkingSpotException e) {
//            e.printStackTrace();
//        } catch (ParkingSpotOccupiedException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            car.park(level1.getParkingSpot(2,1));
//        } catch (UnmatchedParkingSpotException e) {
//            e.printStackTrace();
//        } catch (ParkingSpotOccupiedException e) {
//            e.printStackTrace();
//        }

    }


}
