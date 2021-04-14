<template>
  <div class="favorite-episode-card">
      <h4>{{ favoriteEpisode.title }}</h4>
  </div>
</template>

<script>
export default {
    props: ["favoriteEpisode", "favoriteEpisodeId" ],
}
</script>

<style>
.favorite-episode-card {
  background-color: rgb(39, 37, 37);
  margin-bottom: 20px;
  padding: 10px;
  font-family: 'Arial';
  border-radius: 30px;
  border: 1px solid gray;
}
</style>