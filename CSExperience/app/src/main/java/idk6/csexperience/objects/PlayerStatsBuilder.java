package idk6.csexperience.objects;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerStatsBuilder implements PlayerStatsBuilderInt {
    private PlayerStats stats;
    public PlayerStatsBuilder() {
        stats = new PlayerStats();
    }

    public PlayerStats build(ResultSet rs) throws SQLException {
        final int energy = rs.getInt("ENERGY");
        final int food = rs.getInt("FOOD");
        final int happiness = rs.getInt("HAPPINESS");
        final int money = rs.getInt("MONEY");
        final int dbKnowledge = rs.getInt("DB_KNOWLEDGE");
        final int aiKnowledge = rs.getInt("AI_KNOWLEDGE");
        final int graphicsKnowledge = rs.getInt("GRAPHICS_KNOWLEDGE");

        stats.setEnergy(energy);
        stats.setFood(food);
        stats.setHappiness(happiness);
        stats.setMoney(money);
        stats.setDatabasesKnowledge(dbKnowledge);
        stats.setAiKnowledge(aiKnowledge);
        stats.setGraphicsKnowledge(graphicsKnowledge);

        return stats;
    }
}
