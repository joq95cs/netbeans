package java21;
class IncrementAndDecrement
{
    public static void main(String[] arguments)
    {
        int x, y, z; // x, y and z are all declared
        x = 26; // 42 y set to x
        y = x++; // x is evaluated  and assigned to y, then it increments by 1
        z = ++x; // x is incremented to 44 and then assigned to z
        System.out.println("x = " + z);
    }
}
