package code;

import hibernate.ProductManager;
import hibernate.productTuple;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

@SuppressWarnings("serial")
public class GetProductsByCategoryServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String category = request.getParameter("categoryname");
		
		// Debug!
		System.out.println(category);
		
		ArrayList<productTuple> output = new ArrayList<productTuple>();
		output = ProductManager.getProductsListByCategory(category);
		
		Gson gson = new Gson();
		
		JsonElement element = gson.toJsonTree(output, new TypeToken<List<productTuple>>(){}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
		
		// Debug!
		//System.out.println(jsonArray);
		
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}
}