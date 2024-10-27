class Solution {
    private HashMap<Integer, Integer> cache = new HashMap<>();
    public int fib(int n) {
        // lodash.memoize (n) => (n < 2 ? n : fibonacci(n - 1) + fibonacci(n - 2))
        Integer value = cache.get(n);
        if (value != null) {
            return value;
        }
        value = n < 2 ? n : fib(n - 1) + fib(n - 2);
        cache.put(n, value);
        return value;
    }
}

