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
      User user0 =new  User("Sergey", "Sergeev", "Sergo@mail.ru");
      user0.setCar(new Car("BMW",1));
      User user1 =new  User("Denis", "Denisov", "Den@mail.ru");
      user1.setCar(new Car("Audi",2));
      User user2 =new  User("Evgeniy", "Evgeniyev", "Zgeka@mail.ru");
      user2.setCar(new Car("Ferrari",3));
      User user3 =new  User("Vladimir", "Vladimirov", "Vova@mail.ru");
      user3.setCar(new Car("Kia rio",4));
      userService.add(user0);
      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }
      System.out.println(userService.getUser("Audi",2));
      context.close();
   }
}
