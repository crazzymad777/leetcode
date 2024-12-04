/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        final int high = 2401; // 7**4
        final int needle = (rand7()-1)+(rand7()-1)*7+(rand7()-1)*49+(rand7()-1)*343;
        return (needle / 241) + 1;
    }
}
