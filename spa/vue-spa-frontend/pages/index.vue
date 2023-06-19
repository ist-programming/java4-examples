<template>
  <div>
    <!--  <NuxtLink to="/">Home page</NuxtLink>-->
    <BookList ref="mainList" :books="[{id: 42, name: 'Spring in Action', description: '123'}]"/>
  </div>
</template>

<script>
export default {
  name: 'IndexPage',
}
</script>

<style>
/* List of books */
.books-list {
  margin: 0 50px;
}

.books-list .book-card {
  margin: 30px 0px;
}

.books-list .book-description {
  text-indent: 30px;
}

.books-list .book-header a {
  color: #000;
}

.books-list .book-header a:hover {
  text-decoration: underline;
}

.books-list .book-header .book-info {
  color: #999;
}

.books-list .book-header .book-action-icon {
  float: right;
  font-size: 1.2em;
  font-weight: bold;
  margin: 0px 5px;
}
.books-list .book-header .book-delete-icon{
  cursor: pointer;
  display: inline-block;
  margin-left:30px;
}

.books-list .book-header .book-name {
  display: inline;
  font-style: italic;
  margin: 0px;
}

.books-list .book-header .book-name:first-letter {
  color: #933;
  font-size: 1.5em;
}

.books-list .book-header .book-url {
  margin-left: 5px;
  margin-right: 10px;
}
</style>

