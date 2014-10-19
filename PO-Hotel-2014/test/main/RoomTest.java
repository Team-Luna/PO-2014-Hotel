/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

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
        int expResult = 0;
        int result = instance.getFloor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getID method, of class Room.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Room instance = new Room();
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBeds method, of class Room.
     */
    @Test
    public void testGetBeds() {
        System.out.println("getBeds");
        Room instance = new Room();
        short[][] expResult = null;
        short[][] result = instance.getBeds();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBeds method, of class Room.
     */
    @Test
    public void testSetBeds() {
        System.out.println("setBeds");
        short[][] beds = null;
        Room instance = new Room();
        instance.setBeds(beds);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
