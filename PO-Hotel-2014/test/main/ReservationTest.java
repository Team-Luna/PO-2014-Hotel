/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author K O M P U T E R
 */
public class ReservationTest {
    
    public ReservationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getRoomList method, of class Reservation.
     */
    @Test
    public void testGetRoomList() {
        System.out.println("getRoomList");
        Reservation instance = new Reservation();
        Room[] expResult = null;
        Room[] result = instance.getRoomList();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRoomList method, of class Reservation.
     */
    @Test
    public void testSetRoomList() {
        System.out.println("setRoomList");
        Room[] roomList = null;
        Reservation instance = new Reservation();
        instance.setRoomList(roomList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerFirstName method, of class Reservation.
     */
    @Test
    public void testGetCustomerFirstName() {
        System.out.println("getCustomerFirstName");
        Reservation instance = new Reservation();
        String expResult = "";
        String result = instance.getCustomerFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomerFirstName method, of class Reservation.
     */
    @Test
    public void testSetCustomerFirstName() {
        System.out.println("setCustomerFirstName");
        String customerFirstName = "";
        Reservation instance = new Reservation();
        instance.setCustomerFirstName(customerFirstName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerSurName method, of class Reservation.
     */
    @Test
    public void testGetCustomerSurName() {
        System.out.println("getCustomerSurName");
        Reservation instance = new Reservation();
        String expResult = "";
        String result = instance.getCustomerSurName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomerSurName method, of class Reservation.
     */
    @Test
    public void testSetCustomerSurName() {
        System.out.println("setCustomerSurName");
        String customerSurName = "";
        Reservation instance = new Reservation();
        instance.setCustomerSurName(customerSurName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerEmail method, of class Reservation.
     */
    @Test
    public void testGetCustomerEmail() {
        System.out.println("getCustomerEmail");
        Reservation instance = new Reservation();
        String expResult = "";
        String result = instance.getCustomerEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomerEmail method, of class Reservation.
     */
    @Test
    public void testSetCustomerEmail() {
        System.out.println("setCustomerEmail");
        String customerEmail = "";
        Reservation instance = new Reservation();
        instance.setCustomerEmail(customerEmail);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerAddress method, of class Reservation.
     */
    @Test
    public void testGetCustomerAddress() {
        System.out.println("getCustomerAddress");
        Reservation instance = new Reservation();
        String expResult = "";
        String result = instance.getCustomerAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomerAddress method, of class Reservation.
     */
    @Test
    public void testSetCustomerAddress() {
        System.out.println("setCustomerAddress");
        String customerAddress = "";
        Reservation instance = new Reservation();
        instance.setCustomerAddress(customerAddress);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStartingDate method, of class Reservation.
     */
    @Test
    public void testGetStartingDate() {
        System.out.println("getStartingDate");
        Reservation instance = new Reservation();
        Date expResult = null;
        Date result = instance.getStartingDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStartingDate method, of class Reservation.
     */
    @Test
    public void testSetStartingDate() {
        System.out.println("setStartingDate");
        Date startingDate = null;
        Reservation instance = new Reservation();
        instance.setStartingDate(startingDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEndDate method, of class Reservation.
     */
    @Test
    public void testGetEndDate() {
        System.out.println("getEndDate");
        Reservation instance = new Reservation();
        Date expResult = null;
        Date result = instance.getEndDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEndDate method, of class Reservation.
     */
    @Test
    public void testSetEndDate() {
        System.out.println("setEndDate");
        Date endDate = null;
        Reservation instance = new Reservation();
        instance.setEndDate(endDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
