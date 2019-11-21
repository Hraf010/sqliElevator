package entities;

public class Elevator{
    private String id;
    private int currentFloor ;
    private String state;

    public Elevator(String id, int currentFloor, String state) {
        this.id = id;
        this.currentFloor = currentFloor;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
