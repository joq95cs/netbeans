package java21;
import java.util.StringTokenizer;
class NamesTokens
{
    public static void main(String[] arguments)
    {
        StringTokenizer st1, st2, st3;
        
        String names = "Angel Jonas Lalo Gil Tere";
        st1 = new StringTokenizer(names);
        System.out.println("Name 1: " + st1.nextToken());
        System.out.println("Name 2: " + st1.nextToken());
        System.out.println("Name 3: " + st1.nextToken());
        System.out.println("Name 4: " + st1.nextToken());
        System.out.println("Name 5: " + st1.nextToken());
        
        String lastName = "Cruz Alvarado@Maldonado Ayala@Contreras Jiménez@Ferrer Sánchez@Aguilar Hernández";
        st2 = new StringTokenizer(lastName, "@");
        System.out.println("\nLast name 1: " + st2.nextToken());
        System.out.println("Last name 2: " + st2.nextToken());
        System.out.println("Last name 3: " + st2.nextToken());
        System.out.println("Last name 4: " + st2.nextToken());
        System.out.println("Last name 5: " + st2.nextToken());
        
        String age = "20 23 24 20 20";
        st3 = new StringTokenizer(age);
        System.out.println("\nAge 1: " + st3.nextToken());
        System.out.println("Age 2: " + st3.nextToken());
        System.out.println("Age 3: " + st3.nextToken());
        System.out.println("Age 4: " + st3.nextToken());
        System.out.println("Age 5: " + st3.nextToken());          
    }   
}
