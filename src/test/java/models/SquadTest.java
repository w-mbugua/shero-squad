package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void NewSquadObjectGetsCorrectlyCreated_true() throws Exception{
        Squad squad = new Squad("title", 3, "cause");
        assertEquals(true, squad instanceof Squad);
    }

    @Test
    public void squadInstantiatesWithtitle_true() throws Exception {
        Squad squad = new Squad("title", 3, "cause");
        assertEquals("title", squad.getTitle());
        assertEquals(3, squad.getSize());
        assertEquals("cause", squad.getCause());

    }

    @Test
    public void allSquadsAreCorrectlyReturned_2() {
        Squad squad = new Squad("title1", 3, "cause1");
        Squad otherSquad = new Squad("title2", 3, "cause2");
        assertEquals(2, Squad.getAll().size());
    }
}