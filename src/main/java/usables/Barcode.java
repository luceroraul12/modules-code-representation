package usables;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

import java.awt.image.BufferedImage;

public class Barcode {
    public static BufferedImage generateForIdProduct(String barcodeText) {
        Code128Bean generator = new Code128Bean();

        BitmapCanvasProvider canvas =
                new BitmapCanvasProvider(200, BufferedImage.TYPE_BYTE_BINARY, false, 0);

        generator.generateBarcode(canvas, barcodeText);
        return canvas.getBufferedImage();
    }
}
