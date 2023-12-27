package java21;
class Investment1
{
    public static void main(String[] arguments)
    {
        Investment investmentA = new Investment();
        investmentA.investmentValue = 14000;
        System.out.println("Start");
        investmentA.showCurrentInvestmentValue();
        investmentA.incrementValue = (14000 * 0.40);
        investmentA.increment();
        System.out.println("\nFirst year");
        investmentA.showCurrentInvestmentValue();
        investmentA.incrementValue = -1500;
        investmentA.increment();
        System.out.println("\nSecond year");
        investmentA.showCurrentInvestmentValue();
        investmentA.incrementValue = (14000 * 0.12);
        investmentA.increment();
        System.out.println("\nThird year");
        investmentA.showCurrentInvestmentValue();
    }
}