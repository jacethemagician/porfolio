package src;

public class Train {
  final int TOTAL_PASSENGERS = 10; //the # of passengers that the train can
hold, the default is 10 passengers
  Rider[] passengers;
  String currentStation;
  int direction; //1:south-bound, 0:north-bound
  int passengerIndex; //this should be used to verify if more passengers can be added or not
 
 public Train(String currentStation, int direction) {
  //TODO
 }
 
 public int getDirection() {
  //TODO
  return 0;
 }
 
 //you will need to reset the direction when the train reaches the northernmost or southernmost station and turns around
 public void setDirection(int direc) {
  //TODO 
 }
 
 //return the current passenger(s) in the train
 public String currentPassengers() {
  //TODO
  return null;
 }
 
 //return true if a passenger is added successfully, false if not.
 //You must make sure that the rider is supposed to be on the train.
 public boolean addPassenger(Rider r) {
  //TODO
  return false;
 }

 //return true if a passenger can be added, false if not
 public boolean canAddPassenger() {
  //TODO
  return false;
 }
 
 //This should return a string of all the passengers removed at a station. Example: 7SG7IE6K7J7TZLHCHTZW, Porter
 public String removePassenger(Station s) {
  //TODO
  return null;
 }

 //this should update the currentStation whenever the train is moved between stations
 public void updateStation(String s) {
  //TODO
 }
 
 //return the station the train is currently at
 public String getStation() {
  //TODO
  return null;
 }
 
 public String toString() {
  //TODO
  return null;
 }
}
