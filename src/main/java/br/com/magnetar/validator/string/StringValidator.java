package br.com.magnetar.validator.string;

import br.com.magnetar.validator.Validator;
import br.com.magnetar.validator.ValidatorResult;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class StringValidator {
    private final ResourceBundle bundle;
    private final List<Validator> validators;
    private final String field;

    public StringValidator(String field) {
        this.field = field;
        validators = new ArrayList<>();
        Locale.setDefault(new Locale("pt", "br"));
        bundle = ResourceBundle.getBundle("words", Locale.getDefault());
    }

    public StringValidator required() {
        Validator validator = param -> {
            final String pattern = bundle.getString("notnull");
            final String message = MessageFormat.format(pattern, field);
            if (param == null) {
                return new ValidatorResult(true, message, field, null);
            }
            String value = (String) param;
            boolean result = value.trim().isEmpty();
            return new ValidatorResult(result, result ? message : "", field, param);
        };
        addValidator(validator);
        return this;
    }

    public StringValidator required(final String message) {
        Validator validator = param -> {
            if (param == null) {
                return new ValidatorResult(true, message, field, null);
            }
            String value = (String) param;
            boolean result = value.trim().isEmpty();
            return new ValidatorResult(result, result ? message : "", field, param);
        };
        addValidator(validator);
        return this;
    }

    public StringValidator min(final int val) {
        Validator validator = param -> {
            final String pattern = bundle.getString("min");
            final String message = MessageFormat.format(pattern, field, val);
            if (param == null) {
                return new ValidatorResult(true, message, field, null);
            }
            final String value = (String) param;
            boolean result = value.trim().length() < val;
            return new ValidatorResult(result, result ? message : "", field, param);
        };
        addValidator(validator);
        return this;
    }

    public StringValidator min(final int val, final String message) {
        Validator validator = param -> {
            if (param == null) {
                return new ValidatorResult(false, message, field, null);
            }
            final String value = (String) param;
            boolean result = value.trim().length() < val;
            return new ValidatorResult(result, result ? message : "", field, param);
        };
        addValidator(validator);
        return this;
    }

    public List<Validator> build() {
        return this.validators;
    }

    private void addValidator(Validator validator) {
        this.validators.add(validator);
    }
}
