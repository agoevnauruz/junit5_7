package docs;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnit5Examples {

    @BeforeAll
    static void beforeAll() {
        System.out.println("== Something before All tests");
    }

    @BeforeAll
    static void beforeAll1() {
        System.out.println("== Something 1 before All tests");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("===== Something before Every tests");
    }

    @Test
    void firstTest() {
        System.out.println("========= Started firstTest");
    }

    @Test
    void secondTest() {
        System.out.println("========= Started secondTest");
        assertEquals(2, 3);
    }

    @AfterEach
    void afterEach() {
        System.out.println("===== Something after Every tests");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("== Something after All tests");
    }
}
