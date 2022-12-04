package single;

import entities.Product;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

import java.awt.image.BufferedImage;

public class Barcode {
    public static BufferedImage generateByProduct(Product product)
            throws BarcodeException, OutputException {
        net.sourceforge.barbecue.Barcode barcode = BarcodeFactory.createCode128(product.getId());

        barcode.setResolution(200);
        barcode.setBarWidth(5);
        barcode.setLabel(product.getName() +" @ "+product.getId());
        return BarcodeImageHandler.getImage(barcode);
    }
}
