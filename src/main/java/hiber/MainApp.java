package hiber;

import hiber.config.AppConfig;
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


//      Car car1 = new Car("Mercedes");
//      Car car2 = new Car("Opel");
//      Car car3 = new Car("Geely");
//      Car car4 = new Car("Shkoda");
//
//      User userCar = new User("User", "CarContainer", "user1@mail.ru");
//      userCar.setCar(car1);
//      userCar.setCar(car2);
//      userCar.setCar(car3);
//      userCar.setCar(car4);
//
//
//
//      userService.add(new User("User1", "Lastname1", "user1@mail.ru").setCar(car1));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru").setCar(car2));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru").setCar(car3));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru").setCar(car4));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar().toString());
         System.out.println();
      }

      context.close();
   }
}
