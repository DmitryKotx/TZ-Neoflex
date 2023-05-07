package ru.kotov.VacationCalculator.services;
import org.springframework.stereotype.Service;
import ru.kotov.VacationCalculator.utils.InvalidNumberFormatException;

@Service
public class CalculatorService {
    public double calculate(double annualSalary, double vacationDays) {
        // Проверяем, больше нуля наши числа или нет
        if (annualSalary <= 0 || vacationDays <= 0) {
            throw new InvalidNumberFormatException("Numbers must be greater than 0");
        }
        // Считаем ежедневную зарплату, поделив годовую на 12 месяцев и в среднем на 29.3 дней
        double averageDailyEarnings = Math.round(annualSalary / 12 / 29.3 * 100) / 100.0;
        // Считаем количество отпускных до вычета налога
        double vocationPayBeforeTax = Math.round(averageDailyEarnings * vacationDays * 100) / 100.0;
        double tax = Math.round(vocationPayBeforeTax * 0.13); // Считаем НДФЛ
        return Math.round((vocationPayBeforeTax - tax) * 100) / 100.0; // Возвращаем количество отпускных с учетом налога
    }
}
