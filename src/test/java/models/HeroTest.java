package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void NewHeroObjectGetsCorrectlyCreated_true() throws Exception {
        Hero hero = new Hero("name", 30, "flying", "water");
        assertEquals(true, hero instanceof Hero);
    }

    @Test
    public void heroInstantiatesWithname_true() throws Exception {
        Hero hero = new Hero("name", 30, "flying", "water");
        assertEquals("name", hero.getName());
        assertEquals(30, hero.getAge());
        assertEquals("flying", hero.getStrength());
        assertEquals("water", hero.getWeakness());

    }

    @Test
    public void allHeroesAreCorrectlyReturned_2() {
        Hero hero = new Hero("name", 30, "flying", "water");
        Hero otherHero = new Hero("name", 40, "vision", "fire");

        assertEquals(2, Hero.getAll().size());
    }

}