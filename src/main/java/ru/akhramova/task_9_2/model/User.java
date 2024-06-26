package ru.akhramova.task_9_2.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class User {
    @NotBlank(message = "Имя должно состоять хотя бы из двух букв")
    @Size(min = 2, message = "Имя должно состоять хотя бы из двух букв")
    @Pattern(regexp = "[a-zA-Z]{2,}", message = "Имя должно состоять из букв")
    private String user;
    @NotBlank(message = "Пароль должен состоять хотя бы из шести символов")
    @Size(min = 6, message = "Пароль должен состоять хотя бы из шести символов")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}", message = "Пароль должен содержать строчные и заглавные буквы, цифры и спец. символы")
    private String password;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(this.user, user.user) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, password);
    }

    @Override
    public String toString() {
        return "user='" + user + '\'' +
                ", password='" + password;
    }
}
