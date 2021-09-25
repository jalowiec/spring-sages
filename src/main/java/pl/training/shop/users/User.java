package pl.training.shop.users;

import lombok.*;
import pl.training.shop.common.validator.Name;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Table(name = "users")
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "id")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    //@Pattern(regexp = "[A-Za-z]")
    private String lastName;
    @Name
    private String firstName;

}
