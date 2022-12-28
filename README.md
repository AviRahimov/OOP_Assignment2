# OOP_Assignment2
This assignment is about Observer design pattern with the use of UndoableStringBuilder - an object that we created that is similar to StringBuilder.
We have a GroupAdmin class that will be the Observable Class and ConcreteMember class that will be the Observer Class and 2 interfaces: Member and Sender.
### GroupAdmin Observable Class:
**Variables:** UndoableStringBuilder and an arraylist that holds the members that registered to the groupadmin observable.

**Constructor:** We build a default constructor that initialize the arraylist and the UndoableStringBuilder.

**Functions:**

1)The register function is about registering new member to the collections of members that the groupadmin holds, only a new member will be added, there is no duplicates.

2)The unregister function is about unregistering an existing member.

3)The insert function insert a string to the UndoableStringBuilder of the class and notify the members about the change so, the members can update themselves.

4)The append...

5)The delete function deletes some part in the UndoableStringBuilder and notify the members about the change so, the members can update themselves.

6)The undo function...

7)The notifyMember function run over all the members and notify them to update themselves according to the changes of the UndoableStringBuilder.
We also set getters and setters to the arraylist of members and to the UndoableStringBuilder so we can access them in different class.

### ConcreteMember Observer Class:
**Variables:** UndoableStringBuilder that point <sub>shallow copy</sub> to the UndoableStringBuilder of GroupAdmin and a string name that will be the name of the member.

**Constructor:** We build a constructor that receives a string name to set the name of the member and initiallize the UndoableStringBuilder.

**Functions**
The update function updates all the members to the current UndoableStringBuilder of groupadmin.
the toString function to print the ConcreteMember name and the the current UndoableStringBuilder.

### Testing Classes

## How to use
