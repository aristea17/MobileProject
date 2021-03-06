package servlet;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProductManager;

@SuppressWarnings("serial")
public class GetCategoryServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		/* Get list of Categories based on Department and return a jsonArray of Strings */
		String department = request.getParameter("departmentname");
		List<String> category = ProductManager.getCategories(department);
		Gson gson = new Gson();
		
		JsonElement element = gson.toJsonTree(category, new TypeToken<List<String>>(){}.getType());
		
		JsonArray jsonArray = element.getAsJsonArray();
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}
}
