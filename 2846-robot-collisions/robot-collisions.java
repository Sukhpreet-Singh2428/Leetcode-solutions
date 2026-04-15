class obj{
    int health;
    int pos;
    int idx;
    public obj(int health, int pos, int idx){
        this.health = health;
        this.pos = pos;
        this.idx = idx;
    }
}
class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        TreeMap<Integer, Integer> ph = new TreeMap<>();
        for(int i=0; i<positions.length; i++){
            ph.put(positions[i], healths[i]);
        }
        TreeMap<Integer, Character> pd = new TreeMap<>();
        for(int i=0; i<positions.length; i++){
            pd.put(positions[i], directions.charAt(i));
        }
        HashMap<Integer, Integer> posToIndex = new HashMap<>();
        for(int i=0; i<positions.length; i++){
            posToIndex.put(positions[i], i);
        }

        List<obj> ls = new ArrayList<>();
        for(int key : ph.keySet()){
            if(pd.get(key) == 'R'){
                ls.add(new obj(ph.get(key), key, posToIndex.get(key)));
            }
            else{
                int currHealth = ph.get(key);

                while(!ls.isEmpty() && pd.get(ls.get(ls.size()-1).pos) == 'R' 
                    && ls.get(ls.size()-1).health < currHealth){
                    ls.remove(ls.size()-1);
                    currHealth--;
                }

                if(!ls.isEmpty() && pd.get(ls.get(ls.size()-1).pos) == 'R'){
                    if(ls.get(ls.size()-1).health > currHealth){
                        ls.get(ls.size()-1).health--;
                    } else if(ls.get(ls.size()-1).health == currHealth){
                        ls.remove(ls.size()-1);
                    }
                } else {
                    ls.add(new obj(currHealth, key, posToIndex.get(key)));
                }
            }
        }

        Collections.sort(ls, (a, b) -> a.idx - b.idx);

        List<Integer> ans = new ArrayList<>();
        for(obj o : ls){
            ans.add(o.health);
        }

        return ans;
    }
}