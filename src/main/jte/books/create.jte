@param org.example.webbprojektspringboot26.dtos.CreateBookDTO book
@param org.springframework.validation.BindingResult errors

<!DOCTYPE html>
<html lang="sv-SE">
<head>
    <meta charset="UTF-8">
    <title>Skapa ny bok</title>
    <link rel="stylesheet" href="/css/theme.css">
</head>
<body>

<h1>Skapa en ny bok</h1>

<div class="form-container">
    <form action="/books" method="post">

        <!-- Titel -->
        <label for="title">Titel</label>
        <input type="text" id="title" name="title"
               class="${errors != null && errors.hasFieldErrors("title") ? "input-error" : ""}"
               value="${book.getTitle()}">
        @if(errors != null && errors.hasFieldErrors("title"))
            <span class="field-error">${errors.getFieldError("title").getDefaultMessage()}</span>
        @endif

        <!-- Författare -->
        <label for="author">Författare</label>
        <input type="text" id="author" name="author"
               class="${errors != null && errors.hasFieldErrors("author") ? "input-error" : ""}"
               value="${book.getAuthor()}">
        @if(errors != null && errors.hasFieldErrors("author"))
            <span class="field-error">${errors.getFieldError("author").getDefaultMessage()}</span>
        @endif

        <!-- Beskrivning -->
        <label for="description">Beskrivning</label>
        <textarea id="description" name="description"
                  class="${errors != null && errors.hasFieldErrors("description") ? "input-error" : ""}">${book.getDescription()}</textarea>
        @if(errors != null && errors.hasFieldErrors("description"))
            <span class="field-error">${errors.getFieldError("description").getDefaultMessage()}</span>
        @endif

        <!-- Publiceringsdatum -->
        <label for="publishDate">Publiceringsdatum</label>
        <input type="date" id="publishDate" name="publishDate"
               class="${errors != null && errors.hasFieldErrors("publishDate") ? "input-error" : ""}"
               value="${book.getPublishDate() != null ? book.getPublishDate().toString() : ""}">
        @if(errors != null && errors.hasFieldErrors("publishDate"))
            <span class="field-error">${errors.getFieldError("publishDate").getDefaultMessage()}</span>
        @endif

        <!-- ISBN -->
        <label for="isbn">ISBN</label>
        <input type="text" id="isbn" name="isbn"
               class="${errors != null && errors.hasFieldErrors("isbn") ? "input-error" : ""}"
               value="${book.getIsbn()}">
        @if(errors != null && errors.hasFieldErrors("isbn"))
            <span class="field-error">${errors.getFieldError("isbn").getDefaultMessage()}</span>
        @endif

        <button type="submit">Spara bok</button>

    </form>
</div>

<div class="button-container">
    <a href="/index" class="button">Startsida</a>
</div>

</body>
</html>
