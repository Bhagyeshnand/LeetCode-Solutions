class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            int w = books[i - 1][0], h = books[i - 1][1];
            f[i] = f[i - 1] + h;
            for (int j = i - 1; j > 0; --j) {
                w += books[j - 1][0];
                if (w > shelfWidth) {
                    break;
                }
                h = Math.max(h, books[j - 1][1]);
                f[i] = Math.min(f[i], f[j - 1] + h);
            }
        }
        return f[n];
    }
}

/*
Explanation:
The variable f[i] denotes the least height necessary to accommodate the 
first i books on the shelves.

We begin with a vacant shelf, where the height f[0] is set to 0, as 
having no books results in no height requirement.

For each book i, the approach evaluates whether to place it on the
 same shelf as the preceding books or to initiate a new shelf. It 
 systematically assesses if the addition of the current book to the
  existing shelf would surpass the shelf's width. If it does not, the
   height of the shelf is determined by the tallest book already present 
   on that shelf. The value of f[i] is then updated to reflect the lesser
    of its current value and the height achieved by including the book on
     the current shelf.

Should the inclusion of a book cause the current shelf to exceed its
 maximum width, the process halts, prompting the start of a new shelf.

This methodology guarantees that the overall height of the bookshelves
 is minimized while adhering to the width limitations of each shelf.
*/