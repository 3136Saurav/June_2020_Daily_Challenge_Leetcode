/**
Insert Delete GetRandom O(1)

Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.

**/

class RandomizedSet {
    
    private ArrayList<Integer> arr;
    private Map<Integer, Integer> hash;
    private Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        arr = new ArrayList<>();
        hash = new HashMap<>();        
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (hash.containsKey(val))
            return false;
      
        arr.add(val);
        hash.put(val, arr.size()-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!hash.containsKey(val))
            return false;
        
        int idx_to_remove = hash.get(val);
        int lastElement = arr.get(arr.size()-1);
        
        arr.set(idx_to_remove, lastElement);
        hash.put(lastElement, idx_to_remove);
        
        hash.remove(val);
        arr.remove(arr.size()-1);
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        
        int index = random.nextInt(arr.size());
        
        return arr.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
