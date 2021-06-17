import com.reporting.report.ReportGenerator;

public class Main {
	
	public static void main(String[] args) {
		String input = "2343225,2345,us_east,RedTeam,ProjectApple,3445s\r\n"
				+ "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\r\n"
				+ "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s\r\n"
				+ "1233456,2345,us_west,BlueTeam,ProjectDate,2221s\r\n"
				+ "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s";
		ReportGenerator.getInstance().insertData(input);
		System.out.println(ReportGenerator.getInstance().generateRopert());
	}

}
