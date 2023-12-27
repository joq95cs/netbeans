package java21;
class Boolean
{
    public static void main(String[] arguments)
    {
        boolean adult;
        boolean elder;
        boolean teenager;
        boolean child;
        boolean childToElder;
        boolean childToAdult;
        boolean childToTeenager;
        boolean twoAges;
        int soannaAge = 14;
        int quitoAge = 3;
        int elenaAge = 66;
        int angelAge = 21;
        adult = angelAge > 18;
        elder = elenaAge > 55;
        teenager = quitoAge > 13;
        child = soannaAge < 10;
        childToElder = (elenaAge > 55) && (elenaAge > 5);
        childToAdult = (angelAge > 5) && (angelAge < 55);
        childToTeenager = (soannaAge > 5) && (soannaAge < 18);
        twoAges = quitoAge > 5;
        System.out.println("Is Angel an adult? It's " + adult);
        System.out.println("Is Elena an elder? It's " + elder);
        System.out.println("Is Quito a teenager? It's " + teenager);
        System.out.println("Is Soanna a child? It's " + child);
        System.out.println("Is Angel over a child's age but under an elder age? It's " + childToAdult);
        System.out.println("Is Elena over three ages? " + elder);
        System.out.println("Is Quito over at least two ages? It's " + twoAges);
    }
}