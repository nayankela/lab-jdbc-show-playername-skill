package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Player;
import model.Skill;
import utility.ConnectionManager;

public class PlayerDAO {

	List<Player> list = new ArrayList<Player>();

	public List<Player> getAllPlayers() throws Exception {
		SkillDAO skillDAO = new SkillDAO();
		String sql = "SELECT * FROM PLAYER";

		Connection connection = null;
		connection = ConnectionManager.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			Long playerId = resultSet.getLong(1);
			String name = resultSet.getString(2);
			String country = resultSet.getString(3);
			Long skill_id = resultSet.getLong(4);
			Skill skill = skillDAO.getSkillBylD(skill_id);
			Player player = new Player(playerId, name, country, skill);
			list.add(player);
		}

		return list;

	}
}
