package pdfReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.Assert;

public class Pdfreader {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Gowth\\Downloads\\Gowtham_142272863.pdf");
		FileInputStream fis= new FileInputStream(file);
		PDDocument pdfdocument = PDDocument.load(fis);
		int count = pdfdocument.getPages().getCount();
		System.out.println("Page Count is: "+ " " +count);
		PDFTextStripper pdftext = new PDFTextStripper();
		pdftext.setStartPage(1);
		pdftext.setEndPage(3);
		String documenttext = pdftext.getText(pdfdocument);
		System.out.println(documenttext);
		Assert.assertTrue(documenttext.contains("Gowthamsvcet2k15@gmail.com"));
		
		
		pdfdocument.close();
		fis.close();
		
		
		
	}

}
