import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    @Test
    public void test(){
        GroupAdmin admin_test = new GroupAdmin();
        ConcreteMember member1 = new ConcreteMember("m1");
        ConcreteMember member2 = new ConcreteMember("m2");
        ConcreteMember member3 = new ConcreteMember("m3");

        /*
         We can see that the memoryStats function is a combination of
         objectFootprint function and the objectTotalSize function so, we use sometimes in this function
         and, sometimes we use the two functions.
        */
        logger.info(()->JvmUtilities.objectFootprint(admin_test, member1, member2, member3));

        logger.info(()->JvmUtilities.objectTotalSize(admin_test, member1, member2, member3));

        admin_test.register(member1);
        admin_test.register(member2);
        admin_test.register(member3);

        logger.info(()->JvmUtilities.objectFootprint(admin_test, member1, member2, member3));

        logger.info(()->JvmUtilities.objectTotalSize(admin_test, member1, member2, member3));

        admin_test.append("Testing");

        logger.info(()->JvmUtilities.objectFootprint(admin_test, member1, member2, member3));

        logger.info(()->JvmUtilities.objectTotalSize(admin_test, member1, member2, member3));

        // Unregistered some members to see how it affects on admin_test
        admin_test.unregister(member1);

        logger.info(()->JvmUtilities.memoryStats(admin_test));

        admin_test.unregister(member2);

        logger.info(()->JvmUtilities.memoryStats(admin_test));
    }
}
