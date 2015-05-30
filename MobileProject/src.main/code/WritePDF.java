package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class WritePDF {
	
	public static void main(String[] args){
		try {
			
			File file = new File("C:\\Users\\Tea\\Documents\\GitHub\\MobileProject\\MobileProject\\Orders\\order.pdf");
			FileOutputStream fileout = new FileOutputStream(file);
			Document document = new Document();
			PdfWriter.getInstance(document, fileout);
			
			document.addAuthor("Hotel");
			document.addTitle("Order");
			document.open();
			
			Paragraph p1 = new Paragraph();
			p1.add("Hello! This is our order for the day:\n\n");
			
			Paragraph p2 = new Paragraph();
			BuyProduct bp = new BuyProduct("pane", 2, 2.4, "Despar", "ibershimiaristea@yahoo.com");
			Order order = new Order(bp.getSupplierName(), bp.getSupplierEmail());
			order.add(bp);
			p2.add(order.stringMyOrder());
			
			Paragraph p3 = new Paragraph();
			p3.add("\nThank you!");
			
			document.add(p1);
			document.add(p2);
			document.add(p3);
			
			document.close();
			
			fileout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}