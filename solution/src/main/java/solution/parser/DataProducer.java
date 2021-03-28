package solution.parser;

import solution.model.Data;

// can be writtern more genric dataproducer
public class DataProducer {
	
	enum Attribute
	{
	customerId,
	contractId,
	geozone,
	teamcode,
	projectcode,
	buildduration;

	public final int value = ordinal();
	}

	static Data produce( String str )
	{
	String[] attributes = str.split(",");
	String buildDuration = attributes[Attribute.buildduration.value];
	buildDuration = buildDuration.substring(0, buildDuration.length()-1);
	Data data = new Data.DataBuilder().setCustomerId(attributes[Attribute.customerId.value])
	    .setContractId(Integer.parseInt(attributes[Attribute.contractId.value]))
	    .setGeoZone(attributes[Attribute.geozone.value])
	    .setTeamCode(attributes[Attribute.teamcode.value])
	    .setProjectCode(attributes[Attribute.projectcode.value])
	    .setBuildDuration(Integer.parseInt(buildDuration)).build();
	return data;
	}

}
