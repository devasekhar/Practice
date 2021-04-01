package solution.model;

/*
 * Data class has customerId,contractId,geozone,teamcode,projectcode and projectcode attributes
 * Builder pattern has been used to generate the Data object
 * This can be made Immutable Object
 */
public class Data implements IData {

	private String customerId;
	private int contractId;
	private String geozone;
	private String teamcode;
	private String projectcode;
	private int buildduration;

	public Data(DataBuilder builder) {
		this.customerId = builder.customerId;
		this.contractId = builder.contractId;
		this.geozone = builder.geozone;
		this.teamcode = builder.teamcode;
		this.projectcode = builder.projectcode;
		this.buildduration = builder.buildduration;
	}
	
	public String getData() {
		
      StringBuilder sb = new StringBuilder();
      
      if(!customerId.isEmpty())
      {
    	  sb.append(customerId);
      }
      
      if(contractId != 0)
      {
    	  sb.append(String.valueOf(contractId));
      }
      
      if(!geozone.isEmpty())
      {
    	  sb.append(geozone);
      }
      
      if(!teamcode.isEmpty())
      {
    	  sb.append(teamcode);
      }
      
      if(!projectcode.isEmpty())
      {
    	  sb.append(projectcode);
      }
      
      if(buildduration != 0)
      {
    	  sb.append(String.valueOf(buildduration));
      }
      
      return sb.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + buildduration;
		result = prime * result + contractId;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((geozone == null) ? 0 : geozone.hashCode());
		result = prime * result + ((projectcode == null) ? 0 : projectcode.hashCode());
		result = prime * result + ((teamcode == null) ? 0 : teamcode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		if (buildduration != other.buildduration)
			return false;
		if (contractId != other.contractId)
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (geozone == null) {
			if (other.geozone != null)
				return false;
		} else if (!geozone.equals(other.geozone))
			return false;
		if (projectcode == null) {
			if (other.projectcode != null)
				return false;
		} else if (!projectcode.equals(other.projectcode))
			return false;
		if (teamcode == null) {
			if (other.teamcode != null)
				return false;
		} else if (!teamcode.equals(other.teamcode))
			return false;
		return true;
	}

	public String getCustomerId() {
		return customerId;

	}

	public int getBuildDuration() {

		return buildduration;
	}

	public int getContractId() {
		return contractId;
	}

	public String getProjectCode() {

		return projectcode;
	}

	public String getTeamCode() {
		return teamcode;
	}

	public String getGeoZone() {
		return geozone;
	}

	public static class DataBuilder
	{
		private String customerId;
		private int contractId;
		private String geozone;
		private String teamcode;
		private String projectcode;
		private int buildduration;
	
		public DataBuilder()
		{
		
		}
		
		public DataBuilder setCustomerId(String customerId )
	    {
		    this.customerId = customerId;
		    return this;
	    }
	
		public DataBuilder setBuildDuration(int buildduration)
	    {
			this.buildduration = buildduration;
			return this;
	    }
	
		public DataBuilder setContractId(int contractId)
		{
			    this.contractId = contractId;
			    return this;
		}
		public DataBuilder setProjectCode(String projectcode)
	    {
		    this.projectcode = projectcode;
		    return this;
	    }
		public DataBuilder setTeamCode(String teamcode)
	    {
		    this.teamcode = teamcode;
		    return this;
	    }
		public DataBuilder setGeoZone(String geozone )
	    {
		    this.geozone = geozone;
		    return this;
	    }
	
	    public Data build()
	    {
	    	return new Data(this);
	    }
	}


}
