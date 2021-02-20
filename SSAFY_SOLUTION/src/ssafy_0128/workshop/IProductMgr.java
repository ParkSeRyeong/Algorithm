package ssafy_0128.workshop;

import java.util.ArrayList;


public interface IProductMgr {
	public void add(Product p);

	public ArrayList<Product> getList();

	public boolean delete(int pno);

	public Product searchByNo(int pno);

	public ArrayList<Product>  searchByPrice(int price);

	public ArrayList<Product>  searchByPname(String pname);

	public ArrayList<Product>  getTV();

	public ArrayList<Product>  getRefrigerator();

	public int[] getTotal();

	public ArrayList<Product>  getRefrigeratorOver400();

	public ArrayList<Product>  getTVOver50();
	
	public void updateCost(int pno, int cost);
	
}
