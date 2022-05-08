import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EndangeredAnimalTest {
    @Test
    public void EndangeredAnimal_instantiatesCorrectly_true() {
        new EndangeredAnimal("White rhino", "Young", "Ill");
        assertTrue(true);
    }
    @Test
    public void EndangeredAnimal_instantiatesWithName_String() {//passed
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("White rhino", "Young", "Ill");
        assertEquals("White rhino", testEndangeredAnimal.getName());
    }
    @Test
    public void EndangeredAnimal_instantiatesWithAge_String() {//passed
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("White rhino", "Young", "Ill");
        assertEquals("Young", testEndangeredAnimal.getAge());
    }
    @Test
    public void EndangeredAnimal_instantiatesWithHealth_String() {//passed
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("White rhino", "Young", "Ill");
        assertEquals("Ill", testEndangeredAnimal.getHealth());
    }
    @Test
    public void equals_returnsTrueIfNameIsSame_true() { //passed
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("White rhino", "Young", "Ill");
        EndangeredAnimal anotherEndangeredAnimal = new EndangeredAnimal("White rhino", "Young", "Ill");
        assertEquals(testEndangeredAnimal, anotherEndangeredAnimal);
    }
    @Test
    public void save_returnsTrueIfDescriptionsAretheSame() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("White rhino", "Young", "Ill");
        testEndangeredAnimal.save();
        assertEquals(EndangeredAnimal.all().get(0), testEndangeredAnimal);
    }
    @Test
    public void save_assignsIdToEndangeredAnimal() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("White rhino", "Young", "Ill");
        testEndangeredAnimal.save();
        EndangeredAnimal savedEndangeredAnimal = EndangeredAnimal.all().get(0);
        assertEquals(savedEndangeredAnimal.getId(), testEndangeredAnimal.getId());
    }
    @Test
    public void all_returnsAllInstancesOfEndangeredAnimal_true() {
        EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("White rhino", "Young", "Ill");
        firstEndangeredAnimal.save();
        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Black rhino", "Old", "Okay");
        secondEndangeredAnimal.save();
        assertEquals("White rhino", EndangeredAnimal.all().get(0));//Actual :EndangeredAnimal@78fbff54
        assertEquals("Black Rhino", EndangeredAnimal.all().get(1));
    }
    @Test
    public void find_returnsMonsterWithSameId_secondEndangeredAnimal() {
        EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("White rhino", "Young", "Ill");
        firstEndangeredAnimal.save();
        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Black rhino", "Old", "Okay");
        secondEndangeredAnimal.save();
        assertEquals(EndangeredAnimal.find(secondEndangeredAnimal.getId()), secondEndangeredAnimal);
    }
}