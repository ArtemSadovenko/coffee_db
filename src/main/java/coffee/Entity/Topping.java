package coffee.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "topping")
public class Topping {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "amount")
    private int amount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}