<template>
  <div class="favorite-card"  @click="redirectToProgramDetails">
      <h3>{{ favoriteProgramId }}</h3>
      <h4>{{ favoriteProgram.name }}</h4>
      <h5>{{ favoriteProgram.description}}</h5>
  </div>
</template>

<script>
export default {
    props: ["favoriteProgram", "favoriteProgramId" ],

    methods: {
    redirectToProgramDetails() {
      let routerUrl = '/program-details/' + this.favoriteProgram.id
      this.$router.push({path: routerUrl})
    }
  },
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