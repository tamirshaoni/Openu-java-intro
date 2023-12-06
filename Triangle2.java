/*  
 *  Triangle2.java
 *  Triangle2 class checks if 3 given numbers can be a triangle and identify its type 
 */
import java.util.Scanner;
public class Triangle2
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner (System.in);
        System.out.println("This program checks if 3 given numbers can be a triangle and identify its type");
        System.out.println("Please enter the three lengths of the triangle's sides");
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        if((a+b)>c && (a+c)>b && (b+c)>a ) // Check if the numbers can represent a triangle
        {
            if(a==b && a==c) // Check if it's equilateral triangle
                System.out.println("The numbers: "+ a + ", " + b + " and " + c + " represent an equilateral triangle");
            else if(a==b || a==c || b==c) // Check if it's isosceles triangle
                System.out.println("The numbers: "+ a + ", " + b + " and " + c + " represent an isosceles triangle");
            else if(a>b && a>c) // Find if "a" is the hypotenuse
            {
                if(Math.pow(a,2) == Math.pow(b,2) + Math.pow(c,2)) // Pytgoras check
                    System.out.println("The numbers: "+ a + ", " + b + " and " + c + " represent a right-angle triangle");
                else
                    System.out.println("The numbers: "+ a + ", " + b + " and " + c + " represent a common triangle");
            }
            else if(b>a && b>c)// Find if "b" is the hypotenuse
            {
                if(Math.pow(b,2) == Math.pow(a,2) + Math.pow(c,2)) // Pytgoras check
                    System.out.println("The numbers: "+ a + ", " + b + " and " + c + " represent a right-angle triangle");
                else
                    System.out.println("The numbers: "+ a + ", " + b + " and " + c + " represent a common triangle");
            }
            else if(c>a && c>b) // Find if "c" is the hypotenuse
            {
                if(Math.pow(c,2) == Math.pow(a,2) + Math.pow(b,2)) // Pytgoras check
                    System.out.println("The numbers: "+ a + ", " + b + " and " + c + " represent a right-angle triangle");
                else
                    System.out.println("The numbers: "+ a + ", " + b + " and " + c + " represent a common triangle");
            }
        }
        else{
            System.out.println("The numbers: "+ a + ", " + b + " and " + c + " cannot represent a triangle");
        }
    }
}
