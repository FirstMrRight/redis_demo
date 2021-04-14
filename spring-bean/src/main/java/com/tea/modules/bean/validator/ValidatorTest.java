package com.tea.modules.bean.validator;

import com.tea.modules.exception.RestfulException;
import com.tea.modules.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import java.util.Set;

/**
 * com.tea.modules.bean.validator
 *
 * @author xiejiemin
 * @since 2021/3/31
 */
@Component
public class ValidatorTest {

    public void test() {
        Student student = new Student();
        Set<ConstraintViolation<@Valid Student>> validateSet = Validation.buildDefaultValidatorFactory()
                .getValidator()
                .validate(student);
        if (!CollectionUtils.isEmpty(validateSet)) {
            String messages = validateSet.stream()
                    .map(ConstraintViolation::getMessage)
                    .reduce((m1, m2) -> m1 + "；" + m2)
                    .orElse("参数输入有误！");
            throw new RestfulException(messages);
        }
    }
}
