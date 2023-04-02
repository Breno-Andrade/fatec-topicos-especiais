package br.com.fatecmogidascruzes.topicos.common.domain.humanresources;

import java.util.Objects;

import br.com.caelum.stella.validation.CPFValidator;

public class Phone {
    private final String number;
    public Phone(String number) {
        String tempNumber = Objects.requireNonNull(number,
                "The phone number cannot be null");
        tempNumber = tempNumber.replace("[^\\d]", "");
        if(tempNumber.length() >= 10 && tempNumber.length() <= 11) {
            if(tempNumber.matches("[\\d]{2}9?[\\d]{8}")) {
                this.number = tempNumber;
                return;
            }
        }
        throw new IllegalArgumentException("The provided phone number is invalid");
    }
    public String getNumber() {
        return number;
    }
}