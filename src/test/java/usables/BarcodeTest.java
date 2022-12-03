package usables;

import com.google.zxing.WriterException;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class BarcodeTest {

    @Test
    void generateEAN13BarcodeImage() throws WriterException, IOException {
        File file = new File("test.jpg");

        String text = "homito uwu";
        BufferedImage imageCreated = Barcode.generateForIdProduct(text);

        ImageIO.write(imageCreated, "JPG", file);

    }
}