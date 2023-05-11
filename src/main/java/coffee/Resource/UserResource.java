package coffee.Resource;

import coffee.Entity.Coffee;
import coffee.Entity.CustomPair;
import coffee.Entity.Topping;
import coffee.Entity.User;
import coffee.Entity.enums.UserRole;
import coffee.Repository.RepoCoffee;
import coffee.Repository.RepoTopping;
import coffee.Repository.RepoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserResource {
    @Autowired
    private RepoCoffee coffeeRepo;
    @Autowired
    private RepoUser userRepo;
    @Autowired
    private RepoTopping toppingRepo;

    @PostMapping("/add")
    public void add(@RequestBody User user){
        userRepo.save(user);
    }

    @GetMapping("/all")
    public List<User> getAll(){
        return userRepo.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable long id){
        return userRepo.findById(id).get();
    }

    @PutMapping("/{id}")
    public void update(@RequestBody User user, @PathVariable long id){
        user.setId(id);
        userRepo.save(user);
    }

    @DeleteMapping("/{id}")
    public void del(@PathVariable long id){
        userRepo.deleteById(id);
    }


//    @PostMapping("/{userId}/coffee/")
//    public void buyCoffee(@PathVariable long userId, @RequestBody Coffee coffee){
//        coffeeRepo.min(coffee);
//        userRepo.buyCoffee(userId, coffee);
//    }
//
//
//    @PostMapping("/{userId}/topping/")
//    public void buyTopping(@PathVariable long userId,@RequestBody Topping topping){
//        toppingRepo.min(topping);
//        userRepo.buyTopping(userId, topping);
//    }
//
//    @GetMapping("/{id}/bill")
//    public CustomPair bill(@PathVariable long id){
//        User user = userRepo.findById(id);
//        CustomPair customPair = new CustomPair(user.getCoffeeBill(), user.getToppingBill());
//        return customPair;
//    }

    @PostMapping("/{id}/upCoffee")
    public void upCoffee(@RequestBody Coffee coffee, @PathVariable long id){
        if(userRepo.findById(id).get().getUserRole().equals(UserRole.ADMIN)){
//            coffeeRepo.update(coffee);
            coffeeRepo.save(coffee);
        }
    }

    @PostMapping("/{id}/upTopping")
    public void upTopping(@RequestBody Topping coffee, @PathVariable long id){
        if(userRepo.findById(id).get().getUserRole().equals(UserRole.ADMIN)){
            toppingRepo.save(coffee);
        }
    }


}
