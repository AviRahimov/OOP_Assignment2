package observer;

import java.util.ArrayList;

/**
 *  The groupAdmin class is an observable class that implements from Sender Interface that are responsible
 *  to send updates to all the members that registered, the class hold two objects:
 *  1) An UndoableStringBuilder object.
 *  2) Collections of members that need to be notified when
 *  changing the UndoableStringBuilder.
 */
public class GroupAdmin implements Sender {
    /**
     * USB object for GA
     */
    private UndoableStringBuilder condition;

    /**
     * list that hold all members that regeistered for GA
     */
    private ArrayList<Member> members;

    /**
     * defult constructor
     */
    public GroupAdmin() {
        this.members = new ArrayList<>();
        this.condition = new UndoableStringBuilder();
    }

    /**
     * this function is registering member to GA
     * @param obj describe the member that register to the members collections, this is like hiring a new worker
     *            to a company so, he needs to register to the company.
     */
    @Override
    public void register(Member obj) {
        if(!(members.contains(obj))){
            this.members.add(obj);
            System.out.println("Added new member");
        }
    }

    /**
     * this function is removing member from registered list of GA
     * @param obj describe the member that will be removed from the members collections, this is like firing
     *            a worker from a company.
     */
    @Override
    public void unregister(Member obj) {
        if(members.contains(obj)) {
            this.members.remove(obj);
            System.out.println("Removed member");
        }
    }

    /**
     * this function inserts to GA's USB string in index offset
     * @param offset describe the index that the user start to insert the new String object in.
     * @param obj describe the String object that the user insert in index "offset" until the String object end.
     */
    @Override
    public void insert(int offset, String obj) {
        condition.insert(offset, obj);
        notifyMember();
    }

    /**
     * this function appends to GA's USB string
     * @param obj describe the String Object the user want to append to exist UndoableStringBuilder and,
     *            the for loop notifying all members to update themselves due to appending String object to the current
     *            UndoableStringBuilder.
     */
    @Override
    public void append(String obj) {
        condition.append(obj);
        notifyMember();
    }
    /**
     * this function deletes sub-string of GA's USB' string
     * @param start describe the index that the user start to delete the UndoableStringBuilder.
     * @param end describe the index(not included) the user stop deleting the string(until index end-1)
     *            The for loop notifying all members to update themselves due to deletion some part of
     *            the UndoableStringBuilder.
     */

    @Override
    public void delete(int start, int end) {
        condition.delete(start, end);
        notifyMember();
    }

    /**
     * this function undos the last operation from GA's USB's string
     * An undo function that give the latest change in the UndoableStringBuilder object and update
     * all members UndoableStringBuilder to the current one.
     */
    @Override
    public void undo() {
        condition.undo();
        notifyMember();
    }

    /**
     * this function is notifying all members in the list about a change that happen,
     *      so they could update accordingly
     */
    private void notifyMember() {
        for (Member member : members){
            member.update(condition);
        }
    }

    /**
     * standart get method for list of members
     * @return the GA's array list of regeistered members
     */
    public ArrayList<Member> getMembers() {
        return this.members;
    }

    /**
     * standart get method for USB
     * @return the GA's USB 
     */
    public UndoableStringBuilder getCondition() {
        return condition;
    }
}
