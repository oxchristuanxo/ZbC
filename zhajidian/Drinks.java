package zhajidian;

import java.time.LocalDate;

abstract class Drinks {
    protected String name;
    protected double cost;
    protected LocalDate productiondate;
    protected int shelflife;
    protected Drinks(String name, double cost, LocalDate productiondate, int shelflife)
    {
        this.name=name;
        this.cost=cost;
        this.productiondate=productiondate;
        this.shelflife=shelflife;
    }
    public void judge()
    {
        LocalDate date = productiondate.plusDays(shelflife);
        if(LocalDate.now().isAfter(date)){
            System.out.println("no!!!!!!");
        }
        else{
            System.out.println("yes");
        }
    }
    @Override
    public String toString()
    {
        return "Name: "+this.name+ ", cost: "+this.cost+", productiondate: "+this.productiondate+", shelflife : "+this.shelflife;

    }

}

