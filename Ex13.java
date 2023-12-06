/**
 * Maman 13
 * @author Tamir Shaoni
 * @version 21/01/23
 */
public class Ex13
{
    /**Ex 1.<br>
     * This method takes in a string and returns the minimum number of swaps needed to make the string fit
     * into a pattern of "101010" or "010101" the closest between them.
     * <br>
     * Time complexity: O(n) - This because the method uses a single "for" loop to iterate through the string and performs a constant number of operations on each iteration. <br>
     * Space complexity: O(1) - This because it is only uses a fixed number of variables, regardless of the size of the input string.
     * 
     * @param s A given string made of the same amount of '1' and '0'.
     * @return The minimum number of swaps needed
     */
    public static int alternating (String s)
    {
        //setting counters
        int swaps=0;
        int p1=0; 
        int p2=0;
        int p3=0;

        for(int i=0;i<s.length();i+=2) // Dividing the string into pairs
        {
            if(s.charAt(i) == '1' && s.charAt(i+1) == '0') // if the pair is "10" p1++
                p1++;
            else if(s.charAt(i) == '0' && s.charAt(i+1) == '1') // if the pair is "01" p2++
                p2++;
            else if(s.charAt(i) == '1' && s.charAt(i+1) == '1') // if the pair is "11" (it could be "00" also) p3++
                p3++;
        }

        // Now that we count how many of every pattern we have it is easier to decide what is the closest pattern we want to achieve
        // first of all, if we have pair of "00" must be pair of "11" - we have to swap 
        swaps+=p3;

        if(p1>p2) // if p1 is greater than p2, its easier to turn those p2 pairs into p1
            swaps+=p2;
        else    // if p2 is greater or equal to p1, its easier (or the same as p2) to turn p1 pairs into p2
            swaps+=p1;

        return swaps;
    }

    /** Ex 2.<br>
     * a) "what" method search for the highest range of subarrays which their sum is even.<br>
     * b) "what" method time complexity is O(n^2) and the space complexity is O(1).<br>
     * d) The new "what" method that I wrote have time complexity of O(n) because it iterates through the array twice,<br>
     *    once to calculate the sum of all elements in the array and once to check for odd numbers from the beginning and end of the array. <br>
     *    The space complexity is O(1) because it only uses a constant amount of memory to store the variables "temp" and "sum".
     * 
     * @param a A given array of integers.
     * @return The highest range of subarrays which their sum is even.
     */

    public static int what (int[] a)
    {
        int temp = 0; // Initalize variables 
        int sum = 0;
        for (int i=0; i<a.length; i++)  // Sum all the subarrays values 
        {
            sum+=a[i];
            temp++;
        }
        for(int j=0;j<a.length;j++) 
            if(sum%2!=0) // In case of the sum isn't even
            {
                if(a[a.length-(j+1)]%2!=0) // Checks for uneven number from the end, if there is we remove it from the sum
                {
                    sum-=a[a.length-(j+1)];
                    temp-=(j+1);
                }
                else if(a[j]%2!=0) // Checks for odd number from the beginning, if there is we remove it from the sum
                {
                    sum-=a[j];
                    temp-=(j+1);
                }
            }
        return temp;
    }

    /**
     * Ex 3.<br>
     * isWay method is checking if there is a way to reach the end of the array by moving up or down by the value of the element at the current index.
     * 
     * @return True if we can reach the end or False if we can't.  
     * 
     * @param a Int array full of numbers
     */
        public static boolean isWay(int[] a)
    {
        return isWay(a,0);
    }
    private static boolean isWay(int[] a,int i)
    {
        if(i < 0 || i >= a.length) // In case of invalid index
        return false;
        if(i == a.length-1) // In case we reached the end
        return true;
        
        int temp = a[i]; // Saving a[i] value
        a[i] = Integer.MAX_VALUE; // Marking that we have been here
        boolean up = isWay(a,i+temp); // Checking up
        boolean down = isWay(a,i-temp); // Checking down
        a[i] = temp; // Return the cell value as it was
        return up || down; // Return True/False wether we reached the end or not
        
    }


    /**
     * Ex 4.<br>
     * Prince method gives us the minimum steps necessary to catch the villain
     * @return The minimum number of steps necessary to catch the villain or -1 if we can't catch him.
     * 
     * @param drm Digital roof heights map in array 
     * @param i Prince inital line
     * @param j Prince inital column
     */

    public static int prince(int[][] drm,int i, int j)
    {
        int min = prince(drm,i,j,drm[i][j],0);
        if(min == Integer.MAX_VALUE) // In case we cant reach the villain
            return -1;
        return min; // Return min steps
    }
    
    private static int prince(int[][] drm,int i, int j, int last ,int count)
    {
        if(i<0 || j<0 || i >= drm.length || j >= drm.length) // In case of invalid location
            return Integer.MAX_VALUE;
        if(drm[i][j] == -1) // In case we arrived to the villain 
            return count+1;
        if(last - drm[i][j] < -1 || last - drm[i][j] > 2) // The rules of getting up / down
            return Integer.MAX_VALUE;

        int temp = drm[i][j];  // Temp variable to save the value of the square
        drm[i][j] = Integer.MAX_VALUE; // Mark that we have been here

        int north = prince(drm,i-1,j,temp,count+1); // Going North
        int south = prince(drm,i+1,j,temp,count+1); // Going South
        int west = prince (drm,i,j-1,temp,count+1); // Going West 
        int east = prince(drm,i,j+1,temp,count+1); //Going East

        drm[i][j] = temp; // Return the array as it was

        return Math.min(Math.min(north,south),Math.min(west,east)); // Return the minimum value
    } 
}

