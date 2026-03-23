@param String heroText
@param String quoteText

<!DOCTYPE html>
<html lang="sv-SE">
<head>
    <meta charset="utf-8">
    <title>Bokdatabas</title>
    <link rel="stylesheet" href="css/theme.css">
</head>
<body>

    <div class="hero">
        <h1>Välkommen till Bokdatabasen</h1>
        <p>${heroText}</p>
    </div>

    <div class="quote-box">
        <h3>Karaktären från min favorit bokserie:</h3>
        ${quoteText}
    </div>



    <div class="button-container">
        <a href="/books" class="big-button">Visa alla böcker</a>
        <a href="/books/create" class="big-button">Lägg till ny bok</a>
    </div>

</body>
</html>
