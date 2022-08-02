package pl.javaskills.maven.intro;

public class MoneyFromSocialPerYear {
    private final TaxForNoChildren tax;
    public MoneyFromSocialPerYear(TaxForNoChildren tax){
        this.tax=tax;
    }
    public int calculate(int child){
        if(child > 0){
            return child*500*12;
        }
        else if(child==0){
            return tax.payTaxPerYear();
        }
        else{
            return 0;
        }
    }
}
