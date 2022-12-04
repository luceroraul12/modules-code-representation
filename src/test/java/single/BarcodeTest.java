package single;

import entities.Product;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class BarcodeTest {

    @Test
    void generateEAN13BarcodeImage()
            throws IOException, OutputException, BarcodeException {
        File file = new File("test.jpg");

        Product product = new Product("1", "Granola con miel y avena");

        BufferedImage imageCreated = Barcode.generateByProduct(product);

        ImageIO.write(imageCreated, "JPG", file);

    }
}