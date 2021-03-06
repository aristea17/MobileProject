package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javaClasses.ProductTuple;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProductManager;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

@SuppressWarnings("serial")
public class GetProductsByCategoryServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		/* Get list of ProductTuple object based on Category and return a jsonArray of ProductTuple objects */
		String category = request.getParameter("categoryname");
		String department = request.getParameter("departmentname");
		
		ArrayList<ProductTuple> output = new ArrayList<ProductTuple>();
		output = ProductManager.getProductsListByCategory(department, category);
		
		Gson gson = new Gson();
		
		JsonElement element = gson.toJsonTree(output, new TypeToken<List<ProductTuple>>(){}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
		
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}
}