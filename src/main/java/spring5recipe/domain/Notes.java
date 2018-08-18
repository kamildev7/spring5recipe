package spring5recipe.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author kamildev7 on 2018-08-08.
 */
@Getter
@Setter
public class Notes {

    private String id;
    private Recipe recipe;
    private String recipeNotes;

}
