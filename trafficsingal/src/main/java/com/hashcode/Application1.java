package com.hashcode;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class Application1 {

    public Map<String, Street> streets;
    public List<List<String>> carPaths;

    public static void main(String[] args) {

    }

    public int[] getMetaInfo(InputStream is) {

    }

    private Map<String, Street> createStreets(InputStream is, int numberOfStreets) {

    }

    private List<List<String>> createCarPaths(InputStream is, int numberOfCars) {

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
