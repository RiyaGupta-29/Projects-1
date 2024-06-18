package Expense;

class Log{
    String date;
    String item;
	double cost;
	Log(){
        date=null;
        item= null;
        cost= 0.0d;
	}
	Log(String date,String item,double cost){
		this.date=date;
		this.item=item;
		this.cost=cost;
	}
	public void Setdate(String date){
		this.date=date;
       }
	public void Setitem(String item){
		this.item=item;
	}

	
	public void Setcost(double cost){
		this.cost=cost;
        }
    
	public String getdate(){
		return date;
	}
	public String getitem(){
		return item;
	}
	public double getcost(){
		return cost;
	}
	
}