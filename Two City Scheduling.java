/**
There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].
Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.

Example 1:
Input: [[10,20],[30,200],[400,50],[30,20]]
Output: 110
**/

class Solution {
    
    public int min(int a, int b){ return a > b ? b : a;}
    
    public int twoCitySchedCost(int[][] costs) {

        Arrays.sort(costs, (a, b) -> Math.abs(b[1] - b[0]) - Math.abs(a[1] - a[0]));   
        int cityA = 0;
        int cityB = 0;
        int sum = 0;
        
        int N = costs.length;
        for (int i=0; i<costs.length; i++){
            if(costs[i][0] < costs[i][1]){
                if (cityA < N/2){
                    cityA++;
                    sum += costs[i][0];
                } else {
                    cityB++;
                    sum += costs[i][1];
                }
            } else {
                if (cityB < N/2){
                    cityB++;
                    sum += costs[i][1];
                } else {
                    cityA++;
                    sum += costs[i][0];
                }
            }  
        }
        return sum;
    }
}
