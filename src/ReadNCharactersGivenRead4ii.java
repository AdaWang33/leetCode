/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4); 
 */

public class ReadNCharactersGivenRead4ii {
    private int bufferPnt = 0;
    private int bufferCnt = 0;
    private char[] buffer = new char[4];
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int pnt = 0;
        while(pnt<n) {
            if (bufferPnt==0) {
                bufferCnt = read4(buffer);
            }
            if (bufferCnt==0) {
                break;
            }
            
            while(bufferPnt<bufferCnt) {
                if(pnt==n) {
                    break;
                }
                buf[pnt++] = buffer[bufferPnt++];
            }
            if(bufferPnt==bufferCnt) {
                bufferPnt = 0;
            }
        }
        return pnt;

    }
}
