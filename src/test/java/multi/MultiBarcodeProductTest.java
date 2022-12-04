package multi;

import entities.Product;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MultiBarcodeProductTest {

    @Test
    void createPdf() throws IOException {

        File file = new File("products.pdf");
        List<Product> products = Arrays.asList(
                new Product("1","avena"),
                new Product("2","mani"),
                new Product("3","verduras"),
                new Product("4","frutos secos")
        );


        PDDocument pdf = MultiBarcodeProduct.createPdf(products);
        pdf.save(file);

    }
}