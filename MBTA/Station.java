package src;

public class Station {
	public String name;
	Queue<Rider> northWaiting;
	Queue<Rider> southWaiting;
	Queue<Train> northBoundTrains;
	Queue<Train> southBoundTrains;
	
	public Station(String name) {
		//TODO
	}
	
	public void addWaitingRider(Rider r) {
		//TODO
	}
	
	public String addTrainToStation(Train t) {
		//TODO
		return null;
	}
	
	public Train southBoardTrain() {
		//TODO
		return null;
	}

	public Train northBoardTrain() {
		//TODO
		return null;
	}
	
	public void moveTrainNorthToSouth() {
		//TODO
	}
	
	public void moveTrainSouthToNorth() {
		//TODO
	}
	
	public String toString() {
		//TODO
		return null;
	}
	
	public String stationName() {
		//TODO
		return null;
	}
	
	@Override
	public boolean equals(Object s) {
		//TODO
		return false;
	}
}
