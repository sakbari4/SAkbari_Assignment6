package Assignment6;
import java.util.ArrayList;
import java.util.List;

public class BevShop implements BevShopInterface {
    private int currentAlcDrinks;
    private List<Order> orders;

    private final int MIN_AGE_FOR_ALCOHOL = 21;
    private final int MAX_ORDER_FOR_ALCOHOL = 3;
    private final int MAX_FRUIT = 5;
    private final int MIN_TIME = 8;
    private final int MAX_TIME = 23;

    public BevShop() {
        this.currentAlcDrinks = 0;
        this.orders = new ArrayList<>();
    }

    @Override
    public boolean isValidTime(String time) {
        try {
            int timeInt = Integer.parseInt(time);
            return (timeInt >= MIN_TIME && timeInt <= MAX_TIME);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    @Override
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }

    @Override
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public boolean isEligibleForMore() {
        return currentAlcDrinks < MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public int getNumOfAlcoholDrink() {
        return currentAlcDrinks;
    }

    @Override
    public boolean isValidAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }

    public void startNewOrder(String time, Day day, String customerName, int customerAge) {
        if (!isValidTime(time)) {
            throw new IllegalArgumentException("Invalid order time.");
        }
        Order newOrder = new Order(time, day, new Customer(customerName, customerAge));
        orders.add(newOrder);
        currentAlcDrinks = 0;
    }

    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        Order currentOrder = getCurrentOrder();
        currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        Order currentOrder = getCurrentOrder();
        if (!isValidAge(currentOrder.getCustomer().getAge())) {
            throw new IllegalStateException("Customer is underage for alcohol.");
        }
        if (!isEligibleForMore()) {
            throw new IllegalStateException("Maximum alcohol drinks limit reached for this order.");
        }
        currentOrder.addNewBeverage(bevName, size);
        currentAlcDrinks++;
    }

    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        if (isMaxFruit(numOfFruits)) {
            throw new IllegalArgumentException("Number of fruits exceeds the maximum limit.");
        }
        Order currentOrder = getCurrentOrder();
        currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
    }

    @Override
    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNo() == orderNo) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        if (index == -1) {
            throw new IllegalArgumentException("Order not found.");
        }
        return orders.get(index).calcOrderTotal();
    }

    @Override
    public double totalMonthlySale() {
        double total = 0;
        for (Order order : orders) {
            total += order.calcOrderTotal();
        }
        return total;
    }

    @Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    @Override
    public Order getCurrentOrder() {
        if (orders.isEmpty()) {
            throw new IllegalStateException("No orders have been placed yet.");
        }
        return orders.get(orders.size() - 1);
    }

    @Override
    public Order getOrderAtIndex(int index) {
        if (index < 0 || index >= orders.size()) {
            throw new IndexOutOfBoundsException("Invalid order index.");
        }
        return orders.get(index);
    }

    @Override
    public void sortOrders() {
        orders.sort((o1, o2) -> o1.compareTo(o2));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Monthly Sale Report:\n");
        for (Order order : orders) {
            sb.append(order).append("\n");
        }
        sb.append("Total Monthly Sale: $").append(totalMonthlySale());
        return sb.toString();
    }

	@Override
	public boolean isValidTime(int time) {
		return (time >= MIN_TIME && time <= MAX_TIME);
	}

	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		if (!isValidTime(time)) {
	        throw new IllegalArgumentException("Invalid order time.");
	    }
	    
	    Order newOrder = new Order(String.valueOf(time), day, new Customer(customerName, customerAge));
	    orders.add(newOrder);
	    
	    currentAlcDrinks = 0;
	}
}


