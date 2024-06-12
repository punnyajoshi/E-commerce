package com.punnyajoshi.Ecommerce.modals;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModal {

    private String first_name;
    private String last_name;
    private String emailID;
    private String password;

    public UserModal init() {
        Faker faker = new Faker();
        return UserModal.builder()
                .first_name(faker.name().firstName())
                .last_name(faker.name().lastName())
                .emailID(faker.internet().emailAddress())
                .password("Pass123@")
                .build();
    }

    public UserModal userWithoutEmail() {
        UserModal user = this.init();
        user.setEmailID("");
        return user;
    }

    public UserModal userWithoutPassword() {
        UserModal user = this.init();
        user.setPassword("");
        return user;
    }

    public UserModal userWithValidCredentials() {
        return UserModal.builder()
                .first_name("Khushi")
                .last_name("Agrawal")
                .emailID("khushiagrawl0302@gmail.com")
                .password("khushi123")
                .build();
    }

    public UserModal userWithInvalidCredentials() {
        return UserModal.builder()
                .first_name("Khushi")
                .last_name("Agrawal")
                .emailID("khushiagrawal0302@gmail.com")
                .password("khushi@123")
                .build();
    }

}