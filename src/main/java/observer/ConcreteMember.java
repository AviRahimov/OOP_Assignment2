package observer;

/**
 * The ConcreteMember class is an observer class that implements from Member Interface that are responsible to
 * update the members due to changes in UndoableStringBuilder in GroupAdmin class(the observable class).
 */
public class ConcreteMember implements Member{
    private UndoableStringBuilder stringBuilder;
    private String member_name;

    public ConcreteMember(String member_name){
        this.member_name = member_name;
        this.stringBuilder = new UndoableStringBuilder();
    }

    /**
     *
     * @param usb describe the UndoableStringBuilder that need to be replaced by the current UndoableStringBuilder
     *            object that belong to the member.
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        stringBuilder = usb;
        System.out.println("The member updated successfully");
    }

    @Override
    public String toString() {
        return "ConcreteMember{" + "name=" + member_name +
                "stringBuilder=" + stringBuilder +
                '}';
    }

    public UndoableStringBuilder getUSB() {
        return stringBuilder;
    }
}
