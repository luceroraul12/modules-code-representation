package multi;

import entities.Product;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MultiBarcodeProductTest {

    @Test
    void createPdf() throws IOException {

        File file = new File("products.pdf");
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            products.add(
                    new Product(Integer.toString(i), "producto-"+i)
            );
        }


        PDDocument pdf = MultiBarcodeProduct.createPdf(products);
        pdf.save(file);

    }
}