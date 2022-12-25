package observer;

import java.util.ArrayList;

/**
 *  The groupAdmin class is an observable class that implements from Sender Interface that are responsible
 *  to send updates to all the members that registered, the class hold two objects:
 *  1) An UndoableStringBuilder object.
 *  2) Collections of members that need to be notified when
 *  changing the UndoableStringBuilder.
 */
public class GroupAdmin implements Sender{
    private UndoableStringBuilder condition;
    private ArrayList<Member> members;

    public GroupAdmin() {
        this.members = new ArrayList<>();
        this.condition = new UndoableStringBuilder();
    }

    /**
     *
     * @param obj describe the member that register to the members collections, this is like hiring a new worker
     *            to a company so, he needs to register to the company.
     */
    @Override
    public void register(Member obj) {
        this.members.add(obj);
    }

    /**
     *
     * @param obj describe the member that will be removed from the members collections, this is like firing
     *            a worker from a company.
     */
    @Override
    public void unregister(Member obj) {
        this.members.remove(obj);
    }

    /**
     *
     * @param offset describe the index that the user start to insert the new String object in.
     * @param obj describe the String object that the user insert in index "offset" until the String object end.
     */
    @Override
    public void insert(int offset, String obj) {
        condition = condition.insert(offset, obj);
        for (Member member : members){
            member.update(condition);
        }
    }

    /**
     *
     * @param obj describe the String Object the user want to append to exist UndoableStringBuilder and,
     *            the for loop notifying all members to update themselves due to appending String object to the current
     *            UndoableStringBuilder.
     */
    @Override
    public void append(String obj) {
        condition = condition.append(obj);
        for (Member member : members){
            member.update(condition);
        }
    }
    /**
     *
     * @param start describe the index that the user start to delete the UndoableStringBuilder.
     * @param end describe the index(not included) the user stop deleting the string(until index end-1)
     *            The for loop notifying all members to update themselves due to deletion some part of
     *            the UndoableStringBuilder.
     */

    @Override
    public void delete(int start, int end) {
        condition = condition.delete(start, end);
        for (Member member : members){
            member.update(condition);
        }
    }

    /**
     * An undo function that give the latest change in the UndoableStringBuilder object and update
     * all members UndoableStringBuilder to the current one.
     */
    @Override
    public void undo() {
        condition.undo();
        for (Member member : members){
            member.update(condition);
        }
    }
}
