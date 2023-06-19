<template>
  <div class="book-card template-block">
    <div class="book-header">
      <h3 class="book-name">
        <NuxtLink :to="{name: 'book-id', params: {id: book.id} }">{{ book.name }} ({{ book.id }})</NuxtLink>
      </h3>
      <div class="book-delete-icon"><a v-on:click="deleteBook(book.id)" class="text-danger">X</a></div>
      <div class="clearfix"></div>
    </div>
    <div class="book-description">{{ book.description }}</div>
  </div>
</template>

<script>
export default {
  name: 'BookListItem',
  props: ['book'],
  methods:{
    async deleteBook(id) {
      await this.$axios.$delete('/book/' + id);
    },
  },
}
</script>
