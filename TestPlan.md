# Testplan – DiceGame

Här dokumenteras manuella testfall för spelet. Testfallen beskriver vad som ska kontrolleras; de är inte automatiska tester.

## Testfall

Sätt status till **Godkänd** eller **Underkänd** efter att testet har körts. Skriv gärna det faktiska resultatet eller en avvikelse i kommentarskolumnen. Lämna status som **Ej körd** tills testet faktiskt har genomförts.

| ID   | Funktion                                   | Steg och indata                                                 | Förväntat resultat                                                            | Status  | Kommentar |
| ---- | ------------------------------------------ | --------------------------------------------------------------- | ----------------------------------------------------------------------------- | ------- | --------- |
| T-01 | Starta ett spel                            | Starta spelet. Ange `1` runda, `2` sidor och ett giltigt namn.  | Spelet visar sammanfattningen och ber om en gissning mellan 1 och 2.          | Godkänd |           |
| T-02 | Ogiltigt antal rundor: text                | Vid frågan om antal rundor, ange `abc`, följt av `1`.           | Texten avvisas, spelet ber om ett giltigt heltal och accepterar därefter `1`. | Ej körd |           |
| T-03 | Ogiltigt antal rundor: noll eller negativt | Ange `0` eller ett negativt tal som antal rundor, följt av `1`. | Värdet avvisas eftersom minst en runda krävs.                                 | Ej körd |           |
| T-04 | Ogiltigt antal sidor                       | Ange `abc` eller `1` som antal sidor, följt av `2`.             | Ogiltiga värden avvisas. Spelet accepterar `2` eller ett större heltal.       | Ej körd |           |

## Begränsningar

Tärningen använder slumpmässiga värden. Därför kan test av poäng och vinstvillkor vara svåra att upprepa med exakt samma resultat manuellt. Testerna T-10 till T-12 kan behöva köras flera gånger. För reproducerbara automatiska tester skulle spelet behöva kunna styra eller ersätta slumpvärdet under test.
