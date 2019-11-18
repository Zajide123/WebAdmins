package webAdmins.demo.Validation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import webAdmins.demo.entity.user;
import webAdmins.demo.service.userService;

@Component
public class userValidator implements Validator {
    @Autowired
    private userService userService;

    @Override
    public boolean supports(Class<?> aClass){
        return user.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors){
        user user = (user) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username","NotEmpty");
        if (user.getLogin().length() < 6 || user.getLogin().length() > 32){
            errors.rejectValue("username","Size.userForm.username");
        }
        if (userService.FindByLogin(user.getLogin()) != null){
            errors.rejectValue("username","Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32){
            errors.rejectValue("password","Size.userForm.password");
        }

    }
}
