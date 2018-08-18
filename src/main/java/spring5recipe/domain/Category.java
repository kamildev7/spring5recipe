package spring5recipe.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * @author kamildev7 on 2018-08-12.
 */
@Getter
@Setter
public class Category {

    private String id;
    private String description;
    private Set<Recipe> recipes;

}
