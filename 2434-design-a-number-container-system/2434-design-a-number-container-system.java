class NumberContainers {

    HashMap<Integer,PriorityQueue<Integer>> res;
    HashMap<Integer,Integer> index_val;

    public NumberContainers() {
        res = new HashMap<>();
        index_val = new HashMap<>();
    }
    
    public void change(int index, int number) {

        if(index_val.containsKey(index)){
            int num = index_val.get(index);
            if(num == number){
                return ;
            }

            res.get(num).remove(index);
        }

        res.computeIfAbsent(number, k-> new PriorityQueue<>()).offer(index);
        index_val.put(index, number);
    }
    
    public int find(int number) 
    {
        PriorityQueue<Integer> pq = res.getOrDefault(number, new PriorityQueue<>());
        if(pq.size() == 0)
        {
            return -1;
        }
        return pq.peek();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */