/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
public class HotelTest {
    
    public HotelTest() {
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
     * Test of main method, of class Hotel.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Hotel.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Hotel.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Room room = null;
        Hotel instance = new Hotel();
        instance.add(room);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of room method, of class Hotel.
     */
    @Test
    public void testRoom() {
        System.out.println("room");
        String room = "";
        Hotel instance = new Hotel();
        Room expResult = null;
        Room result = instance.room(room);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findFreeRooms method, of class Hotel.
     */
    @Test
    public void testFindNoRooms() {
        System.out.println("findFreeRooms");
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.set(1980, 10, 10);
        end.set(1980, 10, 12);
        int nPersons = 2;
        Hotel instance = new Hotel(2);
        List<QueryResult> expResult = new ArrayList<>();
        List<QueryResult> result = instance.findFreeRooms(start, end, nPersons);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of findFreeRooms method, of class Hotel.
     */
    @Test
    public void testFindDoubleRoom() {
        System.out.println("findFreeRooms");
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.set(2016, 10, 10);
        end.set(2016, 10, 12);
        int nPersons = 2;
        
        Hotel instance = new Hotel(2);
        List<QueryResult> expResult = new ArrayList<>();
        List<Room> room = new ArrayList<>();
        room.add(new Room(0, 1, "P0", new int[]{2}));
        QueryResult expQuery = new QueryResult(room, 180);
        expResult.add(expQuery);
        
        List<QueryResult> result = instance.findFreeRooms(start, end, nPersons);
        assertEquals(expResult, result);
    }
}
