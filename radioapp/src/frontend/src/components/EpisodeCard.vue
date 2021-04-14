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
.episode-card {
  background-color: lightgray;
  margin-bottom: 20px;
  padding: 10px;
  font-family: 'Arial';
  border-radius: 30px;
  border: 5px solid whitesmoke;
  width: 100%;
  
  }


</style>
