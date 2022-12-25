package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        ins.append("to be or not to be");
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
        del.append("Trying to see if delete func working");
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
    }
}