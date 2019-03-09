package tacos.data;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import tacos.Ingredient;
import tacos.Taco;

@Slf4j
@Repository
public class JdbcTacoRepository implements TacoRepository {

	private JdbcTemplate jdbc;
	
	@Autowired
	public JdbcTacoRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	@Override
	public Taco save(Taco taco) {
		long tacoId = saveTacoInfo(taco);
		taco.setId(tacoId);
		int i=0;
		for (Ingredient ingredient : taco.getIngredients()) {
			saveIngredientToTaco(ingredient, tacoId);
			i++;
		}
		log.info(i + " Ingrediants Saved ");
		return taco;
	}
	
	@SuppressWarnings("deprecation")
	private long saveTacoInfo(Taco taco) {
		taco.setCreatedAt(new Date());
		PreparedStatementCreator psc = new PreparedStatementCreatorFactory("INSERT INTO TACO (NAME, CREATEDAT) VALUES (?,?)",Types.VARCHAR, Types.TIMESTAMP).
										newPreparedStatementCreator(Arrays.asList(taco.getName(), new Timestamp(taco.getCreatedAt().getDate())));
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int count = jdbc.update(psc,keyHolder);
		if (count > 0) {
			log.info("Taco Created");
		}
		return keyHolder.getKey().longValue();
	}
	
	private void saveIngredientToTaco(Ingredient ingredient, long tacoId) {
		jdbc.update("INSERT INTO TACO_INGREDIENTS (TACO, INGREDIENT) VALUES (?, ?)", tacoId, ingredient.getId());
	}

}
