package code;

import hibernate.ProductManager;
import hibernate.Products;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

@SuppressWarnings("serial")
public class GetProductsByCategoryServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String category = request.getParameter("categoryname");
		System.out.println(category);
		
		List<Object[]> products = ProductManager.getProductsListByCategory(category);
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		
		JsonElement element = gson.toJsonTree(products, new TypeToken<List<Object>>(){}.getType());
		
		JsonArray jsonArray = element.getAsJsonArray();
		System.out.println(jsonArray);
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}
}