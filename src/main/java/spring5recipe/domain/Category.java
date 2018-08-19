package spring5recipe.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

/**
 * @author kamildev7 on 2018-08-12.
 */
@Getter
@Setter
@Document
public class Category {
    @Id
    private String id;
    private String description;
    private Set<Recipe> recipes;

}
