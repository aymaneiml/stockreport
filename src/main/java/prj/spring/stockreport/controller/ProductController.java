package prj.spring.stockreport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import prj.spring.stockreport.pdf.PdfGeneratorService;
import prj.spring.stockreport.service.ProductService;

@RestController
@RequestMapping("/report")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private PdfGeneratorService pdfGeneratorService;

    @GetMapping("/pdf")
    public ResponseEntity<byte[]> generateReport() {
        byte[] pdf = pdfGeneratorService.generatePdf(productService.getAllProducts());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=rapport-stock.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
}