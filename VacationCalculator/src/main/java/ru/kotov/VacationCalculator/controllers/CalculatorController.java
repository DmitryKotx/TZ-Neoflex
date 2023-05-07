package ru.kotov.VacationCalculator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.kotov.VacationCalculator.responses.CalculatorResponse;
import ru.kotov.VacationCalculator.services.CalculatorService;
import ru.kotov.VacationCalculator.utils.InvalidNumberFormatException;


@RestController
public class CalculatorController {
    private final CalculatorService calculatorService;
    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/calculate")
    @ResponseStatus(HttpStatus.OK)
    public CalculatorResponse getVacationPay(@RequestParam("salary") String salary,
                                             @RequestParam("days") String days) {
        double annualSalary;
        double vacationDays;
        try {
            annualSalary = Double.parseDouble(salary);
            vacationDays = Double.parseDouble(days);
            return new CalculatorResponse(calculatorService.calculate(annualSalary, vacationDays));
        } catch (NumberFormatException e) {
            throw new InvalidNumberFormatException("Input parameter must be numbers");
        }
    }
}
