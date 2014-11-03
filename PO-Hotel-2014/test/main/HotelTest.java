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
     * Test of findFreeRooms method, of class Hotel. With no free rooms.
     */
    @Test
    public void testFindNoRooms() {
        System.out.println("findFreeRooms");
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.set(1980, 10, 10);
        end.set(1980, 10, 12);
        int nPersons = 2;
        Hotel instance = new Hotel(0);
        List<QueryResult> expResult = new ArrayList<>();
        List<QueryResult> result = instance.findFreeRooms(start, end, nPersons);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of findFreeRooms method, of class Hotel. With a single free room.
     */
    @Test
    public void testFindDoubleRoom() {
        System.out.println("findFreeRooms");
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.set(2016, 10, 10);
        end.set(2016, 10, 12);
        int nPersons = 2;
        
        Hotel instance = new Hotel(1, new int[][]{new int[]{2}});
        List<QueryResult> expResult = new ArrayList<>();
        List<Room> room = new ArrayList<>();
        room.add(new Room(0, 0, "R0", new int[]{2}));
        QueryResult expQuery = new QueryResult(room, 180*2);
        expResult.add(expQuery);
        
        List<QueryResult> result = instance.findFreeRooms(start, end, nPersons);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of findFreeRooms method, of class Hotel. With finding a cheapest room.
     */
    @Test
    public void testFindCheapestRoom() {
        System.out.println("findFreeRooms");
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.set(2016, 10, 10);
        end.set(2016, 10, 12);
        int nPersons = 3;
        
        Hotel instance = new Hotel(4, new int[][]{new int[]{1},new int[]{2},new int[]{2},new int[]{2,2}});
        //TODO Costs && Expected Result
        List<QueryResult> expResult = new ArrayList<>();
        List<Room> room = new ArrayList<>();
        room.add(new Room(3, 0, "R3", new int[]{2,2}));
        QueryResult expQuery = new QueryResult(room, 300*2);
        expResult.add(expQuery);
        
        List<QueryResult> result = instance.findFreeRooms(start, end, nPersons);
        assertEquals(expResult, result);
    }

    /**
     * Test of findFreeRooms method, of class Hotel.
     */
    @Test
    public void testFindFreeRooms() {
        System.out.println("findFreeRooms");
        Calendar start = null;
        Calendar end = null;
        int nPersons = 0;
        Hotel instance = new Hotel();
        List<QueryResult> expResult = null;
        List<QueryResult> result = instance.findFreeRooms(start, end, nPersons);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of daysBetween method, of class Hotel.
     */
    @Test
    public void testDaysBetween() {
        System.out.println("daysBetween");
        Calendar startDate = null;
        Calendar endDate = null;
        long expResult = 0L;
        long result = Hotel.daysBetween(startDate, endDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of daysBetween method, of class Hotel.
     */
    @Test
    public void testReserve() {
        System.out.println("reserve");
        Hotel instance = new Hotel();
        instance.reserve(null, null, null, null);
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
