class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        result.add(folder[0]);

        for (int i = 1; i < folder.length; i++) {
            String prev = result.get(result.size() - 1);
            String curr = folder[i];

            if (!curr.startsWith(prev + "/")) {
                result.add(curr);
            }
        }

        return result;
    }
}