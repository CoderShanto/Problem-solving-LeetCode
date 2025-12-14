package two_pointers;

import java.util.Arrays;

public class TeamChemistry {

    /**
     * Calculates the total chemistry of all teams if possible
     * @param skill Array of player skills
     * @return Sum of chemistry of all teams, or -1 if impossible
     */
    public static long dividePlayers(int[] skill) {
        int n = skill.length;
        Arrays.sort(skill); // sort to pair smallest with largest
        int teamSkill = skill[0] + skill[n - 1]; // target total skill for each team
        long totalChemistry = 0;

        for (int i = 0; i < n / 2; i++) {
            int sum = skill[i] + skill[n - 1 - i];
            if (sum != teamSkill) return -1; // cannot form equal skill teams
            totalChemistry += (long) skill[i] * skill[n - 1 - i]; // chemistry = product
        }

        return totalChemistry;
    }

    public static void main(String[] args) {
        int[] skill1 = {3,2,5,1,3,4};
        System.out.println(dividePlayers(skill1)); // 22

        int[] skill2 = {3,4};
        System.out.println(dividePlayers(skill2)); // 12

        int[] skill3 = {1,1,2,3};
        System.out.println(dividePlayers(skill3)); // -1
    }
}

