package zhajidian;

import java.time.LocalDate;

class Beer extends Drinks {
    Beer(String name, double cost, LocalDate productiondate) {
        super(name, cost, productiondate, 30);
    }
    protected float Degree;
}