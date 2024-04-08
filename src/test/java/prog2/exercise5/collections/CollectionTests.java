package prog2.exercise5.collections;

import org.junit.BeforeClass;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CollectionTests {

    static OrderProcessing orderProcessing;
    static String selectedFirstName;
    static String selectedLastName;
    static String userID;
    static String orderID;
    static User user;
    static OrderDetails orderDetails;
    static String selectedBookID;
    static String bookOrdered;
    static String selectedOrderType;
    

    @BeforeClass
    public static void setUpClass() {
        
        
        orderProcessing = new OrderProcessing();

        String [] firstName = {"Natalie", "Mitchell", "Bruce", "Katie"};
        String [] lastName = {"Moore", "Johnson", "Willis", "Hopkins"};

        Random random = new Random();
        int firstNameIndex = random.nextInt(firstName.length);
        int lastNameIndex = random.nextInt(lastName.length);

        selectedFirstName = firstName[firstNameIndex];
        selectedLastName = lastName[lastNameIndex];

        userID = orderProcessing.generateUserID(selectedFirstName, selectedLastName);

        orderID = orderProcessing.generateOrderID(userID);

        user = new User(selectedFirstName, selectedLastName, "randomemail@random.com", userID);
        orderDetails = new OrderDetails(orderID, LocalDate.now());

        String[] bookIDs = {"001", "002", "003", "004", "005"};
        int bookIDIndex = random.nextInt(bookIDs.length);
        selectedBookID = bookIDs[bookIDIndex];

        for(Books book: Books.values()){
            if(selectedBookID.equals(book.getBookID())){

                bookOrdered = "Book ID: " + book.getBookID() + "\n" + " Book Name: " + 
                    "\n" + book.getBookName() + " Book Author: " + book.getBookAuthor() + 
                    "\n" + " Book Publisher: " + book.getBookPublisher() + "\n" + " Book Price: " + book.getBookPrice();

                String[] orderTypes = {"Purchase", "Rent"};
                int orderTypeIndex = random.nextInt(orderTypes.length);
                selectedOrderType = orderTypes[orderTypeIndex];

                orderDetails.setOrderTransactionAmount(book.getBookPrice());
                orderDetails.setOrderedBook(bookOrdered);
                orderDetails.setOrderType(selectedOrderType);
                orderProcessing.userOrders.put(user, orderDetails);

            }
        }

    }

    @Test
    public void testOrderProcessing() {

        String hashMapValueOutput = orderProcessing.userOrders.values().toString();
        String hashMapKeyOutput = orderProcessing.userOrders.keySet().toString();

        assertEquals("User ID must be available.", userID, user.getUserID());
        assertEquals("Order ID must be available.", orderID, orderDetails.getOrderID());
        
        assertTrue("HashMap value must contain an order ID", hashMapValueOutput.contains(orderID));
        assertTrue("HashMap key must contain an user ID", hashMapKeyOutput.contains(userID));
        assertEquals("HashMap must have one entry", false, orderProcessing.userOrders.isEmpty());
        
    }

    @Test
    public void testSearchingUserOrders(){

        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        orderProcessing.searchUserOrders(userID);

        String expectedOutput = orderProcessing.userOrders.values().toString();
        expectedOutput = expectedOutput.replace("[", "").replace("]", "");

        String actualOutput = outContent.toString().trim();
        actualOutput = actualOutput.replace("[", "").replace("]", "");

        assertEquals(expectedOutput, actualOutput);

        System.setOut(System.out);

    }

    @Test
    public void testDisplayingAllUserOrders(){

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        orderProcessing.displayAllUserOrders();

        String actualOutput = outContent.toString();
        
        assertTrue(actualOutput.contains(userID));
        assertTrue(actualOutput.contains(user.getFirstName()));
        assertTrue(actualOutput.contains(user.getLastName()));
        assertTrue(actualOutput.contains(orderID));
        assertTrue(actualOutput.contains(orderDetails.getOrderedBook().toString()));

        System.setOut(System.out);

    }

    @Test
    public void testRemovingOrders(){
        orderProcessing.removeUserOrders(userID);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        orderProcessing.searchUserOrders(userID);

        String expectedOutput = orderProcessing.userOrders.values().toString();
        expectedOutput = expectedOutput.replace("[", "").replace("]", "");

        String actualOutput = outContent.toString().trim();
        actualOutput = actualOutput.replace("[", "").replace("]", "");

        //assertEquals(expectedOutput, actualOutput);

        assertEquals("HashMap must be empty", true, orderProcessing.userOrders.isEmpty());
        System.setOut(System.out);

    } 
}