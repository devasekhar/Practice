package solution.parser;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import solution.model.Data;
import solution.model.IData;
/*
 * DataParser is Singleton object. It parses the input string provided and provides the List of Data items
 */
public class DataParser implements IParser {

	private static DataParser instance = new DataParser();

	private DataParser() {

	}

	public static DataParser getInstance() {
		return instance;
	}

	public List<IData> parse(String str, DataValidator validator) throws Exception {

		List<IData> listData = new ArrayList<>();

		if (validator == null) {
			validator = SimpleDataValidator.getInstance();
		}

		try {
			InputStream stream = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
			BufferedReader br = new BufferedReader(new InputStreamReader(stream));
			String line;
			while ((line = br.readLine()) != null) {
				if (validator.valid(line)) {
					Data data = DataProducer.produce(line);
					listData.add(data);
				} else {
					// log or exception can be thrown or data cleansing logic can be added( adding
					// default values , average values etc..)
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return listData;
	}

}
