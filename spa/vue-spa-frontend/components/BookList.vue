<template>
  <div>
    <a v-on:click="fetchList()" class="btn btn-success">Update Book List</a>
    <div class="books-list">
      <BookListItem v-for="book in books" v-bind:key="book.id" :book="book"/>
    </div>
  </div>
</template>

<script>
export default {
  name: 'BookList',
  data() {
    return {
      books: [],
    }
  },
  methods: {
    async fetchList() {
      this.books = await this.$axios.$get('/book');
    },
  },
}
</script>
