class Solution {
    public int[][] constructGridLayout(int n, int[][] edges) {
        if (n == 2)
            return edges;
        List<Integer>[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(edge[1]);
            lists[edge[1]].add(edge[0]);
        }
        int max = 0;
        int min = 4;
        int[][] links = new int[n][];
        for (int i = 0; i < n; i++) {
            links[i] = new int[lists[i].size()];
            for (int j = 0; j < links[i].length; j++) {
                links[i][j] = lists[i].get(j);
            }
            max = Math.max(lists[i].size(), max);
            min = Math.min(lists[i].size(), min);
        }
        if (max == 2 && min == 1)
            return get1(links);
        if (max == 3)
            return get2(links);
        return getMulti(links);
    }

    public int[][] get1(int[][] links) {
        int[][] res = new int[1][links.length];
        int idx = 0;
        for (int i = 0; i < links.length; i++) {
            if (links[i].length == 1) {
                int prv = -1;
                int current = i;
                while (idx < links.length) {
                    res[0][idx++] = current;
                    for (int next : links[current]) {
                        if (next != prv) {
                            prv = current;
                            current = next;
                            break;
                        }
                    }
                }
                break;
            }
        }
        return res;
    }

    public int[][] get2(int[][] links) {
        int[][] res = new int[2][links.length / 2];
        int idx = 0;
        for (int i = 0; i < links.length; i++) {
            if (links[i].length == 2) {
                for (int j : links[i]) {
                    if (links[j].length == 2) {
                        int prv1 = -1;
                        int current1 = i;
                        int prv2 = -1;
                        int current2 = j;
                        while (idx < res[0].length) {
                            res[0][idx] = current1;
                            res[1][idx++] = current2;
                            int current1Temp = current1;
                            for (int next : links[current1]) {
                                if (next != prv1 && next != current2) {
                                    prv1 = current1;
                                    current1 = next;
                                    break;
                                }
                            }
                            for (int next : links[current2]) {
                                if (next != prv2 && next != current1Temp) {
                                    prv2 = current2;
                                    current2 = next;
                                    break;
                                }
                            }
                        }
                        return res;
                    }
                }
            }
        }
        return res;
    }

    public int[][] getMulti(int[][] links) {
        boolean[] used = new boolean[links.length];
        for (int i = 0; i < links.length; i++) {
            if (links[i].length == 2) {
                List<Integer> list = new ArrayList<>();
                int current = i;
                do {
                    list.add(current);
                    used[current] = true;
                    for (int next : links[current]) {
                        if (!used[next] && links[next].length != 4) {
                            current = next;
                            break;
                        }
                    }
                } while (links[current].length != 2);
                list.add(current);
                used[current] = true;
                int[][] res = new int[list.size()][links.length / list.size()];
                for (int j = 0; j < res.length; j++) {
                    res[j][0] = list.get(j);
                }
                current = res[0][0];
                for (int j = 1; j < res[0].length; j++) {
                    for (int next : links[current]) {
                        if (!used[next] && links[next].length != 4) {
                            current = next;
                            break;
                        }
                    }
                    res[0][j] = current;
                    used[current] = true;
                }
                for (int j = 1; j < res[0].length; j++) {
                    for (int k = 1; k < res.length; k++) {
                        int prv1 = res[k][j - 1];
                        int prv2 = res[k - 1][j];
                        for (int next1 : links[prv1]) {
                            if (used[next1])
                                continue;
                            for (int next2 : links[prv2]) {
                                if (next1 == next2) {
                                    res[k][j] = next2;
                                    used[next2] = true;
                                    break;
                                }
                            }
                        }
                    }
                }
                return res;
            }
        }
        return new int[0][0];
    }
}