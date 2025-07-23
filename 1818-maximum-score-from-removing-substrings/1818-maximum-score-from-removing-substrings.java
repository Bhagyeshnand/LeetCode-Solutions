class Solution {
    public int maximumGain(String s, int x, int y) {
        char[] chars = s.toCharArray(); // \U0001f4dd Convert the string into an array of characters for easier handling. Think of it like separating candies in a bag. \U0001f36c
        int total = 0, a = 0, b = 0;       // \U0001f3c6 `total`: Your running score. `a`: Count of 'a's waiting for a 'b'. `b`: Count of 'b's waiting for an 'a'. Like lining up dance partners! \U0001f483\U0001f57a

        // Determine which pair scores higher! 'ab' or 'ba'?
        char first = x > y ? 'a' : 'b', second = x > y ? 'b' : 'a'; // \U0001f947`first`: The first letter of the high-scoring pair. `second`: The second letter.
        int max = Math.max(x, y), min = Math.min(x, y);              // \U0001f4b0 `max`: Points for the high-scoring pair. `min`: Points for the low-scoring pair.

        // Loop through each letter
        for (char c : chars) {         // \U0001f6b6‍♀️\U0001f6b6‍♂️ Going through each character of array from start to end.
            if (c == first) {           // Found an 'a' or 'b' (depending on which pair is worth more)?
                a++;                    // Increase the count of the 'a' or 'b' you're waiting for. Like putting a name on a waiting list. \U0001f4dd
                    /*why a++?*/

/*

**The point is priority:**

We *always* try to find a good match first. We have `first` 
(the first letter of the pair) and `second` 
(the second letter of the pair). We don't just increment the 
counter, we wait for a *certain* letter.

* If `first = 'a", then `second = 'b". We are looking for `"ab"` 
* (or `"ba"` if `b` is more profitable).
* If `c == first`, then we increment the counter `a'. 
* This means that we are waiting for `b` to arrive in order to 
* pair `ab`. We can't increase `b++` because we haven't found `b` yet!
*/

/*
- a is used to count the first letter of the advantageous pair 
(the one that will be the first in the pair).
- b is used to count the second letter of the advantageous pair 
(the one that will be the second in the pair). */

            } else if (c == second) {   // Found a 'b' or 'a' (the other letter of the pair)?
                if (a > 0) {            // If we have "a" in stock (so we can start cooking)...
                    a--;                 // ...then we USE this "a"! We take one "a" from the warehouse.

// Important:

/* a-- does not “subtract” the letter 'a' from the string. 
It subtracts 1 from the counter of A. 
This means that we used one letter 'a' from our stock to make 
a pair of "ab". */

                    total += max;       // ...and get points (we have successfully cooked the dish!)
                } else {   // ...but if "a" is not in stock...
                    b++;                // ...then add "b" to the waiting list for "a" (to prepare "ab" later)
                }
            } else { // Met something NOT "a" and NOT "b"
    // Here's what's going on:
    total +=Math.min(a, b) * min; // 1. We look at how many "apples" (a) and "pears" (b) we have accumulated.
                                   // We use the smallest amount (to make pear+apple pairs if they are cheaper)
                                   // and add these points to the total score.
                                   // It's like saying, "Okay, I have 3 apples and 2 pears. I can make 2 pairs of "pear+apple",
                                   // I'll get points for them, even if they're cheaper."

    a = b = 0; // 2. And that's why we reset!
               // Imagine that the "alien" letter "c" is a wall.
               // You can't throw your apples and pears over this wall,
               // so that they can then connect with the letters that come AFTER the wall.
               // Your "stocks" of apples and pears (a and b) have run out for the part of the row that you have already passed.
               // You have to start collecting new stocks of "a" and "b" from scratch for the next part of the line.
}
        }

/*Example;

Let's say we have the string "aba c bab" and we want to delete 
"ab" and "ba".

    Without zeroing out:
        The algorithm might think that it can take the first "a" 
and the last "b" from "aba c bab" and make a pair, even though 
there is a "c" between them. That would be wrong.

    Zeroing out:
The algorithm will correctly process "aba" and "bab" separately.
*/
        // Don't forget the leftovers.
        return total + Math.min(a, b) * min; // Add any final pairs and return the maximum possible total score! \U0001f4af
    }
}