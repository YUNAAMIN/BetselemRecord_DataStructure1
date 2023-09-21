package application;

public class MartyrD implements Comparable<MartyrD> {
	private String name;
	private String age;
	private String location;
	private String date;
	private String gender;

	public MartyrD(String name, String age, String location, String date, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.location = location;
		this.date = date;
		this.gender = gender;
	}

	public MartyrD(String line) {

		String[] matryr = line.trim().split(",");
		if (matryr.length >= 5) {
			name = matryr[0];
			age = matryr[1];
			location = matryr[2];
			date = matryr[3];
			// gender = matryr[4].charAt(0);
			setGender(line);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age + " ";
	}

	public void setAge(String age) {

		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {

		this.location = location;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		if (gender.charAt(0) == 'm' || gender.charAt(0) == 'M' || gender.charAt(0) == 'F' || gender.charAt(0) == 'f')
			this.gender = gender;
		else
			System.out.println("ERROR: There Is a char not = to m or f please check the file.!!");
	}

	@Override
	public String toString() {
		return "name: " + name + "\t" + ", age: " + age + "\t" + ", location: " + location + "\t" + ", date: " + date
				+ "\t" + ", gender: " + gender + "\n";
	}

	@Override
	public int compareTo(MartyrD o) {

		return this.date.compareTo(o.getDate());
	}

}
