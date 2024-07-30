// AdapterPattern.java
interface NewPrinter {
    void printDocument(String text);
}

class OldPrinter {
    public void print(String text) {
        System.out.println("Old Printer: " + text);
    }
}

class PrinterAdapter implements NewPrinter {
    private OldPrinter oldPrinter;

    public PrinterAdapter(OldPrinter oldPrinter) {
        this.oldPrinter = oldPrinter;
    }

    @Override
    public void printDocument(String text) {
        oldPrinter.print(text);
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        OldPrinter oldPrinter = new OldPrinter();
        NewPrinter adapter = new PrinterAdapter(oldPrinter);
        adapter.printDocument("Hello from the adapter!");
    }
}
