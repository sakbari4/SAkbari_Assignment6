package Assignment6;
import java.util.ArrayList;
import java.util.List;

public class Order implements OrderInterface, Comparable<Order> { 
    private int orderNum;
    private String orderTime;
    private Day orderDay;
    private Customer customer;
    private List<Beverage> beverages;

    public Order(Customer customer, Day orderDay, String orderTime) {
        this.customer = customer;
        this.orderDay = orderDay;
        this.orderTime = orderTime;
        this.beverages = new ArrayList<>();
        this.orderNum = randomNumberGenerator();
    }

    public Order(String orderTime, Day orderDay, Customer customer) {
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(customer);
        this.beverages = new ArrayList<>();
        this.orderNum = randomNumberGenerator();
    }

    public int randomNumberGenerator() {
        return (int) (Math.random() * (90000 - 10000) + 10000);
    }

    public void addNewBeverage(Beverage bev) {
        beverages.add(bev);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Number: ").append(orderNum)
          .append(", Time: ").append(orderTime)
          .append(", Day: ").append(orderDay)
          .append(", Customer: ").append(customer.toString())
          .append("\nBeverages:\n");
        for (Beverage beverage : beverages) {
            sb.append(beverage.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.orderNum, other.orderNum);
    }

    @Override
    public boolean isWeekend() {
        return this.orderDay == Day.SATURDAY || this.orderDay == Day.SUNDAY;
    }

    @Override
    public Beverage getBeverage(int itemNo) {
        if (itemNo >= 0 && itemNo < beverages.size()) {
            return beverages.get(itemNo);
        }
        return null;
    }

    @Override
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        Coffee coffee = new Coffee(bevName, size, extraShot, extraSyrup);
        beverages.add(coffee);
    }

    @Override
    public void addNewBeverage(String bevName, Size size) {
        Alcohol alcohol = new Alcohol(bevName, size, isWeekend());
        beverages.add(alcohol);
    }

    @Override
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        Smoothie smoothie = new Smoothie(bevName, size, numOfFruits, addProtein);
        beverages.add(smoothie);
    }

    @Override
    public double calcOrderTotal() {
        double total = 0;
        for (Beverage beverage : beverages) {
            total += beverage.calcPrice();
        }
        return total;
    }

    @Override
    public int findNumOfBeveType(Type type) {
        int count = 0;
        for (Beverage beverage : beverages) {
            if (beverage.getType() == type) {
                count++;
            }
        }
        return count;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getOrderNo() {
        return orderNum;
    }

    public double calculateTotalPrice() {
        double total = 0.0;
        for (Beverage bev : beverages) {
            total += bev.calcPrice();
        }
        return total;
    }

    public List<Beverage> getBeverages() {
        return beverages;
    }
}
