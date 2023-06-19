async function addBook(book){
    let block = bookListItemTemplate.cloneNode(true);
    let urlBlockLink = block.querySelector('.book-name a');
    let deleteBlockLink = block.querySelector('.book-delete-icon a');
    urlBlockLink.innerText = book.name;
    urlBlockLink.href = contextName + '/book/' + book.id;// Can we use better approach?
    block.setAttribute('data-id', book.id);
    deleteBlockLink.addEventListener('click', async function(e){
        e.preventDefault();
        let result = await fetch(contextName + "/api/v1/book/" + book.id,
            {method: 'DELETE'}
        );
        if(result.ok){
            block.remove();
        }
    });
    block.classList.remove('template-block');
    bookListBlock.append(block);
}

document.addEventListener('DOMContentLoaded', function(){
    bookListBlock = document.querySelector('.books-list');
    bookListItemTemplate = document.querySelector('.book-card.template-block');
    document.querySelector('.update-button').addEventListener('click', function(e){
        e.preventDefault();
        fetch(contextName + "/api/v1/book")
            .then(function(response){
               response.json().then(data => {
                   bookListBlock.replaceChildren();
                   for(const book of data){
                       addBook(book);
                   }
               });
            });
    });
});

