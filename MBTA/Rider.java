package src;

public class Rider {
  String riderID;
  String startingStation;
  String destinationStation;
  int direction; //1:south-bound, 0:north-bound
 
 public Rider(String riderID, String startingStation, String destinationStation) {
  //TODO
 }

 //return the name of the starting station
 public String getStarting() {
     return this.startingStation;
 }
 
 //return the name of the destination station
 public String getDestination() {
     return this.destinationStation;
 }
 
 //return the riderID
 public String getRiderID() {
     return this.riderID;
 }
 
 //return the direction
 public int getDirection() {
     return this.direction;
 }
 
 //set the destination
 public void setDirection(int direc) {
     this.direction = direc;
 }
 
 public String toString() {
  //TODO
  return null;
 }
 
 @Override
 //this should compare riderIDs
 public boolean equals(Object s) {
     return this.riderID.equals(s.getRiderID());
 }
}
