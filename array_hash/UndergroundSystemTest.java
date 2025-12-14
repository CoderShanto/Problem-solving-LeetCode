package array_hash;
import java.util.*;

public class UndergroundSystemTest {

    static class UndergroundSystem {
        // Store check-in info: id -> [stationName, time]
        private Map<Integer, Pair> checkInMap;
        // Store travel times: startEndKey -> [totalTime, tripCount]
        private Map<String, long[]> travelMap;

        public UndergroundSystem() {
            checkInMap = new HashMap<>();
            travelMap = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            checkInMap.put(id, new Pair(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            Pair start = checkInMap.get(id);
            String key = start.station + "->" + stationName;
            long travelTime = t - start.time;
            travelMap.putIfAbsent(key, new long[]{0, 0});
            travelMap.get(key)[0] += travelTime; // totalTime
            travelMap.get(key)[1] += 1;          // tripCount
            checkInMap.remove(id); // remove check-in after checkout
        }

        public double getAverageTime(String startStation, String endStation) {
            String key = startStation + "->" + endStation;
            long[] val = travelMap.get(key);
            return (double) val[0] / val[1];
        }

        // Helper class to store check-in info
        private static class Pair {
            String station;
            int time;
            Pair(String s, int t) { station = s; time = t; }
        }
    }

    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();

        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);

        undergroundSystem.checkOut(45, "Waterloo", 15);  // 12
        undergroundSystem.checkOut(27, "Waterloo", 20);  // 10
        undergroundSystem.checkOut(32, "Cambridge", 22); // 14

        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge")); // 14.0
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // 11.0

        undergroundSystem.checkIn(10, "Leyton", 24);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // 11.0
        undergroundSystem.checkOut(10, "Waterloo", 38); // 14
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // 12.0
    }
}
