class Solution {

    public long dividePlayers(int[] skill) {  // Method to divide players into teams and calculate total chemistry
        int n = skill.length;                // Number of players
        int totalSkill = 0;                  // Variable to store total skill of all players
        int[] skillFrequency = new int[1001];// Array to store frequency of each skill level

        // Calculate total skill and skill frequency
        for (int playerSkill : skill) {      // Loop through the skill array
            totalSkill += playerSkill;       // Add player's skill to totalSkill
            skillFrequency[playerSkill]++;   // Increment the count for this player's skill
        }

        // Check if total skill can be evenly distributed among teams
        if (totalSkill % (n / 2) != 0) {     // If totalSkill can't be evenly divided among n/2 teams
            return -1;                       // Return -1 indicating it's impossible to form valid teams
        }

        int targetTeamSkill = totalSkill / (n / 2);  // Target combined skill for each pair of players
        long totalChemistry = 0;                     // Variable to accumulate total chemistry

        // Calculate total chemistry while verifying valid team formations
        for (int playerSkill : skill) {      // Loop through the skill array again
            int partnerSkill = targetTeamSkill - playerSkill; // Calculate the required skill for the partner

            // Check if a valid partner exists
            if (skillFrequency[partnerSkill] == 0) { // If no player with the required partnerSkill exists
                return -1;                           // Return -1 indicating invalid pairing
            }

            totalChemistry += (long) playerSkill * (long) partnerSkill; // Add product of player and partner skills to total chemistry
            skillFrequency[partnerSkill]--;        // Decrease the count of partnerSkill in the frequency array
        }

        // Return half of totalChemistry as each pair is counted twice
        return totalChemistry / 2;                 // Since each pair's chemistry is counted twice, return half of total chemistry
    }
}
