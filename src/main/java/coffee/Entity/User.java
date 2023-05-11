package coffee.Entity;


import coffee.Entity.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
//import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "user_role", columnDefinition = "ENUM('CONSUMER','ADMIN')")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "coffee(id)")
    private List<Coffee> coffeeBill = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "topping(id)")
    private List<Topping> toppingBill = new ArrayList<>();
}
