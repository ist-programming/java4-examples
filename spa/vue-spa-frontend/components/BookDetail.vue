<template>
  <div class="book-page">
    <h1 class="book-name">{{ book.name }}</h1>
    <div class="book-field">
      <span class="field-name">Year:</span>
      <span class="field-value">{{ book.year }}</span>
    </div>
    <div class="book-field">
      <span class="field-name">ISBN:</span>
      <span class="field-value">{{ book.isbn }}</span>
    </div>
    <div class="book-field">
      <span class="field-name">Link:</span>
      <span class="field-value"><a :href="book.url" target="_blank">{{ book.url }}</a></span>
    </div>
    <div class="book-description">{{ book.description }}</div>
  </div>
</template>

<script>
export default {
  name: 'BookDetail',
  props: ['book']
}
</script>
