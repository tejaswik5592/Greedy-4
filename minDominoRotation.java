// Time Complexity = O(n)
// Space Complexity = O(1), since the hashMap will contain only 1-6
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if (tops == null || tops.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int target = -1;

        for (int i=0; i<tops.length; i++) {
            map.put(tops[i], map.getOrDefault(tops[i],0)+1);
            map.put(bottoms[i], map.getOrDefault(bottoms[i],0)+1);

            // check if we found a majority element
            if (map.get(tops[i]) >= tops.length) {
                target = tops[i];
                break;
            }
            if (map.get(bottoms[i]) >= tops.length) {
                target = bottoms[i];
                break;
            }
        }

        // if we did not form a majority, we return -1 since we will not be able to convert all the tops or bottoms to the same value
        if (target == -1) return -1;

        return countRotations(tops, bottoms, target);
    }

    private int countRotations(int[] tops, int[] bottoms, int target) {
        int topRotations = 0, bottomRotations = 0;

        for (int i=0; i<tops.length; i++) {

            // At any point if we find that both top and bottom element is not target, then we return -1
            if (tops[i] != target && bottoms[i] != target) {
                return -1;
            }
            if (tops[i] != target) {
                topRotations++;
            }
            if (bottoms[i] != target) {
                bottomRotations++;
            }
        }

        return Math.min(topRotations, bottomRotations);
    }
}

// -------------------------------------------------------------------------------------------------------------------

// Time Complexity = O(n)
// Space Complexity = O(1)

// We assume index 0 element of either tops or bottoms array will be our target to make a majority
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if (tops == null || tops.length == 0) return 0;

        // checking with tops[0] as the majority element
        int result = countRotations(tops, bottoms, tops[0]);
        if (result != -1) {
            return result;
        }

        // checking with bottoms[0] as the majority element
        return countRotations(tops, bottoms, bottoms[0]);
    }

    private int countRotations(int[] tops, int[] bottoms, int target) {
        int topRotations = 0, bottomRotations = 0;

        for (int i=0; i<tops.length; i++) {

            // At any point if we find that both top and bottom element is not target, then we return -1
            if (tops[i] != target && bottoms[i] != target) {
                return -1;
            }
            if (tops[i] != target) {
                topRotations++;
            }
            if (bottoms[i] != target) {
                bottomRotations++;
            }
        }

        return Math.min(topRotations, bottomRotations);
    }
}