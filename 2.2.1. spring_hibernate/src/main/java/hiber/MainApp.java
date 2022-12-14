package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
   //   CarService carService = context.getBean(CarService.class);
//User user1 = new User();
      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("Alphard", "H30")));
     // carService.addCar(new Car("Toyota", "Verso"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("Alphard", "H20")));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("Alphard", "H10")));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("Vellfire", "H30")));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }
      System.out.println(userService.getCarOwner("Alphard","H30"));
      System.out.println(userService.getCarOwner("Vellfire","H10")); // несуществующий параметр
      context.close();
   }
}


/* сделать Сar                         +
добавить setAnnotatedClasses  Car      +
*  диалект в properties                   +
* Dao, Service для Car                    + не нужно?
* переделать User                         +
* сделать запрос на добавление            +
* сделать метод для получения юзера по машине   + (через запрос)
* метод getCarOwner сделать readOnly (работа в рамках транзакции)
*аннотации у Car Autowired для CarDao и CarService не надо (хорошей практикой является
 предоставление настроек как на уровне класса так и на уровне метода, чтобы разделить
  варианты использования на нетранзакционные, транзакционные, только для чтения и чтения-записи.
*
*
*
* */