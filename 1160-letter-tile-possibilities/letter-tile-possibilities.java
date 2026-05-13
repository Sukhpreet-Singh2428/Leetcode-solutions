class Solution {
    public static void func(int idx, String s, String tiles, HashSet<String> allPremu, boolean[] visited){
        if(s.length() == tiles.length()){
            allPremu.add(s);
            return;
        }

        for(int i=0; i<tiles.length(); i++){
            char c = tiles.charAt(i);
            if(visited[i] != true){
                visited[i] = true;
                func(idx, s+c, tiles, allPremu, visited);
                visited[i] = false;
            }
        }
    }
    public static void generate(int idx, String ans, String s, HashSet<String> st){
        if(idx==s.length()){
            st.add(ans);
            return;
        }

        generate(idx+1, ans+s.charAt(idx), s, st);
        generate(idx+1, ans, s, st);
    }
    public int numTilePossibilities(String tiles) {
        HashSet<String> allPremu = new HashSet<>();
        boolean[] visited = new boolean[tiles.length()];
        func(0, "", tiles, allPremu, visited);

        System.out.println(allPremu);
        
        HashSet<String> st = new HashSet<>();
        for(String s : allPremu){
            generate(0, "", s, st);
        }

        return st.size()-1;
    }
}