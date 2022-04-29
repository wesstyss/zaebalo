package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import javax.persistence.NoResultException;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Руслан", "Хайруллин", "kh.ruslan00@mail.ru");
      User user2 = new User("Антон", "Зорин", "antohaloh@yandex.ru");
      User user3 = new User("Эмиль", "Нигматулин", "rapinheart@gmail.com");
      User user4 = new User("Василий", "Пупкин", "pypkin@mail.ru");

      Car car1 = new Car("BMW", 6);
      Car car2 = new Car("VAZ", 2107);
      Car car3 = new Car("MERCEDEz", 4);
      Car car4 = new Car("SHAHA", 1);

      userService.add(user1.setCar(car1).setUser(user1));
      userService.add(user2.setCar(car2).setUser(user2));
      userService.add(user3.setCar(car3).setUser(user3));
      userService.add(user4.setCar(car4).setUser(user4));


      for (User user : userService.listUsers()) {
         System.out.println(user + " " + user.getCar());
            }

      System.out.println();
      System.out.println(userService.getUserHaveCar("BMW", 6));
      System.out.println();


        try {
           User notFoundUser = userService.getUserHaveCar("Lamborghini", 2);
      } catch (NoResultException e) {
           System.out.println("НЕТУ ТАКОГО");

      }

      context.close();
   }
}