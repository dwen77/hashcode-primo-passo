package com.hashcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application1 {

    public Map<String, Street> streets;
    public List<List<String>> carPaths;

    public static void main(String[] args) {

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
}
