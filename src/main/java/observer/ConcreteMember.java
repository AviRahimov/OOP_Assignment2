package observer;

/**
 * The ConcreteMember class is an observer class that implements from Member Interface that are responsible to
 * update the members due to changes in UndoableStringBuilder in GroupAdmin class(the observable class).
 */
public class ConcreteMember implements Member{
    private UndoableStringBuilder stringBuilder;
    public ConcreteMember(UndoableStringBuilder str){
        this.stringBuilder = str;
    }

    /**
     *
     * @param usb describe the UndoableStringBuilder that need to be replaced by the current UndoableStringBuilder
     *            object that belong to the member.
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        stringBuilder = usb;
    }
}
