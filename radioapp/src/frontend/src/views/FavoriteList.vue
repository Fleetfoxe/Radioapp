<template>
<h2 v-if="!isLoggedIn">Please  
<router-link to="/Login">Login</router-link>
to see favorites
</h2>
    <div v-if="isLoggedIn">
        <h1>Favorite programs</h1>
    
    <div v-if="favoritePrograms.length > 0">
      <FavoriteCard
        v-for="(favoriteProgram, i) in favoritePrograms"
        :key="favoriteProgram + i"
        :favoriteProgram="favoriteProgram"
        :favoriteProgramId="favoriteProgram.id"
         />
        </div>

        <h1>Favorites episodes</h1>

    <div v-if="favoriteEpisodes.length > 0">
      <FavoriteEpisodeCard
        v-for="(favoriteEpisode, i) in favoriteEpisodes"
        :key="favoriteEpisode + i"
        :favoriteEpisode="favoriteEpisode"
        :favoriteEpisodeId="favoriteEpisode.id"
         />
        </div>

    </div>
</template>

<script>
import FavoriteCard from "../components/FavoriteCard";
import FavoriteEpisodeCard from "../components/FavoriteEpCard";

export default {
   
components: {
    FavoriteCard,
    FavoriteEpisodeCard,
},
computed: {
    favoritePrograms() {
            return this.$store.getters.getFavoritePrograms
        },
    favoriteEpisodes() {
            return this.$store.getters.getFavoriteEpisodes
        },
    loggedInUser() {
      return this.$store.state.loggedInUser
    },
    isLoggedIn() {
      return this.loggedInUser != null
    },
},
methods: {
    async fetchFavoritePrograms() {
            let favoriteProgramFromBackend = await fetch('/rest/programs/favorites', {
                mode: 'no-cors',
            })
            favoriteProgramFromBackend = await favoriteProgramFromBackend.json()
            //console.log('Favorite program objects from backend: '+ favoriteProgramFromBackend)
            this.$store.commit("setFavoritePrograms", favoriteProgramFromBackend)
        },
    async fetchFavoriteEpisodes() {
            let favoriteEpisodesFromBackend = await fetch('/rest/episodes/favorites', {
                mode: 'no-cors',
            })
            favoriteEpisodesFromBackend = await favoriteEpisodesFromBackend.json()
            console.log('Favorite episode objects from backend: '+ favoriteEpisodesFromBackend)
            this.$store.commit("setFavoriteEpisodes", favoriteEpisodesFromBackend)
        },
},
    mounted() {
        this.fetchFavoritePrograms()
        this.fetchFavoriteEpisodes()

    }
}
</script>

<style>

</style>