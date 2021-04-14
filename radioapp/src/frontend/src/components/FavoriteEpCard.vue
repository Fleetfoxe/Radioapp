<template>
  <div class="favorite-episode-card">
      <h4>{{ favoriteEpisode.title }}</h4>
      <h4>{{ ourDate }}</h4>
  </div>
</template>

<script>
export default {
    props: ["favoriteEpisode", "favoriteEpisodeId" ],

    computed: {
      ourDate() {
        return new Date(this.favoriteEpisode.startTimeUtc).toLocaleString();

      }
    }
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