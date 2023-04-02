package br.com.fatecmogidascruzes.topicos.common.domain.humanresources;
import java.util.Objects;

import br.com.caelum.stella.validation.CPFValidator;

public class Email {
    private final String address;
    public Email(String address) {
        String tempAddress = Objects.requireNonNull(address,
                "The e-mail address cannot be null");
        if(!tempAddress.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,6}$\n")) {
            throw new IllegalArgumentException("The provided e-mail address is invalid");
        }
        this.address = tempAddress;
    }
    public String getAddress() {
        return address;
    }
}