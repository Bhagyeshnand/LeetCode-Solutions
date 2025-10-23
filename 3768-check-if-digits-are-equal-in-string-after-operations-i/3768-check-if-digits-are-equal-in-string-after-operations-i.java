class Solution {
  public boolean hasSameDigits(String s) {
    int[] arr = new int[s.length()];

    for (int i = 0; i < arr.length; i++)
      arr[i] = s.charAt(i) - '0';
    
    for (int length = arr.length; length > 2; length--) {
      for (int i = 0; i < length - 1; i++) {
        arr[i] = (arr[i] + arr[i + 1]) % 10;
      }
    }

    return arr[0] == arr[1];
      
  }
}