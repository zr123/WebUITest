# language: de
@run
Funktionalität: blog

  Szenario: Ich siehe mir den Blog an
    Wenn ich auf dem Blog bin
    Dann möchte ich die neusten Blogeinträge sehen

  Szenario: Ich kann die Blogeinträge nach Kategorie filtern
    Wenn ich auf dem Blog bin
    Und ich den Filter "Politik" auswähle
    Und den Filter anwende
    Dann möchte ich Einräge der Kategorie "Politik" sehen
    Und ich möchte keine Einträge außer "Politik" sehen

  Szenariogrundriss: Ein Benutzer loggt sich ein
    Wenn ich auf der Loginseite bin
    Und ein Benutzer seinen <Name> und sein <Passwort> eingibt
    Und er auf "Einloggen" klickt
    Dann soll er eingeloggt werden wenn es <Stimmt>
    Und er soll nicht eingeloggt werden wenn es nicht <Stimmt>

    Beispiele:
      | Name        | Passwort        | Stimmt  |
      | John        | 123456          | Ja      |
      | Eve         | password        | Ja      |
      | John        | 12345           | Nein    |
