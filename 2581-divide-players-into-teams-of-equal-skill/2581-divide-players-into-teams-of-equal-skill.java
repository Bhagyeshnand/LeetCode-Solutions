class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        Arrays.sort(skill);

        int x = skill[0] + skill[n-1];
        long chem = skill[0] * skill[n-1];
        
        for(int i=1; i<n/2; i++){
            if(skill[i] + skill[n-i-1] != x){
                return -1;
            }
            chem += skill[i] * skill[n-i-1];
        }
        return chem;
    }
}