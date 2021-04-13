<template>


    <div class="episode-card">
        <h2>Episodes</h2>
        <h3>{{ episode.getEpisodeByProgramIdFromSR }}</h3>
        
    </div>
</template>

<script>
export default {
    props: ["episode"]

// Date = new Date(1618231050329).toLocaleString()


}
</script>

<style>

</style>