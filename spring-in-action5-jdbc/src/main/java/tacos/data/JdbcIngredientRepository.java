package tacos.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tacos.Ingredient;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {
	
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public JdbcIngredientRepository (JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public Iterable<Ingredient> findAll() {
		return jdbc.query("SELECT ID, NAME, TYPE FROM INGREDIENT", this::mapRowToIngredient);
	}

	@Override
	public Ingredient findById(String id) {
		return jdbc.queryForObject("SELECT ID, NAME, TYPE FROM INGREDIENT WHERE ID=?", this::mapRowToIngredient, id);
	}

	@Override
	public Ingredient save(Ingredient ingredient) {
		jdbc.update("INSERT INTO INGREDIENT VALUES (?,?,?)", ingredient.getId(), ingredient.getId(), ingredient.getType());
		return ingredient;
	}
	
	private Ingredient mapRowToIngredient(ResultSet rs, int rowNum)
			throws SQLException {
		return new Ingredient(rs.getString("id"), rs.getString("name"), Ingredient.Type.valueOf(rs.getString("type")));
	}

}
