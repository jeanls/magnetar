package br.com.magnetar;

import br.com.magnetar.validator.string.StringValidator;

public class Rule {
    private final String field;

    private Rule(String field) {
        this.field = field;
    }

    public static Rule init(String field) {
        return new Rule(field);
    }

    public StringValidator string() {
        return new StringValidator(field);
    }
}
