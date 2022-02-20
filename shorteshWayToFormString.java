// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// Time Complexity = O(m*n)
// Space Complexity = O(1), since the map will have at max 26 characters
class Solution {
    public int shortestWay(String source, String target) {
        if (source == null || source.length() == 0) return -1;
        Map<Character,Integer> map = new HashMap<>();
        int result=1;
        int src=0;
        int tar=0;

        for (int i=0; i<source.length(); i++) {
            map.put(source.charAt(i), i);
        }

        while (tar < target.length()) {
            if(!map.containsKey(target.charAt(tar))) return -1;
            else if (src < source.length() && source.charAt(src) == target.charAt(tar)) {
                src++;
                tar++;
            }
            else if (src == source.length()) {
                result++;
                src=0;
            }
            else {
                src++;
            }
        }

        return result;
    }
}

// ---------------------------------------------------------------------------------------

// Time Complexity = O(m*log n), where n is the source string length, m is the target string length
// Space Complexity = O(1), since the map will have at max 26 characters

// Here we directly jump to the next index of the character in the map
class Solution {
    public int shortestWay(String source, String target) {
        if (source == null || source.length() == 0) return -1;
        Map<Character,List<Integer>> map = new HashMap<>();
        int result=1;
        int src=0;  //index on source
        int tar=0;  //index on target

        for (int i=0; i<source.length(); i++) {
            if (!map.containsKey(source.charAt(i))) {
                map.put(source.charAt(i), new ArrayList<>());
            }
            map.get(source.charAt(i)).add(i);   //adding index to the list
        }

        while (tar < target.length()) {
            if(!map.containsKey(target.charAt(tar))) return -1;

            List<Integer> li = map.get(target.charAt(tar));
            int k = Collections.binarySearch(li, src);

            if (k<0) {
                k = -k-1;
            }
            if (k == li.size()) {
                result++;
                src = 0;
            }
            else {
                src = li.get(k)+1;
                tar++;
            }
        }

        return result;
    }
}