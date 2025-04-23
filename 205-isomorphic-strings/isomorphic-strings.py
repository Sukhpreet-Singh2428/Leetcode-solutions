class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        lst_s = []
        lst_t = []
        index_map_s = {}
        index_map_t = {}
        for i in range(len(s)):
            # Append the first occurrence index of each character
            if s[i] not in index_map_s:
                index_map_s[s[i]] = i           #{'e':0, 'g':1}
            if t[i] not in index_map_t:
                index_map_t[t[i]] = i
            lst_s.append(index_map_s[s[i]])      #[0, 1, 1]
            lst_t.append(index_map_t[t[i]])
        return lst_s == lst_t