package ru.kotov.VacationCalculator.responses;

public class CalculatorResponse {
    private double vacationPay;

    public CalculatorResponse(double vacationPay) {
        this.vacationPay = vacationPay;
    }

    public double getVacationPay() {
        return vacationPay;
    }

    public void setVacationPay(double vacationPay) {
        this.vacationPay = vacationPay;
    }
}
