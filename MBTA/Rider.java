//Jace Yang, jaceyang@brandeis.edu

public class Rider {
	 String riderID;
	 String startingStation;
	 String destinationStation;
	 int direction;    // 1-southBound; 0-northBound

	/**
	 * Constructor class
	 * @param riderID
	 * @param startingStation
	 * @param destinationStation
	 * O(1)
	 */
	public Rider(String riderID, String startingStation, String destinationStation) {
		this.riderID = riderID;
		this.startingStation = startingStation;
		this.destinationStation = destinationStation;
	}

	/**
	 * accessor method
	 * @return String of starting station
	 * O(1)
	 */
	public String getStarting() {
		return startingStation;
	}

	/**
	 * Accessor method
	 * @return String of destination
	 * O(1)
	 */
	public String getDestination() {
		return destinationStation;
	}

	/**
	 * accessor get RiderID string
	 * @return string of riderid
	 * O(1)
	 */
	public String getRiderID() {
		return riderID;
	}

	/**
	 * accessor get direction in int
	 * @return int of direction
	 * O(1)
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * mutator method to set the direction
	 * @param direc int of direction
	 *  O(1)
	 */
	public void setDirection(int direc) {
		this.direction = direc;
	}

	/**
	 * toString Method
	 * @return String as needed
	 * O(1)
	 */
	public String toString() {
		String text = "";
		text += "rider's ID: " + riderID;
		text += "   StartingStation: " + startingStation;
		text += "   Destination: " + destinationStation;
		text += "   Direction: " + direction;
		return text;
	}

	/**
	 * Equal method to return the rider object s;
	 * @param s, any object
	 * @return boolean of if the two objects are the same
	 * O(1)
	 */
	@Override
	public boolean equals(Object s) {
        if (s instanceof Rider){
            Rider rider = (Rider) s;
            if (riderID.equals(rider.getRiderID())){
                return true;
            }
        }
        return false;
        }
	}

