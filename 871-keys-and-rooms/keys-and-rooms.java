class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();

        boolean[] vis = new boolean[n];
        Queue<Integer> qu = new ArrayDeque<>();
        int startRoom = 0;
        qu.offer(startRoom);
        vis[startRoom] = true;

        while(!qu.isEmpty()){
            int room = qu.peek();
            qu.poll();

            for(int it : rooms.get(room)){
                if(vis[it] == false){
                    qu.offer(it);
                    vis[it] = true;
                }
            }
        }

        for(int i=0; i<n; i++){
            if(vis[i] == false) return false;
        }

        return true;
    }
}