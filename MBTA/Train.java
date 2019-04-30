//Jace Yang, jaceyang@brandeis.edu

public class Train {
	 final int TOTAL_PASSENGERS = 10;
	 Rider[] passengers;
	 String currentStation;
	 int direction;
	 int passengerIndex;
	 String LogRemove;     // used the keep track of the person removed (runLog)

	/**
	 * The constructor class, initiate the variables
	 * @param currentStation
	 * @param direction
     * O(1)
	 */
	public Train(String currentStation, int direction) {
		this.currentStation = currentStation;
		this.direction = direction;
	    passengers = new Rider[TOTAL_PASSENGERS];
		passengerIndex = 0;
		LogRemove = "";
	}

    /**
     * method that access direction
     * @return int of direction
     * O(1)
     */
	public int getDirection() {
		return this.direction;
	}

    /**
     * mutator method that set the direction
     * @param direc
     * O(1)
     */
	public void setDirection(int direc) {
		this.direction = direc;
	}

    /**
     * get a string of the currentpassenger on the train
     * @return string of the current passenger
     * O(1)
     */
	public String currentPassengers() {
		int counter = 0;
		String passenger = "";

		while(counter < TOTAL_PASSENGERS){
			if (passengers[counter] != null) {
				passenger += passengers[counter].toString() + "\n";
			}
			counter ++;
		}
		return passenger;
	}

    /**
     * method that add rider r into the train queue
     * @param r, rider
     * @return boolean of whether the person is added
     * O(1)
     */
	public boolean addPassenger(Rider r) {
		boolean samedir = (direction == r.getDirection());
		boolean samestation = currentStation.equals(r.startingStation);
		if (canAddPassenger() && samedir && samestation) {
			for (int i = 0; i < TOTAL_PASSENGERS; i++) {
				if (passengers[i]==null) {
					passengers[i] = r;
					passengerIndex++;
					return true;
				}
			}
		}
		return false;
	}

    /**
     * determine if passenger can be added
     * @return boolean of the decision
     * O(1)
     */
	public boolean canAddPassenger() {
		return passengerIndex < TOTAL_PASSENGERS - 1;
	}

    /**
     * method that remove the passenger from the station
     * @param s, station
     * @return String of the passengers removed
     * O(1)
     */
	public String removePassenger(Station s) {
		int counter = 0;
		String passenger = "";
		while(counter < TOTAL_PASSENGERS){
			if (passengers[counter] != null){
				String dest = passengers[counter].getDestination();
				if (dest.equals(s.stationName())){
					passenger += passengers[counter].toString() + "\n";
					passengers[counter] = null;
					passengerIndex--;
				}
			}
			counter ++;
		}
		LogRemove = passenger;
		return passenger;
	}

    /**
     * update the field of the train
     * @param s, station name
     * O(1)
     */
	public void updateStation(String s) {
		this.currentStation = s;
	}

    /**
     * accessor that get the station
     * @return string of the current station
     * O(1)
     */
	public String getStation() {
		return currentStation;
	}

    /**
     * Tostring method that give the needed information
     * @return String of train information
     * O(1)
     */
	public String toString() {
		String text = "";
		text += "Current station: " + currentStation;
		text += "\nDirection: " + direction;
		text += "\nNumber of the passenger: " + passengerIndex;
		text += "\nCurrent passengers are: " + this.currentPassengers();
		return text;
	}
}
