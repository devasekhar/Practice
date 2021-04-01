package solution.aggregator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Utility class for the calculation of groupby aggregates
 */
public class Aggregator {

	/**
	 * Returns map of collection of selected attribute(T) of E for each grouped
	 * attribue of(K) E
	 * 
	 * @param <E>               the type of the input elements
	 * @param <K>               grouping attribute K in E
	 * @param <T>               select attribute T in E
	 * @param collectionFactory a supplier providing a new empty {@code Collection}
	 *                          into which the results will be inserted
	 */
	public static <E, K, T> Map<K, Collection<T>> getCollectionOfTgroupedByK(List<E> list, Function<E, K> groupingKey,
			Function<E, T> selectKey, Supplier<Collection<T>> collectionFactory)

	{
		if (list != null) {

			Map<K, Collection<T>> map = list.stream().collect(Collectors.groupingBy(groupingKey,
					Collectors.mapping(selectKey, Collectors.toCollection(collectionFactory))));

			return map;
		} else {
			return new HashMap<>();
		}

	}

	/**
	 * Returns map of count of selected attribute(T) of E for each grouped attribue
	 * of(K) E
	 * 
	 * @param <E>               the type of the input elements
	 * @param <K>               grouping attribute K in E
	 * @param <T>               select attribute T in E
	 * @param collectionFactory a supplier providing a new empty {@code Collection}
	 *                          into which the results will be inserted
	 */

	public static <E, K, T> Map<K, Integer> getCountOfTgroupedByK(List<E> list, Function<E, K> groupingKey,
			Function<E, T> selectKey, Supplier<Collection<T>> collectionFactory)

	{
		if (list != null) {
			Map<K, Collection<T>> map = getCollectionOfTgroupedByK(list, groupingKey, selectKey, collectionFactory);

			Map<K, Integer> result = map.entrySet().stream()
					.collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().size()));
			return result;
		} else {
			return new HashMap<>();
		}

	}

	/**
	 * Returns map of average of selected attribute(T) of E for each grouped
	 * attribue of(K) E
	 * 
	 * @param <E>               the type of the input elements
	 * @param <K>               grouping attribute K in E
	 * @param <T>               select attribute T in E
	 * @param collectionFactory a supplier providing a new empty {@code Collection}
	 *                          into which the results will be inserted
	 */

	public static <E, K> Map<K, Double> getAverageOfItemsGroupedByK(List<E> list, Function<E, K> groupingKey,
			Function<E, Integer> selectKey)

	{
		if (list != null) {

			Map<K, Collection<Integer>> map = getCollectionOfTgroupedByK(list, groupingKey, selectKey,
					ArrayList<Integer>::new);

			Map<K, Double> result = map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,
					e -> e.getValue().stream().collect(Collectors.averagingLong(Integer::new))));
			return result;
		} else {
			return new HashMap<>();
		}

	}

}
