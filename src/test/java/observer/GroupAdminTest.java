package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class GroupAdminTest {

    @Test
    void register() {
    }

    @Test
    void unregister() {
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