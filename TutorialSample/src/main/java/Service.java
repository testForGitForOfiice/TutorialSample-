package main.java;

public class Service {
//https://github.com/testForGitForOfiice/TutorialSample-.git
	private Dao dao = null;

	public String fetchKey(long id) {

		dao = new Dao();
		Entity entity = dao.findById(id);
		String firstName = entity.getFirstName();
		String surName = entity.getSurName();
		String key = firstName + surName;
		return key;
	}

}
