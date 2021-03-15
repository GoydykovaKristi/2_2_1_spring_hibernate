package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

//      User user9 = new User("User9", "Lastname1", "user1@mail.ru");
//      Car car9 = new Car("Niva2", 123);
//
//      user9.setCar(car9);
//
//      userService.add(user9);


      userService.add(new User("User1", "Lastname1", "user1@mail.ru")
              .setCar(new Car("Niva", 123)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru")
              .setCar(new Car("Lada", 456)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru")
              .setCar(new Car("Pejo", 789)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru")
              .setCar(new Car("Kia", 101112)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());

         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

      System.out.println(userService.getUserByCar("Niva", 123));

      context.close();
   }
}

