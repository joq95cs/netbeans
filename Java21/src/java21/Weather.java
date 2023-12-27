package java21;
public class Weather
{
    public static void main(String[] arguments)
    {
        float fah = 86;
        System.out.println(fah + " Degrees Farenheit is...");
        // To convert Farenheit into Celcis
        // Begin with subtracting 32
        fah -=32;
        // Divide the answer by 9
        fah /=9;
        // Multiply that answer by 5
        fah = fah * 5;
        System.out.println(fah + " Degrees Celsius\n");
        float cel = 33;
        System.out.println(cel + " Degrees Celcius is...");
        // To convert Celcius into Farenheit
        // Begin by multiplying by 9
        cel *= 9;
        // Divide the answer by 5
        cel /= 5;
        // Add 32 to the answer;
        cel += 32;
        System.out.println(cel + " Degrees Farenheit");
    }
}