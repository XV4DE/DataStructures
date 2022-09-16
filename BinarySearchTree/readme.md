#Introduction
This code is intended to create and test a binary search tree data structure and some associated methods. Tests are contained within Main.java, the binary search tree structure itself is contained within BinarySearchTree.java, and the structure for a single node of the binary search tree is contained within Node.java.

#Problems
This code isn't perfect. The main issue (which could very well be hiding others) is the lack of complete testing. Although every method within the `Node` and `BinarySearchTree` classes is run at least once in a full execution of Main.java, there are several cases that remain unwritten and there are no generalized tests or tests for scale.

#Structure
###Node
Contains fields concerning the node's parent and children. Methods include setters and getters, methods to enable tree level insertion, and methods to find the node's successor and depth.
###BinarySearchTree
Keeps track of the head of the tree. Methods enable insertion and deletion into and from the tree as well as finding nodes by key, finding the depth of the tree, and converting the tree to a sorted ArrayList.
###Main
Tests the methods included in the `Node` and `BinarySearchTree` classes.
#Challenges
The main challenges in this problem were in three places, creating the helper method `rotate` for `BinarySearchTree`, creating the `getSuccessor` method for `Node`, and in learning how testing works and how much is the right amount.
#Methods I Wrote
I wrote all methods in this project save the methods named depth in `Node` and `BinarySearchTree`. These are:
###Node
* `Node()`
* `Node(int _key)`
* `Node(int _key, Node parent)`
* `getKey()`
* `getParent()`
* `getRchild()`
* `getLchild()`
* `getFarLeft()`
* `getSuccessor()`
* `setParent(Node _parent)`
* `setRchild(Node _rchild)`
* `setLchild(Node _lchild)`
* `insert(int n)`
* `insert(Node n)`
* `depth()`
###BinarySearchTree
* `getRoot()`
* `insert(int a)`
* `insert(Node a)`
* `find(int n)`
* `delete(Node n)`
* `trim(Node n)`
* `splice(Node n)`
* `rotate(Node n)`
* `treeWalk()`
* `depth()`
###Main
* `testDefaultConstructor()`
* `testInsert()`
* `testInsert2()`
* `testInsert3()`
* `testInsert4()`
* `testGetFarLeft()`
* `testGetSuccessor()`
* `testSetParent()`
* `testSetParent2()`
* `testSetLChild()`
* `testSetRChild()`
* `testTreeInsert()`
* `testFind()`
* `testTreeWalk()`
* `testTrim()`
* `testSplice()`
* `testRotate()`
* `testDepth()`
#Acknowledgements
* Mr.Kuszmaul: assigning the project, outlining the proper creation of several methods, and full credit for the method `depth` as it appears in both `Node` and `BinarySearchTree`.
