class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int ans = Integer.MAX_VALUE;
        int idx = -1;

        for(int i=0; i<drones.length; i++){
            int dis = Math.abs(drones[i][0] - target[0]) + Math.abs(drones[i][1] - target[1]);
            if(dis <= drones[i][2]){
                if(dis < ans){
                    ans = dis;
                    idx = i;
                }
            }
        }

        return idx;
    }
}