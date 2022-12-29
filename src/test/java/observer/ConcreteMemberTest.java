package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteMemberTest {
    /**
     * We are testing the update method by registering some member to the GroupAdmin and then delete
     * some part of the UndoableStringBuilder of GroupAdmin and check if the member changed accordingly.
     */
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