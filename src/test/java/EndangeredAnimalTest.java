import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

public class EndangeredAnimalTest extends DatabaseRule{
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    public DatabaseRule database = new DatabaseRule();
    @Test
    public void EndangeredAnimal_instantiatesCorrectly_true() {
        new EndangeredAnimal("White rhino", "Young", "Ill", 1);
        assertTrue(true);
    }
    @Test
    public void EndangeredAnimal_instantiatesWithName_String() {//passed
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("White rhino", "Young", "Ill", 1);
        assertEquals("White rhino", testEndangeredAnimal.getName());
    }
    @Test
    public void EndangeredAnimal_instantiatesWithAge_String() {//passed
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("White rhino", "Young", "Ill", 1);
        assertEquals("Young", testEndangeredAnimal.getAge());
    }
    @Test
    public void EndangeredAnimal_instantiatesWithHealth_String() {//passed
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("White rhino", "Young", "Ill", 1);
        assertEquals("Ill", testEndangeredAnimal.getHealth());
    }
    @Test
    public void equals_returnsTrueIfNameIsSame_true() { //passed
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("White rhino", "Young", "Ill", 1);
        EndangeredAnimal anotherEndangeredAnimal = new EndangeredAnimal("White rhino", "Young", "Ill", 1);
        assertEquals(testEndangeredAnimal, anotherEndangeredAnimal);
    }
    @Test
    public void save_returnsTrueIfDescriptionsAretheSame() {//failed
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("White rhino", "Young", "Ill", 1);
        testEndangeredAnimal.save();
        assertEquals(EndangeredAnimal.all().get(0).getId(), testEndangeredAnimal.getId());
    }
    @Test
    public void save_assignsIdToEndangeredAnimal() {//failed
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("White rhino", "Young", "Ill", 1);
        testEndangeredAnimal.save();
        EndangeredAnimal savedEndangeredAnimal = EndangeredAnimal.all().get(0);
        assertEquals(testEndangeredAnimal.getId(), savedEndangeredAnimal.getId());
    }
    @Test
    public void all_returnsAllInstancesOfEndangeredAnimal_true() {//failed
        EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("White rhino", "Young", "Ill", 1);
        firstEndangeredAnimal.save();
        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Black rhino", "Old", "Okay", 1);
        secondEndangeredAnimal.save();
        /*assertEquals("White rhino", EndangeredAnimal.all().get(0));//Actual :EndangeredAnimal@78fbff54
        assertEquals("Black Rhino", EndangeredAnimal.all().get(1));*/
        assertEquals(EndangeredAnimal.all().get(0), firstEndangeredAnimal);
        assertEquals(EndangeredAnimal.all().get(1), secondEndangeredAnimal);
    }
    @Test
    public void find_returnsAnimalWithSameId_secondEndangeredAnimal() {
        EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("White rhino", "Young", "Ill", 1);
        firstEndangeredAnimal.save();
        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Black rhino", "Old", "Okay", 1);
        secondEndangeredAnimal.save();
        assertEquals(EndangeredAnimal.find(secondEndangeredAnimal.getId()), secondEndangeredAnimal);
    }
}