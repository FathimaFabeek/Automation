package test1;

public class Employe 
{
	private String name;
	private int id;
	private String designation;
	int salary;
	

	public String getName() 
	{
		return name;
	}


	public void setName(String name) 
	{
		this.name = name;
	}


	public int getId()
	{
		return id;
	}


	public void setId(int id) 
	{
		this.id = id;
	}


	public String getDesignation() 
	{
		return designation;
	}


	public void setDesignation(String designation)
	{
		this.designation = designation;
	}


	public int getSalary()
	{
		return salary;
	}


	public void setSalary(int salary) 
	{
		this.salary = salary;
	}


	public static void main(String[] args)
	{
		Employe obj=new Employe();
		obj.setName("fathima");
		obj.setId(1);
		obj.setDesignation("Tester");
		obj.setSalary(10000);
		System.out.println("Emplolyee Details are \n"+obj.getName()+"-"+obj.getId()+"-"+obj.getDesignation()+"-"+obj.getSalary());



	}

}
