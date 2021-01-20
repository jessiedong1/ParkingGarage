package model.parkingspot;

import model.Level;
import model.vehicle.Vehicle;

public class ParkingSpot {
    private Level Level;
    private int row;
    private int column;
    private ParkingSpotType type;
    private Vehicle vehicle;
    private ParkingSpotState state = ParkingSpotState.VACANT;

    public ParkingSpot(model.Level level, int row, int column, ParkingSpotType type) {
        Level = level;
        if(row>level.getRow())
            throw new IllegalArgumentException("Sorry, there is not enough row in this level");
        else
            this.row = row;
        if(row>level.getCol())
            throw new IllegalArgumentException("Sorry, there is not enough column in this level");
        else
            this.column = column;
        this.type = type;
    }

    public ParkingSpotState getState() {
        return state;
    }

    public void setState(ParkingSpotState state) {
        this.state = state;
    }

    public ParkingSpotType getType() {
        return type;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Level getLevel() {
        return Level;
    }

    public void setLevel(model.Level level) {
        Level = level;
    }
}
