package br.com.fatecmogidascruzes.topicos.common.domain.humanresources;

import java.util.Objects;

import br.com.fatecmogidascruzes.topicos.common.domain.humanresources.validator.ITINValidator;
import br.com.fatecmogidascruzes.topicos.common.ServiceLocator;

public class ITIN {
    private final String number;
    public ITIN(String number) {
        String tempNumber = Objects.requireNonNull(number,
                "The ITIN cannot be null");
        ITINValidator itinValidator = ServiceLocator.getITINValidator();
        if(itinValidator.isValid(tempNumber)) {
            this.number = tempNumber.replace("[^\\d]","");
        } else {
            throw new IllegalArgumentException("The provided ITIN is invalid.");
        }
    }
    public String getNumber() {
        return number;
    }
}
