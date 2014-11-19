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
     * Test of findFreeRooms method, of class Hotel. With no free rooms.
     */
    @Test
    public void testFindNoRooms() {
        System.out.println("testFindNoRooms");
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.set(1980, 10, 10);//0-based month
        end.set(1980, 10, 12);//0-based month
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
    public void testFindSingleDoubleRoom() {
        System.out.println("testFindSingleDoubleRoom");
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.set(2016, 10, 10);//0-based month
        end.set(2016, 10, 12);//0-based month
        int nPersons = 2;
        
        Hotel instance = new Hotel("src/testSingleRoom.xml");
        List<QueryResult> expResult = new ArrayList<>();
        List<Room> room = new ArrayList<>();
        room.add(new Room(1, 0, "R01", new int[]{1,1}));
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
        System.out.println("testFindCheapestRoom");
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.set(2016, 10, 10);//0-based month
        end.set(2016, 10, 12);//0-based month
        int nPersons = 3;
        
        Hotel instance = new Hotel(true);
        
        List<QueryResult> expResult = new ArrayList<>();
        List<Room> room = new ArrayList<>();
        room.add(new Room(4, 0, "R04", new int[]{2,2}));
        QueryResult expQuery = new QueryResult(room, 300*2);
        expResult.add(expQuery);
        
        List<Room> room1 = new ArrayList<>();
        room1.add(new Room(2, 0, "R02", new int[]{2}));
        room1.add(new Room(1, 0, "R01", new int[]{1}));
        QueryResult expQuery2 = new QueryResult(room1, 180*2+120*2);
        expResult.add(expQuery2);
        
        List<QueryResult> result = instance.findFreeRooms(start, end, nPersons);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of findFreeRooms method, of class Hotel. With finding a cheapest room in season.
     */
    @Test
    public void testFindCheapestRoomInSeason() {
        System.out.println("testFindCheapestRoomInSeason");
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.set(2016, 7, 10);//0-based month
        end.set(2016, 7, 12);//0-based month
        int nPersons = 3;
        
        Hotel instance = new Hotel(true);
        
        List<QueryResult> expResult = new ArrayList<>();
        List<Room> room = new ArrayList<>();
        room.add(new Room(4, 0, "R04", new int[]{2,2}));
        QueryResult expQuery = new QueryResult(room, (int) (320*2));
        expResult.add(expQuery);
        
        List<QueryResult> result = instance.findFreeRooms(start, end, nPersons);
        assertEquals(expResult, result);
    }

    /**
     * Test of daysBetween method, of class Hotel.
     */
    @Test
    public void testDaysBetween() {
        System.out.println("daysBetween");
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        long expResult = 0L;
        long result = Hotel.daysBetween(startDate, endDate);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of daysBetween method, of class Hotel.
     */
    @Test
    public void testReserve() {
        System.out.println("reserve");
        
        Person person = new Person();
        Calendar start = Calendar.getInstance(), end = Calendar.getInstance();
        end.add(Calendar.DAY_OF_MONTH, 1);
        QueryResult qres = new QueryResult();
        
        
        Hotel instance = new Hotel();
        instance.reserve(start, end, qres, person);
        
        Reservation expected = new Reservation(start, end, qres, person);
        
        assertEquals(expected, instance.getReservationForPerson(person));
    }
    
    /**
     * Test of findFreeRooms method, of class Hotel. With finding a cheapest room in season with existing overlaping reservation.
     */
    @Test
    public void testFindCheapestRoomInSeasonWithReservation() {
        System.out.println("testFindCheapestRoomInSeasonWithReservation");
        
        Person person = new Person();
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.set(2016, 7, 10);//0-based month
        end.set(2016, 7, 12);//0-based month
        
        Calendar resStart = Calendar.getInstance();
        Calendar resEnd = Calendar.getInstance();
        resStart.set(2016, 7, 7);//0-based month
        resEnd.set(2016, 7, 11);//0-based month
        
        int nPersons = 3;
        
        Hotel instance = new Hotel(true);
        
        List<Room> room = new ArrayList<>();
        room.add(new Room(4, 0, "R04", new int[]{2,2}));
        QueryResult resQuery = new QueryResult(room, (int) (300*2*1.5));
        instance.reserve(resStart, resEnd, resQuery, person);
        
        List<QueryResult> expResult = new ArrayList<>();
        List<Room> room1 = new ArrayList<>();
        room1.add(new Room(2, 0, "R02", new int[]{2}));
        room1.add(new Room(1, 0, "R01", new int[]{1}));
        QueryResult expQuery = new QueryResult(room1, (int) (180*2+200*2));
        expResult.add(expQuery);
        
        List<QueryResult> result = instance.findFreeRooms(start, end, nPersons);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFindCheapestRoomSmallRoomVariant() {
        System.out.println("testFindCheapestRoomSmallRoomVariant");
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.set(2016, 10, 10);//0-based month
        end.set(2016, 10, 12);//0-based month
        int nPersons = 3;
        
        Hotel instance = new Hotel("src/testSmallRooms.xml");
        List<QueryResult> expResult = new ArrayList<>();
        List<Room> room = new ArrayList<>();
        room.add(new Room(3, 0, "R03", new int[]{1}));
        room.add(new Room(4, 0, "R04", new int[]{1}));
        room.add(new Room(5, 0, "R05", new int[]{1}));
        QueryResult expQuery = new QueryResult(room, 50*2*3);
        expResult.add(expQuery);
        
        List<QueryResult> result = instance.findFreeRooms(start, end, nPersons);
        assertEquals(expResult, result);
    }
}
