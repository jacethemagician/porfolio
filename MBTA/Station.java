//Jace Yang, jaceyang@brandeis.edu

public class Station {
	public String name;
	Queue<Rider> northWaiting;
	Queue<Rider> southWaiting;
	Queue<Train> northBoundTrains;
	Queue<Train> southBoundTrains;

    /**
     * constructor for station
     * @param name, string of the station name
     * O(1)
     */
	public Station(String name) {
		this.name = name;
		northWaiting = new Queue<>(20);
		southWaiting = new Queue<>(20);
		northBoundTrains = new Queue<>(20);
		southBoundTrains = new Queue<>(20);
	}

    /**
     * method to add Waiting rider into the queue
     * @param r, rider
     * @throws Exception
     * O (1)
     */
	public void addWaitingRider(Rider r) throws Exception {
		int dir = r.getDirection();
		if (dir == 0) {
			northWaiting.enqueue(r);
		} else {
			southWaiting.enqueue(r);
		}
	}

    /**
     * add the Train into the station queue
     * @param t, train
     * @return String of the train tostring
     * @throws Exception
     * O(1)
     */
	public String addTrainToStation(Train t) throws Exception {
		int dir = t.getDirection();

		Station curr = new Station(t.getStation());
		t.removePassenger(curr);

		if (dir == 0) {
			northBoundTrains.enqueue(t);
		}
		else {
			southBoundTrains.enqueue(t);
		}
		return t.toString();
	}

    /**
     * method that dequeue a train from the queue and add passenger to the train
     * @return the dequeue train
     * @throws Exception
     * O(n)
     */
	public Train southBoardTrain() throws Exception {
		if (!southBoundTrains.isEmpty()) {
			Train t1 = southBoundTrains.dequeue();
			if (t1 != null){
				while ((t1.canAddPassenger()) && (!southWaiting.isEmpty())) {
					t1.addPassenger(southWaiting.dequeue());
				}
				return t1;
			}
		}
		return null;
	}

	 /**
      * method that dequeue a train from the queue and add passenger to the train
	  * @return the dequeue train
      * @throws Exception
      * O(n)
      */
	public Train northBoardTrain() throws Exception {
		if (!northBoundTrains.isEmpty()) {
			Train t0 = northBoundTrains.dequeue();
			if (t0 != null){
				while ((t0.canAddPassenger()) && (!northWaiting.isEmpty())) {
					t0.addPassenger(northWaiting.dequeue());
				}
				return t0;
			}
		}
		return null;
	}

    /**
     * method that move the train from one queue to another and change its direction
     * @throws Exception
     * O(1)
     */
	public void moveTrainNorthToSouth() throws Exception {
		if (!northBoundTrains.isEmpty()){
			Train t = this.northBoundTrains.dequeue();
			t.setDirection(1);
			this.southBoundTrains.enqueue(t);
		}
	}

    /**
     * method that move the train from one queue to another and change its direction
     * @throws Exception
     * O(1)
     */
	public void moveTrainSouthToNorth() throws Exception {
		if (!southBoundTrains.isEmpty()){
			Train t = this.southBoundTrains.dequeue();
			t.setDirection(0);
			this.northBoundTrains.enqueue(t);
		}
	}

    /**
     * The tostring method that give the needed string
     * @return String of important information
     * O(1)
     */
	public String toString() {
		String text ="";
		text =  "The station: " + name ;
		text +=  "\nNumber of people waiting tho is go north " + northWaiting.length;
		text +=  "\nNumber of people waiting who is going south " + southWaiting.length;
		text +=  "\nNumber of trains that will go north " + northBoundTrains.length;
		text +=  "\nNumber of trains that will go south " + southBoundTrains.length;

		return text;
	}

    /**
     * get the station Name
     * @return String of the station name
     * O(1)
     */
	public String stationName() {
		return this.name;
	}

    /**
     * the method that compare the object with station in the queue.
     * @param s, station
     * @return a boolean of whether the two are the same
     * O(1)
     */
	@Override
	public boolean equals(Object s) {
		if (s instanceof Station){
			Station station = (Station) s;
			return name.equals(station.stationName());
		}
		return false;
		}
	}

