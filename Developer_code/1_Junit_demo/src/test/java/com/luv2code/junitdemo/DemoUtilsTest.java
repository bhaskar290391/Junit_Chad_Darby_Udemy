package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static  org.junit.jupiter.api.Assertions.*;

//@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
//@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)

@TestMethodOrder(MethodOrderer.DisplayName.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@TestMethodOrder(MethodOrderer.MethodName.class)
//@TestMethodOrder(MethodOrderer.Random.class)
public class DemoUtilsTest {

    private DemoUtils demo;

    @BeforeEach
    public void beforeTestExecution(){
        demo=new DemoUtils();
        System.out.println("Executing Before each for Each Execution method ");
    }

    @AfterEach
    public void afterEachExecution(){
        System.out.println("Executing After each for Each Execution method \n");
    }

    @BeforeAll
    static  void beforeAllForClass(){
        System.out.println("Executing Before all for Each Class \n");
    }

    @AfterAll
    static  void afterAllForClass(){
        System.out.println("Executing After all for Each Class \n");
    }

    @Test
    @DisplayName("Equals and Not Equals")
    public void assertEqualAndNotEqual(){
        System.out.println("Running Test ==> assertEqualAndNotEqual()");

        assertEquals(6,demo.add(2,4),"2 and 4 must be 6");
        assertNotEquals(6,demo.add(2,2),"2 and 2 must not be 6");
    }


    @Test
    @DisplayName("Null and Not Nulls")
    public void checkNullAndNotNull(){
        System.out.println("Running Test ==> checkNullAndNotNull()");

        String str=null;
        String str2="bhaksar";
        assertNull(demo.checkNull(str),"Given string is null");
        assertNotNull(demo.checkNull(str2),"Given string is not null");
    }


    @Test
    @DisplayName("Same and Not Same")
    public void sameAndNotSame(){
        String str="bhaskar";

        assertSame(demo.getAcademy(),demo.getAcademyDuplicate(),"This should match");
        assertNotSame(str,demo.getAcademyDuplicate(),"This should not match");
    }

    @Test
    @DisplayName("True Or False")
    public void trueAndFalse(){
        assertTrue(demo.isGreater(10,5),"This should return true");
        assertFalse(demo.isGreater(5,10),"This should return false");
    }

    @Test
    @DisplayName("Array Equal")
    public void arrayEquals(){
        String[] data={"A", "B", "C"};
        assertArrayEquals(data,demo.getFirstThreeLettersOfAlphabet(),"Array should be Equals");
    }

    @Test
    @Order(2)
    @DisplayName("Array Iterable Test")
    public void iterableEquals(){
        List<String> data=List.of("luv","2","code");
        assertIterableEquals(data,demo.getAcademyInList());
    }


    @Test
    @DisplayName("Assert Line Match")
    public void lineMatch(){
        List<String> data=List.of("luv","2","code");
        assertLinesMatch(data,demo.getAcademyInList());
    }


    @Test
    @Order(1)
    @DisplayName("Timeout")
    public void timeout(){
        assertTimeoutPreemptively(Duration.ofSeconds(3),()->{demo.checkTimeout();});
    }


    @Test
    @DisplayName("Throws and Not Throws")
    public void assertTestThrows(){
        assertThrows(Exception.class,()-> {demo.throwException(-1);});
        assertDoesNotThrow(()-> {demo.throwException(5);});
    }
}
