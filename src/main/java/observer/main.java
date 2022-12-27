package observer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class main {
    public static void main(String[] args) {
        ConcreteMember m1 = new ConcreteMember("avi");
        ConcreteMember m2 = new ConcreteMember("avi");
        ConcreteMember ptr = m1;


        assertEquals(m1, ptr);

        if (m1 == m2) {
            System.out.println("error!!!!!!");
        }
    }

}