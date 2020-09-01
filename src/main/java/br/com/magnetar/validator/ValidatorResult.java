package br.com.magnetar.validator;

public class ValidatorResult {
    private final boolean errorPresent;
    private final String message;
    private final String field;
    private final Object attemptedValue;

    public ValidatorResult(boolean errorPresent, String message, String field, Object attemptedValue) {
        this.errorPresent = errorPresent;
        this.message = message;
        this.field = field;
        this.attemptedValue = attemptedValue;
    }

    public boolean isErrorPresent() {
        return errorPresent;
    }

    public String getMessage() {
        return message;
    }

    public String getField() {
        return field;
    }

    public Object getAttemptedValue() {
        return attemptedValue;
    }
}
