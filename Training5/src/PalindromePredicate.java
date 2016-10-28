/**
 * Created by admarcu on 10/28/2016.
 */
class PalindromePredicate implements UnaryPredicate<Integer> {
    public boolean test(Integer i) {
        int temp = i, sum = 0, r;
        while (i > 0) {
            r = i % 10;
            sum = (sum * 10) + r;
            i = i / 10;
        }
        if (temp == sum) {
            return true;
        }
        return false;
    }
}