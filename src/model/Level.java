package model;

import model.parkingspot.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

//A level in a parking garge
public class Level {
    private int level; // Which floor
    private int row;
    private int col;
    protected List<List<ParkingSpot>> parkingSpotArrayList;
    public Level(int level, int row, int col) {
        this.level = level;
        this.col = col;
        this.row = row;
        parkingSpotArrayList = new ArrayList<>();
        for(int i =0; i<row;i++)
            parkingSpotArrayList.add(new ArrayList<ParkingSpot>());
    }
    public int getLevel() {
        return level;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void addParkingSpot(ParkingSpot ps){
        parkingSpotArrayList.get(ps.getRow()-1).add(ps.getColumn()-1, ps);
    }
    public ParkingSpot getParkingSpot(int row, int col){
        if(row<=this.row && col<=this.col)
            return this.parkingSpotArrayList.get(row-1).get(col-1);
        else{
           return null;
        }
    }
}
