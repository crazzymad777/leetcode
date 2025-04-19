class Solution {
    public String convert(String s, int numRows)
    {
        // straigforward mapping
        if (numRows == 1 || s.length() < numRows) return s;

        char[] source = s.toCharArray();
        char[] memory = new char[source.length];

        final int jump = 2*numRows-2;
        boolean distanceSwitch = false;
        int row = 0;
        int x = 0;
        int dx = 0;

        for (int i = 0; i < source.length; i++)
        {
            memory[i] = source[x];

            if (row == 0 || row == numRows-1)
            {
                dx = jump;
            }
            else if (!distanceSwitch)
            {
                dx = jump-row*2;
            }
            else
            {
                dx = row*2;
            }
            x += dx;

            distanceSwitch = !distanceSwitch;
            if (x >= source.length)
            {
                distanceSwitch = false;
                row++;
                x = row;
            }
        }

        return new String(memory);
    }
}

