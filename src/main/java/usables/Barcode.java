package usables;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.EAN13Writer;

import java.awt.image.BufferedImage;

public class Barcode {
    public static BufferedImage generateForIdProduct(String barcodeText) throws WriterException {
        Code128Writer barcodeWriter = new Code128Writer();
        BitMatrix bitMatrix = barcodeWriter.encode(barcodeText, BarcodeFormat.CODE_128, 300, 150);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }
}
