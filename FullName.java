//Jace Yang
//magician@brandeis.edu
//March 27, 2019
//PA#2
/* Explanation of the program/class */
/* FullName class provided by instructor */
/* Known Bugs: none */

public class FullName implements Comparable<FullName> {
 private String firstName;
 private String lastName;

 public FullName(String firstName, String lastName) {
  this.firstName = firstName;
  this.lastName = lastName;
 }

 public String toString() {
  return this.lastName + ", " + this.firstName;
 }

 public int compareTo(FullName f) {
  int retval = this.lastName.compareTo(f.lastName);
  if (retval == 0) {
   return this.firstName.compareTo(f.firstName);
  }
  return retval;
 }
}
