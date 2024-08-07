class Solution {
    String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
    "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
    "Seventeen", "Eighteen", "Nineteen"};
    String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", 
    "Eighty", "Ninety"};
    String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if(num == 0)
            return "Zero";
        int i = 0;
        String words = "";
        while(num > 0) {
            if(num % 1000 != 0)
                words = getValue(num % 1000) + THOUSANDS[i] + " " + words;
            num /= 1000;
            i++;
        }
        return words.trim();
    }
    String getValue(int num) {
        if(num == 0)
            return "";
        else if (num < 20)
            return LESS_THAN_20[num] + " ";
        else if (num < 100)
            return TENS[num / 10] + " " + getValue(num % 10);
        else
            return LESS_THAN_20[num / 100] + " Hundred " + getValue(num % 100);
    }
}