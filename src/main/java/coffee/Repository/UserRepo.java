package coffee.Repository;

import coffee.Entity.Coffee;
import coffee.Entity.CustomPair;
import coffee.Entity.Topping;
import coffee.Entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepo {
    private List<User> users = new ArrayList<>();
    private long id = 0;

    public void add(User user){
        ++id;
        user.setId(id);
        users.add(user);
    }

    public void update(User user){
        User old = users.stream()
                .filter(e -> e.getId() == user.getId())
                .findFirst()
                .get();

        old.setUserRole(user.getUserRole());
        old.setName(user.getName());
        old.setCoffeeBill(user.getCoffeeBill());
        old.setToppingBill(user.getToppingBill());
    }

    public void del(long id){
        users = users.stream()
                .filter(e -> e.getId() != id)
                .collect(Collectors.toList());
    }

    public User findById(long id){
        return users.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .get();
    }

    public List<User> getAll(){
        return users;
    }

    public void buyCoffee(long id, Coffee coffee){
        User user = findById(id);
        user.getCoffeeBill().add(coffee);
    }

    public void buyTopping(long id, Topping topping){
        User user = findById(id);
        user.getToppingBill().add(topping);
    }

//    public CustomPair bill(long id){
//        User user = findById(id);
//        CustomPair customPair = new CustomPair(user.getCoffeeBill(), user.getToppingBill());
//        return customPair;
//    }
}

