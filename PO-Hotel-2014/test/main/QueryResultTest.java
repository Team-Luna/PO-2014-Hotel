/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author student
 */
public class QueryResultTest {
    
    public QueryResultTest() {
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
     * Test of rooms method, of class QueryResuts.
     */
    @Test
    public void testRooms() {
        System.out.println("rooms");
        QueryResult instance = new QueryResult();
        List<Room> expResult = null;
        List<Room> result = instance.rooms();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of price method, of class QueryResuts.
     */
    @Test
    public void testPrice() {
        System.out.println("price");
        QueryResult instance = new QueryResult();
        int expResult = 0;
        int result = instance.price();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
