class Solution {

    private class SegT {
        int n;
        int seg[];
        int lazy[];

        public SegT(int arr[]) {
            n = arr.length;
            seg = new int[4*n];
            lazy = new int[4*n];

            build(arr, 0, n-1, 0);
        }

        private int build(int arr[], int l, int r, int si) {
            if(l == r) {
                return seg[si] = arr[l];
            }
            int mid = l + (r-l)/2;
            return seg[si] = build(arr, l, mid, 2*si+1) + build(arr, mid+1, r, 2*si+2);
        }

        private void update(int L, int R, int l, int r, int si) {
            if(lazy[si] != 0) {
                seg[si] = r - l + 1 - seg[si];
                if(l != r) {
                    lazy[2*si+1] = 1 - lazy[2*si+1];
                    lazy[2*si+2] = 1 - lazy[2*si+2];
                }
                lazy[si] = 0;
            }

            // No overlap
            if(l>R || r<L) {
                return;
            }
            // Complete overlap
            if(l>=L && r<=R) {
                seg[si] = r - l + 1 - seg[si];
                if(l != r) {
                    lazy[2*si+1] = 1 - lazy[2*si+1];
                    lazy[2*si+2] = 1 - lazy[2*si+2];
                }
                return;
            }

            // Partial overlap
            int mid = l +(r-l)/2;
            update(L, R, l, mid, 2*si+1);
            update(L, R, mid+1, r, 2*si+2);
            seg[si] = seg[2*si+1] + seg[2*si+2];
        }

        public void update(int L, int R) {
            update(L, R, 0, n-1, 0);
        }

        public int query() {
            return seg[0];
        }
    }

    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {

        long sum = 0;
        for(int i: nums2) {
            sum += i;
        }

        SegT sgt = new SegT(nums1);
        List<Long> list = new ArrayList<>();
        for(int ar[]: queries) {
            if(ar[0] == 1) {
                sgt.update(ar[1], ar[2]);
            } else if(ar[0] == 2) {
                sum += (long)ar[1] * sgt.query();
            } else {
                list.add(sum);
            }
        }
        long ans[] = new long[list.size()];
        for(int i=0;i<ans.length;i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}