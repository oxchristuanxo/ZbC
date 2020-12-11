package zhajidian;

public class SetMeal {
    public Drinks drink;
    protected String Mealname;
    protected double price;
    protected String chicken;
    protected SetMeal(String Mealname, double price, String chicken,Drinks drinks)
    {
        this.Mealname=Mealname;
        this.price=price;
        this.chicken=chicken;
        this.drink=drinks;
    }
    @Override
    public String toString()
    {
        return "Name: "+this.Mealname+ ", cost: "+this.price+", productiondate: "+this.chicken+", shelflife : "+this.chicken;

    }
}
