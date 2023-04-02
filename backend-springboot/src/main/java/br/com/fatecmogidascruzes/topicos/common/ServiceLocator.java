package br.com.fatecmogidascruzes.topicos.common;

import br.com.fatecmogidascruzes.topicos.common.domain.humanresources.validator.ITINValidator;
import br.com.fatecmogidascruzes.topicos.common.impl.humanresources.CaelumStellaITINValidator;

public class ServiceLocator {
    public static ITINValidator getITINValidator() {
        return new CaelumStellaITINValidator();
    }
}