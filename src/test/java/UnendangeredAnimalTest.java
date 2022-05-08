
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UnendangeredAnimalTest {
    @Test
    public void UnendangeredAnimal_instantiatesCorrectly_true() {//passed
        new UnendangeredAnimal("Antelope");
        assertTrue(true);
    }
    @Test
    public void UnendangeredAnimal_instantiatesWithName_String() {//passed
        UnendangeredAnimal testUnendangeredAnimal = new UnendangeredAnimal("Antelope");
        assertEquals("Antelope", testUnendangeredAnimal.getName());
    }

    @Test
    public void equals_returnsTrueIfNameIsSame_true() { //passed
        UnendangeredAnimal testUnendangeredAnimal = new UnendangeredAnimal("Antelope");
        UnendangeredAnimal anotherUnendangeredAnimal = new UnendangeredAnimal("Antelope");
        assertEquals(testUnendangeredAnimal, anotherUnendangeredAnimal);
    }
    @Test
    public void save_returnsTrueIfDescriptionsAretheSame() {
        UnendangeredAnimal testUnendangeredAnimal = new UnendangeredAnimal("Antelope");
        testUnendangeredAnimal.save();
        assertEquals(UnendangeredAnimal.all().get(0), testUnendangeredAnimal);
    }
    @Test
    public void save_assignsIdToUnendangeredAnimal() {
        UnendangeredAnimal testUnendangeredAnimal = new UnendangeredAnimal("Antelope");
        testUnendangeredAnimal.save();
        UnendangeredAnimal savedUnendangeredAnimal = UnendangeredAnimal.all().get(0);
        assertEquals(savedUnendangeredAnimal.getId(), testUnendangeredAnimal.getId());
    }
    @Test
    public void all_returnsAllInstancesOfUnendangeredAnimal_true() {
        UnendangeredAnimal firstUnendangeredAnimal = new UnendangeredAnimal("Antelope");
        firstUnendangeredAnimal.save();
        UnendangeredAnimal secondUnendangeredAnimal = new UnendangeredAnimal("Giraffe");
        secondUnendangeredAnimal.save();
        assertEquals("Antelope", UnendangeredAnimal.all().get(0));
        assertEquals("Giraffe", UnendangeredAnimal.all().get(1));
    }
    @Test
    public void find_returnsAnimalWithSameId_secondUnendangeredAnimal() {//passed
        UnendangeredAnimal firstUnendangeredAnimal = new UnendangeredAnimal("Antelope");
        firstUnendangeredAnimal.save();
        UnendangeredAnimal secondUnendangeredAnimal = new UnendangeredAnimal("Giraffe");
        secondUnendangeredAnimal.save();
        assertEquals(UnendangeredAnimal.find(secondUnendangeredAnimal.getId()), secondUnendangeredAnimal);
    }
}