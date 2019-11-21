package metier;

import entities.Elevator;

public interface Metier {
    public int getDistanceforElevatorUP(Elevator e, int requestedFloor ,int numberOfFloors);
    public int getDistanceforElevatorDown(Elevator e, int requestedFloor);
    public int getDistanceforElevatorRest(Elevator e, int requestedFloor);
}
