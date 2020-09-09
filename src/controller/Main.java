package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import dao.PlayerDAO;
import dao.SkillDAO;
import model.Player;
import model.Skill;

public class Main {
	public static void main(String[] args) throws Exception {
		// creating objects
		SkillDAO skillDAO = new SkillDAO();
		PlayerDAO playerDAO = new PlayerDAO();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		Long id = 0l;
		System.out.println("Enter ID:");
		try {
			id = Long.parseLong(bufferedReader.readLine());
		} catch (Exception e) {
			System.out.println("Enter Valid ID");
		}
		Skill skill2 = skillDAO.getSkillBylD(id);
		System.out.println("---------------------------");
		System.out.println("SkillId       SkillName");
		System.out.println("---------------------------");
		System.out.println(skill2.getSkilld() + "             " + skill2.getSkillName());
		System.out.println("---------------------------");

		List<Player> players = playerDAO.getAllPlayers();
		// Player player = new Player(playerld, name, country, skill)
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("PlayerId      Name        Country        SkillId          SkillName");
		System.out.println("-----------------------------------------------------------------------------");
		for (Player player : players) {
			System.out.println(player.getPlayerld() + "           " + player.getName() + "           "
					+ player.getCountry() + "           " + player.getSkill().getSkilld() + "           "
					+ player.getSkill().getSkillName());
		}
		System.out.println("-----------------------------------------------------------------------------");

	}
}
