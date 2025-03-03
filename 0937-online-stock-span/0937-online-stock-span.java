class StockSpanner {
    Stack<int[]> st; //size of array would be 2 -> 0th index will hold price and 1st index will hold span
    public StockSpanner() {
        st = new Stack<>(); //initialize our stack
    }
    
    public int next(int price) {
        //for every price span would be 1
        int span = 1;
        //we will iterate in our stack and check for past low prices
        //if we got past low price at the top of stack we will add that span in our current span and will pop out that smaller price from stack, and will add our current price with its span in stack
        while(st.isEmpty()==false && st.peek()[0] <= price){
            span += st.peek()[1];//we will add lower price's span in our current span
            st.pop();//we will pop out lower price from our stack
        }
        //add our current price and span in stack
        st.push(new int[]{price,span});
        return span;
    }
}