package java21;

class VolcanoApplication
{
    public static void main(String[] arguments)
    {
        VolcanoRobot dante = new VolcanoRobot();
        dante.status = "exploring";
        dante.speed = 2;
        dante.temperature = 510;
        dante.showAttributes();
        System.out.println("Increasing speed to 3");
        dante.speed = 3;
        dante.showAttributes();
        System.out.println("Changing temperature to 670.");
        dante.temperature = 670;
        dante.showAttributes();
        System.out.println("Checking the temperature.");
        dante.checkTemperature();
        dante.showAttributes();
        VolcanoRobot virgil = new VolcanoRobot();
        virgil.status = "Investigating.";
        virgil.speed = 10;
        virgil.temperature = 100;
        virgil.showAttributes();
        System.out.println("Changing temperature to 350.");
        virgil.temperature = 350;
        virgil.showAttributes();
        System.out.println("Changing status to analazing.");
        virgil.status = "Analazing";
        virgil.showAttributes();
        System.out.println("Changing temperature to 850.");
        virgil.temperature = 850;
        virgil.showAttributes();
        System.out.println("Checking the temperature.");
        virgil.checkTemperature();
        virgil.showAttributes();        
    }
}