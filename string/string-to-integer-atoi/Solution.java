class Solution {
    public int myAtoi(String s) {
        final int last = 10;
        int k = last;
        byte[] buffer = new byte[11];
        int sign = 0;
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++)
        {
            if (str[i] == ' ' && k == last && sign == 0)
            {
                continue;
            }

            if (str[i] >= '0' && str[i] <= '9')
            {
                if (str[i] == '0' && k == last-1 && buffer[last] == 0)
                {
                    continue;
                }

                if (sign == 0)
                {
                    sign = 1;
                }
                if (k == -1)
                {
                    break;
                }
                buffer[k] = (byte)(str[i] - '0');
                k--;
                continue;
            }

            if (sign == 0)
            {
                if (str[i] == '+')
                {
                    sign = 1;
                    continue;
                }
                if (str[i] == '-')
                {
                    sign = -1;
                    continue;
                }
            }
            break;
        }

        if (k == last)
        {
            return 0;
        }
        boolean overflow = false;
        int result = 0;
        int d = 1;
        if (k == -1)
        {
            overflow = true;
        }
        else
        {
            k++;
            for (; k <= last; k++)
            {
                int c = buffer[k]*d;
                if (c/d != buffer[k])
                {
                    overflow = true;
                    break;
                }
                if (result+c < 0)
                {
                    overflow = true;
                    break;
                }
                result += c;
                // int check = d;
                d *= 10;
                // if (d/10 != check)
                // {
                //     overflow = true;
                //     break;
                // }
            }
        }
        if (overflow)
        {
            if (sign > 0)
            {
                return Integer.MAX_VALUE;
            }
            return Integer.MIN_VALUE;
        }
        return sign*result;
    }
}

