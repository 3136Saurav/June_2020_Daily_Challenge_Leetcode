 /**
 
 There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.

Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

Example 1:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200
Explanation: 
The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
**/
 
 class Solution {
   public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i <= K; i++) {
            int[] tmpDist = Arrays.copyOf(dist, dist.length);
            for (int[] edge : flights) {
                int u = edge[0];
                if (dist[u] == Integer.MAX_VALUE) continue;
                int v = edge[1];
                int w = edge[2];
                tmpDist[v] = Math.min(tmpDist[v], dist[u] + w);
            }
            dist = tmpDist;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
