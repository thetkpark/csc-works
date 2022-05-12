package csc319.j4.bankaccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Class3BankAccountExerciseApplication {

    public static void main(String[] args) {
        SpringApplication.run(Class3BankAccountExerciseApplication.class, args);
    }

}
