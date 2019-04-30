//Jace Yang, jaceyang@brandeis.edu

public class Railway {
    DoubleLinkedList<Station> railway;
    String[] stations;
    int stationIndex;

    /**
     * Constructor method
     * O(1)
     */
    public Railway() {
        railway = new DoubleLinkedList();
        stations = new String[18];
        stationIndex = 0;
    }

    /**
     * addStation method to add station s into the queue
     * O(1)
     *
     * @param s
     */
    public void addStation(Station s) {
        railway.insert(s);
        stations[stationIndex] = s.stationName();
        stationIndex++;
    }

    /**
     * add rider r into the queue
     *
     * @param r, Rider
     * @throws Exception O(1)
     */
    public void addRider(Rider r) throws Exception {
        String starting = r.getStarting();
        String dest = r.getDestination();
        int dir = calcStation(starting, dest);
        r.setDirection(dir);

        Station station = new Station(starting);
        Station currStation = railway.get(station);

        currStation.addWaitingRider(r);
    }

    /**
     * add Train t into the queue
     *
     * @param t
     * @throws Exception O(1)
     */
    public void addTrains(Train t) throws Exception {
        String curr = t.getStation();
        Station b = new Station(curr);
        Station station = railway.get(b);
        station.addTrainToStation(t);
    }

    /**
     * Find the direction of the train with two givin parameter
     *
     * @param station1 beginning station
     * @param station2 ending station
     * @return direction
     * O(n)
     */
    public int calcStation(String station1, String station2) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < stationIndex; i++) {
            if (stations[i].equals(station1)) {
                start = i;
            }
            if (stations[i].equals(station2)) {
                end = i;
            }
        }
        if (start - end > 0) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * simulate method that simulate the MBTA
     *
     * @return String of Log book
     * @throws Exception O(n^2)
     */
    public String simulate() throws Exception {
        String runLog = "";
        Node<Station> curr = railway.getHead();

        while (curr != null) {

            runLog += "Station: " + curr.getElement().stationName() + "\n";
            runLog += curr.getElement().northBoundTrains.length() + " north-bound trains waiting\n";
            runLog += curr.getElement().southBoundTrains.length() + " south-bound trains waiting\n";
            runLog += curr.getElement().northWaiting.length() + " north-bound passengers waiting\n";
            runLog += curr.getElement().southWaiting.length() + " south-bound passengers waiting\n";
            runLog += "\n";

            if (!curr.getElement().southBoundTrains.isEmpty()) {
                Station SSouth = curr.getElement();
                Train TSouth = SSouth.southBoardTrain();

                if (TSouth != null) {
                    if (curr.next != null) {
                        TSouth.updateStation(curr.next.getElement().stationName());
                        curr.next.getElement().addTrainToStation(TSouth);
                        runLog += SSouth.stationName() + " Disembarking Passengers: \n" + TSouth.LogRemove;
                        runLog += "Direction(1-SOUTH, 0-NORTH): " + TSouth.getDirection() + "\n";
                        runLog += "Current Passengers: \n" + TSouth.currentPassengers() + "\n";
                    }
                }
            }

            if (curr.equals(railway.getHead())) {
                curr.getElement().moveTrainNorthToSouth();
            }

            if (curr.equals(railway.getTail())) {
                curr.getElement().moveTrainSouthToNorth();
            }

            if (!curr.getElement().northBoundTrains.isEmpty()) {
                Station SNorth = curr.getElement();
                Train TNorth = SNorth.northBoardTrain();

                if (TNorth != null) {
                    if (curr.prev != null) {
                        TNorth.updateStation(curr.prev.getElement().stationName());
                        curr.prev.getElement().addTrainToStation(TNorth);
                        runLog += SNorth.stationName() + " Disembarking Passengers: " + TNorth.LogRemove + "\n";
                        runLog += "Direction(1-SOUTH, 0-NORTH): " + TNorth.getDirection() + "\n";
                        runLog += "Current Passengers: \n" + TNorth.currentPassengers();

                    }
                }
            }


            runLog += "\n------------------------------------------ \n";
            curr = curr.next;
        }
        return runLog;
    }

    /**
     * Tostring method that return a string as needed.
     *
     * @return String of railway
     * O(1)
     */
    public String toString() {
        return railway.toString();
    }

}
