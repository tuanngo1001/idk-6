package idk6.csexperience.objects;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface PlayerStatsBuilderInt {

    PlayerStats build(ResultSet rs) throws SQLException;

}
