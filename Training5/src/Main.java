import java.util.Collection;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Collection<Integer> ci = Arrays.asList(1, 4, 4, 20, 13, 8, 59); // lista test nr prime
        Collection<Integer> as = Arrays.asList(13, 23, 43, 553, 532, 313, 4554); // lista test palindroame
        List<Integer> lsta = Arrays.asList(5, 3, 8, 4, 9, 3, 5, 45, 78, 5);// lista test elem maximal

        List<Integer> li = Arrays.asList(3, 4, 6, 8, 11, 15, 28, 32);
        Collection<Integer> c = Arrays.asList(7, 18, 19, 25);
        UnaryPredicate<Integer> p = new RelativelyPrimePredicate(c);

        int i = findFirst(li, 0, li.size(), p);

        int count = countIf(ci, new PrimePredicate());
        int palin = countIf(as, new PalindromePredicate());
        System.out.println("Number of prime integers = " + count);
        System.out.println("Number of palindrome integers = " + palin);
        System.out.println("Elementul maximal este: " + find(lsta, 0, 2));
        
        if (i != -1) {
            System.out.print(li.get(i) + " is relatively prime to ");
            for (Integer k : c)
                System.out.print(k + " ");
            System.out.println();
        }
    }

    public static <T> int countIf(Collection<T> c, UnaryPredicate<T> p) {
        int count = 0;
        for (T elem : c)
            if (p.test(elem)) {
                ++count;
            }
        return count;
    }

    public static <T> void swap(T[] x, int a, int b) {
        T aux = x[a];
        x[a] = x[b];
        x[b] = aux;
    }

    public static <T extends Comparable> T find(List<T> lst, int begin, int end) {
        T max = lst.get(begin);
        for (begin = begin + 1; begin <= end; begin++) {
            if (max.compareTo(lst.get(begin)) < 0) {
                max = lst.get(begin);
            }
        }
        return max;
    }

    public static <T> int findFirst(List<T> list, int begin, int end, UnaryPredicate<T> p) {
        for (; begin < end; ++begin) {
            if (p.test(list.get(begin))) {
                return begin;
            }
        }
        return -1;
    }


}
