# Object Oriented Programming - Second Assignment

Authors: Avraham Rahimov & Lior Vinman

This project is about _Observer design pattern_ with the use of UndoableStringBuilder (_"USB"_) - an object that we created that is an extention for JAVA's standart stringbuilder object, the update is in extended object, there is an option to undo the last operation (undoable) that was performed on the stringBuilder.


We have a GroupAdmin (_"GA"_) class that will be the Observable Class and ConcreteMember (_"CM"_) class that will be the Observer Class. In addition, there are two interfaces that are Member and Sender, GroupAdmin class implements the Sender and ConcreteMember class implements the Member.

## Functional Classes:

### GroupAdmin - Observable:
**Class Fields:**
UndoableStringBuilder object - "condition", that represents the USB of the current object; and an arraylist of type Member - "members", that holds the CMs that registered to GA.

**Object's Constructor:**
There is a default constructor that initialize the arraylist and the UndoableStringBuilder.

**Class Methods:**

1) _void register(Member)_ - this method is about registering new member to the collections of members that the GA holds, only a new member will be added, there is no duplicates.
2) _void unregister(Member)_ - this method is about unregistering an existing member from the list.
3) _void insert(int, String)_ - this method inserts a string to the USB of the class and notify the members about the change, so they can update themselves.
4) _void append(String)_ - this method is adding string to the end of existing string of all USB objects, then notifying all members about the change.
5) _void delete(int, int)_ - this method deletes a part from the USB and then notifying the members about the change, so they can update themselves.
6) _void undo()_ - this method is undoing the last operation that has been done on all USB objects, then notifying all members about the change.
7) _void notifyAll()_ - this method run over all the members and notify them to update themselves according to the changes of the UndoableStringBuilder.

there are also, _getters_ for class fields:
1) _ArrayList<Member> getMembers()_ - returns the list of members that GA holds.
2) _UndoableStringBuilder getCondition()_ - returns the USB object that GA holds.
  
There are no _setters_!
  
### ConcreteMember - Observer:
**Class Fields:**
UndoableStringBuilder object - "stringBuilder", that that points (_i.e. shallow copy_) to the UndoableStringBuilder of GroupAdmin; and a string - "member_name" that will be the name of the member.

**Object's Constructor:**
There is a constructor that receives a string name to set the name of the member and initiallize the UndoableStringBuilder.

**Class Methods:**
1) _void update(UndoableStringBuilder)_ - this method updates all the members to the current USB of GA.
2) _String toString()_ - this method returns a string of object's fields.

there is also, _getter_ for class field:
1) _UndoableStringBuilder getUSB()_ - returns the the current's object's UndoableStringBuilder.

There are no _setters_!

## Testing Classes:

### ConcreteMemberTest:

**TEST Methods:**
1) _void update()_ - test method for _update()_ method in CM class.

### GroupAdminTest

**TEST Methods:**
1) _void register()_ - test method for _regeiser()_ method in GA class.
2) _void unregister()_ - test method for _unregeiser()_ method in GA class.
3) _void insert()_ - test method for _insert()_ method in GA class.
4) _void append()_ - test method for _append()_ method in GA class.
5) _void delete()_ - test method for _delete()_ method in GA class.
6) _void undo()_ - test method for _undo()_ method in GA class.

## How to use
To clone this project all you need to do is to copy the [_project URL_](https://github.com/AviRahimov/OOP_Assignment2.git) to git bash and to change the current working directory to the location where you want the cloned directory.
  
Using the command: _"git clone https://github.com/AviRahimov/OOP_Assignment2.git <location-to-clone>"_, then the cloning proccess will start.
