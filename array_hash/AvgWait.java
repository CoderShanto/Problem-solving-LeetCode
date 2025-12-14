package array_hash;

public class AvgWait {

    public static double averageWaitingTime(int[][] customers) {

        long chefFreeTime = 0;   // Chef কখন next ফ্রি হবে
        long totalWait = 0;      // সব কাস্টমারের মোট wait time

        for (int[] c : customers) {
            int arrival = c[0];
            int time = c[1];

            // Chef শুরু করবে যখন সে ফ্রি হবে অথবা কাস্টমার এলে
            chefFreeTime = Math.max(chefFreeTime, arrival) + time;

            // Waiting time = finish time - arrival
            totalWait += chefFreeTime - arrival;
        }

        return (double) totalWait / customers.length;
    }

    public static void main(String[] args) {

        int[][] customers1 = { {1, 2}, {2, 5}, {4, 3} };
        int[][] customers2 = { {5, 2}, {5, 4}, {10, 3}, {20, 1} };

        System.out.printf("Average Wait 1: %.5f\n", averageWaitingTime(customers1));
        System.out.printf("Average Wait 2: %.5f\n", averageWaitingTime(customers2));
    }
}
