package solution;

import org.junit.Test;

import solution.aggregator.Aggregator;
import solution.model.Data;
import solution.parser.DataParser;
import solution.parser.DataParserFactory;
import solution.parser.IParser;
import solution.parser.StrictDataValidator;

import org.junit.BeforeClass;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class SolutionTest {

	static List<Data> list;

	@BeforeClass
	public static void init() {
		final String str = "2343225,2345,us_east,RedTeam,ProjectApple,3445s\n"
				+ "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\n"
				+ "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s\n"
				+ "1233456,2345,us_west,BlueTeam,ProjectDate,2221s\n"
				+ "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s";

		IParser<Data> parser = DataParserFactory.getDataParser(DataParserFactory.dataPraser);
		try {
			list = parser.parse(str, StrictDataValidator.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testUniqueCustomerIdsForEachContractId() {

		// The number of unique customerId for each contractId.
		Map<Integer, Integer> expectedMap = new HashMap<>();
		expectedMap.put(2345, 3);
		expectedMap.put(2346, 2);
		Map<Integer, Integer> map = Aggregator.getCountOfTgroupedByK(list, Data::getContractId, Data::getCustomerId,
				HashSet::new);
		assertTrue(expectedMap.equals(map));
	}

	@Test
	public void testUniqueCustomerIdsForEachGeozone() {

		// The number of unique customerId for each contractId.
		Map<String, Integer> expectedMap = new HashMap<>();
		expectedMap.put("eu_west", 2);
		expectedMap.put("us_west", 2);
		expectedMap.put("us_east", 1);
		Map<String, Integer> map = Aggregator.getCountOfTgroupedByK(list, Data::getGeoZone, Data::getCustomerId,
				HashSet::new);
		assertTrue(expectedMap.equals(map));
	}

	@Test
	public void testAverageBuilddurationForEachGeozone() {

		// The number of unique customerId for each contractId.
		Map<String, Double> expectedMap = new HashMap<>();
		expectedMap.put("eu_west", 4222.0);
		expectedMap.put("us_west", 2216.0);
		expectedMap.put("us_east", 3445.0);
		Map<String, Double> map = Aggregator.getAverageOfItemsGroupedByK(list, Data::getGeoZone,
				Data::getBuildDuration);
		assertTrue(expectedMap.equals(map));
	}

	@Test
	public void testListOfCustomerIdsForEachGeozone() {

		// The number of unique customerId for each contractId.
		Map<String, Collection<String>> expectedMap = new HashMap<>();
		expectedMap.put("eu_west", new HashSet<String>() {
			{
				add("3244132");
				add("3244332");
			}
		});
		expectedMap.put("us_west", new HashSet<String>() {
			{
				add("1233456");
				add("1223456");
			}
		});
		expectedMap.put("us_east", new HashSet<String>() {
			{
				add("2343225");
			}
		});
		Map<String, Collection<String>> map = Aggregator.getCollectionOfTgroupedByK(list, Data::getGeoZone,
				Data::getCustomerId, HashSet::new);
		assertTrue(expectedMap.equals(map));
	}
}
