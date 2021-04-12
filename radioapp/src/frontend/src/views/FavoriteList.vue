<template>
<h2 v-if="!isLoggedIn">User not logged in, 
<router-link to="/Login">Login</router-link>
to se favorites
</h2>
    <div v-if="isLoggedIn">
    <div v-if="favorites.length > 0">
      <FavoriteCard
        v-for="(favorite, i) in favorites"
        :key="favorite + i"
        :favorite="favorite"
        :favoriteId="favorite.programId"
         />
        </div>
    </div>
</template>

<script>
import FavoriteCard from "../components/FavoriteCard";
export default {
    data() {
        return {
            programName: ''
        }
    },
components: {
    FavoriteCard
},
computed: {
    favorites() {
            return this.$store.getters.getFavorites
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
            let favoriteFromBackend = await fetch('/rest/myFavorites', {
                mode: 'no-cors',
            })
            favoriteFromBackend = await favoriteFromBackend.json()
            console.log('Favorite objects from backend: '+ favoriteFromBackend)
            this.$store.commit("setFavorites", favoriteFromBackend)
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