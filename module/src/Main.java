import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import static org.testng.Assert.assertEquals;

public class Main {
    public static void main(String[] args) {
        ImmutableSet<Integer> customers1 = ImmutableSet.of(1,2,3);
        ImmutableSet<Integer> customers2 = ImmutableSet.of(3,4);
        assertEquals(Sets.union(customers1, customers2).size(), 4);
    }
}