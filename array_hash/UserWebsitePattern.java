import java.util.*;

public class UserWebsitePattern {

    // প্রতিটি visit সংরক্ষণের জন্য class
    static class Visit {
        String user;
        String site;
        int time;

        Visit(String u, String s, int t) {
            user = u;
            site = s;
            time = t;
        }
    }

    public static List<String> mostVisitedPattern(String[] username, String[] website, int[] timestamp) {

        // 1️⃣ সব visit list এ নিয়ে আসা
        List<Visit> visits = new ArrayList<>();
        for (int i = 0; i < username.length; i++) {
            visits.add(new Visit(username[i], website[i], timestamp[i]));
        }

        // 2️⃣ timestamp অনুযায়ী sort করা
        Collections.sort(visits, (a, b) -> a.time - b.time);

        // 3️⃣ প্রতিটি user এর ordered website history map করা
        Map<String, List<String>> userToSites = new HashMap<>();
        for (Visit v : visits) {
            userToSites.putIfAbsent(v.user, new ArrayList<>());
            userToSites.get(v.user).add(v.site);
        }

        // 4️⃣ pattern → set of users map
        Map<String, Set<String>> patternToUsers = new HashMap<>();

        // 5️⃣ প্রতিটি user এর history থেকে সব possible 3-sequence generate
        for (String user : userToSites.keySet()) {
            List<String> sites = userToSites.get(user);
            Set<String> seen = new HashSet<>(); // duplicate pattern প্রতিটি user এর জন্য avoid করতে

            for (int i = 0; i < sites.size(); i++) {
                for (int j = i + 1; j < sites.size(); j++) {
                    for (int k = j + 1; k < sites.size(); k++) {
                        String pattern = sites.get(i) + " " + sites.get(j) + " " + sites.get(k);
                        if (!seen.contains(pattern)) {
                            seen.add(pattern);
                            patternToUsers.putIfAbsent(pattern, new HashSet<>());
                            patternToUsers.get(pattern).add(user);
                        }
                    }
                }
            }
        }

        // 6️⃣ সবচেয়ে বেশি user follow করা pattern select করা
        String resPattern = "";
        int maxCount = 0;

        for (String pattern : patternToUsers.keySet()) {
            int count = patternToUsers.get(pattern).size();
            if (count > maxCount || (count == maxCount && pattern.compareTo(resPattern) < 0)) {
                resPattern = pattern;
                maxCount = count;
            }
        }

        // 7️⃣ final pattern return করা (split করে list)
        return Arrays.asList(resPattern.split(" "));
    }

    // ✅ Testing main method
    public static void main(String[] args) {
        String[] username = {"bob","bob","bob","alice","alice","alice","alice","charlie","charlie","charlie"};
        String[] website  = {"home","about","career","home","cart","maps","home","home","about","career"};
        int[] timestamp   = {1,2,3,4,5,6,7,8,9,10};

        List<String> ans = mostVisitedPattern(username, website, timestamp);
        System.out.println(ans); // Output: [home, about, career]

        // Example 2
        String[] u2 = {"ua","ua","ua","ub","ub","ub"};
        String[] w2 = {"a","b","a","a","b","c"};
        int[] t2 = {1,2,3,4,5,6};

        System.out.println(mostVisitedPattern(u2, w2, t2)); // Output: [a, b, a]
    }
}
