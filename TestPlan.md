# Testplan – DiceGame

Här dokumenteras manuella testfall för spelet. Testfallen beskriver vad som ska kontrolleras; de är inte automatiska tester.

## Testfall

Sätt status till **Godkänd** eller **Underkänd** efter att testet har körts. Skriv gärna det faktiska resultatet eller en avvikelse i kommentarskolumnen. Lämna status som **Ej körd** tills testet faktiskt har genomförts.

### Spelstart och inmatning

| ID   | Testfall                     | Indata                            | Förväntat resultat                                        | Status |
| ---- | ---------------------------- | --------------------------------- | --------------------------------------------------------- | ------ |
| T-01 | Starta spel                  | 1 runda, 2 sidor, giltigt namn    | Sammanfattning visas och spelaren ombeds gissa mellan 1–2 | ✅     |
| T-02 | Ogiltigt antal rundor (text) | `abc`, sedan `1`                  | Text avvisas och nytt värde efterfrågas                   | ✅     |
| T-03 | Ogiltigt antal rundor (≤0)   | `0` eller negativt tal, sedan `1` | Värdet avvisas                                            | ✅     |
| T-04 | Ogiltigt antal sidor         | `abc` eller `1`, sedan `2`        | Ogiltigt värde avvisas                                    | ✅     |
| T-05 | Tomt namn                    | Tom inmatning, sedan giltigt namn | Tomt namn avvisas                                         | ✅     |
| T-06 | Namn med ogiltiga tecken     | `123`, sedan giltigt namn         | Namnet avvisas                                            | ✅     |
| T-07 | Giltigt namn                 | `Anna`, `Åsa`, `Pelle-Maria`      | Namnet accepteras                                         | ✅     |

### Gissningar

| ID   | Testfall                     | Indata                   | Förväntat resultat                  | Status |
| ---- | ---------------------------- | ------------------------ | ----------------------------------- | ------ |
| T-08 | Gissning inte heltal         | `abc`, sedan giltigt tal | Ny gissning efterfrågas             | ✅     |
| T-09 | Gissning utanför intervallet | `0` eller för högt tal   | Värdet avvisas                      | ✅     |
| T-10 | Rätt/fel gissning            | Spela flera rundor       | Poäng ökar endast vid rätt gissning | ✅     |

### Spelflöde

| ID   | Testfall                      | Indata               | Förväntat resultat           | Status |
| ---- | ----------------------------- | -------------------- | ---------------------------- | ------ |
| T-11 | Begränsat antal rundor        | 1 runda              | Spelet avslutas efter rundan | ✅     |
| T-12 | Vinst vid 10 poäng            | Nå 10 poäng          | Vinnarmeddelande visas       | ✅     |
| T-13 | Ogiltigt svar på "Spela igen" | `kanske`, sedan `no` | Frågan ställs på nytt        | ✅     |
| T-14 | Spela igen                    | `yes` eller `y`      | Ny spelomgång startar        | ✅     |
| T-15 | Avsluta spelet                | `no` eller `n`       | Spelet avslutas              | ✅     |

## Begränsningar

Tärningen använder slumpmässiga värden. Därför kan test av poäng och vinstvillkor vara svåra att upprepa med exakt samma resultat manuellt. Testerna T-10 till T-12 kan behöva köras flera gånger. För reproducerbara automatiska tester skulle spelet behöva kunna styra eller ersätta slumpvärdet under test.
