package prog2.exercise5.collections;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class OrderProcessing {
    private double transactionAmount;
    private String orderType;
    private String bookOrdered;
    ArrayList<OrderDetails> orders = new ArrayList<>();
   
    public double getTransactionAmount() {
        return transactionAmount;
    }
    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
    public String getOrderType() {
        return orderType;
    }
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
    public String getBookOrdered() {
        return bookOrdered;
    }
    public void setBookOrdered(String bookOrdered) {
        this.bookOrdered = bookOrdered;
    }
    public ArrayList<OrderDetails> getOrders() {
        return orders;
    }
    public void setOrders(ArrayList<OrderDetails> orders) {
        this.orders = orders;
    }

    HashMap<User,OrderDetails> userOrders = new HashMap<>(200,0.75f);
    final int CAPACIITY = 200;
    public OrderDetails getUserOrders(User userID) {
        return userOrders.get(userID);
    }
    public void setUserOrders(User userID,OrderDetails orderDetails ) {
        userOrders.put(userID, orderDetails);
    }
    public int getCAPACIITY() {
        return CAPACIITY;
    }

    public OrderProcessing() {
        this.orders = new ArrayList<>();
        this.userOrders = new HashMap<>();
    }
    
   
    public void addOrder(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter your first name:");
        String firstName = reader.nextLine();
        System.out.println("Enter your last name:");
        String lastName = reader.nextLine();
        System.out.println("Enter your email address:");
        String userEmail = reader.nextLine();
        String userID = generateUserID(firstName,lastName);
        System.out.println("It's your user ID:"+userID);
        String orderID = generateOrderID(userID);
        System.out.println("It's your order ID:"+orderID);
        OrderDetails orderDetails = new OrderDetails(orderID,LocalDate.now());
        User user = new User (firstName,lastName,userEmail,userID);
        System.out.println("\nThe details of the book:");
        for(Books book : Books.values()){
            System.out.println("[Book ID:" + book.getBookID() + " ,Book name:" + book.getBookName()+" ,BookAuthor:" + book.getBookAuthor()+" ,BookPages:"+book.getBookPages()+" ,BookGenre:"+ book.getBookGenre()+" ,BookRating"+book.getBookRating()+" ,BookPublishedYear:"+book.getBookPublishedYear()+" ,BookPublisher:"+book.getBookPublisher()+ " ,BookPrice:"+book.getBookPrice()+"]");
        }
        boolean moreBooks = true;
    while(moreBooks){
        System.out.println("\nEnter the book ID that you want to order:");
        String wantID = reader.nextLine();
        for(Books book:Books.values()){
            if(wantID.equals(book.getBookID())){
                System.out.println("How you want to order it,for Purchase or Rent?");
                String orderType = reader.nextLine();
                bookOrdered = "Book ID: " + book.getBookID() +"\n" +"Book Name: " + book.getBookName() +"\n" +"Book Author: " + book.getBookAuthor() +"\n" +"Book Publisher: " + book.getBookPublisher() +"\n" +"Book Price: " + book.getBookPrice()+"\n";
                orderDetails.getOrderedBook().add(bookOrdered);//
                orderDetails.getOrderType().add(orderType);
                if(orderType.equalsIgnoreCase("Purchase")){
                    orderDetails.setOrderTransactionAmount(orderDetails.getOrderTransactionAmount()+book.getBookPrice());
                }else if(orderType.equalsIgnoreCase("Rent")){
                    orderDetails.setOrderTransactionAmount(orderDetails.getOrderTransactionAmount() + book.getBookRent());
                }
                userOrders.put(user,orderDetails);
                System.out.println("Do you want to order more books? (Yes/No)");
                String want = reader.nextLine();
                if (want.equalsIgnoreCase("No")) {
                    moreBooks =false;
                    break;
                }
            }
        }
        }
    }

    public String generateUserID(String firstName,String lastName){
        return "TANLUS" + (firstName + lastName).substring(0,5).toUpperCase();
    }
    public String generateOrderID(String userID){
        DateTimeFormatter time = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String currentDate = LocalDate.now().format(time);
        return "TANLOD" + currentDate + userID.substring(6,9).toUpperCase();
    }

    /*public String generateOrderID(String userID){
        Date current = new Date();
        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = time.format(current);
        return "TANLOD" + currentDate + userID.substring(6,8).toUpperCase();
    } */


    public void searchUserOrders(String userID){
        /* if(userOrders.isEmpty()){
            System.out.println("It's invilid.Please enter again.");
        }else{ */
        boolean Found = false;
        for(User key : userOrders.keySet()){
            if(key.getUserID().equals(userID)){
                System.out.println(userOrders.get(key));
                Found = true;
                break;
            }
        }
        if(!Found){
            System.out.println("It does not exist.");
        } 
    }
    public void removeUserOrders(String userID){
        boolean exist = false;
        for(Map.Entry<User,OrderDetails> entry : userOrders.entrySet()){
            if(entry.getKey().getUserID().equals(userID)){     //entry.getKey().getUserID().equals(userID)
                userOrders.remove(entry.getKey());
                exist = true;
                break;
            }
        }
        if(exist){
            System.out.println("Order details for user ID" + userID+ "removed successfully.");
        }else{
            System.out.println("The user ID is not exist.");
        }
        
    }

    public void displayAllUserOrders(){
        for(Map.Entry<User,OrderDetails> entry : userOrders.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("------------------------------------");
        }
    }
}



