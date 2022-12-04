package multi;

import entities.Product;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.JPEGFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.vandeseer.easytable.OverflowOnSamePageTableDrawer;
import org.vandeseer.easytable.settings.HorizontalAlignment;
import org.vandeseer.easytable.settings.VerticalAlignment;
import org.vandeseer.easytable.structure.Row;
import org.vandeseer.easytable.structure.Table;
import org.vandeseer.easytable.structure.Table.TableBuilder;
import org.vandeseer.easytable.structure.cell.ImageCell;
import org.vandeseer.easytable.structure.cell.TextCell;
import single.Barcode;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

public class MultiBarcodeProduct {


    public static PDDocument createPdf(List<Product> products) throws IOException {
        PDDocument document = new PDDocument();

        OverflowOnSamePageTableDrawer.builder()
                .table(createTable(products, document))
                .startX(50)
                .lanesPerPage(2)
                .spaceInBetween(0)
                .endY(50F)
                .build()
                .draw(() -> document, () -> new PDPage(PDRectangle.A4), 50f);

        return document;
    }

    private static Table createTable(List<Product> products, PDDocument document){
        TableBuilder tableBuilder = Table.builder()
                .addColumnsOfWidth(250)
                .verticalAlignment(VerticalAlignment.MIDDLE)
                .horizontalAlignment(HorizontalAlignment.CENTER);

//        //About header
//        TextCell headerCell = TextCell.builder()
//                .text("Codigos de Barra")
//                .borderWidth(1F)
//                .build();
//
//        tableBuilder.addRow(Row.builder()
//                .add(headerCell)
//                .build());

        //About barcodes
        products.forEach(
                product -> {
                    BufferedImage barcode;
                    PDImageXObject image;

                    try {
                        barcode = Barcode.generateByProduct(product);
                        image = JPEGFactory.createFromImage(document, barcode);
                    } catch (BarcodeException | OutputException | IOException e) {
                        throw new RuntimeException(e);
                    }

                    ImageCell imageCell = ImageCell.builder()
                            .image(image)
                            .borderWidth(1)
                            .build();

                    tableBuilder.addRow(
                            Row.builder()
                                    .height(Float.parseFloat("70"))
                                    .add(imageCell)
                                    .build());
                }
        );


        return tableBuilder.build();

    }

}
