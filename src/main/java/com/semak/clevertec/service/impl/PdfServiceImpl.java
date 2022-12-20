package com.semak.clevertec.service.impl;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.semak.clevertec.model.Receipt;
import com.semak.clevertec.service.PdfService;
import jakarta.servlet.ServletOutputStream;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class PdfServiceImpl implements PdfService {
    private static final String HEADER_RECEIPT = "CASH RECEIPT";

    private static final String HEADER_SMALL = "\nSUPERMARKET 123\n12, MILKYWAY Galaxy/ Earth\nTel: 123-456-7890";

    private static final String HEADER_DATE = "Date: ";
    private static final String HEADER_TIME = "Time: ";
    private static final String FOOTER_TOTAL = "Total: ";
    private static final String FOOTER_DISCOUNT = "Discount: -";
    private static final String CURRENCY_SIGN = "$";
    private static final String EMPTY_PARAGRAPH = " ";

    private static final Font HEADER_FONT = FontFactory.getFont(FontFactory.TIMES, 26, Font.BOLD);

    private static final Font HEADER_FONT_SMALL = FontFactory.getFont(FontFactory.TIMES, 16);

    private static final Font SUB_HEADER_FONT = FontFactory.getFont(FontFactory.TIMES, 20, Font.BOLD);
    private static final Font MAIN_FONT = FontFactory.getFont(FontFactory.TIMES, 13, Font.BOLD);

    private static final String[] TABLE_HEADERS = {"QTY", "DESCRIPTION", "PRICE", "TOTAL"};
    private static final int TABLE_CELL_PADDING = 5;

    private static final int VERTICAL_INDENT = 1;
    private static final int EXTRA_VERTICAL_INDENT = 2;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    @SneakyThrows
    private static void addHeader(Receipt receipt, Document document) {
        var header = new Paragraph();
        addEmptyLine(header, VERTICAL_INDENT);
        var title = new Paragraph(HEADER_RECEIPT, HEADER_FONT);
        title.setAlignment(Element.ALIGN_CENTER);
        header.add(title);
        var title_small = new Paragraph(HEADER_SMALL, HEADER_FONT_SMALL);
        title_small.setAlignment(Element.ALIGN_CENTER);
        header.add(title_small);
        addEmptyLine(header, VERTICAL_INDENT);
        var subTitle = new Paragraph(receipt.getDescription(), SUB_HEADER_FONT);
        subTitle.setAlignment(Element.ALIGN_CENTER);
        header.add(subTitle);
        var dateTime = receipt.getDate();
        var date = new Paragraph(HEADER_DATE + dateTime.format(DATE_FORMATTER), MAIN_FONT);
        date.setAlignment(Element.ALIGN_RIGHT);
        header.add(date);
        var time = new Paragraph(HEADER_TIME + dateTime.format(TIME_FORMATTER), MAIN_FONT);
        time.setAlignment(Element.ALIGN_RIGHT);
        header.add(time);
        addEmptyLine(header, EXTRA_VERTICAL_INDENT);
        document.add(header);
    }

    private static void addEmptyLine(Paragraph paragraph, int quantity) {
        for (int i = 0; i < quantity; i++) paragraph.add(new Paragraph(EMPTY_PARAGRAPH));
    }

    @SneakyThrows
    private static void addContent(Receipt receipt, Document document) {
        var table = new PdfPTable(TABLE_HEADERS.length);
        Stream.of(TABLE_HEADERS).forEach(title -> table.addCell(getCenteredCell(title)));
        table.setHeaderRows(VERTICAL_INDENT);
        receipt
                .getProduct()
                .forEach(
                        position -> {
                            table.addCell(getCenteredCell(position.getQuantity().toString()));
                            table.addCell(getCenteredCell(position.getName()));
                            table.addCell(getCenteredCell(CURRENCY_SIGN + position.getPrice().toString()));
                            table.addCell(getCenteredCell(CURRENCY_SIGN + position.getTotal().toString()));
                        });
        document.add(table);
    }

    private static PdfPCell getCenteredCell(String phrase) {
        var cell = new PdfPCell(new Phrase(phrase));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setPadding(TABLE_CELL_PADDING);
        return cell;
    }

    @SneakyThrows
    private static void addFooter(Receipt receipt, Document document) {
        var footer = new Paragraph();
        addEmptyLine(footer, VERTICAL_INDENT);
        var discount =
                new Paragraph(
                        FOOTER_DISCOUNT + CURRENCY_SIGN + receipt.getDiscount().toString(), SUB_HEADER_FONT);
        discount.setAlignment(Element.ALIGN_RIGHT);
        footer.add(discount);
        var total =
                new Paragraph(FOOTER_TOTAL + CURRENCY_SIGN + receipt.getTotal().toString(), HEADER_FONT);
        total.setAlignment(Element.ALIGN_RIGHT);
        footer.add(total);
        document.add(footer);
    }

    @Override
    @SneakyThrows
    public void generatePdf(Receipt receipt, ServletOutputStream outputStream) {
        var document = new Document();
        PdfWriter.getInstance(document, outputStream);
        document.open();
        addHeader(receipt, document);
        addContent(receipt, document);
        addFooter(receipt, document);
        document.close();
    }
}
