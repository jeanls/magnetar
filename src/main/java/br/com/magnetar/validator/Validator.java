package br.com.magnetar.validator;

public interface Validator {
    ValidatorResult run(Object field);
}
