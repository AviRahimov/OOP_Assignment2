package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GroupAdminTest {

    @Test
    void register() {
        GroupAdmin reg = new GroupAdmin();
        ConcreteMember member1 = new ConcreteMember("member1");
        reg.register(member1);
        for (Member members : reg.getMembers()){
            assertEquals(members, member1);
        }
    }

    @Test
    void unregister() {
        GroupAdmin reg = new GroupAdmin();
        ConcreteMember member2 = new ConcreteMember("member2");
        reg.register(member2);
        reg.unregister(member2);
        for (Member members : reg.getMembers()){

        }
    }

    @Test
    void insert() {
        UndoableStringBuilder ins = new UndoableStringBuilder();
        ins.append("Testing the insert method");
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            ins.insert(100, "Testing");
        });

        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            ins.insert(-1, "Testing");
        });

        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            ins.insert(1, null);
        });
    }

    @Test
    void append() {
    }

    @Test
    void delete() {
        UndoableStringBuilder del = new UndoableStringBuilder();
        del.append("Trying to see if delete func working well");
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            del.delete(-1, 3);
        });

        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            del.delete(0, -3);
        });

        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            del.delete(10, 3);
        });
    }

    @Test
    void undo() {
//        assertThrows(EmptyStackException.class, () ->{
//
//        })
    }
}