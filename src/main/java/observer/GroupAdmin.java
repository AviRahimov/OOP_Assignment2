package observer;

import java.util.ArrayList;
import java.util.Stack;

public class GroupAdmin implements Sender{
    private ArrayList<UndoableStringBuilder> conditions;
    private ArrayList<Member> members;
    private Stack<UndoableStringBuilder> stk;
    public GroupAdmin(){
        this.members = new ArrayList<>();
        this.conditions = new ArrayList<>();
        this.stk = new Stack<>();
    }
    @Override
    public void register(Member obj) {
        this.members.add(obj);
    }

    @Override
    public void unregister(Member obj) {
        this.members.remove(obj);
    }

    @Override
    public void insert(int offset, String obj) {

    }

    @Override
    public void append(String obj) {

    }

    @Override
    public void delete(int start, int end) {

    }

    @Override
    public void undo() {

    }
}
