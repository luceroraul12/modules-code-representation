package single;

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

        BufferedImage imageCreated = Barcode.generateByProduct("1", "Granola con miel y avena");

        ImageIO.write(imageCreated, "JPG", file);

    }
}