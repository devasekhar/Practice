package solution;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import solution.aggregator.Aggregator;
import solution.model.Data;
import solution.parser.DataParser;
import solution.parser.DataParserFactory;
import solution.parser.IParser;
import solution.parser.StrictDataValidator;

public class App {
	public static void main(String[] args) {

		String str = "2343225,2345,us_east,RedTeam,ProjectApple,3445s\n"
				+ "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\n"
				+ "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s\n"
				+ "1233456,2345,us_west,BlueTeam,ProjectDate,2221s\n"
				+ "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s";

		IParser<Data> parser = DataParserFactory.getDataParser(DataParserFactory.dataPraser);
		try {

			List<Data> list = parser.parse(str, StrictDataValidator.getInstance());

			// The number of unique customerId for each contractId.
			Map<Integer, Integer> map1 = Aggregator.getCountOfTgroupedByK(list, Data::getContractId,
					Data::getCustomerId, HashSet::new);

			// The number of unique customerId for each geozone.
			Map<String, Integer> map2 = Aggregator.getCountOfTgroupedByK(list, Data::getGeoZone, Data::getCustomerId,
					HashSet::new);

			// The average buildduration for each geozone.
			Map<String, Double> map3 = Aggregator.getAverageOfItemsGroupedByK(list, Data::getGeoZone,
					Data::getBuildDuration);

			// The list of unique customerId for each geozone.

			Map<String, Collection<String>> map4 = Aggregator.getCollectionOfTgroupedByK(list, Data::getGeoZone,
					Data::getCustomerId, HashSet::new);
			System.out.println("");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
