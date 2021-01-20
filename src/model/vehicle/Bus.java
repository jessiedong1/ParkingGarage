package model.vehicle;

import exception.ParkingSpotOccupiedException;
import exception.UnmatchedParkingSpotException;
import model.parkingspot.ParkingSpot;
import model.parkingspot.ParkingSpotState;
import model.parkingspot.ParkingSpotType;

public class Bus extends Vehicle{
    public Bus(){
        spotsNeeded =5;
        type = VehicleType.BUS;
    }
    @Override
    public void park(ParkingSpot ps) throws UnmatchedParkingSpotException, ParkingSpotOccupiedException{
        if(ps.getType().equals(ParkingSpotType.MOTORCYCLESPOT) || ps.getType().equals(ParkingSpotType.COMPACTSPOT) )
            throw new UnmatchedParkingSpotException("Sorry! You can only park in Large Parking Spot");
        else
        {
            if(ps.getState().equals(ParkingSpotState.VACANT)){
                ps.setVehicle(this);
                ps.setState(ParkingSpotState.OCCUPIED);
                this.parkingSpotArrayList.add(ps);
            }
            else{
                throw new ParkingSpotOccupiedException("Sorry, the parking spot is occupied");
            }

        }
    }

    @Override
    public void remove(ParkingSpot ps) {

    }
}
