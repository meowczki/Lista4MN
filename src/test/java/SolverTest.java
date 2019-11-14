import org.junit.jupiter.api.*;
import zajecia.Solver;

import static org.junit.jupiter.api.Assertions.*;

public class SolverTest {
    private Solver solver;

    @BeforeAll
    static void init() {
        System.out.println("Zaczynamy testy");

    }

    @BeforeEach
    void setup() {
        System.out.println("Zaraz uruchomimy koleny test...");
    }

    @Test
    @DisplayName("Test czy takie same obiekty")
    void takieSameFalse() {
        solver = new Solver((x -> 2 * x), 0);
        Solver solver1 = new Solver((x -> 2 * x), 0);
        assertFalse(solver.equals(solver1));
    }

    @Test
    @DisplayName("Wynik poprawny")
    void wynikPoprawny() {
    solver=new Solver((x) -> Math.pow(x,2)-1,-1);
    assertEquals(solver.bisection(0,2,0.01,100).getWyniki(),1);
    }

    @AfterEach
    void teardown() {

    }
}
