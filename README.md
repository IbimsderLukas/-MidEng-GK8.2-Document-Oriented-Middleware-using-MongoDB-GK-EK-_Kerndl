# MidEng GK8.2 Document Oriented Middleware using MongoDB [GK/EK]

- Grundlagen Anforderungen **"überwiegend erfüllt"**
  - Installation und Konfiguration einer dokumentenorientierten Middleware mit einem Framework Ihrer Wahl und MongoDB
  - Entwurf und Umsetzung einer entsprechenden JSON Datenstruktur
  - Speicherung der Daten von nur einem Lagerstandort
  - Speicherung der Daten in einer MongoDB Datenbank in der Zentrale
    - mindestens 10 Produkte in 3 Produktkategorien
  - REST API:
    - POST /product, GET /product, GET /warehouse
  - Beantwortung der Fragestellungen

Ich habe das Github Repository vom Lerhrer Gecloned und habe einen MongoDB Docker Container erstellt.

Die Umsetzung der Json Datenstrucktur war berreits gegeben und es werden Elemente wie folgt gespeichert

```java
repository.save(new ProductData("1","00-443175","Bio Orangensaft Sonne","Getraenk", 2500));
```

Dadurch wird ein Json direkt in die Datenbank gespeichert und wir bei einem erneuten start nicht doppelt gespeichert. Das liegt an der Produkt ID. Mit der hilfe von dem Command habe ich 13 Produkte mit 3 verschiedenen Typen in 2 Warehäusern gespeichert. Die warehäuse werden auch bei start des Programmes einzeln aussgegeben, das heißt man sieht welches Produkt in welchem warehouse vorhanden ist.

![](file://C:\Users\lukas.dumbo\AppData\Roaming\marktext\images\2025-04-29-15-07-03-image.png?msec=1745932023830)

Hier kann man in cmd sehen das die Mongo db lokal läuft und man auch auf die Datenbank warehouse db und die Collections productData zugreifen kann.

Get products funktion in Postman

![](file://C:\Users\lukas.dumbo\AppData\Roaming\marktext\images\2025-04-29-14-37-44-image.png?msec=1745930264787)

Get warehouse funktion in Postman

![](file://C:\Users\lukas.dumbo\AppData\Roaming\marktext\images\2025-04-29-15-13-53-image.png?msec=1745932433589)

Post product funktion in Postman

![](file://C:\Users\lukas.dumbo\AppData\Roaming\marktext\images\2025-04-29-15-14-34-image.png?msec=1745932474201)

#### Beantwortung der Fragestellungen

**Vorteile von NoSQL vs. relationalem DBMS**

- Flexible Schema: Dokumente können unterschiedliche Felder haben.
  
- Hohe Skalierbarkeit: Einfach horizontales Sharding.
  
- Schnelle Lese-/Schreibzugriffe bei großen Datensätzen.
  
- Native JSON-Unterstützung für moderne Web-APIs.
  

**Nachteile von NoSQL vs. relationalem DBMS**

- Keine ACID-Transaktionen über mehrere Dokumente hinweg (meist nur eventual consistency).
  
- Weniger mächtige Abfragesprache (kein JOIN, eingeschränkte Aggregationen).
  
- Unterschiedliche APIs, kein einheitlicher Standard wie SQL.
  
- Oft weniger Reife bei Backup/Monitoring-Tools.
  

**Schwierigkeiten bei der Zusammenführung der Daten**

- Unterschiedliche Schemata erschweren Konsolidierung.
  
- Kein JOIN → manuelle Aggregation in der Anwendung.
  
- Eventual consistency kann zu Inkonsistenzen führen.
  
- Daten‐Duplikate und Konflikt-Resolution werden komplizierter.
  

**Arten von NoSQL-Datenbanken & je ein Vertreter**

- **Dokumentenorientiert** (z. B. MongoDB)
  
- **Key-Value-Store** (z. B. Redis)
  
- **Spaltenorientiert** (z. B. Apache Cassandra)
  
- **Graphdatenbank** (z. B. Neo4j)
  

**CAP-Theorem**

- **C (Consistency)**: Alle Knoten sehen immer dieselben Daten.
  
- **A (Availability)**: Jeder Request erhält eine Antwort (nicht unbedingt aktuell).
  
- **P (Partition Tolerance)**: System läuft trotz Netzwerkausfällen weiter.
  
- Kombis: CA (keine Partition Tolerance), CP (kein Always-Available), AP (kein sofortige Konsistenz).
  

**MongoDB-Shell-Befehle**

> Hinweis: Ersetze `productData` durch deine Collection, falls du einen anderen Namen nutzt.

- **Lagerstand eines Produkts über alle Standorte:**
  
  js
  
  KopierenBearbeiten
  
  `db.productData.find({ productID: "00-443175" }).pretty()`
  
- **Lagerstand eines Produkts an einem bestimmten Standort (z. B. Lager 1):**
  
  js
  
  KopierenBearbeiten
  
  `db.productData.find({ productID: "00-443175", warehouseID: "1" }).pretty()`
