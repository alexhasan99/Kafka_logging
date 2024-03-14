# Kafka Logging System

Det här projektet är en enkel implementation av ett Kafka logging system med en producer- och en consumer-applikation. Producer-applikationen är ansvarig för att skicka loggmeddelanden till en Kafka-topic, medan consumer-applikationen konsumerar dessa meddelanden för bearbetning eller lagring.

## Innehållsförteckning
1. [Krav](#krav)
2. [Installation](#installation)
3. [Konfiguration](#konfiguration)
4. [Användning](#användning)
5. [Bidrag](#bidrag)
6. [Licens](#licens)

## Krav
För att köra detta projekt krävs följande förutsättningar:
- Java JDK installerat på din maskin
- Apache Kafka server tillgänglig för användning
- Docker (om du planerar att köra i containrar)

## Installation
1. Klona detta projekt till din lokala maskin genom att köra följande kommando i terminalen:
git clone https://github.com/alexhasan99/Kafka_logging
2. Navigera till den katalog där projektet är klont och byt till den `producer`-katalogen och `consumer`-katalogen för respektive applikation.

## Konfiguration
### Producer-applikation
1. Öppna filen `log4j2.xml` i `producer`-applikationen.
2. I konfigurationsfilen kan du se följande variabler som ska sättas:
- `sys:topic_name`: Kafka-ämnesnamn där loggmeddelanden ska skickas.
- `sys:kafka_server`: Adress till Kafka Bootstrap-servern.
3. Se till att dessa variabler är konfigurerade enligt ditt system. De kan sättas antingen direkt i `log4j2.xml`-filen eller genom systemvariabler som anges vid körning av applikationen.

### Consumer-applikation
1. Konfiguration för consumer-applikationen är enklare. Vid körning av containern eller applikationen måste du bara ange adressen till den Kafka-server där den ska lyssna på meddelanden.

## Användning
För consumer-applikationen, ange Kafka-serveradressen när du kör containern eller startar applikationen.

## Bidrag
Bidrag är välkomna! Om du vill bidra till detta projekt, följ dessa steg:
1. Forka projektet
2. Skapa en branch för dina ändringar (`git checkout -b feature/ny-funktion`)
3. Gör dina ändringar
4. Commita dina ändringar (`git commit -am 'Lägg till ny funktion'`)
5. Pusha till branchen (`git push origin feature/ny-funktion`)
6. Skapa en Pull Request


