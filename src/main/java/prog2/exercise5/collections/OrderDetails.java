package prog2.exercise5.collections;
import java.time.LocalDate;
import java.util.*;
public class OrderDetails {
    private String orderID;//订单的ID
    private double orderTransactionAmount;//一个订单里购买或租的书的钱
    private LocalDate orderDate;//订单的日期
    private ArrayList<String> orderedBook = new ArrayList<>();//订单的信息
    private ArrayList<String> orderType = new ArrayList<>();//订单的类型

    public OrderDetails(String orderID, LocalDate orderDate) {
        this.orderID = orderID;
        this.orderDate = orderDate;
    }
    
    public String getOrderID() {
        return orderID;
    }
    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
    public double getOrderTransactionAmount() {
        return orderTransactionAmount;
    }
    public void setOrderTransactionAmount(double orderTransactionAmount) {
        this.orderTransactionAmount = orderTransactionAmount;
    }
    public LocalDate getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
    public ArrayList<String> getOrderedBook() {
        return orderedBook;
    }
    public void setOrderedBook(String book) {
        orderedBook.add(book);
    }
    public ArrayList<String> getOrderType() {
        return orderType;
    }
    public void setOrderType(String orderType) {
        this.orderType.add(orderType);
    }
    @Override
    public String toString() {
        return "The order details:"+"\n"+
        "Order ID:"+ orderID+"\n"+  
        "Ordered Book:" + orderedBook + "\n"+
        "Order Date:" + orderDate + "\n"+
        "Order Transaction Amount:" + orderTransactionAmount; 
    }
}
