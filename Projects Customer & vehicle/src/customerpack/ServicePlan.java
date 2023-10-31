package customerpack;

public enum ServicePlan {

	GOLD(200),SILVER(1000),DIAMAND(5000),PLATINUM(10000);
	private int cost;
	private ServicePlan(int cost) {
	this.cost = cost;
	}
	
	public int getcost()
	{
		return this.cost;
	}
}
