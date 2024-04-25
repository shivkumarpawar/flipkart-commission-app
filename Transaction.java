import java.util.*;

public class Transaction {
    private String transactionId;
    private List<Order> orders;
    private double totalAmountPaid;

    
    public Transaction(String transactionId, List<Order> orders, double totalAmountPaid) {
        this.transactionId = transactionId;
        this.orders = new ArrayList<>();
        this.totalAmountPaid = 0.0;
    }
    public String getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
    public List<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    public double getTotalAmountPaid() {
        return totalAmountPaid;
    }
    public void setTotalAmountPaid(double totalAmountPaid) {
        this.totalAmountPaid = totalAmountPaid;
    }
    
    public void addOrder(Order order, double commission){
        orders.add(order);
        totalAmountPaid = totalAmountPaid + commission;
    }
    public boolean isEmpty(){
        return orders.isEmpty();
    }
    public boolean containsOrder(Order order){
        return orders.contains(order);
    }
    public void removeOrder(Order order){
        orders.remove(order);
    }

}
