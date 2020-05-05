package FactoryDesing;

import java.io.File;

public class ReadWriteMainClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filetype = "xls";
		File rfile = new File("txt");
		File wfile = new File("xls");
		GetClassObjectFactory gcf = new GetClassObjectFactory();
		if (filetype.equalsIgnoreCase("pdf")) {
			PdfFile pdffile = (PdfFile) gcf.getClassObject("pdf");
			pdffile.readWriteFile(rfile, null);
		} else if (filetype.equalsIgnoreCase("xls")) {
			XlsFile xls = (XlsFile) gcf.getClassObject("xls");
			xls.readWriteFile(rfile, wfile);
		}
	}
}