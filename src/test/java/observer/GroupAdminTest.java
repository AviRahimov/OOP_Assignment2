package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupAdminTest {

    @Test
    void register() {
        GroupAdmin reg = new GroupAdmin();
        ConcreteMember [] members = new ConcreteMember[10];
        for (int i = 0; i < members.length; i++) {
            members[i] = new ConcreteMember("member"+i);
        }
        for (Member m : members){
            reg.register(m);
        }
        for (Member check_member : reg.getMembers()){
            assertTrue(reg.getMembers().contains(check_member));
        }
    }

    @Test
    void unregister() {
        // creating new CMs to register and unregister from GA
        ConcreteMember mem1 = new ConcreteMember("MEMBER1");
        ConcreteMember mem2 = new ConcreteMember("MEMBER2");
        ConcreteMember mem3 = new ConcreteMember("MEMBER3");
        ConcreteMember mem4 = new ConcreteMember("MEMBER4");

        // creating new GA
        GroupAdmin adm = new GroupAdmin();

        // registering CM's
        adm.register(mem1);
        adm.register(mem2);
        adm.register(mem3);
        adm.register(mem4);

        // unregistering CM's
        adm.unregister(mem1);
        adm.unregister(mem2);
        adm.unregister(mem3);
        adm.unregister(mem4);

        // checking if list of members is empty
        assertTrue(adm.getMembers().isEmpty());
    }

    @Test
    void insert() {
        UndoableStringBuilder ins = new UndoableStringBuilder();
        ins.append("Testing the insert method");
        assertThrows(StringIndexOutOfBoundsException.class, () -> ins.insert(100, "Testing"));

        assertThrows(StringIndexOutOfBoundsException.class, () -> ins.insert(-1, "Testing"));

        assertThrows(StringIndexOutOfBoundsException.class, () -> ins.insert(1, null));
    }

    @Test
    void append() {
        // creating CM to register in GA
        ConcreteMember mem1 = new ConcreteMember("MEMBER1");
        ConcreteMember mem2 = new ConcreteMember("MEMBER2");
        ConcreteMember mem3 = new ConcreteMember("MEMBER3");
        ConcreteMember mem4 = new ConcreteMember("MEMBER4");

        //creating GA and registering CM's to it
        GroupAdmin adm = new GroupAdmin();
        adm.register(mem1);
        adm.register(mem2);
        adm.register(mem3);
        adm.register(mem4);

        // saving old CM's strings
        String[] old = new String[4];
        old[0] = mem1.getUSB().toString();
        old[1] = mem2.getUSB().toString();
        old[2] = mem3.getUSB().toString();
        old[3] = mem4.getUSB().toString();

        // appending to GA
        String app = "q85BmuIaqTMNbpqQP39k";
        adm.append(app);

        // checking append
        String str = "";
        int i = 0;
        for(Member m : adm.getMembers()) {
            // this condition is always True!
            if(m instanceof ConcreteMember) {
                str = ((ConcreteMember) m).getUSB().toString();
            }
            assertEquals(old[i] + app, str);
            i++;
        }
    }

    @Test
    void delete() {
        UndoableStringBuilder del = new UndoableStringBuilder();
        del.append("Trying to see if delete func working well");
        assertThrows(StringIndexOutOfBoundsException.class, () -> del.delete(-1, 3));

        assertThrows(StringIndexOutOfBoundsException.class, () -> del.delete(0, -3));

        assertThrows(StringIndexOutOfBoundsException.class, () -> del.delete(10, 3));
    }

    @Test
    void undo() {
        // creating CM to register
        ConcreteMember mem = new ConcreteMember("MEMBER1");

        // creating GA and registering CM to it
        GroupAdmin adm = new GroupAdmin();
        adm.register(mem);

        // doing some operations on GA
        adm.append("6OsWPmMZpXLtgYrGtRRk"); // = "6OsWPmMZpXLtgYrGtRRk"
        adm.insert(4, "eZiUMNdYBYcwEdXJ2MgE"); // = "6OsWeZiUMNdYBYcwEdXJ2MgEPmMZpXLtgYrGtRRk"
        adm.delete(0, 5); // = "ZiUMNdYBYcwEdXJ2MgEPmMZpXLtgYrGtRRk"
        adm.append("NJN64ls0TKkB1i1zNyE0"); // // = "ZiUMNdYBYcwEdXJ2MgEPmMZpXLtgYrGtRRkNJN64ls0TKkB1i1zNyE0"

        // undoing some operations
        adm.undo();
        adm.undo();
        adm.undo();

        // checking if ok (this condition is always True!)
        if(adm.getMembers().get(0) instanceof ConcreteMember) {
            assertEquals("6OsWPmMZpXLtgYrGtRRk", ((ConcreteMember)adm.getMembers().get(0)).getUSB().toString());
        }


    }
}
