package FactoryDesing;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Destination;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;

public class PdfFile extends Component {
	@Override
	public void readWriteFile(File rfile, File wfile) {
		try {
			System.out.println(" calling pdf logic");
			InputStream isA = new FileInputStream(rfile);
			OutputStream os = new FileOutputStream(wfile);
			byte[] buffer = new byte[1024];
			int bytesRead;
			// read from is to buffer
			while ((bytesRead = isA.read(buffer)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			isA.close();
			// flush OutputStream to write any buffered data to file
			os.flush();
			os.close();
			// Open the image file
			InputStream is = new BufferedInputStream(new FileInputStream(rfile));
			// create a PDF doc flavor
			DocFlavor flavor = DocFlavor.INPUT_STREAM.PDF;
			// Locate the default print service for this environment.
			PrintService service = PrintServiceLookup.lookupDefaultPrintService();
			// Create and return a PrintJob capable of handling data from
			// any of the supported document flavors.
			DocPrintJob printJob = service.createPrintJob();
			// register a listener to get notified when the job is complete
			printJob.addPrintJobListener(new JobCompleteMonitor());
			// Construct a SimpleDoc with the specified
			// print data, doc flavor and doc attribute set.
			Doc doc = new SimpleDoc(is, flavor, null);
			// set up the attributes
			PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();
			try {
				attributes.add(new Destination(new java.net.URI("C:/myfile.ps")));
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// Print a document with the specified job attributes.
			try {
				printJob.print(doc, attributes);
			} catch (PrintException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*
			 * while (jobRunning) {
			 * 
			 * Thread.sleep(1000);
			 * 
			 * }
			 */
			System.out.println("Exiting app");
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static class JobCompleteMonitor extends PrintJobAdapter {
		@Override
		public void printJobCompleted(PrintJobEvent jobEvent) {
			System.out.println("Job completed");
			// jobRunning = false;
		}
	}
}