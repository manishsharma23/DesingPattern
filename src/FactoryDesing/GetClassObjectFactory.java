package FactoryDesing;

class GetClassObjectFactory {
	public Object getClassObject(String fileType) {
		if (fileType == null) {
			System.out.println("pdf and xls....null");
			
			return null;
		}
		if (fileType.equalsIgnoreCase("PDF")) {
			System.out.println("pdf object....");
			return new PdfFile();
		}
		if (fileType.equalsIgnoreCase("xls") || fileType.equalsIgnoreCase("xl")) {
			System.out.println("xls and xl object....");
			return new XlsFile();
		}
		return null;
	}
}