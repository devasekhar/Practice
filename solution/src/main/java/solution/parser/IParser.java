package solution.parser;

import java.util.List;

import solution.model.IData;

/*
 * parses the input string for type T, validates the string with DataValidator supplied and produces List of Type T
 */
public interface IParser<T> {
	
	List<T> parse(String str,DataValidator validator) throws Exception;

}
