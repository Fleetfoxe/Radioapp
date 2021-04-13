<template>




    <div class="episode-card">

        
        <h2>{{episode.title}}</h2>
        <h2>{{episode.startTimeUtc}}</h2>

        

    </div>

</template>



<script>

export default {

    props: ["episode"],








}

</script>



<style>



</style>
// Date = new Date(1618231050329).toLocaleString()