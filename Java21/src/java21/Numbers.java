package java21;
class Numbers
{
    public static void main(String[] arguments)
    {
        int n1 = 25563, n2 = 1995, result;
        double reminder;
        result = n1 / n2;
        reminder = n1 % n2;
        System.out.println("Number 1: " + n1 + "\nNumber 2: " + n2 + 
                           "\nDivision and reminder: " + result + "\t" + reminder);
    }
}