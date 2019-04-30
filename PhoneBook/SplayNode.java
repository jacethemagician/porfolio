//Jace Yang
//magician@brandeis.edu
//March 27, 2019
//PA#2
/* Explanation of the program/class */
//PhoneBook class essentially creates a SplayTree from SplayNode with key FullName and value PhoneNumber
/* Known Bugs: none */

public class SplayNode<KeyType extends Comparable<KeyType>, DataType> {

 private DataType data;
 private KeyType key;
 private SplayNode<KeyType, DataType> parent;
 private SplayNode<KeyType, DataType> leftChild;
 private SplayNode<KeyType, DataType> rightChild;
 
 /**
  * Constructor for the SplayNode
  * @param key
  * @param data
  */
 public SplayNode(KeyType key, DataType data) {
  this.key = key;
  this.data = data;
  this.parent = null;
  this.leftChild = null;
  this.rightChild = null;
 }

 /**
  * Gets the data stored in the node
  * Run time: O(1)
  * @return data
  */
 public DataType getData() {
  return this.data;
 }

 /**
  * Search for a node with this.key.equals(key) and splay that node to the root, return the new root
  * Run time: O(n)
  * @param key
  * @return SplayNode
  */
 public SplayNode<KeyType, DataType> search(KeyType key) {
  int comp = this.key.compareTo(key);
  if (comp == 0) {
   // When it is the right key
   splay();
   return this;
  } else if (comp > 0) {
   if (leftChild == null) {
    // Unsuccessful search
    splay();
    return this;
   } else {
    return leftChild.search(key);
   }
  } else {
   if (rightChild == null) {
    // Unsuccessful search
    splay();
    return this;
   } else {
    return rightChild.search(key);
   }
  }
 }

 /**
  * Checks if a certain key exists in the tree, returns true if key is in the tree else false
  * Run time: O(n)
  * @param key
  * @return true if key is found, false if not
  */
 public boolean contains(KeyType key) {
  int comp = this.key.compareTo(key);
  if (comp == 0) {
   return true;
  } else if (comp > 0) { // If child is null then return false, if not continue searching
   return leftChild == null ? false : leftChild.contains(key);
  } else {
   return rightChild == null ? false : rightChild.contains(key);
  }
 }

 /**
  * Insert a new node, then splay it to the root and return the new root
  * Run time: O(n)
  * @param newNode
  * @return SplayNode root
  */
 public SplayNode<KeyType, DataType> insert(SplayNode<KeyType, DataType> newNode) {
  int comp = this.key.compareTo(newNode.key);
  if (comp == 0) {
   // Key already exists
   return null;
  } else if (comp > 0) {
   if (leftChild == null) {
    // Successfully found place to insert
    newNode.parent = this;
    leftChild = newNode;
    newNode.splay();
    return newNode;
   } else {
    // Continue searching for place to insert
    return leftChild.insert(newNode);
   }
  } else {
   if (rightChild == null) {
    // Successfully found place to insert
    newNode.parent = this;
    rightChild = newNode;
    newNode.splay();
    return newNode;
   } else {
    // Continue searching for place to insert
    return rightChild.insert(newNode);
   }
  }
 }

 /**
  * Find the node to be deleted and splay it to the root. Remove the root, leaving the left and right subtrees
  * disconnected. Find the max element of the left subtree and splay it to the root of the left subtree,
  * then make the root of the right subtree a right child of the left root.
  * Run time: O(n)
  * @param oldVal
  * @return New root
  */
 public SplayNode<KeyType, DataType> delete(KeyType oldVal) {
  SplayNode<KeyType, DataType> deleteNode = search(oldVal);
  SplayNode<KeyType, DataType> rightNode = deleteNode.rightChild;
  SplayNode<KeyType, DataType> leftNode = deleteNode.leftChild;
  
  if (rightNode != null) {
   rightNode.parent = null;
  }
  if (leftNode != null) {
   leftNode.parent = null;
  }
  
  // Returning the new root
  if (leftNode == null) {
   return rightNode;
  } else {
   SplayNode<KeyType, DataType> maxNode = leftNode.findMax();
   if (maxNode.rightChild != null) {
    throw new RuntimeException();
   }
   maxNode.rightChild = rightNode;
   if (rightNode != null) {
    rightNode.parent = maxNode;
   }
   return maxNode;
  }
 }
 
 /**
  * Finding the maximum element by comparing the current node and its right child
  * Run time: O(n)
  * @return Node with maximum value
  */
 private SplayNode<KeyType, DataType> findMax() {
  if (rightChild == null) {
   splay();
   return this;
  } else {
   return rightChild.findMax();
  } 
 }
 
 /**
  * Splay operations on a node until it is at the root
  * Run time: O(n)
  */
 private void splay(){
  if (isRoot()) {
   return;
  } else {
   if (parent.isRoot()) {
    zig();
   } else {
    if (isLeft() == parent.isLeft()) {
     zigZig();
    } else {
     zigZag();
    }
    splay();
   }
  }
 }
 
 /**
  * Zig operation
  * Run time: O(1)
  */
 private void zig() {
  if (isLeft()) {
   rotateRight();
  } else if (isRight()) {
   rotateLeft();
  } else {
   throw new RuntimeException();
  }
 }
 
 /**
  * Zig zag operation
  * Run time: O(1)
  */
 private void zigZag() {
  zig();
  zig();
 }
 
 /**
  * Zig zig operation
  * Run time: O(1)
  */
 private void zigZig() {
  parent.zig();
  zig();
 }
 
 /**
  * Rotate right the node
  * Run time: O(1)
  */
 private void rotateRight() {
  if (isRoot()) {
   throw new RuntimeException();
  }
  
  SplayNode<KeyType, DataType> grandParent = parent.parent;
  boolean isLeft = parent.isLeft();
  
  parent.leftChild = this.rightChild;
  if (this.rightChild != null) {
   this.rightChild.parent = parent;
  }
  
  parent.parent = this;
  this.rightChild = parent;
  
  this.parent = grandParent;
  
  if (grandParent == null) {
   return;
  }
  
  if (isLeft) {
   grandParent.leftChild = this;
  } else {
   grandParent.rightChild = this;
  }
 }
 
 /**
  * Rotate left the node
  * Run time: O(1)
  */
 private void rotateLeft() {
  if (isRoot()) {
   throw new RuntimeException();
  }
  
  SplayNode<KeyType, DataType> grandParent = parent.parent;
  boolean isLeft = parent.isLeft();
  
  parent.rightChild = this.leftChild;
  if (this.leftChild != null) {
   this.leftChild.parent = parent;
  }
  
  parent.parent = this;
  this.leftChild = parent;
  
  this.parent = grandParent;
  
  if (grandParent == null) {
   return;
  }
  
  if (isLeft) {
   grandParent.leftChild = this;
  } else {
   grandParent.rightChild = this;
  }
 }
 
 /**
  * Checks if the node is the root
  * Run time: O(1)
  * @return true if it is the root, false if not
  */
 private boolean isRoot() {
  return parent == null;
 }
 
 /**
  * Checks if the node is the left child
  * Run time: O(1)
  * @return true if it is the left child, false if not
  */
 private boolean isLeft() {
  return parent != null && parent.leftChild == this;
 }
 
 /**
  * Checks if the node is the right child
  * Run time: O(1)
  * @return true if it is the right child, false if not
  */
 private boolean isRight() {
  return parent != null && parent.rightChild == this;
 }

 /**
  * Returns the string representation of the node
  * Run time: O(1)
  */
 public String toString() {
  return key.toString() + " : " + data.toString() + "\n";
 }

 /**
  * String representation of the tree
  * Run time: O(n)
  * @return string representation of tree
  */
 public String treeString() {
  String output = "(";
  
  if (leftChild != null) {
   output += leftChild.treeString();
  }
  output += " ";
  output += key.toString();
  output += " ";
    
  if (rightChild != null) {
   output += rightChild.treeString();
  }
  
  output += ")";
  return output;
 }

 /**
  * Finds the height of the tree
  * Run time: O(n)
  * @return height of tree
  */
 public int height() {
  int l = leftChild == null ? 0 : leftChild.height();
  int r = rightChild == null ? 0 : rightChild.height();
  
  return 1 + Integer.max(l, r);
 }

}
