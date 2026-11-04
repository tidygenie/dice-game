# DiceGame

## Projekt 1 – Tärningsspel

Obligatorisk del – krav för godkänt

# Die

I den första delen ska ni modellera en tärning med hjälp av klassen Die. Tärningsklassen används sedan för att skapa ett enkelt tärningsspel. Tärningen ska ha två instansvariabler som beskriver själva tärningen: nuvarande värde och antal sidor (tärningens högsta möjliga värde). Klassen ska dessutom ha en privat variabel för en slumpgenerator av typen Random.

Antalet sidor ska anges i klassens konstruktor, vara av typen int och ha en gettermetod. Det nuvarande värdet ska vara av typen int, ha en gettermetod och ändras när metoden roll() anropas.

Slumpgeneratorn används av metoden roll(). Klassen Random importeras från java.util.Random.

Skapa metoden public void roll(). Den ska använda slumpgeneratorn för att ändra tärningens nuvarande värde till ett heltal från 1 till antalet sidor. Tips: Random har metoden nextInt(int maxValue), som ger ett heltal från 0 till maxValue - 1. Anpassa därför resultatet till tärningens värden.

# Player

Skapa klassen Player för att representera en spelare. Spelaren ska ha tre instansvariabler: namn, poäng och en tärning. Namnet ska anges i konstruktorn och ha en gettermetod. Poängen ska ha getter- och settermetoder. Tärningen ska vara av typen Die. I den obligatoriska delen har varje spelare en tärning.

Klassen Player ska ha följande metoder:
• rollDice(): Rullar spelarens tärning.
• getDieValue(): Returnerar värdet på spelarens tärning som ett heltal.
• increaseScore(): Ökar spelarens poäng med ett.
• addDie(int numberOfSides): Skapar en ny tärning med det angivna antalet sidor och tilldelar den till spelaren. I extra utmaning 1 kan klassen vidareutvecklas så att spelaren har flera tärningar.

# DiceGame

Skapa klassen DiceGame med en main()-metod så att programmet kan köras i terminalen. Använd beskrivningen nedan och klasserna Die och Player för att självständigt planera hur programmets delar ska samverka.

Spelregler – obligatorisk del (en spelare):
Programmet frågar hur många omgångar som ska spelas, hur många sidor tärningen ska ha och vad spelaren heter. Använd ett Scanner-objekt för inmatning via terminalen. I varje omgång gissar spelaren ett tal inom tärningens möjliga värden och rullar därefter tärningen. Om gissningen stämmer med tärningens värde får spelaren en poäng. Visa resultatet och den sammanlagda poängen. Spelet avslutas efter det valda antalet omgångar. Testa både korrekta och felaktiga inmatningar och dokumentera vad som händer. Fullständig hantering av felaktig inmatning krävs inte, men ni ska kunna beskriva beteendet och eventuella fel ni hittar.
För krav på testning, felsökning, Git, AI, dokumentation, bidragsrapport och redovisning gäller det separata dokumentet ”Projekt 1 –

# Beskrivning”. De frivilliga extra utmaningarna krävs inte för godkänt.

## Extra utmaning 1 – MultiplayerDiceGame (frivillig)

För en extra utmaning kan ni vidareutveckla DiceGame till MultiplayerDiceGame. Användaren väljer antal spelare, antal tärningar per spelare och antal omgångar. I varje omgång slår spelarna sina tärningar i tur och ordning. Summan av en spelares tärningar läggs till spelarens totala poäng. Efter det valda antalet omgångar vinner den eller de spelare som har högst totalpoäng. Observera att dessa spelregler skiljer sig från enspelarläget. Anpassa Player så att en spelare kan ha flera tärningar, exempelvis i en ArrayList<Die>.

### Hjälpmetoder

• private static ArrayList<Player> initialize(): Tar emot användarens val, skapar de objekt som behövs och returnerar en lista med spelare.
• private static void takeTurn(ArrayList<Player> players): Genomför en hel omgång genom att låta varje spelare slå sina tärningar, summera resultaten och uppdatera poängen.
• private static ArrayList<Player> getWinners(ArrayList<Player> players): Returnerar en lista med den eller de spelare som har högst totalpoäng. Flera spelare kan dela förstaplatsen.

## Extra utmaning 2 – PigGame (frivillig)

Skapa ett separat tärningsspel som heter Pig. Spelet spelas av två eller fler spelare med varsin sexsidig tärning. Spelarna turas om. Under sin tur slår spelaren tärningen och lägger resultatet i en tillfällig pott. Efter varje slag väljer spelaren att stanna eller fortsätta. Om spelaren stannar läggs potten till spelarens totalpoäng och turen går vidare. Om spelaren slår en etta förloras hela den tillfälliga potten och turen går vidare utan att poängen läggs till. Den första spelaren som når minst 100 poäng vinner.
