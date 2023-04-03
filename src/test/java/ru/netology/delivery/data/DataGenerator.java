package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }


    public static String generateDate(int shift) {
        LocalDate date = LocalDate.now().plusDays(shift);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return date.format(formatter);
    }



    public static class CityGenerator {
        public static String generateCity(String locale) {
            Faker faker = new Faker(new Locale(locale));
            String city = faker.address().city();
            return city;
        }
    }

    public static class NameGenerator {
        public static String generateName(String locale) {
            Faker faker = new Faker(new Locale(locale));
            String name = faker.name().fullName();
            return name;
        }
    }

    public static class PhoneGenerator {
        public static String generatePhone(String locale) {
            Faker faker = new Faker(new Locale(locale));
            String phone = faker.phoneNumber().phoneNumber();
            return phone;
        }
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            String city = CityGenerator.generateCity(locale);
            String name = NameGenerator.generateName(locale);
            String phone = PhoneGenerator.generatePhone(locale);
            return new UserInfo(city, name, phone);
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
