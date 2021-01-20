package model.vehicle;

import exception.ParkingSpotOccupiedException;
import exception.UnmatchedParkingSpotException;
import model.parkingspot.ParkingSpot;
import model.parkingspot.ParkingSpotState;
import model.parkingspot.ParkingSpotType;

public class Car extends Vehicle{
    public Car() {
        spotsNeeded =1;
        type = VehicleType.CAR;
    }

    @Override
    public void park(ParkingSpot ps) throws UnmatchedParkingSpotException, ParkingSpotOccupiedException {
        if(ps.getType().equals(ParkingSpotType.MOTORCYCLESPOT))
            throw new UnmatchedParkingSpotException("Sorry! You cannot park in MOTORCYCLE SPOT");
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
        ps.setVehicle(null);
        ps.setState(ParkingSpotState.VACANT);
        this.remove(ps);
    }
}
