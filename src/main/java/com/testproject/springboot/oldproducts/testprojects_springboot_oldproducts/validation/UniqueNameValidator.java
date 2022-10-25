package com.testproject.springboot.oldproducts.testprojects_springboot_oldproducts.validation;

import com.testproject.springboot.oldproducts.testprojects_springboot_oldproducts.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

    @Autowired
    private ProductServiceImpl productNameCheckBuffer;

    @Override
    public boolean isValid(String enteredValue, ConstraintValidatorContext context) {

        return enteredValue != null && !productNameCheckBuffer.isProductnameAlreadyInUse(enteredValue);
    }

}