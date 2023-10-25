package com.microservices;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/PFD")
public class PdfClasse {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private ClasseRepository classeRepository;


    @GetMapping(value = "/GeneratePdf/{classId}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generatePdf(@PathVariable Long classId) throws IOException, DocumentException, SQLException {

        // Create a document object
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);

        // Create a byte array output stream
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // Create a PDF writer object
        PdfWriter.getInstance(document, baos);

        // Open the document
        document.open();



        Image logo = Image.getInstance("C:/Users/Malek Boughanmi/Documents/GitHub/University-Microservice/University-Project-main/Etudiant-service/src/main/resources/Logo.png");
        // Positionner le logo en haut à gauche de la page
        logo.setAbsolutePosition(20, 760);
        // Définir la largeur et la hauteur maximales
        float maxWidth = 60f;
        float maxHeight = 60f;
        // Redimensionner le logo pour qu'il s'adapte à la taille maximale
        logo.scaleToFit(maxWidth, maxHeight);


        String cl = classeRepository.findByNomClasse(classId);
        String texte = "Classe : " + cl;

        // Créer une police personnalisée pour le titre
        Font fontTitle = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, BaseColor.RED);
        fontTitle.setSize(28);
        Paragraph paragraph = new Paragraph(texte, fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(30);


        // Ajouter le logo au document
        document.add(logo);
        // Add content to the document
        document.add(paragraph);
        // Ajouter un saut de ligne après le titre
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("\n"));

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionetudiant", "root", "mysql");


        List<Etudiant> etudiants = etudiantRepository.findByClasseId(classId);


        // Créer une table pour afficher les données
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);
        // Ajouter des en-têtes de colonne à la table
        PdfPCell cell1 = new PdfPCell(new Phrase("Identifiant"));
        PdfPCell cell2 = new PdfPCell(new Phrase("Nom"));
        PdfPCell cell3 = new PdfPCell(new Phrase("Prenom"));
        PdfPCell cell5 = new PdfPCell(new Phrase("Mail"));
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        table.addCell(cell5);
        // Ajouter les données
        for (Etudiant etudiant : etudiants) {
            table.addCell(etudiant.getIdentifiant());
            table.addCell(etudiant.getNom());
            table.addCell(etudiant.getPrenom());
            table.addCell(etudiant.getMail());
        }


        // Ajouter la table au document PDF
        document.add(table);


        // Close the document
        document.close();

        // Set the response headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("inline", "Classe.pdf");

        // Return the response entity with the PDF content
        return new ResponseEntity<>(baos.toByteArray(), headers, HttpStatus.OK);
    }

}
