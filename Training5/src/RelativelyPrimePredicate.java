import java.util.Collection;

/**
 * Created by admarcu on 10/28/2016.
 */
class RelativelyPrimePredicate implements UnaryPredicate<Integer> {

    public RelativelyPrimePredicate(Collection<Integer> c) {
        this.c = c;
    }

    public boolean test(Integer x) {
        for (Integer i : c) {
            if (GCD(x, i) != 1) {
                return false;
            }
        }
        return c.size() > 0;
    }

    public int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }

    private Collection<Integer> c;
}