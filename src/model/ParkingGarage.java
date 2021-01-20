package model;

import exception.NotEnoughParkingSpot;
import exception.ParkingSpotOccupiedException;
import exception.UnmatchedParkingSpotException;
import model.parkingspot.ParkingSpot;
import model.vehicle.Vehicle;
import model.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingGarage {
    private List<Level> levelList= new ArrayList<>();
    public ParkingGarage() {

    }
    public void addLevel(Level level){
        levelList.add(level);
    }
    public boolean park(Level level, Vehicle vehicle, ParkingSpot ps) throws NotEnoughParkingSpot, ParkingSpotOccupiedException, UnmatchedParkingSpotException {
        boolean capacity = true;
        if(levelList.contains(level)){
            if(vehicle.getType().equals(VehicleType.BUS)){
                for(int i=0; i<=vehicle.getSpotsNeeded();i++){
                    if(level.getParkingSpot(ps.getRow(), ps.getColumn()+i)==null){
                        capacity=false;
                        throw new NotEnoughParkingSpot("Sorry, there is not enough parking spot for bus");
                    }
                }
                if(capacity){
                    try {
                        for(int i=0; i<vehicle.getSpotsNeeded();i++) {
                            vehicle.park(level.getParkingSpot(ps.getRow(), ps.getColumn() + i));
                        }
                    } catch (UnmatchedParkingSpotException e) {
                        e.printStackTrace();
                    } catch (ParkingSpotOccupiedException e) {
                        e.printStackTrace();
                    }

                }
            }
            else{
                try {
                    vehicle.park(ps);
                } catch (UnmatchedParkingSpotException e) {
                    e.printStackTrace();
                } catch (ParkingSpotOccupiedException e) {
                    e.printStackTrace();
                }
            }
        }
        else{
            throw new IllegalArgumentException("No such a level");
        }

        return capacity;

    }


}
