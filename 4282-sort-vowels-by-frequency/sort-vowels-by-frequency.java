class Pair {
    char key;
    int freq;
    int firstIdx;

    public Pair(char key, int freq, int firstIdx){
        this.key = key;
        this.freq = freq;
        this.firstIdx = firstIdx;
    }
}

class Solution {

    public static boolean isVowel(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }

    public String sortVowels(String s) {

        HashMap<Character, Integer> freqMap = new HashMap<>();
        HashMap<Character, Integer> firstIndex = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(isVowel(c)){
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);

                if(!firstIndex.containsKey(c)){
                    firstIndex.put(c, i);
                }
            }
        }

        ArrayList<Pair> list = new ArrayList<>();

        for(char key : freqMap.keySet()){
            list.add(new Pair(key, freqMap.get(key), firstIndex.get(key)));
        }

        Collections.sort(list, (a, b) -> {
            if(a.freq == b.freq){
                return a.firstIdx - b.firstIdx;  
            }
            return b.freq - a.freq;            
        });

        ArrayList<Character> sortedVowels = new ArrayList<>();

        for(Pair p : list){
            for(int i = 0; i < p.freq; i++){
                sortedVowels.add(p.key);
            }
        }

        StringBuilder result = new StringBuilder();
        int j = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(isVowel(c)){
                result.append(sortedVowels.get(j++));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}