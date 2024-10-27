class Solution {
    // memoization approach
    private HashMap<Integer, Integer> cache = new HashMap<>();
    public int climbStairs(int n) {
        if (n <= 3) return n;
        Integer value = cache.get(n);
        if (value != null) {
            return value;
        }
        value = climbStairs(n-1)+climbStairs(n-2);
        cache.put(n, value);
        return value;
    }
}

