package usables;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

import java.awt.image.BufferedImage;

public class Barcode {
    public static BufferedImage generateByProduct(String id, String name) {
        Code128Bean generator = new Code128Bean();
        BitmapCanvasProvider canvas =
                new BitmapCanvasProvider(200, BufferedImage.TYPE_BYTE_BINARY, false, 0);

        String barcodeText = name +"@"+ id;

        generator.generateBarcode(canvas, barcodeText);
        return canvas.getBufferedImage();
    }
}
