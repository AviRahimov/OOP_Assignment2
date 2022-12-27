package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteMemberTest {
    @Test
    void update(){
        GroupAdmin admin = new GroupAdmin();
        admin.append("Testing the update method");
        ConcreteMember member = new ConcreteMember("member number1");
        admin.register(member);
        admin.delete(0, 8);
        for (Member members : admin.getMembers()){
            assertEquals(members.toString(), admin.getCondition().toString());
        }
    }
}