package model.vehicle;

import exception.NotEnoughParkingSpot;
import exception.ParkingSpotOccupiedException;
import exception.UnmatchedParkingSpotException;
import model.parkingspot.ParkingSpot;

import java.util.ArrayList;

public abstract class Vehicle {
        protected int spotsNeeded;
        protected VehicleType type;
        protected ArrayList<ParkingSpot> parkingSpotArrayList = new ArrayList<>();
        public int getSpotsNeeded() {
            return spotsNeeded;
        }
        public VehicleType getType() {
            return type;
        }
        public abstract void park(ParkingSpot ps) throws UnmatchedParkingSpotException, ParkingSpotOccupiedException;
        public abstract void remove(ParkingSpot ps);
}
