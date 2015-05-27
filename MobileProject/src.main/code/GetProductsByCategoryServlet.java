package code;

import hibernate.ProductManager;
import hibernate.Products;
import hibernate.productTuple;

import java.io.IOException;
import java.util.ArrayList;
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
		
		ArrayList<productTuple> output = new ArrayList<productTuple>();
		output = ProductManager.getProductsListByCategory(category);
		
		//Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		Gson gson = new Gson();
		
		/*System.out.println("Inside getProd... : "+((productTuple)output.get(0)).getP_name() + "\t" +
				((productTuple)output.get(0)).getS_name() + "\t" +
				((productTuple)output.get(0)).getPrice());
				*/
		
		JsonElement element = gson.toJsonTree(output, new TypeToken<List<productTuple>>(){}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
		
		//String jsonArray = gson.toJson(output);
		
		System.out.println(jsonArray);
		
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}
}