class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for(int x : students){
            dq.addLast(x);
        }

        int cnt = 0;
        int j = 0;
        int loop = 0;
        while(true){
            if(dq.size()==0) break;
            if(dq.size() == loop) break;
            int x = dq.removeFirst();
            if(x == sandwiches[j]){
                j++;
                cnt++;
                loop = 0;
            }
            else{
                dq.addLast(x);
                loop++;
            }
        }

        return students.length-cnt;
    }
}