
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

public class UnendangeredAnimalTest extends DatabaseRule{
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    public DatabaseRule database = new DatabaseRule();
    @Test
    public void UnendangeredAnimal_instantiatesCorrectly_true() {//passed
        new UnendangeredAnimal("Antelope", 1);
        assertTrue(true);
    }
    @Test
    public void UnendangeredAnimal_instantiatesWithName_String() {//passed
        UnendangeredAnimal testUnendangeredAnimal = new UnendangeredAnimal("Antelope", 1);
        assertEquals("Antelope", testUnendangeredAnimal.getName());
    }

    @Test
    public void equals_returnsTrueIfNameIsSame_true() { //passed
        UnendangeredAnimal testUnendangeredAnimal = new UnendangeredAnimal("Antelope", 1);
        UnendangeredAnimal anotherUnendangeredAnimal = new UnendangeredAnimal("Antelope", 1);
        assertEquals(testUnendangeredAnimal, anotherUnendangeredAnimal);
    }
    @Test
    public void save_returnsTrueIfDescriptionsAretheSame() {
        UnendangeredAnimal testUnendangeredAnimal = new UnendangeredAnimal("Antelope", 1);
        testUnendangeredAnimal.save();
        assertEquals(UnendangeredAnimal.all().get(0), testUnendangeredAnimal);
    }
    @Test
    public void save_assignsIdToUnendangeredAnimal() {
        UnendangeredAnimal testUnendangeredAnimal = new UnendangeredAnimal("Antelope", 1);
        testUnendangeredAnimal.save();
        UnendangeredAnimal savedUnendangeredAnimal = UnendangeredAnimal.all().get(0);
        assertEquals(savedUnendangeredAnimal.getId(), testUnendangeredAnimal.getId());
    }
    @Test
    public void all_returnsAllInstancesOfUnendangeredAnimal_true() {
        UnendangeredAnimal firstUnendangeredAnimal = new UnendangeredAnimal("Antelope", 1);
        firstUnendangeredAnimal.save();
        UnendangeredAnimal secondUnendangeredAnimal = new UnendangeredAnimal("Giraffe", 1);
        secondUnendangeredAnimal.save();
        assertEquals("Antelope", UnendangeredAnimal.all().get(0));
        assertEquals("Giraffe", UnendangeredAnimal.all().get(1));
    }
    @Test
    public void find_returnsAnimalWithSameId_secondUnendangeredAnimal() {//passed
        UnendangeredAnimal firstUnendangeredAnimal = new UnendangeredAnimal("Antelope", 1);
        firstUnendangeredAnimal.save();
        UnendangeredAnimal secondUnendangeredAnimal = new UnendangeredAnimal("Giraffe", 1);
        secondUnendangeredAnimal.save();
        assertEquals(UnendangeredAnimal.find(secondUnendangeredAnimal.getId()), secondUnendangeredAnimal);
    }
}