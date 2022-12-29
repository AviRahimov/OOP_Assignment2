# Object Oriented Programming - Second Assignment
This assignment is about Observer design pattern with the use of UndoableStringBuilder - an object that we created that is similar to StringBuilder.
We have a GroupAdmin class that will be the Observable Class and ConcreteMember class that will be the Observer Class and 2 interfaces: Member and Sender.
### GroupAdmin Observable Class:
**Class Fields:** UndoableStringBuilder and an arraylist that holds the members that registered to the groupadmin observable.

**Constructor:** We build a default constructor that initialize the arraylist and the UndoableStringBuilder.

**Functions:**

1)The register function is about registering new member to the collections of members that the groupadmin holds, only a new member will be added, there is no duplicates.

2)The unregister function is about unregistering an existing member.

3)The insert function insert a string to the UndoableStringBuilder of the class and notify the members about the change so, the members can update themselves.

4)The append function is adding string to the end of existing string of all UndoableStringBuilder objects, then notifying all members about the change.

5)The delete function deletes some part in the UndoableStringBuilder and notify the members about the change so, the members can update themselves.

6)The undo function is undoing the last operation that has been done on all UndoableStringBuilder objects, then notifying all members about the change.

7)The notifyMember function run over all the members and notify them to update themselves according to the changes of the UndoableStringBuilder.
We also set getters and setters to the arraylist of members and to the UndoableStringBuilder so we can access them in different class.

### ConcreteMember Observer Class:
**Class Fields:** UndoableStringBuilder that points <sub>shallow copy</sub> to the UndoableStringBuilder of GroupAdmin and a string name that will be the name of the member.

**Constructor:** We build a constructor that receives a string name to set the name of the member and initiallize the UndoableStringBuilder.

**Functions**
1)The update function updates all the members to the current UndoableStringBuilder of groupadmin.

2)The toString function to print the ConcreteMember name and the the current UndoableStringBuilder.

3)The getUSB function is standard get method which returns the current's object's UndoableStringBuilder.

## Testing Classes

### ConcreteMemberTest

**Functions**

1)The update function is a TEST method for update() method in Concrete Member class

### GroupAdminTest

**Functions:**

1)The register function is a TEST method for register() method in Group Admin class, which registers 10 members to group admin and then check if they are registered successfully

2)The unregister function is a TEST method for unregister() method in Group Admin class, which registers 4 members to group admin and then unregisters them and checks if unregistered successfully

3)The insert function is a TEST method for insert() method in Group Admin class, which inserting and checking if inserted as well

4)The append function is a TEST method for append() method in Group Admin class, which registers 4 members to group admin and then appending them and checks if appended successfully

5)The delete function is a TEST method for delete() method in Group Admin class, which deleting and checking if deleted as well

6)The undo function is a TEST method for undo() method in Group Admin class, which perform 5 actions on Group Admin and then udoing 4 of them and checking if we get only the first operation


## How to use
