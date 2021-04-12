<template>
  <div class="favorite-card">
      Component FavoriteCard
      <h1>{{ favorite }}</h1>
  </div>
</template>

<script>
export default {
    props: ["favorite"]
    
}
</script>

<style>
.favorite-card {
  background-color: lightgray;
  margin-bottom: 20px;
  padding: 10px;
  font-family: 'Arial';
  border-radius: 30px;
  border: 5px solid whitesmoke;
}
</style>