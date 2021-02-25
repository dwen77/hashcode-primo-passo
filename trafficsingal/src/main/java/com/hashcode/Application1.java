package com.hashcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application1 {

    public Map<String, Street> streets;
    public List<List<String>> carPaths;
    public int simulationDuration;
    public int points;
    public Map<Integer, List<Schedule>> result;


    public static void main(String[] args) throws Exception {
        Application1 app = new Application1();
        app.readInput(args[0]);
        //apply the algorithm
        app.writeOutput(args[0]);
    }

    private void writeOutput(String inputFileName) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("out-"+inputFileName));
        bw.write();
    }

    public void readInput(String fileName) throws Exception {
        BufferedReader bf = new BufferedReader(new FileReader(fileName));
        Integer[] metaInfo = getMetaInfo(bf);
        this.simulationDuration = metaInfo[0];
        this.points = metaInfo[4];
        this.streets = createStreets(bf, metaInfo[2]);
        this.carPaths = createCarPaths(bf, metaInfo[3]);
    }

    public Integer[] getMetaInfo(BufferedReader is) throws IOException {
        String line = is.readLine();
        String[] parts = line.split(" ");
        return Arrays.stream(parts).map(Integer::parseInt).toArray(Integer[]::new);
    }

    private Map<String, Street> createStreets(BufferedReader is, int numberOfStreets) throws IOException {
        streets = new HashMap<>();
        String line;
        for (int i = 0; i < numberOfStreets; i++) {
            line = is.readLine();
            String[] parts = line.split(" ");
            streets.put(parts[2], new Street(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[3])));
        }
        return streets;
    }

    private List<List<String>> createCarPaths(BufferedReader is, int numberOfCars) throws IOException {
        carPaths = new ArrayList<>(numberOfCars);
        String line;
        for (int i = 0; i < numberOfCars; i++) {
            line = is.readLine();
            String[] parts = line.split(" ");
            final List<String> path = Arrays.stream(parts).collect(Collectors.toList());
            path.remove(0);
            carPaths.add(path);
        }
        return carPaths;
    }

    private class Street {

        private int start;
        private int end;
        private int time;

        public Street(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }

    private class Schedule {
        String streetName;
        int time;

        public Schedule(String streetName, int time) {
            this.streetName = streetName;
            this.time = time;
        }

        @Override
        public String toString() {
            return streetName + ' ' + time;
        }
    }
}
