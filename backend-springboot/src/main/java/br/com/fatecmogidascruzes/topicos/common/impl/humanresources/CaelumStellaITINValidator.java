package br.com.fatecmogidascruzes.topicos.common.impl.humanresources;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.fatecmogidascruzes.topicos.common.domain.humanresources.validator.ITINValidator;

public class CaelumStellaITINValidator
        implements ITINValidator {
    public boolean isValid(String number) {
        CPFValidator cpfValidator = new CPFValidator(true);
        try {
            cpfValidator.assertValid(number);
            return true;
        } catch(Exception e) {
            return false;
        }
    }
}