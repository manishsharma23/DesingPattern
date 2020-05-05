package FactoryDesing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class XlsFile extends Component {
	@Override
	public void readWriteFile(File rfile, File wfile) {
		// TODO Auto-generated method stub
		System.out.println(" calling xls logic");
		try {
			System.out.println(" calling xls logic");
			InputStream is = new FileInputStream(rfile);
			OutputStream os = new FileOutputStream(wfile);
			byte[] buffer = new byte[1024];
			int bytesRead;
			// read from is to buffer
			while ((bytesRead = is.read(buffer)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			is.close();
			// flush OutputStream to write any buffered data to file
			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}