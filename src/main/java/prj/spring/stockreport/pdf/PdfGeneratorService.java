package prj.spring.stockreport.pdf;


import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

import prj.spring.stockreport.entity.Product;

@Service
public class PdfGeneratorService {

    @Autowired
    private TemplateEngine templateEngine;

    public byte[] generatePdf(List<Product> products) {

        try {
            Context context = new Context();
            context.setVariable("products", products);

            //genere le html final
            String finalHtml = templateEngine.process("report-template", context);

            //convertir en pdf
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            builder.withHtmlContent(finalHtml, null);
            builder.toStream(os);
            builder.run();

            return os.toByteArray();

        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la génération du PDF", e);
        }
    }

    
}