package model.vehicle;

import exception.ParkingSpotOccupiedException;
import model.parkingspot.ParkingSpot;
import model.parkingspot.ParkingSpotState;

public class Motorcycle extends Vehicle{

    public Motorcycle() {
        spotsNeeded =1;
        type = VehicleType.MOTORCYCLE;
    }

    @Override
    public void park(ParkingSpot ps) throws ParkingSpotOccupiedException {
        if(ps.getState().equals(ParkingSpotState.OCCUPIED)){
            throw new ParkingSpotOccupiedException("Sorry, the parking spot is occupied");
        }
        else{
            ps.setVehicle(this);
            ps.setState(ParkingSpotState.OCCUPIED);
            this.parkingSpotArrayList.add(ps);
        }
    }
    @Override
    public void remove(ParkingSpot ps) {
        ps.setVehicle(null);
        ps.setState(ParkingSpotState.VACANT);
        this.remove(ps);
    }
}
