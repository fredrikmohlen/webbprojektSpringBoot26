@param java.util.List<org.example.webbprojektspringboot26.dtos.BookViewDTO> books
<!DOCTYPE html>
<html lang="sv-SE">
<head>
    <meta charset="UTF-8">
    <title>Boklista</title>
    <link rel="stylesheet" href="css/theme.css">
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            font-family: Arial, sans-serif;
        }
        th, td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }
        tr:hover {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>

<h1>Alla böcker</h1>

<table>
    <thead>
    <tr>
        <th>Titel</th>
        <th>Författare</th>
        <th>Beskrivning</th>
        <th>Publiceringsdatum</th>
    </tr>
    </thead>
    <tbody>
    @for(var book : books)
        <tr>
            <td>${book.getTitle()}</td>
            <td>${book.getAuthor()}</td>
            <td>${book.getDescription()}</td>
            <td>${book.getPublishDateFormatted()}</td>
        </tr>
    @endfor
    </tbody>
</table>
<div class="button-container">
    <a href="/books/create" class="button">Skapa en ny book</a>
    <a href="/index" class="button">Startsida</a>
</div>

</body>
</html>
