package zhajidian;


public class test {
    public static void main(String[] args) {
        West2FriedChickenRestauran LZZ = new West2FriedChickenRestauran();
        LZZ.Account=0;
        LZZ.buy(West2FriedChickenRestauran.gx,2);
        LZZ.buy(West2FriedChickenRestauran.hh,4);
        LZZ.buy(West2FriedChickenRestauran.hz,4);
        LZZ.sell(2,1);
        LZZ.buy(West2FriedChickenRestauran.gx,1);
        for(int i = 0 ; i<West2FriedChickenRestauran.Beer.size();i++){
            System.out.println(West2FriedChickenRestauran.Beer.get(i));
        }
        LZZ.sell(1,3);
        for(int i = 0 ; i<West2FriedChickenRestauran.Juice.size();i++){
            System.out.println(West2FriedChickenRestauran.Juice.get(i));
        }

    }



}
