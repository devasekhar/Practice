package solution.parser;

import java.util.List;

import solution.model.IData;
 
public interface IParser<T> {
	
	List<T> parse(String str,DataValidator validator) throws Exception;

}
