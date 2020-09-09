package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Skill;
import utility.ConnectionManager;

public class SkillDAO {

	public Skill getSkillBylD(Long id) throws Exception {
		String sql = "SELECT * FROM SKILL WHERE ID = " + id;

		Connection connection = null;
		connection = ConnectionManager.getConnection();

		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		Skill skill = null;
		while (resultSet.next()) {
			Long skillId = resultSet.getLong(1);
			String skillName = resultSet.getString(2);
			skill = new Skill(skillId, skillName);
		}
		return skill;

	}
}
