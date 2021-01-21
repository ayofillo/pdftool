package org.ayofill;

import lombok.SneakyThrows;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.File;
import java.util.Iterator;

public class PdfMain {

    @SneakyThrows
    public static void main(String[] args) {
        try (PDDocument document = PDDocument.load(new File("source.pdf"))) {

            if (!document.isEncrypted()) {

                Iterator<PDPage> iter = document.getPages().iterator();
                int c = 0;
                while (iter.hasNext()) {
                    try (PDDocument doc = new PDDocument()) {
                        doc.addPage(iter.next());
                        doc.save(String.format("file%d.pdf", c++));
                    }
                }

            }

        }

    }
}
