@param org.example.webbprojektspringboot26.books.Book book


<html>
<body>
<h1>Alla böcker</h1>

    <ul>
        @for(book : books)
            <li>
                ${book.title} av ${book.author}
            </li>
        @endfor
    </ul>
</body>
</html>
