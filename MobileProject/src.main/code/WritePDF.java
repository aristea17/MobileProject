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
			File file = new File("prova.pdf");
			FileOutputStream fileout = new FileOutputStream(file);
			Document document = new Document();
			PdfWriter.getInstance(document, fileout);
			
			document.addAuthor("Hotel");
			document.addTitle("Order");
			document.open();
			
			Paragraph p1 = new Paragraph();
			p1.add("This is p1");
			
			document.add(p1);
			
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