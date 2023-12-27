package java21;
class Investment
{
    double investmentValue;
    double incrementValue;
    void showCurrentInvestmentValue()
    {
        System.out.println("The current investment value equals to: " + investmentValue);
    }
    void increment()
    {
        investmentValue += incrementValue;
    }
}