/*
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:

If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
One must use all the tickets once and only once.

Example 1:

Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
*/

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> hm = new HashMap<>();
        
        for (int i=0; i<tickets.size(); i++) {
            String key = tickets.get(i).get(0);
            String value = tickets.get(i).get(1);
            
            if (!hm.containsKey(key)) {
                PriorityQueue<String> pq = new PriorityQueue<>();
                hm.put(key, pq);
            }
            hm.get(key).add(value);
        }
        
        LinkedList<String> res = new LinkedList<>();
        dfs(hm, "JFK", res);
        
        return res;
    }
    
    private void dfs(Map<String, PriorityQueue<String>> adj, String src, LinkedList<String> res) {
        PriorityQueue<String> arrivals = adj.get(src);
        
        while(arrivals!=null && !arrivals.isEmpty()) {
            String dest = arrivals.poll();
            dfs(adj, dest, res);
        }
        
        res.addFirst(src);
    }
}
