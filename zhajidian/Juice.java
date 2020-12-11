package zhajidian;

import java.time.LocalDate;

class Juice extends Drinks {
    Juice(String name, double cost, LocalDate productiondate) {
        super(name, cost, productiondate, 2);
    }


}