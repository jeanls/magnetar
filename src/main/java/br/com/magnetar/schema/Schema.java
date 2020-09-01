package br.com.magnetar.schema;

import br.com.magnetar.validator.Validator;
import br.com.magnetar.validator.ValidatorResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Schema {

    private final List<ValidatorResult> results;

    public Schema() {
        this.results = new ArrayList<>();
    }

    protected void addRule(Object o, List<Validator> validators) {
        validators.forEach(validator -> addRule(o, validator));
    }

    protected void addRule(Object o, Validator validator) {
        final ValidatorResult result = validator.run(o);
        results.add(result);
    }

    public List<ValidatorResult> getErrors() {
        return results.stream().filter(ValidatorResult::isErrorPresent).collect(Collectors.toList());
    }
}
