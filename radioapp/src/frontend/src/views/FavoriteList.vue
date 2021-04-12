<template>
    
    <div v-if="favorites.length > 0">
      <FavoriteCard
        v-for="(favorite, i) in favorites"
        :key="favorite + i"
        :favorite="favorite"
      />
    </div>
</template>

<script>
import FavoriteCard from "../components/FavoriteCard";
export default {
components: {
    FavoriteCard
},
computed: {
    favorites() {
            return this.$store.getters.getFavorites
        },
    }
}
</script>

<style>

</style>