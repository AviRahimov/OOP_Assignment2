package observer;

import java.util.*;

/**
 * A class that similar to StringBuilder class and an undo function that will be presented below
 * @author  Avraham and Avihai
 * @version 01/11/22
 */
public class UndoableStringBuilder {
    private StringBuilder s = new StringBuilder();
    private Stack<String> stk;

    /**
     * Default constructor that initialize the StringBuilder object and the stack
     */
    public UndoableStringBuilder(){
        s = new StringBuilder();
        stk = new Stack<>();
    }
    /**
     *
     * @param str the string that we want to append to the current StringBuilder we have
     * @return the new StringBuilder that caused by concatenating the two strings
     */
    public UndoableStringBuilder append(String str) {
        stk.push(s.toString());
        s = ((this.s).append(str));
        return this;
    }
    /**
     *
     * @param offset the index that we start to insert the new string in
     * @param str the string that we insert in index "offset" until the string end
     * @return a new StringBuilder after the string insertion in "offset" starting index
     */
    public UndoableStringBuilder insert(int offset, String str) {
        if(offset>s.length() || offset<0 || (str==null && offset!=0))
            throw new StringIndexOutOfBoundsException("Your offset index is out of the String bounds");
        stk.push(s.toString());
        s = (this.s).insert(offset, str);
        return this;
    }
    /**
     *
     * @param start the index that we start to delete the string from
     * @param end the index(not included) we stop deleting the string(until index end-1)
     * @return a new StringBuilder after deleting the string in index start to (end-1)
     */
    public UndoableStringBuilder delete(int start, int end) {
        if(start>s.length() || end>s.length() || start<0 || end<0 || start>end || (s==null && start!=0))
            throw new StringIndexOutOfBoundsException("You can't start or end in negative index and the start index cannot be greater than the end index and the start and end indexes cannot be greater the the current string length");
        stk.push(s.toString());
        s = (this.s).delete(start, end);
        return this;
    }
    /**
     *
     * @param start the index that the StringBuilder start from
     * @param end the index that the StringBuilder will stop but not contain the end itself, until end-1
     * @param str the string that we replace with into the StringBuilder from the index start to end-1
     * @return the full StringBuilder after the changes that created by swapping the string in the indexes that specified
     */
    public UndoableStringBuilder replace(int start,int end, String str) {
        if(str == null)
            throw new NullPointerException("You can't replace the string by null");
        if(start>s.length() || end >s.length() || start<0 || end<0 || start>end || (s==null && start!=0))
            throw new StringIndexOutOfBoundsException("You can't start or end in negative index or the start index cannot be greater than the end index or the start and end indexes cannot be greater than the current string length");
        stk.push(s.toString());
        s = (this.s).replace(start, end, str);
        return this;
    }
    /**
     *
     * @return the current StringBuilder reversed
     */
    public UndoableStringBuilder reverse() {
        stk.push(s.toString());
        s = (this.s).reverse();
        return this;
    }

    /**
     * An undo function that give the latest change in the StringBuilder in UndoableStringBuilder object
     */
    public void undo(){
        if(stk.isEmpty()!=true)
            s.replace(0, s.length(), stk.pop());
    }
    /**
     * @return the concatenation of the StringBuilder
     */
    @Override
    public String toString() {
        return (this.s).toString();
    }
}

