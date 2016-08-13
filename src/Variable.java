public class Variable{
	private String varType;
	private String name;
	
	public Variable(String varType, String name)
	{
		this.varType=varType;
		this.name=name;
	}
	
	public String getType()
	{
		return varType;
	}

	public String getName()
	{
		return name;
	}

	public String toString()
	{
		return "Type: "+ varType +"; Name: "+name;
	}
}