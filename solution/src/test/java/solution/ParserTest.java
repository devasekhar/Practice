package solution;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import solution.model.Data;
import solution.parser.DataParser;
import solution.parser.IParser;
import solution.parser.StrictDataValidator;

public class ParserTest {
	
	IParser<Data> parser = new DataParser();
	
	@Test
	public void testParser() {
		String str = "2343225,2345,us_east,RedTeam,ProjectApple,3445s\n"
				+ "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\n"
				+ "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s\n"
				+ "1233456,2345,us_west,BlueTeam,ProjectDate,2221s\n"
				+ "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s";
		try {
			List<Data> list = parser.parse(str, new StrictDataValidator());
			assertEquals(5,list.size());
			assertEquals("3244332",list.get(2).getCustomerId());
			assertEquals(2346,list.get(2).getContractId());
			assertEquals("eu_west",list.get(2).getGeoZone());
			assertEquals("ProjectCarrot",list.get(2).getProjectCode());
			assertEquals("YellowTeam3",list.get(2).getTeamCode());
			assertEquals(4322,list.get(2).getBuildDuration());
			
			assertEquals("2343225",list.get(0).getCustomerId());
			assertEquals(2345,list.get(1).getContractId());
			assertEquals("us_west",list.get(1).getGeoZone());
			assertEquals("ProjectEgg",list.get(4).getProjectCode());
			assertEquals("BlueTeam",list.get(3).getTeamCode());
			assertEquals(4322,list.get(2).getBuildDuration());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testParserWithEmptyData() {
		String str = "2343225,2345,us_east,RedTeam,ProjectApple,3445s\n"
				+ "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\n"
				+ "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s\n"
				+ "1233456,2345,,BlueTeam,ProjectDate,2221s\n"
				+ "3244132,,eu_west,YellowTeam3,ProjectEgg,4122s";
		try {
			List<Data> list = parser.parse(str, new StrictDataValidator());
			assertEquals(3,list.size());
			assertEquals("3244332",list.get(2).getCustomerId());
			assertEquals(2346,list.get(2).getContractId());
			assertEquals("eu_west",list.get(2).getGeoZone());
			assertEquals("ProjectCarrot",list.get(2).getProjectCode());
			assertEquals("YellowTeam3",list.get(2).getTeamCode());
			assertEquals(4322,list.get(2).getBuildDuration());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testParserWithUnequalAttribute() {
		String str = "2343225,2345,us_east,RedTeam,ProjectApple,3445s,2344\n"
				+ "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\n"
				+ "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s\n"
				+ "1233456,2345,,BlueTeam,ProjectDate,2221s\n"
				+ "3244132,,eu_west,YellowTeam3,ProjectEgg,4122s";
		try {
			List<Data> list = parser.parse(str, new StrictDataValidator());
			assertEquals(2,list.size());
			assertEquals("3244332",list.get(1).getCustomerId());
			assertEquals(2346,list.get(1).getContractId());
			assertEquals("eu_west",list.get(1).getGeoZone());
			assertEquals("ProjectCarrot",list.get(1).getProjectCode());
			assertEquals("YellowTeam3",list.get(1).getTeamCode());
			assertEquals(4322,list.get(1).getBuildDuration());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
