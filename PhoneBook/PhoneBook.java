//Jace Yang
//magician@brandeis.edu
//March 27, 2019
//PA#2
/* Explanation of the program/class */
//PhoneBook class uses SplayNode with key FullName and value PhoneNumber
//to creates a splay tree and make use of its function
/* Known Bugs: none */

public class PhoneBook<FullName extends Comparable<FullName>, PhoneNumber> {
 
 public SplayNode<FullName, PhoneNumber> root;

 public PhoneBook() {
 }
 
 /**
  * Inserts a SplayNode into the PhoneBook
  * Run time: O(n)
  * @param node
  */
 public void insert(SplayNode<FullName, PhoneNumber> node) {
  // If root is null, then the node should be the root
  root = root == null ? node : root.insert(node);
 }
 
 /**
  * Calls the insert method by passing a SplayNode object with the name and data
  * Run time: O(n)
  * @param name
  * @param data
  */
 public void insert(FullName name, PhoneNumber data) {
  insert(new SplayNode<FullName, PhoneNumber>(name, data));
 }
 
 /**
  * Deletes a specific name
  * Run time: O(n)
  * @param name
  */
 public void delete(FullName name) {
  root = root.delete(name);
 }
 
 /**
  * Searches for a specific name
  * Run time: O(n)
  * @param name
  * @return PhoneNumber
  */
 public PhoneNumber search(FullName name) {
  if (root == null) {
   return null;
  } else {
   root = root.search(name);
   return root.getData();
  }
 }

 /**
  * Returns a string representation
  * Run time: O(1)
  */
 public String toString() {
  return root.toString();
 }
 
 /**
  * Run time: O(n)
  * @return String representation of PhoneBook
  */
 public String treeString() {
  if (root == null) {
   return "";
  }
  return root.height() + ": " + root.treeString();
 }
 
}
