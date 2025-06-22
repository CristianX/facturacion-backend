package com.cristianx.backend_facturacion.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.cristianx.backend_facturacion.models.Factura;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class ReporteService {

    public ByteArrayInputStream generarReporteFacturas(List<Factura> facturas) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            document.add(new Paragraph("Reporte de Facturas"));
            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(4);
            table.addCell("ID");
            table.addCell("Cliente");
            table.addCell("Fecha");
            table.addCell("Total");

            for (Factura factura : facturas) {
                table.addCell(factura.getId().toString());
                table.addCell(factura.getCliente().getNombre());
                table.addCell(factura.getFecha().toString());
                table.addCell(factura.getTotal().toString());
            }

            document.add(table);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
