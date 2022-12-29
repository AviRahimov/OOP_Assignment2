package observer;

/**
 * The ConcreteMember class is an observer class that implements from Member Interface that are responsible to
 * update the members due to changes in UndoableStringBuilder in GroupAdmin class(the observable class).
 */
public class ConcreteMember implements Member {
    /**
     * USB object that CM will hold
     */
    private UndoableStringBuilder stringBuilder;

    /**
     * name for each CM object
     */
    private String member_name;

    /**
     * standart constructore for CM objects
     * @param member_name - name that will be assigned to any CM object
     */
    public ConcreteMember(String member_name) {
        this.member_name = member_name;
        this.stringBuilder = new UndoableStringBuilder();
    }

    /**
     * this function is updates the USB object
     * @param usb describe the UndoableStringBuilder that need to be replaced by the current UndoableStringBuilder
     *            object that belong to the member.
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        stringBuilder = usb;
        System.out.println("The member updated successfully");
    }

    /**
     * this function is standrart toString() method
     * @return fields of current CM object
     */
    @Override
    public String toString() {
        return "ConcreteMember{" + "name=" + member_name +
                ", stringBuilder=" + stringBuilder +
                '}';
    }

    /**
     * standart get method for CM's USB object
     * @return the current CM's USB
     */
    public UndoableStringBuilder getUSB() {
        return this.stringBuilder;
    }
}
