package ru.kotov.VacationCalculator.services;
import org.junit.jupiter.api.Test;
import ru.kotov.VacationCalculator.utils.InvalidNumberFormatException;
import static org.junit.jupiter.api.Assertions.*;

class  CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();
    @Test
    void exceptionCheckingOnDays() {
        Throwable thrown = assertThrows(InvalidNumberFormatException.class, () -> {
            calculatorService.calculate(1, 0);
        });
        assertNotNull(thrown.getMessage());
    }
    @Test
    void exceptionCheckingOnSalary() {
        Throwable thrown = assertThrows(InvalidNumberFormatException.class, () -> {
            calculatorService.calculate(0, 1);
        });
        assertNotNull(thrown.getMessage());
    }
    @Test
    void exceptionCheckingOnDaysAndSalary() {
        Throwable thrown = assertThrows(InvalidNumberFormatException.class, () -> {
            calculatorService.calculate(0, 0);
        });
        assertNotNull(thrown.getMessage());
    }
    @Test
    void calculationCheck() {
        assertEquals(calculatorService.calculate(317100, 14), 10985.32);
    }
}