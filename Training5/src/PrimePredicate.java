/**
 * Created by admarcu on 10/28/2016.
 */
class PrimePredicate implements UnaryPredicate<Integer> {
    public boolean test(Integer i) {
        for (int x = 2; x < i; x++) {
            if (i % x == 0)
                return false;
        }
        return true;
    }
}