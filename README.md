# Stock Report PDF

## Description
Stock Report PDF est une application Spring Boot qui génère un **rapport de stock des produits au format PDF**.  
Le rapport est basé sur un **template HTML** et converti en PDF via **OpenHTMLtoPDF**.  
Le projet utilise également **Thymeleaf** pour rendre le template dynamique.

---

## Fonctionnalités
- Génération d’un PDF contenant la liste des produits avec :  
  - Nom  
  - Catégorie  
  - Prix  
  - Quantité  
- Possibilité de filtrer ou personnaliser les produits à inclure dans le rapport.  
- Template HTML séparé pour faciliter la modification du design.  
- Téléchargement direct du PDF via un endpoint REST.

---

## Technologies utilisées
- Java 21  
- Spring Boot  
- Spring Data JPA  
- MySQL  
- Thymeleaf  
- OpenHTMLtoPDF  
- Lombok

---

## Installation et Utilisation

1. **Cloner le projet :**
```bash
- git clone https://github.com/ton-utilisateur/stock-report-pdf.git
- cd stock-report-pdf
- mvn spring-boot:run

2. **Endpoint pour générer le PDF :**
GET http://localhost:8080/report/pdf




Si tu souhaites tester avec des produits, tu peux remplir la base avec ces produit: 
INSERT INTO product (name, category, price, quantity) VALUES ('Produit 1', 'Catégorie A', 10.5, 100);
INSERT INTO product (name, category, price, quantity) VALUES ('Produit 2', 'Catégorie A', 20.0, 50);
INSERT INTO product (name, category, price, quantity) VALUES ('Produit 3', 'Catégorie B', 15.75, 200);
INSERT INTO product (name, category, price, quantity) VALUES ('Produit 4', 'Catégorie B', 30.0, 80);
