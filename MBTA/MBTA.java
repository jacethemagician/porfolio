//Jace Yang, jaceyang@brandeis.edu

import java.io.*;
import java.util.*;

public class MBTA {

    static final int HOURS = 6;
    static Scanner s;
    static Railway r;

    /**
     * Main method, calls methods from the class
     * O(n^3)
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        r = new Railway();

        initiateStations("redLine.txt");
        initiateTrains("trains.txt");
        initiateRiders("riders.txt");

        runTrains(HOURS);

    }

    /**
     * run the simulation for tics times
     * @param tics, times need to run
     * @throws Exception
     * O(1)
     */
    public static void runTrains(int tics) throws Exception {
        for (int i = 0; i < tics; i++) {
            System.out.println(r.simulate());
            System.out.println("=================================================");
        }
    }

    /**
     * read the file from the txt
     * @param filename
     * @throws Exception
     * O(n)
     */
    public static void initiateStations(String filename) throws Exception {
        s = new Scanner(new File(filename));
        while (s.hasNextLine()) {
            Station station = new Station(s.nextLine());
            r.addStation(station);
        }
    }

    /**
     * read the Rider into the queue
     * @param filename
     * @throws Exception
     * O(n)
     */
    public static void initiateRiders(String filename) throws Exception {
        s = new Scanner(new File(filename));
        String riderID;
        String startingStation;
        String destination;

        while (s.hasNextLine()) {
            riderID = s.nextLine();
            startingStation = s.nextLine();
            destination = s.nextLine();
            Rider rider = new Rider(riderID, startingStation, destination);
            r.addRider(rider);
        }

    }

    /**
     * Read the file and initiate trains into the queues
     * @param filename
     * @throws Exception
     * O(n)
     */
    public static void initiateTrains(String filename) throws Exception {
        s = new Scanner(new File(filename));
        Train train;
        String station;
        int direction;
        while (s.hasNextLine()){
            station = s.nextLine();
            direction = Integer.parseInt(s.nextLine());
            train = new Train(station, direction);
            r.addTrains(train);
        }
    }

}

