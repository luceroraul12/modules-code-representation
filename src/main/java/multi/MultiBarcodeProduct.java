package multi;

import entities.Product;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.vandeseer.easytable.OverflowOnSamePageTableDrawer;
import org.vandeseer.easytable.structure.Row;
import org.vandeseer.easytable.structure.Table;
import org.vandeseer.easytable.structure.Table.TableBuilder;
import org.vandeseer.easytable.structure.cell.TextCell;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class MultiBarcodeProduct {


    public static void createPdf(List<Product> products) throws IOException {
        PDDocument document = new PDDocument();

        OverflowOnSamePageTableDrawer.builder()
                .table(createTable())
                .startX(50)
                .lanesPerPage(3)
                .spaceInBetween(25)
                .endY(50F)
                .build()
                .draw(() -> document, () -> new PDPage(PDRectangle.A4), 50f);
    }

    private static Table createTable(){
        TableBuilder tableBuilder = Table.builder()
                .addColumnOfWidth(60)
                .addColumnOfWidth(60);

        //About header
        TextCell headerCell = TextCell.builder()
                .text("Codigos de Barra")
                .backgroundColor(Color.blue)
                .borderWidth(1F)
                .build();

        tableBuilder.addRow(Row.builder().add(headerCell).build());

        //About barcodes
        for (int i = 0; i < 200; i++) {
            tableBuilder.addRow(
                    Row.builder()
                            .add(TextCell.builder()
                                    .text("a " + i)
                                    .borderWidth(1F)
                                    .build())
                            .add(TextCell.builder()
                                    .text("b " + i)
                                    .borderWidth(1F)
                                    .build())
                            .build());
        }

        return tableBuilder.build();

    }

}
