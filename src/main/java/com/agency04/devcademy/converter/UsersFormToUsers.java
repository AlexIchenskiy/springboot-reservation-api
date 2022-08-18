package com.agency04.devcademy.converter;


import com.agency04.devcademy.form.UsersForm;
import com.agency04.devcademy.model.Users;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UsersFormToUsers implements Converter<UsersForm, Users> {

    @Override
    public Users convert(UsersForm usersDetails) {
        final Users users = new Users();

        users.setFirstName(usersDetails.getFirstName());
        users.setLastName(usersDetails.getLastName());
        users.setEmail(usersDetails.getEmail());

        return null;
    }
}
