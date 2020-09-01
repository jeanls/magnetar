package br.com.magnetar.schema;

import br.com.magnetar.Rule;
import br.com.magnetar.validator.ValidatorResult;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class SchemaTest {

    @Test
    public void test(){

        Schema schema = new Schema();
        TestDto dto = new TestDto();
        dto.setName("swsss");

        schema.addRule(dto.getName(), Rule.init("name").string()
                .min(6)
                .required()
                .build()
        );

        List<ValidatorResult> results = schema.getErrors();
        System.out.println(results);
        assertEquals(0, results.size());
    }

    private class TestDto {
        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}