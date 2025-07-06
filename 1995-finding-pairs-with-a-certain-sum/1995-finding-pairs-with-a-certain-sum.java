class FindSumPairs {
    int[] nums1;
    int[] nums2;

    // freq maps
    Map<Integer,Integer> mp1;
    Map<Integer,Integer> mp2;
    // sorted distinct keys from nums1
    List<Integer> sortedKeys1;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;

        mp1 = new HashMap<>();
        mp2 = new HashMap<>();

        // build freq map for nums1
        for (int x : nums1) {
            mp1.put(x, mp1.getOrDefault(x, 0) + 1);
        }
        // cache & sort the distinct nums1 keys
        sortedKeys1 = new ArrayList<>(mp1.keySet());
        Collections.sort(sortedKeys1);

        // build freq map for nums2
        for (int x : nums2) {
            mp2.put(x, mp2.getOrDefault(x, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = nums2[index];
        int newVal = oldVal + val;

        // decrement or remove oldVal
        int countOld = mp2.get(oldVal);
        if (countOld == 1) {
            mp2.remove(oldVal);
        } else {
            mp2.put(oldVal, countOld - 1);
        }

        // increment newVal
        mp2.put(newVal, mp2.getOrDefault(newVal, 0) + 1);

        // commit it to the array
        nums2[index] = newVal;
    }

    public int count(int tot) {
        int res = 0;
        // iterate sorted keys; break as soon as key > tot
        for (int k : sortedKeys1) {
            if (k > tot) break; 
            Integer c2 = mp2.get(tot - k);
            if (c2 != null) {
                res += mp1.get(k) * c2;
            }
        }
        return res;
    }
}