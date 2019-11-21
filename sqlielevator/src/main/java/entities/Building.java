package entities;

import metier.Metier;
import metier.MetierImpl;

import java.util.*;

public class Building{
    List<Elevator> elevators;
    private int numberOfFloors;
    private Metier metier;

    public Building(int numberOfFloors,String... states) {
        this.numberOfFloors = numberOfFloors;

        elevators = new ArrayList<Elevator>();
        initElevators(states);
        this.metier = new MetierImpl();
    }

    public String requestElevator() {
        return requestElevator(0);
    }
    public String requestElevator(int i) {
        Map<Integer,Elevator > distances = new HashMap<>();
        List<Integer> dists = new ArrayList<>();

        for(Elevator e : elevators){
            if(e.getState().equals("UP")){
               int dist =  metier.getDistanceforElevatorUP(e,i,numberOfFloors);
               distances.put(dist,e);
            }
            else if(e.getState().equals("DOWN")){
               int dist = metier.getDistanceforElevatorDown(e,i);
                distances.put(dist,e);
            }
            else if(e.getState().equals("REST")){
               int dist =  metier.getDistanceforElevatorRest(e,i);
               distances.put(dist,e);
            }
        }
        dists.addAll(distances.keySet());
        Collections.sort(dists);
        Elevator e = distances.get(dists.get(0));
        return e.getId();
    }
    public void move(String id1, String newState) {
        Elevator e = getElevatorById(id1);
        if(e!=null){
            if(newState.equals("UP"))
                e.setState("UP");
            else
                e.setState("DOWN");
        }
    }





    public Elevator getElevatorById(String id){
        for(Elevator e : elevators){
            if(e.getId().equals(id))
                return e;
        }
        return null;
    }

    private void initElevators(String[] states){
        for(String name : states){
            String[] strings = name.split(":");
            elevators.add(new Elevator(strings[0],Integer.parseInt(strings[1]),"REST"));
        }
    }


}
