/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int x = rand7()*7;
        int y = rand7();
        int value = (x + y)-7;
        if (value <= 40)
        {
            return (value % 10) + 1;
        }

        int cell = value%10;
        int reminder = 9*7;
        for (int i = 1; i < cell; i++)
        {
            reminder = 63-(70-reminder);
        }

        int d = rand7()*10;
        if (d <= reminder)
        {
            return cell;
        }
        
        int fateful = rand7();
        if ((70-d)+fateful <= reminder)
        {
            return cell;
        }
        return cell+1;
    }
}

