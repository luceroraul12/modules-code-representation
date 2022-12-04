package usables;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class BarcodeTest {

    @Test
    void generateEAN13BarcodeImage() throws IOException {
        File file = new File("test.jpg");

        BufferedImage imageCreated = Barcode.generateByProduct("1324", "verdulerias");

        ImageIO.write(imageCreated, "JPG", file);

    }
}