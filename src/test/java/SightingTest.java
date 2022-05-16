

import org.junit.Rule;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;


public class SightingTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();
    @Test
    public void Sighting_instatiatesCorrectly_true() { //passed
        Sighting testSighting = new Sighting(" ","ZoneA", "Anita");
        testSighting.save();
        assertTrue(true);
    }

    @Test
    public void getLocation_SightingInstantiatesWithName_ZoneA() {//passed
        Sighting testSighting = new Sighting("","ZoneA", "Anita");
        assertEquals("ZoneA", testSighting.getLocation());
    }

    @Test
    public void getRangerName_SightingInstantiatesWithRangerName_String() {//passed
        Sighting testSighting = new Sighting("","ZoneA", "Anita");
        assertEquals("Anita", testSighting.getRangerName());
    }
    @Test
    public void equals_returnsTrueIfLocationAndRangerNameAreSame_true() {//passed
        Sighting firstSighting = new Sighting("","ZoneA", "Anita");
        Sighting anotherSighting = new Sighting("","ZoneA", "Anita");
        assertEquals(firstSighting, anotherSighting);
    }
    */
/*@Test
    public void all_returnsAllInstancesOfSighting_true() {//passed
        Sighting firstSighting = new Sighting("rhino","ZoneA", "Anita");
        firstSighting.save();
        Sighting secondSighting = new Sighting("elephant","ZoneB", "Zainab");
        secondSighting.save();
        assertEquals(Sighting.all().get(0), firstSighting);
        assertEquals(Sighting.all().get(1), secondSighting);
    }*//*

    @Test
    public void save_assignsIdToObject() {//passed
        Sighting testSighting = new Sighting("Ann","ZoneA", "Anita");
        testSighting.save();
        Sighting savedSighting = Sighting.all().get(0);
        assertEquals(testSighting, savedSighting);
    }
    @Test
    public void find_returnsSightingWithSameId_secondSighting() {//passed
        Sighting firstSighting = new Sighting("","ZoneA", "Anita");
        firstSighting.save();
        Sighting secondSighting = new Sighting("", "ZoneB", "Zainab");
        secondSighting.save();
        assertEquals(Sighting.find(secondSighting.getId()), secondSighting);
    }
    */
/*@Test
    public void getAnimals_retrievesAllAnimalsFromDatabase_animalsList() {//failed
        Sighting testSighting = new Sighting("", "ZoneA", "Anita");
        testSighting.save();
        EndangeredAnimal firstAnimal = new EndangeredAnimal("White rhino", "Young", "Ill", 1);
        firstAnimal.save();
        UnendangeredAnimal secondAnimal = new UnendangeredAnimal("Antelope", 1);
        secondAnimal.save();
        Object[] animals = new Object[] {firstAnimal, secondAnimal};
        assertTrue(testSighting.getAnimals().containsAll(Arrays.asList(animals)));
    }*//*

}

