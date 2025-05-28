/*  
 *  Triangle1.java
 *  Triangle1 class calculates the area and the perimeter of a given triangle.
 */
import java.util.Scanner;
public class Triangle1
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner (System.in);
        System.out.println("This program calculates the area and the perimeter of a given triangle.");
        System.out.println("Please enter the three lengths of the triangle's sides");
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        int perimeter = a + b + c; // Define and calculate the triangle's perimeter
        double s = 0.5 * perimeter; // Define and calculate half of the perimeter
        double area = Math.sqrt(s*(s-a)*(s-b)*(s-c)); // Define and calculate the triangle's area by Heron's formula

        System.out.println("The lengths of the triangle sides are: " + a + ',' + b + ',' + c + '.');
        System.out.println("The perimeter of the triangle is: " + perimeter);
        System.out.println("The area of the triangle is: " + area);
    }
}