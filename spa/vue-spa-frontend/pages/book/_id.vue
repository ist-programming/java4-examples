<template>
  <div class="book-page">
    <NuxtLink to="/">Home page</NuxtLink>
    <BookDetail :book="book"/>
  </div>
</template>

<script>
export default {
  name: 'BookPage',
  data() {
    return {
      book: {},
    }
  },
  created: async function(){
    this.book = await this.$axios.$get('/book/' + this.$route.params.id);
  },
}
</script>

<style>
/* Standalone book page */
.book-page {
  font-size: 1.8em;
  margin: 0px 50px;
}

.book-page .book-card {
  margin: 5px 0px;
}

.book-page .book-description {
  text-indent: 30px;
}

.book-page .book-field {
  font-size: 0.7em;
}

.book-page .book-field .field-name {
  font-weight: bold;
}

.book-page .book-field .field-value {
}

.book-page .book-header .book-name {
  float: left;
  font-style: italic;
}

.book-page .book-header .book-name:first-letter {
  color: #993333;
  font-size: 1.5em;
}
</style>

