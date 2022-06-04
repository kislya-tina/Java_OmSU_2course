package lambda;

import org.testng.annotations.Test;
import people.*;

import static lambda.LambdaDemo.*;
import static lambda.LambdaRunner.run;
import static org.testng.Assert.*;
import static people.Gender.*;

public class LambdaTest {
    Student student = new Student("Abc", "Abc", "Abc", 18, MALE, "OmSU", "FMIT", "Progs");
    Student student1 = new Student("Bcd", "Bcd", "Bcd", 18, MALE, "OmSU", "FMIT", "Progs");
    Student student2 = new Student("Cde", "Cde", "Cde", 18, MALE, "OmSU", "FMIT", "Progs");
    Student student3 = new Student("Abc", "Def", "Def", 18, MALE, "OmSU", "FMIT", "Maths");
    Human human = new Human("Efg", "Efg", "Efg", 19, FEMALE);

    @Test
    public void shouldAnswerWithTrue() {
        assertEquals(6, stringLen.applyAsInt("qwerty"));
    }

    @Test
    public void getFirstSymbolTest() {
        String str = "Sausage";
        Character s = stringFirstChar.apply(str);
        Character expected = 'S';
        assertEquals(expected, s);
    }

    @Test
    public void noSpacesTest() {
        String str = "Мама мыла раму";
        assertFalse(stringSpaces.test(str));
        String str2 = "Мамамылараму";
        assertTrue(stringSpaces.test(str2));
    }

    @Test
    public void countWordsTest() {
        String str = "мама, мыла, раму";
        assertEquals(3, stringCountWords.applyAsInt(str));
    }

    @Test
    public void studentTest() {
        assertEquals(18, humanAge.applyAsInt(student));
        assertTrue(humYoungerThan.function(student, student1, student2, 19));
        assertTrue(sameSurnames.test(student, student3));
        assertEquals("Abc Def Def", humanFullName.apply(student3));
    }

    @Test
    public void growUpTest() {
        Human human1 = new Human("Efg", "Efg", "Efg", 20, FEMALE);
        assertEquals(human1, humanOlder.apply(human));
    }

    @Test
    public void runnerGetFirstSymbolTest() {
        Character s = 'S';
        assertEquals(s, run("Sausage", stringFirstChar));
    }

    @Test
    public void runnerStringLength() {
        assertEquals(6, run("qwerty", stringLen));
    }

    @Test
    public void runnerNoSpacesTest() {
        String str2 = "Мамамылараму";
        assertTrue(run(str2, stringSpaces));
    }

    @Test
    public void runnerCountWords() {
        String str = "мама, мыла, раму";
        assertEquals(3, run(str, stringCountWords));
    }

    @Test
    public void runnerGetAge() {
        assertEquals(19, run(human, humanAge));
    }

    @Test
    public void runnerIsNamesakes() {
        assertTrue(run(student, student3, sameSurnames));
    }

    @Test
    public void runnerGetFullName() {
        assertEquals("Abc Def Def", run(student3, humanFullName));
    }

    @Test
    public void runnerGrowUp() {
        Human human1 = new Human("Efg", "Efg", "Efg", 20, FEMALE);
        assertEquals(human1, run(human, humanOlder));
    }

    @Test
    public void runnerAllYounger() {
        assertTrue(run(student3, student, student2, 20, humYoungerThan));
    }
}