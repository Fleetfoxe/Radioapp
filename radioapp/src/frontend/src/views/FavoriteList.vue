<template>
<h2 v-if="!isLoggedIn">User not logged in, 
<router-link to="/Login">Login</router-link>
to se favorites
</h2>
    <div v-if="isLoggedIn">
    <div v-if="favoritePrograms.length > 0">
      <FavoriteCard
        v-for="(favoriteProgram, i) in favoritePrograms"
        :key="favoriteProgram + i"
        :favoriteProgram="favoriteProgram"
        :favoriteProgramId="favoriteProgram.id"
         />
        </div>
    </div>
</template>

<script>
import FavoriteCard from "../components/FavoriteCard";
export default {
   
components: {
    FavoriteCard
},
computed: {
    favoritePrograms() {
            return this.$store.getters.getFavoritePrograms
        },
    loggedInUser() {
      return this.$store.state.loggedInUser
    },
    isLoggedIn() {
      return this.loggedInUser != null
    },
},
methods: {
    async fetchFavorites() {
            let favoriteProgramFromBackend = await fetch('/rest/programs/favorites', {
                mode: 'no-cors',
            })
            favoriteProgramFromBackend = await favoriteProgramFromBackend.json()
            console.log('Favorite objects from backend: '+ favoriteProgramFromBackend)
            this.$store.commit("setFavoritePrograms", favoriteProgramFromBackend)
        }
},
    mounted() {
        this.fetchFavorites()
        //this.$store.dispatch("fetchFavorites");
    }
}
</script>

<style>

</style>