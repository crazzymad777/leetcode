class Solution {
    public String encode(int num) {
        if (num == 0) {
            return "";
        }
        char[] buffer = new char[(int)(Math.log(num+1)/Math.log(2))];
        int x = num+1;
        int i = 0;
        while (x > 1) {
            buffer[buffer.length-i-1] = (char)((x%2)+'0');
            x >>= 1;
            i++;
        }
        return new String(buffer);
    }
}

