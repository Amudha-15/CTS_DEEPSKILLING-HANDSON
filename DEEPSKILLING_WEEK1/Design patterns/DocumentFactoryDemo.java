interface Document { String getType(); }

class WordDocument implements Document { public String getType(){return "Word";} }
class PdfDocument implements Document { public String getType(){return "PDF";} }
class ExcelDocument implements Document { public String getType(){return "Excel";} }

abstract class DocumentFactory {
    public abstract Document createDocument();
}

class WordFactory extends DocumentFactory { public Document createDocument(){ return new WordDocument(); } }
class PdfFactory extends DocumentFactory { public Document createDocument(){ return new PdfDocument(); } }
class ExcelFactory extends DocumentFactory { public Document createDocument(){ return new ExcelDocument(); } }

public class DocumentFactoryDemo {
    public static void main(String[] args) {
        DocumentFactory f1 = new WordFactory();
        DocumentFactory f2 = new PdfFactory();
        System.out.println(f1.createDocument().getType());
        System.out.println(f2.createDocument().getType());
    }
}
