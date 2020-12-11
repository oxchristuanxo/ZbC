package zhajidian;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class West2FriedChickenRestauran implements FriedChickenRestaurant{
    public double Account;
    static List <Beer> Beer = new ArrayList<>();
    static List <Juice> Juice =new ArrayList<>();
    static List <SetMeal> Meal =new ArrayList<>();
    static final Beer gx =new Beer("冠希哈皮",30, LocalDate.of(2020,10,11));
    static final Beer hh =new Beer("勃艮第至尊1873年酒",100, LocalDate.of(2020,10,11));
    static final Juice hz=new Juice("耗子尾汁",10, LocalDate.of(2020,10,11));
    static final SetMeal m1 = new SetMeal("套餐一",20,"小鸡鸡", gx);
    static final SetMeal m2 = new SetMeal("套餐二",30,"大鸡鸡", hz);
    static final SetMeal m3 = new SetMeal("套餐三",30,"大鸡鸡", hh);
    static {
       West2FriedChickenRestauran.Meal.add(m1);
       West2FriedChickenRestauran.Meal.add(m2);
       West2FriedChickenRestauran.Meal.add(m3);

}
    public void use(Beer beer,int number) throws IngredientSortOutException{
        int num =0;
        for (Drinks drinks : Beer) {
            if (beer == drinks)
                num++;
        }

        if(num>=number) {
            for(int i = 0; i < number;i++){
                for(int j = 0,k=0; k<1 ;j++){
                    if(beer==Beer.get(j)) {
                        Beer.remove(j);
                        k++;
                    }
                }
            }

        }
        else{
            throw new IngredientSortOutException("太差太差，"+beer.name+"不够了");
        }
    }
    public void use(Juice juice,int number) throws  IngredientSortOutException{
        int num =0;
        for (Drinks drinks : Juice) {
            if (juice == drinks)
                num++;
        }
        if(num>=number) {
            for(int i = 0; i < number;i++){
                for(int j = 0,k=0; k<1 ;j++){
                    if(juice==Juice.get(j)) {
                        Juice.remove(j);
                        k++;
                    }
                }
            }
        }
        else{
            throw new IngredientSortOutException("太差太差，"+juice.name+"卖完了");
        }
    }
    @Override
    public void sell(int mealID,int num) {
        if (Meal.get(mealID).drink instanceof Beer) {
          use((zhajidian.Beer) Meal.get(mealID).drink,num);
        }
        if (Meal.get(mealID).drink  instanceof Juice) {
          use((zhajidian.Juice) Meal.get(mealID).drink,num);

        }
    this.Account+= Meal.get(mealID).price*num;
    }

    @Override
    public void buy (Drinks drink,int num) throws OverdraftBalanceException{
        if(this.Account-drink.cost*num>=0){
        this.Account-=drink.cost*num;
        if (drink instanceof Beer) {
            for(int i =0 ;i<num;i++){
            Beer.add((zhajidian.Beer) drink);
            }

        }
        if (drink instanceof Juice) {
            for (int i = 0; i < num; i++) {
                Juice.add((zhajidian.Juice) drink);
            }
        }
        }
        else{
            throw new OverdraftBalanceException("穷逼，你还差"+(drink.cost*num-this.Account)+"钱");
        }
    }
}
