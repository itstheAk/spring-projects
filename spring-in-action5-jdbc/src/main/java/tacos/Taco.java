package tacos;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Taco {

	private Long id;
	
	@NotNull
	@Size(min=5, message = "Name Shoule be at least 5 charecter long")
	private String name;
	
	@Size(min=1, message = "You Must Choose At least 1 ingredient")
	private List<Ingredient> ingredients;
	
	private Date createdAt;

	
}
