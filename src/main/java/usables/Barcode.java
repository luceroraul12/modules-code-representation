package usables;

import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

import java.awt.image.BufferedImage;

public class Barcode {
    public static BufferedImage generateByProduct(String id, String name)
            throws BarcodeException, OutputException {
        net.sourceforge.barbecue.Barcode barcode = BarcodeFactory.createCode128(id);

        barcode.setResolution(200);
        barcode.setBarWidth(5);
        barcode.setLabel(name +" @ "+id);
        return BarcodeImageHandler.getImage(barcode);
    }
}
