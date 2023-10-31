package ShowroomManagment;

public enum Color {
	WHITE(5000), BLACK(10000), BLUE(7500), SILVER(8000), RED(15000);
	private int amt;
	private Color(int cost)
	{
		amt = cost;
	}
	public int getAmt() {
		return amt;
		
	
	
	}
	
	public String equalsc(Color c)
	{
		if(this.name()==c.name())
		{
			return c.name();
		}
		return c.name();
	}
	
}
