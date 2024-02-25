/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */


 /**
  * Given a file and assume that you can only read the file using a given method read4, implement a method to read n characters.

Method read4:

The API read4 reads four consecutive characters from file, then writes those characters into the buffer array buf4.

The return value is the number of actual characters read.

Note that read4() has its own file pointer, much like FILE *fp in C.

  */


  /*
   * read4(): modifies buf4(), and return number read
   */

   /*
    * example
    File file("abcde"); // File is "abcde", initially file pointer (fp) points to 'a'
char[] buf4 = new char[4]; // Create buffer with enough space to store characters
read4(buf4); // read4 returns 4. Now buf4 = "abcd", fp points to 'e'
read4(buf4); // read4 returns 1. Now buf4 = "e", fp points to end of file
read4(buf4); // read4 returns 0. Now buf4 = "", fp points to end of file
    */

 public class ReadNCharactersGivenRead4 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int copied = 0;
        int read = 4;
        char[] buf4 = new char[4];

        while(copied<n && read==4) {
            read = read4(buf4);
            for (int i=0;i<read;i++) {
                if(copied==n) {
                    return copied;
                }
                buf[copied++] = buf4[i];
            }
        }
        return copied;
    }
}