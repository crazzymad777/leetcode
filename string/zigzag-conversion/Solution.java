class Solution {
    public String convert(String s, int numRows)
    {
        // straigforward mapping
        if (numRows == 1 || s.length() < numRows) return s;

        StringBuilder sb = new StringBuilder();
        char[] str = s.toCharArray();

        final int jump = 2*numRows-2;
        boolean distanceSwitch = false;
        int row = 0;
        int x = 0;
        int dx = 0;

        for (int i = 0; i < str.length; i++)
        {
            sb.append(str[x]);

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
            if (x >= str.length)
            {
                row++;
                x = row;
                distanceSwitch = false;
            }
        }
        return sb.toString();
    }
}

