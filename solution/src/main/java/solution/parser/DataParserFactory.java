package solution.parser;

/*
 * ParserFactory to provide instances of Parser
 * Factory method pattren has been used
 */
public class DataParserFactory {
	public static final String dataPraser = "DataParser";

	public static IParser getDataParser(String parserType) {
		IParser parser = null;
		if (parserType != null) {
			if (parserType.equals(dataPraser)) {
				parser = DataParser.getInstance();
			}
		}

		return parser;

	}

}
