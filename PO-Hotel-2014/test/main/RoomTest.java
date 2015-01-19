/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Calendar;
import java.util.GregorianCalendar;
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
public class RoomTest {

    public RoomTest() {
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
     * Test of getFloor method, of class Room.
     */
    @Test
    public void testGetFloor() {
        System.out.println("getFloor");
        Room instance = new Room();
        int expResult = -1;
        int result = instance.getFloor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFloor method, of class Room.
     */
    @Test
    public void testSetFloor() {
        System.out.println("setFloor");
        int floor = 0;
        Room instance = new Room();
        instance.setFloor(floor);
        assertEquals(instance.getFloor(), floor);
    }

    /**
     * Test of getID method, of class Room.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Room instance = new Room();
        int expResult = -1;
        int result = instance.getID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setID method, of class Room.
     */
    @Test
    public void testSetID() {
        System.out.println("setID");
        int ID = 0;
        Room instance = new Room();
        instance.setID(ID);
        assertEquals(instance.getID(), ID);
    }

    /**
     * Test of getBeds method, of class Room.
     */
    @Test
    public void testGetBeds() {
        System.out.println("getBeds");
        Room instance = new Room();
        int[] expResult = null;
        int[] result = instance.getBeds();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of setBeds method, of class Room.
     */
    @Test
    public void testSetBeds() {
        System.out.println("setBeds");
        int[] beds = null;
        Room instance = new Room();
        instance.setBeds(beds);
    }

    /**
     * Test of getRoomID method, of class Room.
     */
    @Test
    public void testGetRoomID() {
        System.out.println("getRoomID");
        Room instance = new Room();
        String expResult = "";
        String result = instance.getRoomID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRoomID method, of class Room.
     */
    @Test
    public void testSetRoomID() {
        System.out.println("setRoomID");
        String roomID = "";
        Room instance = new Room();
        instance.setRoomID(roomID);
    }

    @Test
    public void testRoom2() {
        Hotel hotel = new Hotel("src/user.xml");
        Room room = hotel.room("2");

        assertNotNull(room);
        assertEquals(80,
                room.price(
                        new GregorianCalendar(2015, Calendar.JANUARY, 15)
                )
        );
        assertEquals(100,
                room.price(
                        new GregorianCalendar(2014, Calendar.DECEMBER, 26)
                )
        );
        assertEquals(90,
                room.price(
                        new GregorianCalendar(2014, Calendar.DECEMBER, 28)
                )
        );

    }

    @Test
    public void testRoom5() {
        Hotel hotel = new Hotel("src/user.xml");
        Room room = hotel.room("5");

        assertEquals(220,
                room.price(
                        new GregorianCalendar(2014, Calendar.DECEMBER, 26)
                )
        );

        assertEquals(300,
                room.price(
                        new GregorianCalendar(2014, Calendar.DECEMBER, 27)
                )
        );

        assertEquals(200,
                room.price(
                        new GregorianCalendar(2014, Calendar.DECEMBER, 28)
                )
        );

        assertEquals(160,
                room.price(
                        new GregorianCalendar(2015, Calendar.JANUARY, 7)
                )
        );

    }

}
