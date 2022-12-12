package observer;

public class ConcreteMember implements Member{
    private UndoableStringBuilder stringBuilder;
    @Override
    public void update(UndoableStringBuilder usb) {
        this.stringBuilder = usb;
    }
}
