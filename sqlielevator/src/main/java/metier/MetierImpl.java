package metier;

import entities.Elevator;

public class MetierImpl implements Metier {
    @Override
    public int getDistanceforElevatorUP(Elevator e, int requestedFloor , int numberOfFloors) {
        if(e.getCurrentFloor()>requestedFloor){
            return (numberOfFloors-e.getCurrentFloor())+(numberOfFloors-requestedFloor);
        }
        else{
            return requestedFloor-e.getCurrentFloor();
        }
    }

    @Override
    public int getDistanceforElevatorDown(Elevator e, int requestedFloor) {
        if(e.getCurrentFloor()<requestedFloor){
            return (e.getCurrentFloor())+(requestedFloor);
        }
        else{
            return e.getCurrentFloor()-requestedFloor;
        }
    }

    @Override
    public int getDistanceforElevatorRest(Elevator e, int requestedFloor) {
        if(e.getCurrentFloor()>requestedFloor){
            return e.getCurrentFloor()-requestedFloor;
        }
        else{
            return requestedFloor-e.getCurrentFloor();
        }
    }
}
