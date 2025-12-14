package two_pointers;

import java.util.Arrays;

public class BagOfTokens {

    /**
     * Returns the maximum score achievable by playing tokens.
     * @param tokens Array of token values
     * @param power Initial power
     * @return Maximum score
     */
    public static int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens); // sort tokens to play small first for score
        int i = 0, j = tokens.length - 1;
        int score = 0, maxScore = 0;

        while (i <= j) {
            if (power >= tokens[i]) {
                // Play token face-up
                power -= tokens[i];
                score++;
                maxScore = Math.max(maxScore, score);
                i++;
            } else if (score >= 1) {
                // Play token face-down to gain power
                power += tokens[j];
                score--;
                j--;
            } else {
                // Cannot play any token
                break;
            }
        }

        return maxScore;
    }

    public static void main(String[] args) {
        int[] tokens1 = {100};
        int power1 = 50;
        System.out.println(bagOfTokensScore(tokens1, power1)); // 0

        int[] tokens2 = {200,100};
        int power2 = 150;
        System.out.println(bagOfTokensScore(tokens2, power2)); // 1

        int[] tokens3 = {100,200,300,400};
        int power3 = 200;
        System.out.println(bagOfTokensScore(tokens3, power3)); // 2
    }
}
