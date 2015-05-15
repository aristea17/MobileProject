package code;

import hibernate.ProductManager;
import hibernate.Products;
import java.io.IOException;
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
		List<Products> products = ProductManager.getProductsListByCategory();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		
		JsonElement element = gson.toJsonTree(products, new TypeToken<List<Products>>(){}.getType());
		
		JsonArray jsonArray = element.getAsJsonArray();
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}
}